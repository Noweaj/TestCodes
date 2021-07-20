package rxJava.chapter4.section2_transformingOperator;

import io.reactivex.Observable;
import util.CommonUtils;

import java.util.concurrent.TimeUnit;

public class subsection1_concatMap {

    public static void main(String[] args){
        new subsection1_concatMap().solve();
    }

    private void solve(){
        CommonUtils.exampleStart();

        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable
                .interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(idx -> balls[idx])
                .take(balls.length)
                .concatMap(ball -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                        .map(notUsed -> ball+"<>")
                        .take(2)
                );
        source.subscribe(result -> new util.Log().it(result));

        CommonUtils.sleep(2000);

        whatIfSwitchToFlatMap();
    }

    private void whatIfSwitchToFlatMap(){
        CommonUtils.exampleStart();

        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable
                .interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(idx -> balls[idx])
                .take(balls.length)
                .flatMap(ball -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                        .map(notUsed -> ball+"<>")
                        .take(2)
                );
        source.subscribe(result -> new util.Log().it(result));

        CommonUtils.sleep(2000);
    }
}
