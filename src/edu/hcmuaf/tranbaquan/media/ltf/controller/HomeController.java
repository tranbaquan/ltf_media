package edu.hcmuaf.tranbaquan.media.ltf.controller;

import edu.hcmuaf.tranbaquan.media.ltf.controller.component.MainContentController;
import edu.hcmuaf.tranbaquan.media.ltf.controller.component.SidebarController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private SidebarController sidebarController;
    @FXML
    private MainContentController mainContentController;
    @FXML
    private AnchorPane home;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sidebarController.setParent(this);
        mainContentController.setParent(this);
    }

    public void openFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        Stage stage = (Stage) home.getScene().getWindow();
        FileChooser.ExtensionFilter extension = new FileChooser.ExtensionFilter("Videos", "*.mp4");
        fileChooser.getExtensionFilters().add(extension);
        File file = fileChooser.showOpenDialog(stage);
        if (file == null) return;
        URI uri = file.toURI();
        Media pick = new Media(uri.toString());
        MediaPlayer player = new MediaPlayer(pick);
        mainContentController.playVideo(player);
    }

    public void resizeContent(boolean isScaleUp) {
        mainContentController.resize(isScaleUp);
    }
}
