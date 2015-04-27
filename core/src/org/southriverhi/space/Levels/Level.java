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
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import org.southriverhi.space.SpaceShooter;

public abstract class Level implements Screen {

    protected AssetManager assetManager;
    protected Game game;

    public Level(Game game) {
        this.game = game;
        this.assetManager = SpaceShooter.assetManager;
    }

    /** Called when this screen becomes the current screen for a {@link Game}. */
    @Override
    public abstract void show();

    /** Called when the screen should render itself.
     * @param delta The time in seconds since the last render. */
    @Override
    public abstract void render(float delta);

    /**
     * Called on resize.
     * @param width : pixels.
     * @param height : pixels.
     */
    @Override
    public abstract void resize(int width, int height);

    /**
     * Called on pause.
     */
    @Override
    public abstract void pause();

    /**
     * Called on resume.
     */
    @Override
    public abstract void resume();

    /** Called when this screen is no longer the current screen for a {@link Game}. */
    @Override
    public abstract void hide();

    /** Called when this screen should release all resources. */
    @Override
    public abstract void dispose();

    public static Level getLevelByName(String s){
        return null;
    }
}
