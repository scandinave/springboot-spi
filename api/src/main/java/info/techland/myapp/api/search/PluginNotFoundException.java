package info.techland.myapp.api.search;

public class PluginNotFoundException extends RuntimeException {
    public PluginNotFoundException(String name) {
        super("Can't find a plugin with the name " + name);
    }
}
