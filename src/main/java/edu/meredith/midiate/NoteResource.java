package edu.meredith.midiate;

import edu.meredith.midiate.model.Note;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/note")
public class NoteResource {

    private long n = 1;
    private final Map<Long, Note> notes = new HashMap<>();
    public Set<Integer> nums = new HashSet<>();


    public NoteResource() {
    }

    @DELETE
    @Path("/{deleteID}")
    public Response deleteNote(@PathParam("deleteID") long id) {
        if (notes.remove(id) != null) {
            return Response.noContent().build();
        }
        return Response.status(404).build();
    }

    @GET
    @Path("/{noteid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Note loadById(@PathParam("noteid") long id) {
        if (notes.containsKey(id)) {
            return notes.get(id);
        }
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Note> getNotes() {
        return notes.values();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createNote(Note note) {
        if (note.getId() == 0) //if this note's id is 0
        {
            Note noteForBackend = new Note(n++, note.getTitle(), note.getBody());
            notes.put(noteForBackend.getId(), noteForBackend);
        } else {
            notes.put(note.getId(), note);
        }

    }


}