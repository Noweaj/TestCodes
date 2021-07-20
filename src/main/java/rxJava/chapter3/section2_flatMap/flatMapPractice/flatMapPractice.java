package rxJava.chapter3.section2_flatMap.flatMapPractice;

import io.reactivex.Observable;
import util.CommonUtils;

import java.util.concurrent.TimeUnit;

public class flatMapPractice {

    public static void main(String[] args){
        CommonUtils.exampleStart();

        Observable<String> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .range(0, 100)
                .map(index -> "current count: "+index);
        source.subscribe(util.Log::it);

        CommonUtils.sleep(10000);
    }
}
