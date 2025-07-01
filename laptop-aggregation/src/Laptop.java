public class Laptop {
    String model;
    Processor processor;
    RAM ram;
    Storage disk;

    public Laptop() {
    }

    public Laptop(String model, Processor processor, RAM ram, Storage disk) {
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.disk = disk;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Storage getDisk() {
        return disk;
    }

    public void setDisk(Storage disk) {
        this.disk = disk;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brandName='" + model + '\'' +
                ", processor=" + processor +
                ", ram=" + ram +
                ", disk=" + disk +
                '}';
    }
}
