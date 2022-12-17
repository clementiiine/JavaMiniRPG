package code.javarpg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class GUIParser extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUIParser.class.getResource("StartGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 600);
        stage.setResizable(false);
        stage.setTitle("RPG");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}