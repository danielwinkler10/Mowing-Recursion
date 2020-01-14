import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main{
    public static void main(String[] args) throws FileNotFoundException{

        File input = new File("input.txt");
        Scanner scan = new Scanner(input);

        while(scan.hasNext()){
            int moves = 0;
            String line = scan.nextLine();
            Deletions d = new Deletions(line);
            while(d.checkArray() == false){
                int e = 0;
                while(d.getStringList().contains("0")){
                    d.removeZeros();
                    e++;
                    if(e > 1){
                        d.subtractMove();
                    }
                }
                if(d.checkArray() == false){
                    d.getMostFrequent();
                    d.subtract();
                }
            }
            System.out.println(d.getMoves());
        }
    }
}
