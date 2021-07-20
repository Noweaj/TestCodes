package rxJava.chapter4.section1_creatingOperator;

import io.reactivex.Observable;
import util.Log;

public class subsection6_repeat {
    public static void main(String[] args){
        new subsection6_repeat().solve();
    }

    private void solve(){
        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable.fromArray(balls).repeat(3);

        source.doOnComplete(() -> new Log().it("onComplete")).subscribe(util.Log::it);
    }
}
