public class RAM {
    private String memory;//8GB, 16GB
    private String type; //DDR4, DDR3L

    public RAM(String memory, String type) {
        this.memory = memory;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "RAM{" +
                "memory='" + memory + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
