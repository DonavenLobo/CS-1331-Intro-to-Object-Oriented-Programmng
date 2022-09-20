//I worked on the homework assignment alone, using only course materials.

import javafx.application.Application;
import javafx.event.ActionEvent;
//import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * This Class represents a multiplayer JavaFX Fractal game
 * @author Donaven Lobo
 * @version 2.0
 */
public class FractalMuseum extends Application {

    private int numOfFractals;
    private int player1Total;
    private int player2Total;

    /**
     * Main Method, Launches the application
     * @param args No Command Line input given
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The Overriden start method
     * @param stage Stage object to present application
     */
    public void start(Stage stage) {
        //Create all nodes

        Label numberOfFractals = new Label();

        Label zoomPrompt1 = new Label();
        zoomPrompt1.setText("Note: You can zoom in and out using scroll!");
        zoomPrompt1.setFont(Font.font("Verdana", FontPosture.ITALIC, 8));

        /**Label zoomPrompt2 = new Label();
        zoomPrompt2.setText("IF YOU USED THE ZOOM FUNCTION MAKE SURE TO ZOOM OUT FULLY TO CLICK NEW GAME");
        zoomPrompt2.setFont(Font.font("Verdana", FontWeight.BOLD, 8));*/

        Button guesses = new Button();
        guesses.setDisable(true);
        guesses.setText("Submit Guesses!");

        TextField player1Input = new TextField();
        player1Input.setPromptText("Player 1 Guess");
        player1Input.setDisable(true);
        player1Input.setFocusTraversable(true);

        TextField player2Input = new TextField();
        player2Input.setPromptText("Player 2 Guess");
        player2Input.setDisable(true);
        player2Input.setFocusTraversable(true);

        Label player1Score = new Label("Player 1 Score: 0");
        Label player2Score = new Label("Player 2 Score: 0");

        Pane fractalImage = new Pane();
        fractalImage.setPrefSize(500, 500);

        Button newGame = new Button();
        newGame.setText("New Game");
        newGame.setAlignment(Pos.CENTER);

        HBox guessingRow = new HBox();
        guessingRow.setAlignment(Pos.CENTER);
        guessingRow.setSpacing(10);
        guessingRow.getChildren().addAll(player1Input, player2Input, guesses);

        HBox scoreRow = new HBox();
        scoreRow.setAlignment(Pos.CENTER);
        scoreRow.setSpacing(10);
        scoreRow.getChildren().addAll(player1Score, player2Score);

        VBox topElements = new VBox();
        topElements.setAlignment(Pos.CENTER);
        topElements.setSpacing(10);
        topElements.getChildren().addAll(newGame, zoomPrompt1);

        HBox fractalRow = new HBox();
        fractalRow.setAlignment(Pos.CENTER);
        fractalRow.setViewOrder(1.0);
        fractalRow.getChildren().add(fractalImage);

        VBox bottomElements = new VBox();
        bottomElements.setAlignment(Pos.CENTER);
        bottomElements.setSpacing(10);
        bottomElements.getChildren().addAll(guessingRow, scoreRow, numberOfFractals);

        newGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                fractalImage.getChildren().clear();
                numOfFractals = FractalFactory.drawFractal(fractalImage);
                player1Input.setDisable(false);
                player2Input.setDisable(false);
                guesses.setDisable(false);
                numberOfFractals.setText("");
            }
        });

        guesses.setOnAction(event -> {
                String player1InputString = player1Input.getCharacters().toString();
                String player2InputString = player2Input.getCharacters().toString();
                try {
                    double player1Guess = Double.parseDouble(player1InputString);
                    double player2Guess = Double.parseDouble(player2InputString);
                    if (player1Guess < 0 || player2Guess < 0) {
                        throw new NumberFormatException();
                    }
                    double player1Diff = Math.abs(player1Guess - numOfFractals);
                    double player2Diff = Math.abs(player2Guess - numOfFractals);
                    if (player1Diff < player2Diff) {
                        player1Total++;
                    } else if (player2Diff < player1Diff) {
                        player2Total++;
                    }
                    player1Score.setText("Player 1 Score: " + player1Total);
                    player2Score.setText("Player 2 Score: " + player2Total);
                    player1Input.setDisable(true);
                    player2Input.setDisable(true);
                    guesses.setDisable(true);
                    numberOfFractals.setText("Number of Fractals: " + numOfFractals);
                } catch (NumberFormatException e) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setHeaderText("Invalid Guess!");
                    a.setContentText("That is not a valid guess entry. Enter a positive number.");
                    a.showAndWait();
                } finally {
                    player1Input.clear();
                    player2Input.clear();
                }
            });

        fractalImage.setOnScroll(new EventHandler<ScrollEvent>() {
            public void handle(ScrollEvent event) {
                event.consume();
                if (event.getDeltaY() == 0) {
                    return;
                }
                double scaleFactor =
                        (event.getDeltaY() > 0)
                                ? 1.1
                                : 1 / 1.1;
                fractalImage.setScaleX(fractalImage.getScaleX() * scaleFactor);
                fractalImage.setScaleY(fractalImage.getScaleY() * scaleFactor);
            }
        });

        // Creating the main page layout
        BorderPane root = new BorderPane();
        root.setTop(topElements);
        root.setCenter(fractalRow);
        root.setBottom(bottomElements);
        root.setStyle("-fx-padding: 10;" + "-fx-border-style: dotted;" + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: lightskyblue;");

        // Showing the application stuff
        Scene scene = new Scene(root, 700, 700);
        stage.setTitle("Fractal Museum.");
        stage.setScene(scene);
        stage.show();

    }
}
