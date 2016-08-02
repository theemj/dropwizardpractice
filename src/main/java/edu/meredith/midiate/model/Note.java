package edu.meredith.midiate.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by emily on 7/21/16.
 */
public class Note {

    private final String title;
    private final String body;
    private final long id;

    //constructor
    @JsonCreator
    public Note(
            @JsonProperty("id") long id,
            @JsonProperty("title") String title,
            @JsonProperty("body") String body)
    {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (id != note.id) return false;
        if (title != null ? !title.equals(note.title) : note.title != null) return false;
        return body != null ? body.equals(note.body) : note.body == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", id=" + id +
                '}';
    }

}
