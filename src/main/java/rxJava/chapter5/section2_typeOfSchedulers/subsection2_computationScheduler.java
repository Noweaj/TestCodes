package rxJava.chapter5.section2_typeOfSchedulers;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import util.CommonUtils;
import util.Log;

import java.util.concurrent.TimeUnit;

public class subsection2_computationScheduler {

    public static void main(String[] args){
        new subsection2_computationScheduler().solve();
    }

    private void solve(){
        String[] orgs = {"1", "3", "5"};

        Observable<String> source = Observable.fromArray(orgs)
                .zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS), (a, b) -> a);

        // subscription #1
        source.map(item -> "<<"+item+">>")
                .subscribeOn(Schedulers.computation())
                .subscribe(Log::it);

        // subscription #2
        source.map(item -> "##"+item+"##")
                .subscribeOn(Schedulers.computation())
                .subscribe(Log::it);

        CommonUtils.sleep(1000);
    }
}
