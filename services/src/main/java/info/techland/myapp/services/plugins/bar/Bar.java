package info.techland.myapp.services.plugins.bar;

import info.techland.myapp.services.spi.pluginProvider.Plugin;

public class Bar implements Plugin {

    private final String name = "Bar";
    private final String description = "Another really cool bar plugin";

    public Bar() {

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

}
