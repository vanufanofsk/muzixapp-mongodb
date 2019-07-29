package com.stackroute.muzixapp.Domain;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "track")
public class Track {
    @Id
    private int id;
    private String name;
    private String artist;

  /*  public Track() {
    }

    public Track(int id, String trackName, String trackArtist) {
        this.id = id;
        this.name = trackName;
        this.artist = trackArtist;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", trackName='" + name + '\'' +
                ", trackArtist='" + artist+ '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrackName() {
        return name;
    }

    public void setTrackName(String trackName) {
        this.name = trackName;
    }

    public String getTrackComments() {
        return artist;
    }

    public void setTrackComments(String trackArtist) {
        this.artist = trackArtist;
    }*/
}
