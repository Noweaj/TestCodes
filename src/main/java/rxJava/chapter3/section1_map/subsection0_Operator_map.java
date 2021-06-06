package rxJava.chapter3.section1_map;

import io.reactivex.Observable;

public class subsection0_Operator_map {

    public static void main(String[] args) {
        new subsection0_Operator_map().solve();
    }

    private void solve() {
        Observable<String> source = Observable
                .fromArray(new String[]{"1", "2", "3", "4"})
                .map(str -> String.valueOf(Integer.parseInt(str)*2));
        source.subscribe(util.PrintUtil::println);
    }
}
