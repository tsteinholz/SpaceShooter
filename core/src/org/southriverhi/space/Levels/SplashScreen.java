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
import com.badlogic.gdx.assets.AssetManager;
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

    private AssetManager assetManager;
    private SpriteBatch batch;
    private Game game;
    private long start;
    private long end;
    public static boolean continueToMainMenu = false;
    AddonManager manager;

    public SplashScreen(Game game, AssetManager assetManager) {
        super(game, assetManager);
        this.assetManager = assetManager;
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        assetManager.load("splash/laststand.png", Texture.class);
        assetManager.load("splash/libgdx_logo.png", Texture.class);
        start = TimeUtils.millis();

        new Thread(() -> {
            registerHandlers();
            while (TimeUtils.millis() < (start + 5000)) {
            }
            continueToMainMenu = true;
        }).start();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        assetManager.finishLoading();
        batch.draw(assetManager.get("splash/laststand.png", Texture.class), 0, 0,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());
        batch.draw(assetManager.get("splash/libgdx_logo.png", Texture.class), 0, 0,
                assetManager.get("splash/libgdx_logo.png", Texture.class).getWidth(),
                assetManager.get("splash/libgdx_logo.png", Texture.class).getHeight());
        batch.end();
        if (continueToMainMenu) {
            dispose();
            game.setScreen(new MainMenu(game, assetManager));
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
        assetManager.unload("splash/laststand.png");
        assetManager.unload("splash/libgdx_logo.png");
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
