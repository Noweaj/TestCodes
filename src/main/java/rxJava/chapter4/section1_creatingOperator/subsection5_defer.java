package rxJava.chapter4.section1_creatingOperator;

import io.reactivex.Observable;
import util.CommonUtils;
import util.Log;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;

public class subsection5_defer {

    public static void main(String[] args){
        new subsection5_defer().solve();
    }

    private void solve(){
        Iterator<String> colors = Arrays.asList("1", "3", "5", "7").iterator();

        Callable<Observable<String>> supplier = () -> getObservable(colors);

        Observable<String> source = Observable.defer(supplier);

        source.subscribe(val -> new Log().it("Subscriber #1: "+val));
        source.subscribe(val -> new Log().it("Subscriber #2: "+val));

        whatIfCallObservableInsteadOfDefer();

    }

    private Observable<String> getObservable(Iterator<String> colors){
        if(colors.hasNext()){
            String color = colors.next();
            return Observable.just("("+color+")", "["+color+"]", "<"+color+">");
        }
        return Observable.empty();
    }

    private void whatIfCallObservableInsteadOfDefer(){
        new Log().it("whatIfCallObservableInsteadOfDefer");

        Iterator<String> colors = Arrays.asList("1", "3", "5", "7").iterator();

        Observable<String> source = getObservable(colors);

        source.subscribe(val -> new Log().it("Subscriber #1: "+val));
        source.subscribe(val -> new Log().it("Subscriber #2: "+val));
    }
}
