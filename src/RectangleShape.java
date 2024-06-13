
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleShape implements iShape {
	
	double width, height;
	
	public RectangleShape() {
		
	}
	
    @Override
    public void drawShape(Pane board, Location start, Location end, boolean fill, Color color) {
        width = getWidth(start.getX(), end.getX());
        height = getHeight(start.getY(), end.getY());
        
        double x = Math.min(start.getX(), end.getX());
        double y = Math.min(start.getY(), end.getY());

        Rectangle rectangle = new Rectangle(x, y, width, height);
        if (fill) {
            rectangle.setFill(color); 
        } else {
            rectangle.setFill(Color.TRANSPARENT);
            rectangle.setStroke(color); 
        }

        board.getChildren().add(rectangle);
    }
	
	public double getWidth(double start, double end){
		return Math.abs(start-end);
	}
	
	public double getHeight(double start, double end){
		return Math.abs(start-end);
	}

	
	
}
