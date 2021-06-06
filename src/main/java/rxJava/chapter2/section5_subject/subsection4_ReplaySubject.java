package rxJava.chapter2.section5_subject;

import io.reactivex.subjects.ReplaySubject;
import static util.PrintUtil.println;

public class subsection4_ReplaySubject {

    public static void main(String[] args) {
        new subsection4_ReplaySubject().solve();
    }

    /**
     * The new subscribers receive all data from the beginning.
     * REPLAY
     */
    private void solve() {
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(data -> println("Subscriber #1 => "+data));
        subject.onNext("String 1");
        subject.onNext("String 2");
        subject.onNext("String 3");
        subject.subscribe(data -> println("Subscriber #2 => "+data));
        subject.onNext("String 4");
        subject.onNext("String 5");
        subject.onNext("String 6");
        subject.subscribe(data -> println("Subscriber #3 => "+data));
        subject.onComplete();
    }
}
