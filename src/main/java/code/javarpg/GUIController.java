package code.javarpg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIController {
    @FXML
    private Button btnnewgameWindow;

    @FXML
    public void handlebtnNewGameWindow() throws IOException {
        btnnewgameWindow.setText("New Game");
        FXMLLoader fxmlLoader = new FXMLLoader(GUIParser.class.getResource("NewGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 600);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("New Game");
        stage.setScene(scene);
        stage.initModality(Modality.NONE);
        stage.show();

    }
}