import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class shapesController {

    Location startLocation = new Location (0,0);
    Location endLocation = new Location(0,0);
    boolean fillFlag = false;
    int shapeFlag = 0, shapesCount = 0;
    Color selectedColor = Color.TRANSPARENT;
    String colors[] = {"Black", "Blue", "Yellow", "Green"};
    
    public Color getColor(String color) {
    	switch (color) {
	case "Black":
		return Color.BLACK;
	case "Blue":
		return Color.BLUE;
	case "Yellow":
		return Color.YELLOW;
	case "Green":
		return Color.GREEN;
	default:
		return Color.TRANSPARENT;
		
    }
}
    
    @FXML
    private Pane board;

    @FXML
    private Button circleButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button fillButton;

    @FXML
    private Button lineButtom;

    @FXML
    private Button rectangleButton;

    @FXML
    private Button undoButton;


    @FXML
    void clear(ActionEvent event) {
        for (int i = 0; i < shapesCount; i++) {
            board.getChildren().remove(board.getChildren().size() - 1);
        }    }
    
    @FXML
    private ChoiceBox<String> colorBox;
    
    @FXML
    void initialize() {
        colorBox.getItems().addAll(colors);

        colorBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                selectedColor = getColor(newValue);
                if (selectedColor == Color.TRANSPARENT)
                    JOptionPane.showMessageDialog(null,"Please select a color", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }


    @FXML
    void fillShape(ActionEvent event) {
        fillFlag = !fillFlag;
    }

    @FXML
    void getMouseRelease(MouseEvent event) {
        double endX = event.getX();
        double endY = event.getY();
        endLocation.setLocation(endX, endY);


        try {
            iShape shape = ShapeFactory.createShape(shapeFlag);

            shape.drawShape(board, startLocation, endLocation, fillFlag, selectedColor);
            shapesCount++;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void getStartMouse(MouseEvent event) {
        double startX = event.getX();
        double startY = event.getY();
        startLocation.setLocation(startX, startY);
    }

    @FXML
    void makeCircle(ActionEvent event) {
        shapeFlag = 2;
    }

    @FXML
    void makeLine(ActionEvent event) {
        shapeFlag = 1;
    }

    @FXML
    void makeRectangle(ActionEvent event) {
        shapeFlag = 3;
    }

    @FXML
    void undo(ActionEvent event) {
        if (!board.getChildren().isEmpty()) {
            board.getChildren().remove(board.getChildren().size() - 1);
        }
    }
}
