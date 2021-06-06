package rxJava.chapter2.section5_subject;

import io.reactivex.subjects.PublishSubject;
import static util.PrintUtil.println;

public class subsection3_PublishSubject {

    public static void main(String[] args) {
        new subsection3_PublishSubject().solve();
    }

    /**
     * The new subscribers receive only data after the subscription.
     */
    private void solve() {
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(data -> println("Subscriber #1 => "+data));
        subject.onNext("String 1");
        subject.onNext("String 2");
        subject.subscribe(data -> println("Subscriber #2 => "+data));
        subject.onNext("String 3");
        subject.onNext("String 4");
        subject.onComplete();
    }
}
