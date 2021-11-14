package util;

public class InputSet<T> {
    private T input;
    private T answer;

    public InputSet(T input, T answer){
        this.input = input;
        this.answer = answer;
    }

    public T getInput(){
        return input;
    }
    public T getAnswer(){
        return answer;
    }
}
