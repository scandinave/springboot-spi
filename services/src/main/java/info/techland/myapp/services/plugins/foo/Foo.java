package info.techland.myapp.services.plugins.foo;

import info.techland.myapp.services.spi.pluginProvider.Plugin;

public class Foo implements Plugin {

    private final String name = "Foo";
    private final String description = "A really cool foo plugin";

    public Foo() {

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
