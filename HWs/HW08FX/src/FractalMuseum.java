import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.InputMismatchException;

public class FractalMuseum extends Application {

    private int numOfFractals;
    private int player1Total;
    private int player2Total;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        //Create all nodes

        Pane FractalImage = new Pane();

        Button newGame = new Button();
        newGame.setText("New Game");
        newGame.setOnAction( actionEvent -> {
            numOfFractals = FractalFactory.drawFractal(FractalImage);
        });

        Button guesses = new Button();
        guesses.setText("Submit Guesses!");

        TextField player1Input = new TextField("Player 1 Guess");
        player1Input.setFocusTraversable(false);

        TextField player2Input = new TextField("Player 2 Guess");
        player2Input.setFocusTraversable(false);

        Label player1Score = new Label("Player 1 Score: 0");
        Label player2Score = new Label("Player 2 Score: 0");

        Label numberOfFractals = new Label();

        HBox guessingRow = new HBox();
        guessingRow.setAlignment(Pos.CENTER);
        guessingRow.setSpacing(10);
        guessingRow.getChildren().addAll(player1Input, player2Input, guesses);

        HBox scoreRow = new HBox();
        scoreRow.setAlignment(Pos.CENTER);
        scoreRow.setSpacing(10);
        scoreRow.getChildren().addAll(player1Score, player2Score);

        VBox bottomElements = new VBox();
        bottomElements.setAlignment(Pos.CENTER);
        bottomElements.setSpacing(10);
        bottomElements.getChildren().addAll(guessingRow, scoreRow);

         guesses.setOnAction(event -> {
             String player1InputString = player1Input.getCharacters().toString();
             String player2InputString = player2Input.getCharacters().toString();
             try {
                 double player1Guess = Double.parseDouble(player1InputString);
                 double player2Guess = Double.parseDouble(player2InputString);
                 double player1Diff = Math.abs(player1Guess - numOfFractals);
                 double player2Diff = Math.abs(player2Guess - numOfFractals);
                 if (player1Diff < player2Diff) {
                     player1Total++;
                 } else if (player2Diff < player1Diff) {
                     player2Total++;
                 }
                 numberOfFractals.setText("Number of Fractals: " + numOfFractals);
                 bottomElements.getChildren().addAll(guessingRow, scoreRow, numberOfFractals);
             } catch (InputMismatchException E) {

             }
                });



        // Creating the main page layout
        BorderPane root = new BorderPane();
        root.setTop(newGame);
        root.setBottom(bottomElements);
        root.setCenter(FractalImage);


        // Showing the application stuff
        Scene scene = new Scene(root, 600,600);
        stage.setTitle("Fractal Museum.");
        stage.setScene(scene);
        stage.show();

    }

}
