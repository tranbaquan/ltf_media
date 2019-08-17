package edu.hcmuaf.tranbaquan.media.ltf.controller.data;

import javafx.scene.media.MediaPlayer;

import java.util.LinkedList;

public class Playlist {
    private LinkedList<MediaPlayer> mediaPlayers;

    private static Playlist INSTANCE;

    private Playlist() {
        this.mediaPlayers = new LinkedList<>();
    }

    public static Playlist getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Playlist();
        }
        return INSTANCE;
    }

    public void addMedia(MediaPlayer mediaPlayer) {
        mediaPlayers.add(mediaPlayer);
    }

    public LinkedList<MediaPlayer> getMediaPlayers() {
        return mediaPlayers;
    }
}
