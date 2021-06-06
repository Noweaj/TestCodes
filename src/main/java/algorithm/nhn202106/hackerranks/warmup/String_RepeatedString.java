package algorithm.nhn202106.hackerranks.warmup;

public class String_RepeatedString {

    public static void main(String[] args){
        String_RepeatedString mClass = new String_RepeatedString();
        long sample1 = mClass.getNumberOfCharA("aba", 10);
        System.out.println("Result: "+(sample1 == 7)+" / answer: 7 / input: "+sample1);

        long sample2 = mClass.getNumberOfCharA("a", 1000000000000L);
        System.out.println("Result: "+(sample2 == 1000000000000L)+" / answer: 7 / input: "+sample2);

        long sample3 = mClass.getNumberOfCharA("abcadeafga", 1000000000000L);
        System.out.println("Result: "+(sample3 == 400000000000L)+" / answer: 7 / input: "+sample3);

        long sample4 = mClass.getNumberOfCharA("abaca", 29);
        System.out.println("Result: "+(sample4 == 17)+" / answer: 17 / input: "+sample4);
    }

    private long getNumberOfCharA(String str, long n){
        if(str.length() == 1 && str.equals("a")) return n;

        long stringSize = str.length();
        long cycle = n / stringSize;

        long wordCnt = 0;
        char[] chars = str.toCharArray();
        for(char c : chars){
            if(c == 'a')
                wordCnt++;
        }

        wordCnt *= cycle;

        long leftovers = n - cycle * stringSize;

        for(int i=0; i<leftovers; i++){
            if(chars[i] == 'a')
                wordCnt++;
        }

        return wordCnt;
    }
}
