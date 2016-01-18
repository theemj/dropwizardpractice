package edu.meredith.midiate;

import io.dropwizard.views.View;

/**
 * Created by Emily on 1/17/2016.
 */
public class MessageOfDayView extends View {
    String message;

    public MessageOfDayView(String message) {
        super("message.ftl");
        this.message = message;

    }

    public String getMessage()
    {
        return message;
    }
}
