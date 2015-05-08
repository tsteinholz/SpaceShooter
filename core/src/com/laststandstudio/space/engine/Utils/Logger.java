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

package com.laststandstudio.space.engine.Utils;

import com.laststandstudio.space.SpaceShooter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("unused")
public class Logger {

    /**
     * The ANSI RESET key code value, using this with the console will change back to default color and formatting.
     */
    public static final String ANSI_RESET = "\u001B[0m";
    /**
     * The ANSI BLACK key code value, using this with the console will change font color to black.
     */
    public static final String ANSI_BLACK = "\u001B[30m";
    /**
     * The ANSI RED key code value, using this with the console will change font color to red.
     */
    public static final String ANSI_RED = "\u001B[31m";
    /**
     * The ANSI GREEN key code value, using this with the console will change font color to green.
     */
    public static final String ANSI_GREEN = "\u001B[32m";
    /**
     * The ANSI YELLOW key code value, using this with the console will change font color to yellow.
     */
    public static final String ANSI_YELLOW = "\u001B[33m";
    /**
     * The ANSI BLUE key code value, using this with the console will change font color to blue.
     */
    public static final String ANSI_BLUE = "\u001B[34m";
    /**
     * The ANSI PURPLE key code value, using this with the console will change font color to purple.
     */
    public static final String ANSI_PURPLE = "\u001B[35m";
    /**
     * The ANSI CYAN key code value, using this with the console will change font color to cyan.
     */
    public static final String ANSI_CYAN = "\u001B[36m";
    /**
     * The ANSI WHITE key code value, using this with the console will change font color to white.
     */
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * An ArrayList that holds each line of the log file as a seperate element.
     */
    private ArrayList<String> log;
    private String prefix, suffix, cleanupCode = ANSI_RESET;

    /**
     * Debug Prefix
     */
    private final String DEBUG = ANSI_YELLOW + "Space Shooter" + ANSI_BLUE + " DEBUG" + ANSI_YELLOW + ": " + ANSI_RESET;
    /**
     * Error Prefix
     */
    private final String ERROR = ANSI_RED + "SpaceShooter ERROR: " + ANSI_RESET;
    /**
     * Error Suffix
     */
    private final String ERROR_SUFFIX = "!!";
    /**
     * Clear log message
     */
    private final String CLEAR_LOG = ANSI_CYAN + "Log has been cleared!" + ANSI_RESET;

    /**
     * Constructor for default new log.
     */
    public Logger() {
        this(new ArrayList<>(), ANSI_PURPLE + "[Space Shooter] " + ANSI_RESET, ".");
    }

    /**
     * Constructor that tkae a previous log to append to.
     * @param pastLog
     */
    public Logger(ArrayList<String> pastLog) {

        this(pastLog, ANSI_PURPLE + "[Space Shooter] " + ANSI_RESET, ".");
    }

    /**
     * Constructor with param for the default prefix.
     * @param prefix
     */
    public Logger(String prefix) {
        this(new ArrayList<>(), prefix, "");
    }

    /**
     * Constructor with params for the default prefix and suffix.
     * @param prefix
     * @param suffix
     */
    public Logger(String prefix, String suffix) {
        this(new ArrayList<>(), prefix, suffix);
    }

    /**
     * Constructor with params for a log to append to, and a default prefix.
     * @param pastLog
     * @param prefix
     */
    public Logger(ArrayList<String> pastLog, String prefix) {
        this(pastLog, prefix, ".");
    }

    /**
     * Constructor with params for a log to append to, and params for the default prefix and suffix.
     * @param pastLog
     * @param prefix
     * @param suffix
     */
    public Logger(ArrayList<String> pastLog, String prefix, String suffix) {
        this.log = pastLog;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    /**
     * Returns the loggers prefix.
     * @return
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Returns the loggers suffix.
     * @return
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Logs a standard message to the output stream.
     * @param message
     */
    public void log(String message) {
        if (message != null) {
            String msg = "[" + getCurrentTime() + "] " + prefix + ANSI_CYAN + message + ANSI_RESET + suffix + cleanupCode;
            log.add(msg);
            System.out.println(ANSI_CYAN + msg);
        }
    }

    /**
     * Logs a "quiet" message to the outputstream. (No time, prefix, suffix, etc.)
     * @param message
     */
    public void logQuiet(String message) {
        if (message != null) {
            String msg = message + cleanupCode;
            log.add(msg);
            System.out.println(msg);
        }
    }

    /**
     * Logs to the debug stream. These messages will only show if game is in debug mode.
     * @param message
     */
    public void logDebug(String message) {
        if (message != null && SpaceShooter.debug) {
            String msg = "[" + getCurrentTime() + "] " + DEBUG + message + suffix + cleanupCode;
            log.add(msg);
            System.out.println(ANSI_BLUE + msg);
        }
    }

    /**
     * Logs as an error to the output stream.
     * @param message
     */
    public void logError(String message) {
        if (message != null) {
            String msg = "[" + getCurrentTime() + "] " + ERROR + message + ERROR_SUFFIX + cleanupCode;
            log.add(msg);
            System.out.println(ANSI_RED + msg);
        }
    }

    /**
     * Clears the log by flooding 50 lines.
     */
    public void logClear() {
        logClear(50);
    }

    /**
     * Clears the log by flooding with <i>x</i> amount of lines, where x is the paramater.
     * @param lines
     */
    public void logClear(int lines) {
        log.add(CLEAR_LOG);
        for (int i = 1; i < lines; i++)
            System.out.print("\n");
        System.out.println(CLEAR_LOG);

    }

    /**
     *
     * @implNote Not Implemented Yet
     * @return
     */
    public boolean saveLog() {
        throw new NotImplementedException();
    }

    /**
     * Returns the log as a string?
     * @implNote Might not work...
     * @return
     */
    public String getLog() {
        return log.toString();
    }

    /**
     * Returns the current time in the format "HH:mm:ss"
     * @return
     */
    public String getCurrentTime(){
        String uncleanDateTime = new Date(System.currentTimeMillis()).toString();
        String[] splitDateTime = uncleanDateTime.split(" ");
        return splitDateTime[3];
    }
}
