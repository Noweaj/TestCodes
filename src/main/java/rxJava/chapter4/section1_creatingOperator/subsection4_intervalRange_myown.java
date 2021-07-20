package rxJava.chapter4.section1_creatingOperator;

import io.reactivex.Observable;
import util.CommonUtils;
import util.Log;

import java.util.concurrent.TimeUnit;

public class subsection4_intervalRange_myown {

    public static void main(String[] args){
        new subsection4_intervalRange_myown().solve();
    }

    private void solve(){
        CommonUtils.exampleStart();

        Observable<String> source = Observable
                .interval(0L, 500L, TimeUnit.MILLISECONDS)
                .map(val -> "val"+val)
                .take(10);

        source.subscribe(data -> new Log().it("currentL: "+data));

        CommonUtils.sleep(10000);
    }
}
