import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main{
    public static void main(String[] args) throws FileNotFoundException{
        File inFile = new File("input.txt");
        Scanner scanFile = new Scanner(inFile);

        while(scanFile.hasNext()){
            int moves = 0;
            String line = scanFile.nextLine();
            Deletions d = new Deletions(line);
            //if not empty
            while(d.checkArray() == false){
                int m = 0;
                //if there are 0s
                while(d.getStringList().contains("0")){
                    d.removeZeros();
                    m++;
                    if(m > 1){
                        //Only one move to remove all 0s
                        d.subtractMove();
                    }
                }
                //finds and subtracts largest
                d.getLargest();
                if(d.checkArray() == false){
                    d.subtract();
                }
            }
            System.out.println(d.getMoves());
        }
    }
}
