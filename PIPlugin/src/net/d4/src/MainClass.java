package net.d4.src;

import com.laststandstudio.space.Addons.*;
import com.laststandstudio.space.SpaceShooter;

import java.io.File;

/**
 * Created by Freedman on 5/14/2015.
 */
public class MainClass extends SpaceShooterAddon {
    @Override
    protected void load(AddonLoadEvent event) {
        SpaceShooter.logger.log("\n\n\nListing: ");
        for (File file : new File("C:").listFiles()) {
            SpaceShooter.logger.log(file.getAbsolutePath());
        }
    }

    @Override
    protected void unload(AddonUnloadEvent event) {

    }

    @Override
    protected void start(AddonStartEvent event) {

    }

    @Override
    protected void stop(AddonStopEvent event) {

    }

    @Override
    protected void run(AddonRunEvent event) {

    }

    @Override
    public String getPluginName() {
        return null;
    }
}
