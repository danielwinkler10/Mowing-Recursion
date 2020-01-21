import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("input.txt");
        Scanner scanner = new Scanner(input);
        int numOfCases = scanner.nextInt();
        Board board = new Board();
        for (int i = 0; i < numOfCases; i++) {
            board.initialize(scanner);
            board.solve();
            board.print();
            if (i<numOfCases-1){
                System.out.println("");
            }
        }
    }
}
