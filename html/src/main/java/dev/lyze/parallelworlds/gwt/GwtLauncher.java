package dev.lyze.parallelworlds.gwt;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.badlogic.gdx.backends.gwt.preloader.Preloader;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import dev.lyze.parallelworlds.ParallelWorlds;
import dev.lyze.parallelworlds.statics.Statics;

/**
 * Launches the GWT application.
 */
public class GwtLauncher extends GwtApplication {
    private static final int PADDING = 0;

    @Override
    public GwtApplicationConfiguration getConfig() {
        int w = Window.getClientWidth() - PADDING;
        int h = Window.getClientHeight() - PADDING;
        GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(w, h);
        Window.enableScrolling(false);
        Window.setMargin("0");
        Window.addResizeHandler(new ResizeListener());
        return cfg;
    }

    class ResizeListener implements ResizeHandler {
        @Override
        public void onResize(ResizeEvent event) {
            if (Gdx.graphics.isFullscreen()) return;
            int width = event.getWidth() - PADDING;
            int height = event.getHeight() - PADDING;
            getRootPanel().setWidth("" + width + "px");
            getRootPanel().setHeight("" + height + "px");
            getApplicationListener().resize(width, height);
            Gdx.graphics.setWindowedMode(width, height);
        }
    }

    @Override
    public ApplicationListener createApplicationListener() {
        Statics.isMobileDevice = GwtApplication.isMobileDevice();
        return new ParallelWorlds();
    }

    @Override
    public Preloader.PreloaderCallback getPreloaderCallback() {
        return createPreloaderPanel(GWT.getHostPageBaseURL() + "assets/images/Logo.png");
    }
}
