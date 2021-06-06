package rxJava.chapter3.section4_reduce;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

public class subsection0_Operator_reduce {

    public static void main(String[] args) {
        new subsection0_Operator_reduce().solve();
    }

    private void solve() {
        BiFunction<String, String, String> mergeStrings =
                (str1, str2) -> str2+"("+str1+")";

        Maybe<String> source = Observable
                .fromArray("String 1", "Strin 2", "String 3", "String 4", "Strng 5")
//                .filter(data -> data.contains("String")) // test
                .reduce((str1, str2) -> str2+"("+str1+")");
        source.subscribe(util.PrintUtil::println);
    }
}
