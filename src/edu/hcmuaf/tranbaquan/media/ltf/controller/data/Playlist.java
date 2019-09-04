package edu.hcmuaf.tranbaquan.media.ltf.controller.data;

import javafx.scene.media.Media;

import java.util.LinkedList;

public class Playlist {
    private LinkedList<Media> playlist;
    private int index;

    private static Playlist INSTANCE;

    private Playlist() {
        this.playlist = new LinkedList<>();
        index = 0;
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
        this.playlist.add(index + 1, media);
    }

    public void nextMedia() {
        if (index < playlist.size() - 1) {
            index++;
        }
    }

    public void previousMedia() {
        if (index > 0) {
            index--;
        }
    }

    public Media getMedia() {
        if (index < playlist.size()) {
            return playlist.get(index);
        }
        return null;
    }
}
