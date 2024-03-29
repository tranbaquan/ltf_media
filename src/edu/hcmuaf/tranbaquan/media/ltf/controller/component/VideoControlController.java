package edu.hcmuaf.tranbaquan.media.ltf.controller.component;

import com.jfoenix.controls.JFXSlider;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import edu.hcmuaf.tranbaquan.media.ltf.controller.data.Playlist;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class VideoControlController implements Initializable {
    private MainContentController parent;
    private MediaPlayer player;
    private double currentVolume;
    @FXML
    private JFXSlider time;
    @FXML
    private JFXSlider volume;
    @FXML
    private FontAwesomeIconView volumeIcon;
    @FXML
    private FontAwesomeIconView playIcon;

    private Playlist playlist = Playlist.getInstance();

    private boolean isPlay;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        isPlay = true;
    }

    public void setParent(MainContentController parent) {
        this.parent = parent;
    }

    public void update() {
        player = parent.getPlayer();
        time.setMax(player.getTotalDuration().toSeconds());

        player.currentTimeProperty().addListener(observable -> time.setValue(player.getCurrentTime().toSeconds()));
        time.valueProperty().addListener(observable -> {
            if(time.isValueChanging()) {
                player.seek(Duration.seconds(time.getValue()));
            }
        });

//        time.valueProperty().bind(Bindings.createDoubleBinding(() -> player.getCurrentTime().toSeconds(), player.currentTimeProperty()));
        volume.valueProperty().addListener(observable -> {
            if (volume.isPressed()) {
                if (player.isMute()) {
                    volumeUp();
                }
                player.setVolume(volume.getValue() / 100);
            }
        });
    }

    @FXML
    public void changeVolume() {
        if (player.isMute()) {
            volumeUp();
        } else {
            mute();
        }
    }


    @FXML
    public void play() {
        if (isPlay) {
            player.pause();
            playIcon.setGlyphName("PLAY");
        } else {
            player.play();
            playIcon.setGlyphName("PAUSE");
        }
        isPlay = !isPlay;
    }

    @FXML
    public void previous() {
        parent.playPreviousVideo();
    }

    @FXML
    public void next() {
        parent.playNextVideo();
    }

    public void volumeUp() {
        player.setVolume(currentVolume);
        volume.setValue(currentVolume);
        volumeIcon.setGlyphName("VOLUME_UP");
        player.setMute(false);
    }

    public void mute() {
        currentVolume = volume.getValue();
        player.setMute(true);
        volume.setValue(0);
        volumeIcon.setGlyphName("VOLUME_OFF");
    }

    public void changeMediaStatus() {
    }

    public void changeVolume(double range) {
        this.currentVolume += range;
        if(currentVolume > 1) {
            currentVolume = 1;
        }
        if(currentVolume < 0) {
            currentVolume = 0;
        }
        volumeUp();
    }
}
