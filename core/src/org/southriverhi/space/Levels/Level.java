package org.southriverhi.space.Levels;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

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

    @Override
    public abstract void resize(int width, int height);

    @Override
    public abstract void pause();

    @Override
    public abstract void resume();

    /** Called when this screen is no longer the current screen for a {@link Game}. */
    @Override
    public abstract void hide();

    /** Called when this screen should release all resources. */
    @Override
    public abstract void dispose();
}
