public class IssueLaptop {
    public static void main(String... a){

        Storage disk1 = new Storage("512GB", "SSD");
        Processor proc1 = new Processor("Apple M1");
        RAM ram1 = new RAM("8GB","DDR4");

        Laptop laptop = new Laptop();
        laptop.setModel("Mac Pro");
        laptop.setDisk(disk1);
        laptop.setRam(ram1);
        laptop.setProcessor(proc1);

        System.out.println("Issuing Laptop : "+laptop);
    }
}
