public class Rectangle extends Shape{
    double length;
    double width;

    public Rectangle() {
    }

    public void setDimensions(double length){
        this.length = length;
        this.width = length;
    }

    public void setDimensions(double length, double width){
        this.length = length;
        this.width = width;
    }

    double calculateArea(){
        return length * width;
    }

    double calculatePerimeter(){
        return 2*(length+width);
    }
}