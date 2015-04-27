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

package org.southriverhi.space.Utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import org.southriverhi.space.SpaceShooter;

public class MusicManager {
    private AssetManager assetManager;
    private String[] mix;
    private Music currentSong;
    private int currentIndex;

    /**
     * Constructor For the Music Manager
     *
     * @param mix String array of the title's locations in the asset folder.
     */
    public MusicManager(String[] mix) {
        this.assetManager = SpaceShooter.assetManager;
        this.mix = mix;
        for (String x : mix) {
            assetManager.load(x, Music.class);
            assetManager.finishLoading();
        }
        currentIndex = 0;
        currentSong = assetManager.get(mix[currentIndex], Music.class);
    }

    /**
     * Play the current song.
     */
    public void play() {
        currentSong.play();
    }

    /**
     * Play the next song.
     */
    public void next() {
        currentSong.stop();
        currentIndex = currentIndex >= mix.length ? currentIndex++ : 0;
        currentSong = assetManager.get(mix[currentIndex], Music.class);
        currentSong.play();
    }

    /**
     * Pauses the current song.
     */
    public void pause() {
        currentSong.pause();
    }

    /**
     * Stops the song
     */
    public void stop() {
        currentSong.stop();
    }

    /**
     * @return if a song is playing.
     */
    public boolean playing() {
        return currentSong.isPlaying();
    }

    /**
     * Called once per frame
     */
    public void update() {
        if (!playing()) next();
    }
}
