package edu.hcmuaf.tranbaquan.media.ltf.controller.component;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import edu.hcmuaf.tranbaquan.media.ltf.controller.HomeController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContentDisplay;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class SidebarController implements Initializable {
    private HomeController parent;
    @FXML
    private AnchorPane sidebar;
    @FXML
    private VBox option;
    @FXML
    private FontAwesomeIconView toggleButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void toggle() {
        if (sidebar.getWidth() < 100) {
            open();
            toggleButton.setGlyphName("ANGLE_LEFT");
            parent.resizeContent(false);
        } else {
            close();
            toggleButton.setGlyphName("ANGLE_RIGHT");
            parent.resizeContent(true);
        }
    }

    @FXML
    public void openFile() {
        parent.openFile();
    }

    @FXML
    public void openFolder() {
        parent.openFolder();
    }

    public void setParent(HomeController parent) {
        this.parent = parent;
    }

    private void open() {
        DoubleProperty width = sidebar.prefWidthProperty();
        KeyValue keyValue = new KeyValue(width, 200);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), keyValue));
        timeline.play();
        timeline.setOnFinished(event ->
                option.getChildren().forEach(node -> {
                    JFXButton button = (JFXButton) node;
                    button.setContentDisplay(ContentDisplay.LEFT);
                }));
    }

    private void close() {
        option.getChildren().forEach(node -> {
            JFXButton button = (JFXButton) node;
            button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        });

        DoubleProperty width = sidebar.prefWidthProperty();
        KeyValue keyValue = new KeyValue(width, 50);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), keyValue));
        timeline.play();
    }

    public void startRecognize(MouseEvent mouseEvent) {

    }

    public void showPlaylist(MouseEvent mouseEvent) {
        parent.showPlaylist();
    }
}
