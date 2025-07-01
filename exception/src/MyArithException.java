public class MyArithException extends RuntimeException {

    public static final String ZERO_NOT_ALLOWED = "Zero not allowed";
    public static final String NEGATIVE_NOT_ALLOWED = "Negative not allowed";

    MyArithException(){}

    MyArithException(String message){
        super(message);
    }
}
