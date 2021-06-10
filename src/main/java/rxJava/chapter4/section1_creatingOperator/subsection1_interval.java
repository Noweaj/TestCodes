package rxJava.chapter4.section1_creatingOperator;

import io.reactivex.Observable;
import util.CommonUtils;

import java.util.concurrent.TimeUnit;

public class subsection1_interval {

    public static void main(String[] args){ new subsection1_interval().solve(); }

    private void solve(){
        CommonUtils.exampleStart();

        Observable<Long> source = Observable
                .interval(0L, 100L, TimeUnit.MILLISECONDS)
                .map(data -> (data+1)*100)
                .take(5);
        source.subscribe(util.Log::it);

        CommonUtils.sleep(1000);
    }
}
