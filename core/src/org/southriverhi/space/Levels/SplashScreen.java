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
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import org.southriverhi.space.Addons.AddonLoadEvent;
import org.southriverhi.space.Addons.AddonManager;
import org.southriverhi.space.Addons.SpaceShooterAddon;
import org.southriverhi.space.SpaceShooter;

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
        batch = new SpriteBatch();
        SpaceShooter.assetManager.load("splash/laststand.png", Texture.class);
        SpaceShooter.assetManager.load("splash/libgdx_logo.png", Texture.class);
        start = TimeUtils.millis();

        new Thread(() -> {
            registerHandlers();
            while (TimeUtils.millis() < (start + 5000)) {}
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
        batch.draw(SpaceShooter.assetManager.get("splash/libgdx_logo.png", Texture.class), 0, 0,
                SpaceShooter.assetManager.get("splash/libgdx_logo.png", Texture.class).getWidth(),
                SpaceShooter.assetManager.get("splash/libgdx_logo.png", Texture.class).getHeight());
        batch.end();
        if (continueToMainMenu) {
            dispose();
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
        SpaceShooter.assetManager.unload("splash/laststand.png");
        SpaceShooter.assetManager.unload("splash/libgdx_logo.png");
    }

    public void registerHandlers() {
        manager = new AddonManager();
        SpaceShooter.addons = manager.loadPlugins();
        List<SpaceShooterAddon> pluginsLoaded = new ArrayList<>();
        for (final SpaceShooterAddon plugin : SpaceShooter.addons) {
            System.out.println("Running load method on: " + plugin.getPluginName());

            plugin.loadP(new AddonLoadEvent("Load - " + plugin.getPluginName(), pluginsLoaded));
            pluginsLoaded.add(plugin);
        }
    }
}
