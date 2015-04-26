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
<<<<<<< HEAD
import com.badlogic.gdx.assets.AssetManager;
=======
import org.southriverhi.space.Addons.AddonManager;
import org.southriverhi.space.Addons.SpaceShooterAddon;
>>>>>>> 40c525229fbc5278ca848aa3b29dd59ac46a20d8
import org.southriverhi.space.Levels.SplashScreen;
import org.southriverhi.space.Utils.Logger;

import java.util.List;

public class SpaceShooter extends Game {

<<<<<<< HEAD
	private AssetManager assetManager;

	@Override
	public void create() {
		assetManager = new AssetManager();
		setScreen(new SplashScreen(this, assetManager));
	}
=======
    public static Logger logger = new Logger();
    public static List<SpaceShooterAddon> addons;

    @Override
    public void create() {
        setScreen(new SplashScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();
    }
>>>>>>> 40c525229fbc5278ca848aa3b29dd59ac46a20d8

}
