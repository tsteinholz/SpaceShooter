/******************************************************************************
 * Space Shooter Software License
 * Version 0.0.2-alpha
 *
 * Copyright (C) 2015 Last Stand Studio
 *
 *  SpaceShooter is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  SpaceShooter is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with SpaceShooter.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

package com.laststandstudio.space.launcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Launcher extends Application {

    public Language language;

    public static final int WIDTH = 900, HEIGHT = 600;
    private Thread updateNewsThread;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Label titleLabel;
    private TextArea newsBody;
    private Thread updateFilesAndStartThread;


    @Override
    public void start(Stage primaryStage) throws Exception {
        //TODO : Load last language from conf

        Font cFont = Font.loadFont(new File("Alien_Resurrection.ttf").toURI().toURL().toExternalForm(), 36);

        usernameField = new TextField();
        usernameField.setLayoutX(WIDTH - 225);
        usernameField.setLayoutY(HEIGHT - 120);
        usernameField.setFont(Font.font("Times New Roman", 16));
        usernameField.setPromptText("Username/Email");

        passwordField = new PasswordField();
        passwordField.setLayoutX(WIDTH - 225);
        passwordField.setLayoutY(HEIGHT - 80);
        passwordField.setFont(Font.font("Times New Roman", 16));
        passwordField.setPromptText("Password");

        loginButton = new Button();
        loginButton.setText("Login");
        loginButton.setPrefWidth(80);
        loginButton.setLayoutX(WIDTH - 105);
        loginButton.setLayoutY(HEIGHT - 40);
        loginButton.setFont(Font.font("Times New Roman", 16));
        loginButton.setOnAction((e) -> {
            System.out.println("Login clicked");
            loginButton.setDisable(true);
            updateFilesAndStartThread = new UpdateAndStartThread();
            updateFilesAndStartThread.start();
        });

        titleLabel = new Label("space   shooter");
        titleLabel.setId("titleLabel");
        titleLabel.setFont(cFont);
        System.out.println((WIDTH / 2) - (titleLabel.getWidth() * 4));
        titleLabel.setLayoutX(((WIDTH / 2) - (WIDTH / 2) / 2) - 50);
        titleLabel.setLayoutY(50);

        newsBody = new TextArea();
        newsBody.setId("newsBody");
        newsBody.setFont(Font.font("Times New Roman", 16));
        newsBody.setLayoutX(100);
        newsBody.setLayoutY(125);
        newsBody.setMinHeight(HEIGHT - 280);
        newsBody.setPrefHeight(HEIGHT - 280);
        newsBody.setPrefWidth(WIDTH - 200);
        newsBody.setMinWidth(WIDTH - 200);
        newsBody.setEditable(false);
        newsBody.setWrapText(true);

        newsBody.setText("");
        updateNewsThread = new Thread(() -> {
            try {
                URL url = new URL("http://jfreedman.us/lsnews.txt");
                URLConnection urlConnection = url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String news = "";
                String line = null;
                int lines = 0;

                while ((line = bufferedReader.readLine()) != null && lines < 10) {
                    news += line + "\n";
                    lines++;
                }
                synchronized (news) {
                    setNewsText(news);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        updateNewsThread.start();


        AnchorPane anchorPane = new AnchorPane();

        anchorPane.getChildren().add(usernameField);
        anchorPane.getChildren().add(passwordField);
        anchorPane.getChildren().add(loginButton);
        anchorPane.getChildren().add(titleLabel);
        anchorPane.getChildren().add(newsBody);

        Scene scene1 = new Scene(anchorPane, WIDTH, HEIGHT);
        scene1.getStylesheets().add(new File("stylesheet.css").toURI().toURL().toExternalForm());

        primaryStage.setTitle("SpaceShooter Launcher");
        primaryStage.setScene(scene1);

        primaryStage.show();
        primaryStage.setResizable(false);

        loginButton.requestFocus();
    }

    synchronized void setNewsText(String text) {
        if (newsBody != null) newsBody.setText(text);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
