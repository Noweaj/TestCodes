package rxJava.chapter4.section1_creatingOperator;

import io.reactivex.Observable;
import util.CommonUtils;
import util.PrintUtil;

import java.util.concurrent.TimeUnit;

public class subsection4_intervalRange {

    public static void main(String[] args){
        new subsection4_intervalRange().solve();
    }

    private void solve(){
        CommonUtils.exampleStart();

        Observable<String> source = Observable.intervalRange(
                1,
                10,
                0L,
                500L,
                TimeUnit.MILLISECONDS
        ).map(range -> "Number: "+range);

        source.subscribe(util.Log::it);

        CommonUtils.sleep(10000);
    }

}
