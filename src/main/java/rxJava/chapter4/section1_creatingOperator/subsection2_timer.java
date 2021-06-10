package rxJava.chapter4.section1_creatingOperator;

import io.reactivex.Observable;
import util.CommonUtils;
import util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class subsection2_timer {

    public static void main(String[] args){
        new subsection2_timer().solve();
    }

    private void solve(){
        CommonUtils.exampleStart();

        Observable<String> source = Observable.timer(500L, TimeUnit.MILLISECONDS)
                .map( notUsed -> {
                    return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
                });

        source.subscribe(Log::it);

        CommonUtils.sleep(1000);
    }

}
