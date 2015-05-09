package com.laststandstudio.space.launcher;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class Launcher extends Application {

    public static final int WIDTH = 900, HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Font font = Font.loadFont((new File("Gtek_Technology_free.ttf").toURI().toURL()), 28);
        Font cFont = Font.loadFont(new File("Alien_Resurrection.ttf").toURI().toURL().toExternalForm(), 36);
        System.out.println(cFont == null);
        System.out.println(cFont.getName());

        TextField usernameField = new TextField();
        usernameField.setLayoutX(WIDTH - 225);
        usernameField.setLayoutY(HEIGHT - 120);
        usernameField.setFont(Font.font("Times New Roman", 16));
        usernameField.setPromptText("Username/Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(WIDTH - 225);
        passwordField.setLayoutY(HEIGHT - 80);
        passwordField.setFont(Font.font("Times New Roman", 16));
        passwordField.setPromptText("Password");

        Button loginButton = new Button();
        loginButton.setText("Login");
        loginButton.setPrefWidth(80);
        loginButton.setLayoutX(WIDTH - 105);
        loginButton.setLayoutY(HEIGHT - 40);
        loginButton.setFont(Font.font("Times New Roman", 16));
        loginButton.setOnAction((e) -> {
            System.out.println("Login clicked");
            loginButton.setDisable(true);
        });

        Label titleLabel = new Label("SpaceShooter");
        titleLabel.setId("titleLabel");
        titleLabel.setFont(cFont);
        System.out.println((WIDTH / 2) - (titleLabel.getWidth() * 4));
        titleLabel.setLayoutX(((WIDTH / 2) - (WIDTH / 2) / 2) - 50);
        titleLabel.setLayoutY(50);

        AnchorPane anchorPane = new AnchorPane();

        anchorPane.getChildren().add(usernameField);
        anchorPane.getChildren().add(passwordField);
        anchorPane.getChildren().add(loginButton);
        anchorPane.getChildren().add(titleLabel);

        Scene scene1 = new Scene(anchorPane, WIDTH, HEIGHT);
        scene1.getStylesheets().add(new File("stylesheet.css").toURI().toURL().toExternalForm());

        primaryStage.setTitle("SpaceShooter Launcher");
        primaryStage.setScene(scene1);

        primaryStage.show();

        loginButton.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
