package edu.hcmuaf.tranbaquan.media.ltf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/home.fxml"));
        primaryStage.setTitle("LTF Media");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }
}
