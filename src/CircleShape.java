import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleShape implements iShape {
	double centerX, centerY, radius;
	@Override
	public void drawShape(Pane board, Location start, Location end, boolean fill, Color color) {
		centerX = getCenter(start.getX(),end.getX());
		centerY = getCenter(start.getY(),end.getY());
		radius = getRadius(start,end);
		Circle circle = new Circle(centerX, centerY, radius);
		if (fill) {
            circle.setFill(color); 
        } else {
            circle.setFill(Color.TRANSPARENT);
            circle.setStroke(color); 
        }		board.getChildren().add(circle);
	}
	
	double getCenter(double start, double end) {
		return (start+end)/2;
	}
	
	double getRadius(Location start, Location end) {
		return Math.sqrt(Math.pow(start.getX()- end.getX(), 2)+Math.pow(start.getY()-end.getY(), 2));
	}

}
