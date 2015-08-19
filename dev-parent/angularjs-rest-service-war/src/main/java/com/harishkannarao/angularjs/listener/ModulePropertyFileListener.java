package com.harishkannarao.angularjs.listener;

import com.harishkannarao.angularjs.util.ModulePropertyFileLoader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;

public class ModulePropertyFileListener implements Runnable {

    private void startWatchService() {
        try {
            final WatchService propertyFileWatcher = FileSystems.getDefault().newWatchService();
            Path propertyFilepath = Paths.get(this.getClass().getClassLoader().getResource(ModulePropertyFileLoader.ANGULARJS_REST_SETTINGS_THROUGH_MODULE_PROPERTIES).toURI());
            propertyFilepath.getParent().register(propertyFileWatcher, StandardWatchEventKinds.ENTRY_MODIFY);

            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    try {
                        propertyFileWatcher.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            while (true) {
                WatchKey key;
                try {
                    key = propertyFileWatcher.take();
                } catch (InterruptedException ex) {
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    @SuppressWarnings("unchecked")
                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path fileName = ev.context();

                    if (kind == StandardWatchEventKinds.ENTRY_MODIFY &&
                            fileName.toString().equals(ModulePropertyFileLoader.ANGULARJS_REST_SETTINGS_THROUGH_MODULE_PROPERTIES)) {
                        ModulePropertyFileLoader.loadProperties();
                    }
                }
                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        startWatchService();
    }
}
