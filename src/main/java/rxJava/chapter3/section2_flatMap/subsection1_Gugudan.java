package rxJava.chapter3.section2_flatMap;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class subsection1_Gugudan {

    public static void main(String[] args) {
        new subsection1_Gugudan().solve();
    }

    private void solve() {
        Function<Integer, Observable<Integer>> getGugudan =
                data -> Observable.just(data*4);

        Observable<Integer> source = Observable
                .range(1, 9)
//                .map(num -> num*2);
                .flatMap(getGugudan);
        source.subscribe(util.PrintUtil::println);

    }
}
