import java.util.Arrays;
import java.util.ArrayList;

public class Deletions{
    String inputLine;
    String[] stringArray;
    ArrayList<String> inputList = new ArrayList<String>();
    int mostFrequent;
    int frequency;
    int max;
    int place;
    int moves;

    public Deletions(String l){
        inputLine = l;
        inputLine = inputLine.replace(" ","");
        stringArray = inputLine.split(",");
        for (String s : stringArray){
            inputList.add(s);
        }
        String mostFrequent = inputList.get(0);
    }

    public ArrayList<String> getStringList() {
        return inputList;
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

    public void getMostFrequent(){
        frequency = 0;
        mostFrequent = 0;
        for(int i = 0; i < inputList.size(); i++){
            int count = 0;
            for(int j = 0; j < inputList.size(); j++){
                if(Integer.valueOf(inputList.get(i)) == Integer.valueOf(inputList.get(j)))
                    count++;
            }

            if(count > frequency){
                frequency = count;
                mostFrequent = Integer.valueOf(inputList.get(i));
                place = i;
            }else if(count == frequency){
                if(mostFrequent < Integer.valueOf(inputList.get(i))){
                    mostFrequent = Integer.valueOf(inputList.get(i));
                    place = i;
                } else if(mostFrequent == Integer.valueOf(inputList.get(i))){
                    place = i;
                }
            }
        }
    }

    public void subtract(){
        //Even - subtract 2
        if(mostFrequent % 2 == 0){
            mostFrequent = mostFrequent-2;
        } else{
            //Odd - subtract 1
            mostFrequent = mostFrequent-1;
        }
        if(mostFrequent >= 0){
            inputList.set(place, String.valueOf(mostFrequent));
        }else{
            inputList.set(0, "0");
        }
        moves++;
    }

    //subtracts a move (in case of few zeros)
    public void subtractMove(){
        moves--;
    }


    public boolean checkArray(){
        //if array is empty (Yay) returns true
        if(inputList.size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public int getMoves() {
        return moves;
    }
}
