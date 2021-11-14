package util;

import java.util.ArrayList;

public class CheckUtil<T> {
    public boolean checkAnswer(T input, T answer){
        String result = input.equals(answer) ? "CORRECT" : "WRONG";
        PrintUtil.println(result + " || input: "+input+" / answer: "+answer);
        return input.equals(answer);
    }

    public void checkAnswer(InputSet<T>[] input){
        ArrayList<Boolean> results = new ArrayList<>();
        for(InputSet<T> inp : input){
            results.add(checkAnswer(inp.getInput(), inp.getAnswer()));
        }
        if(results.contains(false)){
            PrintUtil.println("ERROR!!!. Please check your answer.");
        } else {
            PrintUtil.println("PASS.");
        }
    }
}

