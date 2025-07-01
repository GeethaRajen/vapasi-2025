public class MyCalcApp {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int input = 0;
        System.out.println("Check for input : "+input);
        double value = calc.calcDouble(input);
        System.out.println("Result : "+value);
    }
}
