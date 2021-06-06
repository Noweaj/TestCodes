package rxJava.chapter3.section4_reduce;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class subsection1_dataQuery {

    public static void main(String[] args) {
        new subsection1_dataQuery().solve();
    }

    private void solve() {
        List<Pair<String, Integer>> sales = new ArrayList<>();
        sales.add(new Pair<>("TV", 2500));
        sales.add(new Pair<>("Camera", 300));
        sales.add(new Pair<>("TV", 1600));
        sales.add(new Pair<>("Phone", 800));

        Maybe<Integer> tvSales = Observable.fromIterable(sales)
                .filter(sale -> sale.getKey().equals("TV"))
                .map(sale -> sale.getValue())
                .reduce((val1, val2) -> val1+val2);
        tvSales.subscribe(util.PrintUtil::println);
    }
}
