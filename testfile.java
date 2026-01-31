class anvi {
    static void garv() {
        System.out.println("garv from class");
    }
}
public class testfile {
    public static void main(String[] args) {
        anvi.garv(); // Call static method directly
    }
}
