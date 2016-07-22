package edu.meredith.midiate;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by Emily on 1/17/2016.
 */
public class MidiateApp extends Application<MidiateAppConfiguration> {

    public static void main(String args[]) throws Exception {
        new MidiateApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<MidiateAppConfiguration> bootstrap) {
        bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));

    }

    @Override
    public void run(MidiateAppConfiguration configuration, Environment environment) throws Exception {
        HelloWorldResource resource = new HelloWorldResource();
        environment.jersey().register(resource);
    }

}
