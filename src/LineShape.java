import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LineShape implements iShape {
	
	@Override
	public void drawShape(Pane board, Location start, Location end, boolean fill, Color color) {
        Line line = new Line(start.getX(), start.getY(), end.getX(), end.getY());
        line.setStroke(color);
        board.getChildren().add(line);
	}

}
