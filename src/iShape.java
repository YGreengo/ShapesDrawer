import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public interface iShape {
	   

	void drawShape(Pane board, Location start, Location end, boolean fill, Color selectedColor);
	

}
