public class Storage {
    private String size; //1TB, 512 GB
    private String type;//HDD, SSD, Fusion Drives

    public Storage(){ }

    public Storage(String size, String type) {
        this.size = size;
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "size='" + size + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}