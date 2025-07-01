public class Circle extends Shape{
    double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    double calculateArea(){
        return Math.PI * radius * radius;
    }
    double calculatePerimeter(){
        return 2 * Math.PI * radius;
    }
}
