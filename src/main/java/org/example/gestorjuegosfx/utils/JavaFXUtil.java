package org.example.gestorjuegosfx.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lombok.Getter;


import java.io.IOException;

@Getter
public class JavaFXUtil {

    private static Stage stage;

    private JavaFXUtil() {}

    public static void initStage(Stage stage) {
        JavaFXUtil.stage = stage;

    }



    public static <T> T setScene(String fxml) {

        try {
            FXMLLoader loader = new FXMLLoader(JavaFXUtil.class.getResource(fxml));
            Parent root = loader.load();
            T controller = loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

            return controller;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void showModal(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.initOwner(stage);
        alert.showAndWait();
    }
}
