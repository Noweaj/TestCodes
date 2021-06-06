package rxJava.chapter3.section3_filter;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Predicate;
import static util.PrintUtil.println;

public class subsection0_Operator_filter {

    public static void main(String[] args) {
        new subsection0_Operator_filter().solve();
    }

    private void solve() {

        Predicate<String> filterContains = str -> str.contains("rxjava");

        Observable<String> source = Observable
                .fromArray(new String[]{"abcrxjavadef", "ghirxjavajkl", "mnopqr", "stuvwx", "yz"})
//                .filter( str -> str.contains("rxjava"));
                .filter(filterContains);
        source.subscribe(util.PrintUtil::println);

        similar();
    }

    private void similar(){
        Single<Integer> source_first = Observable
                .fromArray(1,2,3,4)
                .first(-1);
        source_first.subscribe(data -> println("first: "+data));

        Single<Integer> source_last = Observable
                .fromArray(1,2,3,4)
                .last(-1);
        source_last.subscribe(data -> println("last: "+data));

        Observable<Integer> source_take = Observable
                .fromArray(1,2,3,4)
                .take(3);
        source_take.subscribe(data -> println("take: "+data));

        Observable<Integer> source_takeLast = Observable
                .fromArray(1,2,3,4)
                .takeLast(3);
        source_takeLast.subscribe(data -> println("takeLast: "+data));

        Observable<Integer> source_skip = Observable
                .fromArray(1,2,3,4)
                .skip(2);
        source_skip.subscribe(data -> println("skip: "+data));

        Observable<Integer> source_skipLast = Observable
                .fromArray(1,2,3,4)
                .skipLast(2);
        source_skipLast.subscribe(data -> println("skipLast: "+data));
    }
}
