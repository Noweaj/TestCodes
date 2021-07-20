package rxJava.chapter5.section2_typeOfSchedulers;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import util.CommonUtils;
import util.Log;

public class subsection1_newThreadScheduler {

    public static void main(String[] args){
        new subsection1_newThreadScheduler().solve();
    }

    private void solve(){
        String[] orgs = {"1", "3", "5"};

        Observable.fromArray(orgs)
                .doOnNext(data -> Log.vt(data))
                .map(data -> "<<"+data+">>")
                .subscribeOn(Schedulers.newThread())
                .subscribe(Log::it);
        CommonUtils.sleep(500);

        Observable.fromArray(orgs)
                .doOnNext(data -> Log.vt(data))
                .map(data -> "##"+data+"##")
                .subscribeOn(Schedulers.newThread())
                .subscribe(Log::it);
        CommonUtils.sleep(500);
    }
}
