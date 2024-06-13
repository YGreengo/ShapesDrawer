public class ShapeFactory {
	
    public static iShape createShape(int shapeFlag) {
        switch (shapeFlag) {
            case 1:
                return new LineShape();
            case 2:
                return new CircleShape();
            case 3:
                return new RectangleShape();
            default:
                throw new IllegalArgumentException("please selece a shape");
        }
    }
}