package edu.hcmuaf.tranbaquan.media.ltf.controller;

import edu.hcmuaf.tranbaquan.media.ltf.controller.component.MainContentController;
import edu.hcmuaf.tranbaquan.media.ltf.controller.component.SidebarController;
import edu.hcmuaf.tranbaquan.media.ltf.controller.data.Playlist;
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

    private Playlist playlist;

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
        player.setOnReady(() -> mainContentController.playVideo(player));

    }

    public void openFolder() {
//        DirectoryChooser directoryChooser = new DirectoryChooser();
//        directoryChooser.setTitle("Open Folder");
//        directoryChooser.setInitialDirectory(new File("C:/"));
//        Stage stage = (Stage) home.getScene().getWindow();
//        File selected = directoryChooser.showDialog(stage);
//
//        File[] subFiles = selected.listFiles(file -> file.getAbsolutePath().endsWith(".mp4"));
//        playlist = Playlist.getInstance();
//
//        for (File file : subFiles) {
//            URI uri = file.toURI();
//            Media pick = new Media(uri.toString());
//            MediaPlayer player = new MediaPlayer(pick);
//            playlist.addMedia(player);
//        }
//        mainContentController.playVideo(playlist);
    }

    public void resizeContent(boolean isScaleUp) {
        mainContentController.resize(isScaleUp);
    }

    public void showPlaylist() {

    }
}
