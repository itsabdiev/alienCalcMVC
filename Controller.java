import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller implements EventHandler <ActionEvent> {
    private Model model;

    public Controller(Viewer viewer) {
        model = new Model(viewer);
    }

    public void handle(ActionEvent event) {
        Button buttonEvent = (Button) event.getTarget();
        String textButton = buttonEvent.getText();
        String command;
        if (textButton.equals("G")) {
            command = "0";
        } else if (textButton.equals("%")) {
            command = "1";
        } else if (textButton.equals("F")) {
            command = "2";
        } else if (textButton.equals("$")) {
            command = "3";
        } else if (textButton.equals("X")) {
            command = "4";
        } else if (textButton.equals("#")) {
            command = "5";
        } else if (textButton.equals("Y")) {
            command = "6";
        } else if (textButton.equals("@")) {
            command = "7";
        } else if (textButton.equals("D")) {
            command = "8";
        } else if (textButton.equals("!")) {
            command = "9";
        } else if (textButton.equals("+")) {
            command = "+";
        } else if (textButton.equals("=")) {
            command = "=";
        }else {
            command = "C";
        }
        model.doAction(command);
    }
}
