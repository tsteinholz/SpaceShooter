/*
 * This file is part of SpaceShooter.
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
 */

package org.southriverhi.space.Levels;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import org.southriverhi.space.SpaceShooter;

public class MainMenu extends Level {

    private static final float PADDING = (Gdx.graphics.getWidth() / 120);

    private SpriteBatch batch;

    private BitmapFont titleFont;
    private BitmapFont menuFont;
    private Pixmap pixmap;
    private Skin skin;
    private Sound menuClick;
    private Stage stage;
    private Table table;

    private Label title;

    private Label.LabelStyle labelStyle;
    private TextButton.TextButtonStyle textButtonStyle;

    private TextButton btnSinglePlayer;
    private TextButton btnMultiplayer;
    private TextButton btnOptions;
    private TextButton btnTexturePacks;
    private TextButton btnMods;
    private TextButton btnExit;

    public MainMenu(Game game) {
        super(game);
        SpaceShooter.logger.logDebug("Creating Main Menu Screen");
        this.batch = new SpriteBatch();
        this.titleFont = super.loadFont("fonts/Gtek_Technology_free.ttf", (Gdx.graphics.getHeight() / 12));
        SpaceShooter.logger.logDebug("Creating Button Tables & Fonts");
        this.menuFont = new BitmapFont();
        this.pixmap = new Pixmap(
                (Gdx.graphics.getWidth() / 2) - (Gdx.graphics.getWidth() / 10),
                (Gdx.graphics.getHeight() / 12), Pixmap.Format.RGB888);
        this.skin = new Skin();
        this.stage = new Stage();
        this.table = new Table();
        this.labelStyle = new Label.LabelStyle(titleFont, Color.BLACK);
        this.textButtonStyle = new TextButton.TextButtonStyle();

        skin.add("default", menuFont);
        pixmap.setColor(Color.MAROON);
        pixmap.fill();
        skin.add("background", new Texture(pixmap));

        SpaceShooter.logger.logDebug("Building Button Style");
        textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
        textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
        textButtonStyle.font = skin.getFont("default");

        skin.add("default", textButtonStyle);

        SpaceShooter.logger.logDebug("Building Buttons");
        this.title = new Label("space shooter", labelStyle);
        this.btnSinglePlayer = new TextButton("Single Player", skin);
        this.btnMultiplayer = new TextButton("Multiplayer", skin);
        this.btnOptions = new TextButton("Options", skin);
        this.btnTexturePacks = new TextButton("Texture Packs", skin);
        this.btnMods = new TextButton("Mods", skin);
        this.btnExit = new TextButton("Exit", skin);
    }

    @Override
    public void show() {
        SpaceShooter.musicManager.play();
        SpaceShooter.logger.logDebug("Loading Assets");
        SpaceShooter.assetManager.load("menus/MenuSelectionClick.wav", Sound.class);
        SpaceShooter.assetManager.load("menus/background.png", Texture.class);
        SpaceShooter.assetManager.finishLoading();
        this.menuClick = SpaceShooter.assetManager.get("menus/MenuSelectionClick.wav");

        SpaceShooter.logger.logDebug("Building the Table of Buttons w/ the Title");
        table.add(title).pad(PADDING * 4).row();
        table.add(btnSinglePlayer).pad(PADDING).row();
        table.add(btnMultiplayer).pad(PADDING).row();
        table.add(btnOptions).pad(PADDING).row();
        table.add(btnTexturePacks).pad(PADDING).row();
        table.add(btnMods).pad(PADDING).row();
        table.add(btnExit).pad(PADDING).row();
        table.setFillParent(true);

        stage.addActor(table);

        SpaceShooter.logger.logDebug("Set Button Listeners");
        btnSinglePlayer.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                menuClick.play();
                btnSinglePlayer.setText("Loading Single Player Menu");
                SpaceShooter.logger.logDebug("Loading Single Player Menu");
                //TODO : load level select.
            }
        });
        btnMultiplayer.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                menuClick.play();
                btnMultiplayer.setText("Loading Multiplayer Menu");
                SpaceShooter.logger.logDebug("Loading Multiplayer Menu");
                //TODO : load server select.
            }
        });
        btnOptions.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                menuClick.play();
                btnOptions.setText("Loading Options Menu");
                SpaceShooter.logger.logDebug("Loading Options Menu");
                //TODO : Load options.
            }
        });
        btnTexturePacks.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                menuClick.play();
                btnTexturePacks.setText("Loading Texture Pack Menu");
                SpaceShooter.logger.logDebug("Loading Texture Pack Menu");
                //TODO : load texture map menu.
            }
        });
        btnMods.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                menuClick.play();
                btnMods.setText("Loading Mods Menu");
                SpaceShooter.logger.logDebug("Loading Mods Menu");
                //TODO : load mods menu.
            }
        });
        btnExit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                menuClick.play();
                btnExit.setText("Exiting Game");
                SpaceShooter.logger.logDebug("Exiting the Game");
                Gdx.app.exit();
            }
        });

        SpaceShooter.logger.logDebug("Set the Input Processor to the Main Menu Stage");
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(SpaceShooter.assetManager.get("menus/background.png", Texture.class), 0, 0,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());
        batch.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void pause() {}

    @Override
    public void resize(int width, int height) {}

    @Override
    public void resume() {}

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        SpaceShooter.logger.logDebug("Destroying Main Menu");
        SpaceShooter.logger.logDebug("Unloading Assets from Main Menu");
        SpaceShooter.assetManager.unload("menus/background.png");
        stage.dispose();
        skin.dispose();
    }
}
