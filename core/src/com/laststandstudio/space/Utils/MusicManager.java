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

package com.laststandstudio.space.Utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.laststandstudio.space.SpaceShooter;

public class MusicManager {
    private AssetManager assetManager;
    private String[] mix;
    private Music currentSong;
    private int currentIndex;
    private boolean paused;

    /**
     * Constructor For the Music Manager
     *
     * @param mix String array of the title's locations in the asset folder.
     */
    public MusicManager(String[] mix) {
        this.assetManager = SpaceShooter.assetManager;
        this.mix = mix;
        this.paused = false;
        for (String x : mix) {
            assetManager.load(x, Music.class);
            assetManager.finishLoading();
        }
        next();
        stop();
    }

    /**
     * Play the current song.
     */
    public void play() {
        this.paused = false;
        currentSong.play();
        SpaceShooter.logger.logDebug("Music Manager: Now Playing -> " + mix[currentIndex]);
    }

    /**
     * Play the next song.
     */
    public void next() {
        if (playing()) stop();
        currentIndex = (int)(Math.random() * mix.length);
        currentSong = assetManager.get(mix[currentIndex], Music.class);
        SpaceShooter.logger.logDebug("Music Manager: Loaded -> " + mix[currentIndex]);
        currentSong.play();
    }

    /**
     * Pauses the current song.
     */
    public void pause() {
        if (playing()) currentSong.pause();
        this.paused = true;
    }

    /**
     * Stops the song
     */
    public void stop() {
        pause();
        if (playing()) currentSong.stop();
        SpaceShooter.logger.logDebug("Music Manager: Stopped -> " + mix[currentIndex]);
    }

    /**
     * @return if a song is playing.
     */
    public boolean playing() {
        return currentSong != null && currentSong.isPlaying();
    }

    /**
     * Called once per frame
     */
    public void update() {
        if (!playing() && !paused) next();
    }

    public void dispose() {
        SpaceShooter.logger.logDebug("Destroying Music Manager");
        for (String x : mix) {
            SpaceShooter.assetManager.unload(x);
        }
    }
}
