package edu.hcmuaf.tranbaquan.media.ltf.controller.data;

import javafx.scene.media.Media;

import java.util.LinkedList;

public class Playlist {
    private LinkedList<Media> playlist;

    private static Playlist INSTANCE;

    private Playlist() {
        this.playlist = new LinkedList<>();
    }

    public static Playlist getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Playlist();
        }
        return INSTANCE;
    }

    public void addMedia(Media media) {
        this.playlist.add(media);
    }

    public LinkedList<Media> getPlaylist() {
        return playlist;
    }

    public void pushMedia(Media media) {
        this.playlist.push(media);
    }
}
