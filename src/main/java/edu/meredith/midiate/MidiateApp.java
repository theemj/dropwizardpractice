package edu.meredith.midiate;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

/**
 * Created by Emily on 1/17/2016.
 */
public class MidiateApp extends Application<MidiateAppConfiguration> {

    public static void main(String args[]) throws Exception {
        new MidiateApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<MidiateAppConfiguration> boot1) {
        boot1.addBundle(new ViewBundle<MidiateAppConfiguration>());

    }

    @Override
    public void run(MidiateAppConfiguration configuration, Environment environment) throws Exception {
        HelloWorldResource resource = new HelloWorldResource();
        environment.jersey().register(resource);
    }

}
