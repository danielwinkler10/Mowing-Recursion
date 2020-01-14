import java.util.Arrays;
import java.util.ArrayList;

public class Deletions{
    String inputLine;
    String[] inputArray;
    ArrayList<String> inputList = new ArrayList<String>();
    int biggest;
    int pos;
    int moves;

    public Deletions(String l){
        inputLine = l;
        inputLine = inputLine.replace(" ","");
        inputArray = inputLine.split(",");
        for (int i =1; i<inputArray.length;i++)
        {
            inputList.add(inputArray[i]);
        }
    }

    public int getMoves() {
        return moves;
    }

    public ArrayList<String> getStringList() {
        return inputList;
    }

    //subtracts a move (in case of few zeros)
    public void subtractMove()
    {
        moves--;
    }

    //removes left to the zero and zero
    public void removeZeros(){
        for(int i = 0; i<inputList.size();i++){
            if(Integer.valueOf(inputList.get(i)) == 0){
                inputList.remove(inputList.get(i));
                if(inputList.size() != 0){
                    for(int o = 0; o<i;o++){
                        inputList.remove(0);
                    }
                    i = inputList.size();
                }
            }
        }
        moves++;
    }

    //Finds the largest element and its position
    public void getLargest(){
        for(int i = 0; i<inputList.size();i++){
            if(i == 0 && inputList.size() != 1){
                //First element
                if(Integer.valueOf(inputList.get(i)) < Integer.valueOf(inputList.get(i+1))){
                    biggest = Integer.valueOf(inputList.get(i+1));
                    pos = i+1;
                }else if(Integer.valueOf(inputList.get(i)) == Integer.valueOf(inputList.get(i+1))){
                    biggest = Integer.valueOf(inputList.get(i+1));
                    pos = i+1;
                }else if(Integer.valueOf(inputList.get(i)) > Integer.valueOf(inputList.get(i+1))){
                    biggest = Integer.valueOf(inputList.get(i));
                    pos = i;
                }
            } else if(i < inputList.size()-1){
                //Mid ones
                if(Integer.valueOf(inputList.get(i)) > biggest){
                    biggest = Integer.valueOf(inputList.get(i));
                    pos = i;
                }else if(Integer.valueOf(inputList.get(i)) == biggest){
                    biggest = Integer.valueOf(inputList.get(i));
                    pos = i;
                }else if(Integer.valueOf(inputList.get(i)) < Integer.valueOf(inputList.get(i+1)) && Integer.valueOf(inputList.get(i+1)) > biggest){
                    biggest = Integer.valueOf(inputList.get(i+1));
                    pos = i+1;
                }
            }else{
                //Last one
                if(Integer.valueOf(inputList.get(i)) > biggest){
                    biggest = Integer.valueOf(inputList.get(i));
                    pos = i;
                }else if(Integer.valueOf(inputList.get(i)) == biggest){
                    biggest = Integer.valueOf(inputList.get(i));
                    pos = i;
                }
            }
        }
    }

    public void subtract(){
        //Even - subtract 2
        if(biggest % 2 == 0){
            biggest = biggest-2;
        }else{
        //Odd - subtract 1
            biggest = biggest-1;
        }
        if(biggest >= 0){
            inputList.set(pos, String.valueOf(biggest));
        }else{
            inputList.set(0, "0");
        }
        moves++;
    }

    public boolean checkArray(){
        //if array is empty (Yay) returns true
        if(inputList.size() == 0){
            return true;
        }else{
            return false;
        }
    }
}
