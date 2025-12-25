package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        GameLogic game = new GameLogic();

        Label title = new Label("Random Number Guessing Game");

        TextField input = new TextField();
        input.setPromptText("Enter number (1-100)");

        Button guessButton = new Button("Guess");
        Button resetButton = new Button("Reset");

        Label result = new Label();

        guessButton.setOnAction(e -> {
            try {
                int guess = Integer.parseInt(input.getText());
                result.setText(game.checkGuess(guess));
            } catch (Exception ex) {
                result.setText("Please enter a valid number!");
            }
        });

        resetButton.setOnAction(e -> {
            game.generateNumber();
            result.setText("Game Reset. Guess again!");
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                title, input, guessButton, resetButton, result
        );
        layout.setStyle("-fx-padding: 20");

        Scene scene = new Scene(layout, 350, 250);

        stage.setTitle("SCT_SD_2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

