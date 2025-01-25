package ms.prac;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
        	System.out.print("\n\n");
            System.out.println("***** Online Library System *****");
            System.out.println("1. Add Book To Library");
            System.out.println("2. Borrow Book From Library");
            System.out.println("3. Return Book to the Library");
            System.out.println("4. View Available Books in Library");
            System.out.println("5. Exit");

            System.out.print("\nEnter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    Library.addBook();
                    break;
                case 2:
                    Library.BorrowBook();
                    break;
                case 3:
                    Library.returnBook();
                    break;
                case 4:
                    Library.ViewBooks();
                    break;
                case 5:
                    System.out.println("Thank you for using the Online Library System!");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid Choice, please try again.");
            }
        }
    }
}
