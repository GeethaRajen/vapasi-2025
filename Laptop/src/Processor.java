public class Processor {

    private String type;//Apple M1, Apple M2

    public Processor(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "type='" + type + '\'' +
                '}';
    }
}
