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
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MainMenu extends Level {

    private static final float PADDING = 5;

    private BitmapFont font;
    private Pixmap pixmap;
    private Skin skin;
    private Stage stage;
    private Table table;

    private Label title;

    private TextButton.TextButtonStyle textButtonStyle;
    private TextButton btnSinglePlayer;
    private TextButton btnMultiplayer;
    private TextButton btnOptions;
    private TextButton btnTexturePacks;
    private TextButton btnMods;
    private TextButton btnExit;

    public MainMenu(Game game) {
        super(game);
        this.font = new BitmapFont();
        this.pixmap = new Pixmap(
                (Gdx.graphics.getWidth() / 2) - (Gdx.graphics.getWidth() / 10),
                (Gdx.graphics.getHeight() / 12), Pixmap.Format.RGB888);
        this.skin = new Skin();
        this.stage = new Stage();
        this.table = new Table();
        this.textButtonStyle = new TextButton.TextButtonStyle();

        skin.add("default", font);
        pixmap.setColor(Color.PINK);
        pixmap.fill();
        skin.add("background", new Texture(pixmap));

        textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
        textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
        textButtonStyle.font = skin.getFont("default");

        skin.add("default", textButtonStyle);

        this.btnSinglePlayer = new TextButton("Single Player", skin);
        this.btnMultiplayer = new TextButton("Multiplayer", skin);
        this.btnOptions = new TextButton("Options", skin);
        this.btnTexturePacks = new TextButton("Texture Packs", skin);
        this.btnMods = new TextButton("Mods", skin);
        this.btnExit = new TextButton("Exit", skin);

        btnSinglePlayer.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                btnSinglePlayer.setText("Loading Single Player");
                //TODO : load level select.
            }
        });
        btnMultiplayer.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                btnMultiplayer.setText("Loading Multiplayer");
                //TODO : load server select.
            }
        });
        btnOptions.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                btnOptions.setText("Loading Options");
                //TODO : Load options.
            }
        });
        btnTexturePacks.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                btnTexturePacks.setText("Loading Texture Pack Menu");
                //TODO : load texture map menu.
            }
        });
        btnMods.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                btnMods.setText("Loading Mods Menu");
                //TODO : load mods menu.
            }
        });
        btnExit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                btnExit.setText("Exiting Game");
                Gdx.app.exit();
            }
        });
    }

    @Override
    public void show() {
        table.add(btnSinglePlayer).pad(PADDING).row();
        table.add(btnMultiplayer).pad(PADDING).row();
        table.add(btnOptions).pad(PADDING).row();
        table.add(btnTexturePacks).pad(PADDING).row();
        table.add(btnMods).pad(PADDING).row();
        table.add(btnExit).pad(PADDING).row();

        table.setFillParent(true);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
        stage.dispose();
        skin.dispose();
    }
}
