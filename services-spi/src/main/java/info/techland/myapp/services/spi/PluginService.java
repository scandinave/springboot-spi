package info.techland.myapp.services.spi;

import info.techland.myapp.services.spi.pluginProvider.Plugin;

import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;

public class PluginService {

    private final ServiceLoader<Plugin> loader;
    private static PluginService instance = null;

    private PluginService() {
        loader = ServiceLoader.load(Plugin.class);
    }

    public static PluginService getInstance() {
        if (instance == null) {
            instance = new PluginService();
        }

        return instance;
    }

    public Optional<Plugin> getPlugin(String name) {
        return loader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(plugin -> plugin.getName().equals(name))
                .findFirst();

    }

    public List<Plugin> getPlugins() {
        return loader.stream()
            .map(ServiceLoader.Provider::get)
            .toList();
    }

    public List<Plugin> getPlugins(String filter) {
        return loader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(plugin -> plugin.getName().toLowerCase().contains(filter.toLowerCase()))
                .toList();
    }


}
