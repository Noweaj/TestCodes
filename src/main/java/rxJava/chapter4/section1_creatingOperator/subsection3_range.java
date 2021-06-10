package rxJava.chapter4.section1_creatingOperator;

import io.reactivex.Observable;
import util.PrintUtil;

public class subsection3_range {

    public static void main(String[] args){
        new subsection3_range().solve();
    }

    private void solve(){
        Observable<String> source = Observable.range(1, 10)
                .filter(cnt -> cnt % 2 == 0)
                .map(num -> "event number: "+num);

        source.subscribe(PrintUtil::println);

    }
}
