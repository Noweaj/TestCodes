package rxJava.chapter2.section5_subject;

import io.reactivex.subjects.AsyncSubject;
import static util.PrintUtil.println;

public class subsection1_AsyncSubject {

    public static void main(String[] args) {
        new subsection1_AsyncSubject().solve();
    }

    private void solve() {
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.onNext("String 1");
        subject.subscribe(data -> println("Subscriber #1 => "+data));
        subject.onNext("String 2");
        subject.onNext("String 3");
        subject.onNext("String 4");
        subject.subscribe(data -> println("Subscriber #2 => "+data));
        subject.onNext("String 5");
        subject.onNext("String 6");
        subject.onComplete();
    }
}
