package rxJava.chapter4.section1_creatingOperator;

import io.reactivex.Observable;
import util.CommonUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class exercise_heartBeat {
    public static void main(String[] args){
        new exercise_heartBeat().solve();
    }

    private void solve(){
        CommonUtils.exampleStart();

        String url = "http://google.com";
        Observable<String> source = Observable
                .interval(500L, TimeUnit.MILLISECONDS)
                .map(data -> url)
                .map(data -> get(data))
                .repeat();

        source.subscribe(util.Log::it);

        CommonUtils.sleep(10000);
    }

    private String get(String url){
        return "ping";
    }
}
