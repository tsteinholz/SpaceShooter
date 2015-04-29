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

package org.southriverhi.space;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import org.southriverhi.space.Addons.SpaceShooterAddon;
import org.southriverhi.space.Levels.SplashScreen;
import org.southriverhi.space.Utils.Logger;
import org.southriverhi.space.Utils.MusicManager;

import java.util.List;

public class SpaceShooter extends Game {

	public static AssetManager assetManager;
    public static MusicManager musicManager;
    public static Logger logger = new Logger();
    public static List<SpaceShooterAddon> addons;
    private String[] mix = {
            "music/TSLASH_Mixtape/rain.wav",
            "music/TSLASH_Mixtape/dawn.wav",
            "music/TSLASH_Mixtape/wanted.wav",
    };

    @Override
	public void create() {
		assetManager = new AssetManager();
		musicManager = new MusicManager(mix);
		musicManager.pause();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void render() {
		super.render();
        musicManager.update();
	}

	@Override
	public void dispose() {
		musicManager.dispose();
        super.dispose();
	}
}
