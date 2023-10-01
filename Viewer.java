import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Viewer extends Application {
    private Controller controller;
    private TextField textField;
    private byte BUTTON_WIDTH = 70;
    private byte BUTTON_HEIGHT = 70;

    public Viewer() {
        controller = new Controller(this);
    }

    public void start(Stage stage) {
        initScene(stage);
    }

    private void initScene(Stage stage) {
        Pane root = new Pane();
        initComponents(root);
        Scene scene = new Scene(root, 300, 500);
        stage.setScene(scene);
        stage.setTitle("Alien");
        stage.show();
    }

    private void initComponents(Pane root) {
        textField = new TextField();
        textField.setEditable(false);
        textField.setEditable(false);
        textField.setLayoutX(5.0);
        textField.setLayoutY(135.0);
        textField.setPrefSize(290, 25);
        textField.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        textField.setStyle("-fx-background-color: #f3f3f3; -fx-text-fill: #acacac;");
        textField.setAlignment(Pos.CENTER_RIGHT);
        byte buttonIndex = 0;
        char[] symbols = {'@','X','%','D','#','F','!','Y','$','C','+','='};
        for (int i = 0;i < 4;i++) {
            for (int r = 0;r < 3;r++) {
                root.getChildren().add(createButton(String.valueOf(symbols[buttonIndex]),i*BUTTON_WIDTH+10,
                        r*BUTTON_HEIGHT+180));
                buttonIndex++;
            }
        }
        root.getChildren().addAll(textField,createButton("G",80,390));
    }

    public void startJavaFX(String[] args) {
        launch(args);
    }

    private Button createButton(String text, double layoutX, double layoutY) {
        Button button = new Button(text);
        button.setLayoutX(layoutX);
        button.setLayoutY(layoutY);
        button.setPrefHeight(BUTTON_HEIGHT);
        button.setPrefWidth(BUTTON_WIDTH);
        button.setStyle(String.format("-fx-background-color: %s;-fx-border-width: 1px; -fx-border-color: #000000;",
                "C+=".contains(text) ? "#5CBA7B" : "#D9F0E1"));
        button.setTextFill(Color.web("#000000"));
        Font font = new Font("Verdana Bold", 15.0);
        button.setFont(font);
        button.setOnAction(controller);
        return button;
    }

    public void setTextField(String result) {
        textField.clear();
        textField.appendText(result);
    }

    public TextField getTextField() {
        return textField;
    }

}
