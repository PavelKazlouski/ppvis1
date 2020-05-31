package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class Visual extends Application {

    @Override
    public void start(Stage stage) {

        Button JButton = new Button();
        JButton.setText("Click!");

        JButton.setOnAction(e -> {

            JButton.setText("You've clicked!");
        });

        Group root = new Group(JButton);
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.setTitle("JavaFX");
        stage.setWidth(250);
        stage.setHeight(200);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

