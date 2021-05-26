package test;

public class JavaSimpleTest {

    public static void main(String[] args) {
        new JavaSimpleTest().solve();
    }

    private void solve() {
        String protocol;
        protocol = "https://api.dev.eversafe.co.kr".split("://")[0];
        System.out.println(protocol == null);
    }
}
