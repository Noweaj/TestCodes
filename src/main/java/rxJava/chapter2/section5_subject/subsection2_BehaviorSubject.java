package rxJava.chapter2.section5_subject;

import io.reactivex.subjects.BehaviorSubject;
import static util.PrintUtil.println;

public class subsection2_BehaviorSubject {

    public static void main(String[] args) {
        new subsection2_BehaviorSubject().solve();
    }

    private void solve() {
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("String 1");
        subject.subscribe(data -> println("Subscriber #1 => "+data));
        subject.onNext("String 2");
        subject.onNext("String 3");
        subject.subscribe(data -> println("Subscriber #2 => "+data));
        subject.onNext("String 4");
        subject.onComplete();
    }
}
