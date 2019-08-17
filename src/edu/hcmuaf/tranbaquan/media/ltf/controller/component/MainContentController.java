package edu.hcmuaf.tranbaquan.media.ltf.controller.component;

import edu.hcmuaf.tranbaquan.media.ltf.controller.HomeController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MainContentController implements Initializable {
    private HomeController parent;
    @FXML
    private AnchorPane content;
    @FXML
    private MediaView media;
    @FXML
    private AnchorPane control;
    @FXML
    private VideoControlController videoControlController;
    private MediaPlayer player;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        videoControlController.setParent(this);
    }

    public void showControl() {
        if (media.getMediaPlayer() != null) {
            control.setVisible(true);
            BooleanProperty isShow = control.visibleProperty();
            KeyValue keyValue = new KeyValue(isShow, !isShow.get());
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(5), keyValue);
            Timeline timeline = new Timeline(keyFrame);
            timeline.play();
        }
    }

    public void setParent(HomeController parent) {
        this.parent = parent;
    }

    public void playVideo(MediaPlayer mediaPlayer) {
        content.getStyleClass().add("dark");
        if(player != null) {
            player.stop();
        }
        player = mediaPlayer;
        media.setMediaPlayer(player);
        player.play();
        videoControlController.update();
    }

    public void resize(boolean isScaleUp) {
        double size = content.getScene().getWindow().getWidth() - 16;
        if (isScaleUp) {
            resizeAnimation(size - 50);
        } else {
            resizeAnimation(size - 200);
        }
    }

    private void resizeAnimation(double nextValue) {
        DoubleProperty width = media.fitWidthProperty();
        KeyValue keyValue = new KeyValue(width, nextValue);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
        Timeline timeline = new Timeline(keyFrame);
        timeline.play();
    }

    public MediaPlayer getPlayer() {
        return player;
    }
}
