package edu.meredith.midiate;

import edu.meredith.midiate.model.Note;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by emily on 7/23/16.
 */
public class NoteResourceTest {

    @Test
    public void testGetEmptyNotes() {
        NoteResource resource = new NoteResource();
        Collection<Note> expected = Collections.emptyList();
        Collection<Note> actual = resource.getNotes();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetSingleNote() {
        NoteResource resource = new NoteResource();
        Note noteToCreate = new Note("I'm a title.", "I'm not");
        resource.createNote(noteToCreate);
        Collection<Note> expected = Collections.singletonList(noteToCreate);
        Collection<Note> actual = resource.getNotes();
        assertEquals(expected, actual);
    }

}