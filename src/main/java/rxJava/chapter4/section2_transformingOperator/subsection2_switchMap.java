package rxJava.chapter4.section2_transformingOperator;

import io.reactivex.Observable;
import util.CommonUtils;

import java.util.concurrent.TimeUnit;

public class subsection2_switchMap {

    public static void main(String[] args){
        new subsection2_switchMap().solve();
    }

    private void solve(){
        CommonUtils.exampleStart();

        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable
                .interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(idx -> balls[idx])
                .take(balls.length)
                .doOnNext(util.Log::dt)
                .switchMap(ball -> Observable
                        .interval(200L, TimeUnit.MILLISECONDS)
                        .map(notUsed -> ball+"<>")
                        .take(2)
                );
        source.subscribe(util.Log::it);

        CommonUtils.sleep(2000);
    }
}
