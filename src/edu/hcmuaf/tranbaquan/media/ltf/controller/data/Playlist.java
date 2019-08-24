package edu.hcmuaf.tranbaquan.media.ltf.controller.data;

import javafx.scene.media.Media;

import java.util.LinkedList;

public class Playlist {
    private LinkedList<Media> playlist;
    private LinkedList<Media> playback;

    private static Playlist INSTANCE;

    private Playlist() {
        this.playlist = new LinkedList<>();
        this.playback = new LinkedList<>();
    }

    public static Playlist getInstance() {
        if (INSTANCE == null) {
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

    public void nextMedia() {
        if (!playlist.isEmpty()) {
            this.playback.push(this.playlist.pop());
        }
    }

    public void previousMedia() {
        if (!playback.isEmpty()) {
            this.playlist.push(this.playback.pop());
        }
    }
}
