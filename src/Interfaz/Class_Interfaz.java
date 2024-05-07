package Interfaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Class_Interfaz extends Application {

    private static final Random random = new Random();

    private static final String ROOT_STYLE = getRandomColorStyle();
    private static final String LEFT_SIDE_STYLE = getRandomColorStyle();
    private static final String RIGHT_SIDE_STYLE = getRandomColorStyle();

    private static String getRandomColorStyle() {
        return String.format("-fx-background-color: #%02x%02x%02x;",
                random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    @Override
    public void start(Stage stage) {
        try {
            VBox leftSide = new VBox();
            leftSide.setSpacing(10);

            for (int i = 0; i < 8; i++) {
                HBox hbox = new HBox();
                hbox.setSpacing(5);

                TextField textField = new TextField();
                textField.setPromptText("Nombre y apellido");
                textField.setStyle(LEFT_SIDE_STYLE);

                hbox.getChildren().addAll(textField);
                leftSide.getChildren().add(hbox);
            }

            ListView<String> listView = new ListView<>();
            listView.setPrefHeight(340);
            listView.setPrefWidth(200);
            VBox rightSide = new VBox(listView);

            TextField bottomTextField = new TextField();
            bottomTextField.setPrefWidth(420);
            bottomTextField.setStyle(RIGHT_SIDE_STYLE);

            AnchorPane root = new AnchorPane(leftSide, rightSide, bottomTextField);
            root.setStyle(ROOT_STYLE);

            AnchorPane.setLeftAnchor(leftSide, 10.0);
            AnchorPane.setTopAnchor(leftSide, 10.0);

            AnchorPane.setRightAnchor(rightSide, 10.0);
            AnchorPane.setTopAnchor(rightSide, 10.0);

            AnchorPane.setLeftAnchor(bottomTextField, 10.0);
            AnchorPane.setBottomAnchor(bottomTextField, 10.0);

            Scene scene = new Scene(root, 600, 400);

            stage.setTitle("Interface Example");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
