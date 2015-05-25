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

package com.laststandstudio.space.launcher;

import java.io.File;
import java.util.HashMap;

public class TextBank {

    HashMap<String, String> dictionary;

    public TextBank(Language language) {
        switch (language) {
            case ENGLISH:
                loadLanguage(new File("Languages" + File.separator + "en.properties"));
                break;
            case CHINESE:
                loadLanguage(new File("Languages" + File.separator + "zh.properties"));
                break;
            case SPANISH:
                loadLanguage(new File("Languages" + File.separator + "es.properties"));
                break;
            case ARABIC:
                loadLanguage(new File("Languages" + File.separator + "ar.properties"));
                break;
            case PORTUGUESE:
                loadLanguage(new File("Languages" + File.separator + "po.properties"));
                break;
            case JAPANESE:
                loadLanguage(new File("Languages" + File.separator + "ja.properties"));
                break;
            case RUSSIAN:
                loadLanguage(new File("Languages" + File.separator + "ru.properties"));
                break;
            case GERMAN:
                loadLanguage(new File("Languages" + File.separator + "de.properties"));
                break;
            case FRENCH:
                loadLanguage(new File("Languages" + File.separator + "fr.properties"));
                break;
            case MALAY:
                loadLanguage(new File("Languages" + File.separator + "ma.properties"));
                break;
        }
    }

    private void loadLanguage(File file) {

    }
}
