import app.Module;
import common.JettyModule;
import io.logz.guice.jersey.JerseyModule;
import io.logz.guice.jersey.JerseyServer;
import io.logz.guice.jersey.configuration.JerseyConfiguration;

/**
 * Created by BenBen嚓 on 2018/4/3.
 */
public class App {
    public static void main(String[] args) throws Exception {
        JerseyConfiguration configuration = JerseyConfiguration.builder()
                .addPackage("Res")
                .withContextPath("/api/*")
                .addPort(8085)
                .build();

        Module module = Module.getModule().build(new JerseyModule(configuration),new JettyModule());
        module.getInstance(JerseyServer.class).start();

    }
}
