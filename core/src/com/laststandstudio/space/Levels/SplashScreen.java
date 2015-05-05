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

package com.laststandstudio.space.Levels;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.laststandstudio.space.Levels.Menus.MainMenu;
import com.laststandstudio.space.SpaceShooter;
import com.laststandstudio.space.Addons.AddonLoadEvent;
import com.laststandstudio.space.Addons.AddonManager;
import com.laststandstudio.space.Addons.SpaceShooterAddon;
import com.laststandstudio.space.engine.Level;

import java.util.ArrayList;
import java.util.List;

public class SplashScreen extends Level {

    private SpriteBatch batch;
    private Game game;
    private long start;
    public static boolean continueToMainMenu = false;
    AddonManager manager;

    public SplashScreen(Game game) {
        super(game);
        this.game = game;
    }

    @Override
    public void show() {
        SpaceShooter.logger.logDebug("Loading Splash Screen");
        batch = new SpriteBatch();
        SpaceShooter.assetManager.load("splash/laststand.png", Texture.class);
        start = TimeUtils.millis();

        new Thread(() -> {
            registerHandlers();
            SpaceShooter.logger.logDebug("Enjoying the Splash Screen");
            while (TimeUtils.millis() < (start + 5000)) {}
            SpaceShooter.logger.logDebug("Done Enjoying the Splash Screen");
            continueToMainMenu = true;
        }).start();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        SpaceShooter.assetManager.finishLoading();
        batch.draw(SpaceShooter.assetManager.get("splash/laststand.png", Texture.class), 0, 0,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());
        batch.end();
        if (continueToMainMenu) {
            dispose();
            SpaceShooter.logger.logDebug("Setting Screen to 'MainMenu'");
            game.setScreen(new MainMenu(game));
        }
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        SpaceShooter.logger.logDebug("Destroying Splash Screen");
        SpaceShooter.logger.logDebug("Unloading Assets for Splash Screen");
        SpaceShooter.assetManager.unload("splash/laststand.png");
    }

    public void registerHandlers() {
        SpaceShooter.logger.logDebug("Registering Handlers for Add-ons");
        manager = new AddonManager();
        SpaceShooter.addons = manager.loadPlugins();
        List<SpaceShooterAddon> pluginsLoaded = new ArrayList<>();
        for (final SpaceShooterAddon plugin : SpaceShooter.addons) {
            SpaceShooter.logger.log("Running load method on: " + plugin.getPluginName());

            plugin.loadP(new AddonLoadEvent("Load - " + plugin.getPluginName(), pluginsLoaded));
            pluginsLoaded.add(plugin);
        }
    }
}
