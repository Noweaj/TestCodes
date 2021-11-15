package util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckUtil<T> {
    public void checkAnswer(InputSet<T>[] input){
        ArrayList<Boolean> results = new ArrayList<>();
        for (InputSet<T> inp : input) {
            results.add(checkAnswer(inp.getInput(), inp.getAnswer()));
        }
        if(results.contains(false)){
            PrintUtil.println("ERROR!!!. Please check your answer.");
        } else {
            PrintUtil.println("PASS.");
        }
    }

    public boolean checkAnswer(T input, T answer){
        String result = input.equals(answer) ? "CORRECT" : "WRONG";
        PrintUtil.println(result + " || input: "+input+" / answer: "+answer);
        return input.equals(answer);
    }

    public void checkAnswerIntegerArray(InputSet<Integer[]>[] input){

    }

    private boolean checkIntegerArray(Integer[] input, Integer[] answers){
        if(input.length != answers.length){
            PrintUtil.println(stringFormatter(
                    "WRONG",
                    Arrays.toString(input),
                    Arrays.toString(answers)
                    ));
            return false;
        } else {
            for (int i = 0; i < input.length; i++) {
                if(input[i] != answers[i]){
                    PrintUtil.println(stringFormatter(
                            "WRONG",
                            Arrays.toString(input),
                            Arrays.toString(answers)
                    ));
                    return false;
                }
            }
        }
        PrintUtil.println(stringFormatter(
                "CORRECT",
                Arrays.toString(input),
                Arrays.toString(answers)
        ));
        return true;
    }

    private String stringFormatter(String result, String input, String answer){
        StringBuilder sb = new StringBuilder();
        sb.append(result);
        sb.append(" || input: ");
        sb.append(input);
        sb.append(" / answer: ");
        sb.append(answer);
        return sb.toString();
    }

}

