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
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.laststandstudio.space.SpaceShooter;

public abstract class Level implements Screen {

    protected Game game;

    public Level(Game game) {
        this.game = game;
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

    /**
     * Loads a font into a Bitmap Font.
     * @param fileLoc : Location of the font file
     * @param fontSize : The font size of the
     * @return
     */
    public BitmapFont loadFont(String fileLoc, int fontSize) {
        SpaceShooter.logger.logDebug("Loading font " + fileLoc + " at the size " + fontSize + "px");
        BitmapFont font;
        FileHandle fontFile = Gdx.files.internal(fileLoc);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = fontSize;
        font = generator.generateFont(parameter);
        generator.dispose();
        return font;
    }
}
