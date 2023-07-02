package Oralce2;

import Oralce2.health.TemplateHealthCheck;
import Oralce2.resources.HelloWordResource;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import Oralce2.resources.CorsFilter;
import jakarta.servlet.Filter;


public class OracletestApplication extends Application<OracletestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new OracletestApplication().run(args);
    }

    @Override
    public String getName() {
        return "Oracletest";
    }

    @Override
    public void initialize(final Bootstrap<OracletestConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final OracletestConfiguration configuration,
                    final Environment environment) {
        final HelloWordResource resource = new HelloWordResource(
                configuration.getTemplate(),
                configuration.getDefaultName());
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.servlets().addFilter("CorsFilter", (Filter) new CorsFilter()).addMappingForUrlPatterns(null, true, "/*");
        environment.jersey().register(resource);
        environment.jersey().register(resource);

    }

}
