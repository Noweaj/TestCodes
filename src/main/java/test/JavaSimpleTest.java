package test;

import util.PrintUtil;

public class JavaSimpleTest {

    public static void main(String[] args) {
//        new JavaSimpleTest().solve();
        new JavaSimpleTest().mathCeil();
    }

    private void mathCeil(){
        int int1 = (100-96)/3;
//        int1 = (int) Math.ceil((100-96)/3);
        PrintUtil.println(int1);
    }

    private void solve() {
        String protocol;
        protocol = "https://api.dev.eversafe.co.kr".split("://")[0];
        System.out.println(protocol == null);
    }
}
