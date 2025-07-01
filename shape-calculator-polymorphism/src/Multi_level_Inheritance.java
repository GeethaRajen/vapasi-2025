public class Multi_level_Inheritance {
    public static void main(String... a){
        new Child("","");
    }
}

class GP {
    String name = "Anjali";
    int age = 30;

    public GP() {
        System.out.println("Default GP constructor invoked");
    }

    public GP(String name, int age) {
        this();
        System.out.println("GP Parameterized constructor");
    }

    public void sayHello(String message) {
        System.out.println(message);
    }

    public void getDetails(){
        sayHello("Hello World!!!");
        System.out.println("Printing GP details");
        System.out.println("Name is "+this.name);
        System.out.println(" Age is "+this.age);
    }
}

class Parent extends GP {
    String city = "Krishnagiri";
    int year = 2025;

    public Parent() {
        super("",0);
        System.out.println("Invoking Parent default constructor");
    }

    public Parent(String birth_city, int birth_year) {
        this();
        System.out.println("Invoking Parent parameterized constructor");
    }

    public void getMessage(String msg){
        System.out.println("I live in "+this.city);
        System.out.println(msg);
    }

    public void getDetails(){
        super.getDetails();
        getMessage("It is a beautiful place to live.\"");
        System.out.println("Current year "+this.year);
        System.out.println("So far all good");
    }
}

class Child extends Parent{
    String snack = "icecream";
    String food = "Poori";

    public Child(){
        super("",0);
        System.out.println("Invoking Child default constructor");
    }

    public Child(String snack, String food) {
        this();
        System.out.println("Invoking Child parameterized constructor");
        this.getDetails();
    }

    public void getDetails(){
        super.getDetails();
        System.out.println("I like to eat.");
        System.out.println("Snack: "+this.snack);
        method1("");
    }

    public void method1(String str){
        System.out.println("Food: "+this.food);
        System.out.println("End of my story");
    }
}