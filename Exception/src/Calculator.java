public class Calculator {

    public double calcDouble(int x){
        System.out.println("Inside calcDouble()");
        if(x==0){
            throw new MyArithException(MyArithException.ZERO_NOT_ALLOWED);
        } else if(x<0){
            throw new MyArithException(MyArithException.NEGATIVE_NOT_ALLOWED);
        }
        return Double.parseDouble(String.valueOf(x));
    }
}
