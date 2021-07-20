package rxJava.chapter5.section2_typeOfSchedulers;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import util.CommonUtils;
import util.Log;

public class subsection4_trampolineScheduler {
    public static void main(String[] args){
        new subsection4_trampolineScheduler().solve();
    }

    private void solve(){
        String[] orgs = {"1", "3", "5"};

        Observable<String> source = Observable.fromArray(orgs);

        // subscription #1
        source.subscribeOn(Schedulers.trampoline())
                .map(data -> "<<"+data+">>")
                .subscribe(Log::it);

        // subscription #2
        source.subscribeOn(Schedulers.trampoline())
                .map(data -> "##"+data+"##")
                .subscribe(Log::it);

        CommonUtils.sleep(500);
    }
}
