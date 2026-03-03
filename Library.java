import java.util.Scanner;

class Book {
    String name;
    String author;
    double price;
    int copies;

    void readData(Scanner sc) {

        System.out.print("Enter Book Name: ");
        name = sc.nextLine();

        System.out.print("Enter Author Name: ");
        author = sc.nextLine();

        System.out.print("Enter Price: ");
        price = sc.nextDouble();

        System.out.print("Enter Number of Copies: ");
        copies = sc.nextInt();
        sc.nextLine();
    }

    void displayData() {
        System.out.println("\nBook Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Copies Available: " + copies);
    }
}

public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];

        for(int i=0;i<5;i++){
            arr[i]=arr[5];   }

        public void adddetails(Book[] arr, Scanner sc) {
            for(int i=0;i<5;i++){ arr[i].readData(sc); }
        }
        
        public void search(Book[] arr, Scanner sc){
            System.out.println("Enter the book name to search: ");
            String searchname = sc.nextLine();
            for(int i=0;i<5;i++){ 
                if(arr[i].name.equals(searchname)){ arr[i].displayData(); } }
            

        




        }

   } }