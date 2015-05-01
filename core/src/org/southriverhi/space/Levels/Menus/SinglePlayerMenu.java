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

package org.southriverhi.space.Levels.Menus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import org.southriverhi.space.Levels.Level;

public class SinglePlayerMenu extends Level {

    public SinglePlayerMenu(Game game) {
        super(game);
    }

    /**
     * Called when this screen becomes the current screen for a {@link Game}.
     */
    @Override
    public void show() {

    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {

    }

    /**
     * Called on resize.
     *
     * @param width  : pixels.
     * @param height : pixels.
     */
    @Override
    public void resize(int width, int height) {

    }

    /**
     * Called on pause.
     */
    @Override
    public void pause() {

    }

    /**
     * Called on resume.
     */
    @Override
    public void resume() {

    }

    /**
     * Called when this screen is no longer the current screen for a {@link Game}.
     */
    @Override
    public void hide() {

    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {

    }

    @Override
    public BitmapFont loadFont(String fileLoc, int fontSize) {
        return super.loadFont(fileLoc, fontSize);
    }
}
