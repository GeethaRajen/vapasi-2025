import java.util.ArrayList;

public class ShapeCalculator {
    public static void main(String... str){
        ArrayList<Shape> list = new ArrayList<>();

        Shape circle = new Circle(5);

        Rectangle square = new Rectangle();
        square.setDimensions(6);

        Rectangle rect = new Rectangle();
        rect.setDimensions(6,9);

        Triangle triangle = new Triangle(10,12,15);

        list.add(circle);
        list.add(rect);
        list.add(triangle);
        list.add(square);

        for(Shape s:list){
            System.out.println("Name : "+s.getClass().getSimpleName()+" Area : "+s.calculateArea()+" | Perimeter : "+s.calculatePerimeter());
        }
    }
}
