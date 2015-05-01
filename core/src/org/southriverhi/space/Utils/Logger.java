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

import org.southriverhi.space.SpaceShooter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@SuppressWarnings("unused")
public class Logger {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private ArrayList<String> log;
    private Calendar time;
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private String prefix, suffix, cleanupCode = ANSI_RESET;

    private final String DEBUG = ANSI_YELLOW + "Space Shooter" + ANSI_BLUE + " DEBUG" + ANSI_YELLOW + ": " + ANSI_RESET;
    private final String ERROR = ANSI_RED + "SpaceShooter ERROR: " + ANSI_RESET;
    private final String ERROR_SUFFIX = "!!";
    private final String CLEAR_LOG = ANSI_CYAN + "Log has been cleared!" + ANSI_RESET;

    public Logger() {
        this(new ArrayList<>(), ANSI_PURPLE + "[Space Shooter] " + ANSI_RESET, ".");
    }

    public Logger(ArrayList<String> pastLog) {

        this(pastLog, ANSI_PURPLE + "[Space Shooter] " + ANSI_RESET, ".");
    }

    public Logger(String prefix) {
        this(new ArrayList<>(), prefix, "");
    }

    public Logger(String prefix, String suffix) {
        this(new ArrayList<>(), prefix, suffix);
    }

    public Logger(ArrayList<String> pastLog, String prefix) {
        this(pastLog, prefix, ".");
    }

    public Logger(ArrayList<String> pastLog, String prefix, String suffix) {
        this.time = Calendar.getInstance();
        this.log = pastLog;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void log(String message) {
        if (message != null) {
            String msg = "[" + sdf.format(this.time.getTime()) + "] " + prefix + message + suffix + cleanupCode;
            log.add(msg);
            System.out.println(msg);
        }
    }

    public void logQuiet(String message) {
        if (message != null) {
            String msg = message + cleanupCode;
            log.add(msg);
            System.out.println(msg);
        }
    }

    public void logDebug(String message) {
        if (message != null && SpaceShooter.debug) {
            String msg = "[" + sdf.format(this.time.getTime()) + "] " + DEBUG + message + suffix + cleanupCode;
            log.add(msg);
            System.out.println(ANSI_BLUE + msg);
        }
    }

    public void logError(String message) {
        if (message != null) {
            String msg = "[" + sdf.format(this.time.getTime()) + "] " + ERROR + message + ERROR_SUFFIX + cleanupCode;
            log.add(msg);
            System.out.println(ANSI_RED + msg);
        }
    }

    public void logClear() {
        logClear(50);
    }

    public void logClear(int lines) {
        log.add(CLEAR_LOG);
        for (int i = 1; i < lines; i++)
            System.out.print("\n");
        System.out.println(CLEAR_LOG);

    }

    public boolean saveLog() {
        return true;
    }

    public String getLog() {
        return log.toString();
    }

}
