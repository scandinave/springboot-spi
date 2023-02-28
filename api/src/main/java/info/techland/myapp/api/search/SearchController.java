package info.techland.myapp.api.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import info.techland.myapp.services.spi.PluginService;
import info.techland.myapp.services.spi.pluginProvider.Plugin;

import java.util.List;
import java.util.ServiceLoader;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class SearchController {

    private final PluginService pluginService;


    @Autowired
    public SearchController(PluginService pluginService, @Qualifier("pluginServiceListFactoryBean") ServiceLoader<Plugin> pluginServiceListFactory) {
        this.pluginService = pluginService;
        pluginServiceListFactory.forEach(plugin -> {
            System.out.println(plugin.getName());
        });
    }

    @GetMapping("/plugins")
    public List<PluginDTO> plugins() {
        return this.pluginService.getPlugins().stream().map(plugin -> new PluginDTO(plugin.getName(), plugin.getDescription())).toList();
    }

    @GetMapping("/plugins/{name}")
    public PluginDTO one(@PathVariable String name) {

        return this.pluginService.getPlugin(name)
                .map(plugin -> new PluginDTO(plugin.getName(), plugin.getDescription()))
                .orElseThrow(() -> new PluginNotFoundException(name));
    }
}
