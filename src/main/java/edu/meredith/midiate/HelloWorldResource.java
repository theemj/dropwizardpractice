package edu.meredith.midiate;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class HelloWorldResource {

    String messageOfDay = "My name is Inigo Montoya. You killed my father. Prepare to die.";

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
    public String getMessage()
    {
        return messageOfDay;
    }

    @POST
    @Path ("/motd")
    //@Consumes(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void setMessage(@FormParam("message") String message) {
        messageOfDay = message;
    }


}