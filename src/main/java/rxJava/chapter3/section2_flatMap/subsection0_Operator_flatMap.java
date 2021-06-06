package rxJava.chapter3.section2_flatMap;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class subsection0_Operator_flatMap {

    public static void main(String[] args) {
        new subsection0_Operator_flatMap().solve();
    }

    /**
     * uses Observable 
     */
    private void solve() {

        Function<String, Observable<String>> getDoubleDiamonds =
                ball -> Observable.just(ball+ "<>", ball+"<>", ball+"<>");

        Observable<String> source = Observable
                .fromArray(new String[]{"1", "2", "3", "4"})
                .flatMap(getDoubleDiamonds);
        source.subscribe(util.PrintUtil::println);
    }
}
