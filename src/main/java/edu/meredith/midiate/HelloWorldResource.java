package edu.meredith.midiate;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path ("/")
public class HelloWorldResource {

    String messageOfDay = "";

    public HelloWorldResource() {
    }

    @GET
    @Path("/hello-world")
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello() {
        return "Hello";
    }
    @GET
    @Path("/motd")
    @Produces (MediaType.TEXT_HTML)
    public MessageOfDayView getMessage()
    {
        return new MessageOfDayView(messageOfDay);
    }

    @POST
    @Path ("/motd")
    //@Consumes(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void setMessage(@FormParam("message") String message) {
        messageOfDay = message;
    }


}