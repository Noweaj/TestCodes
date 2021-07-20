package util;

public class Log {

    public static void it(Object obj){
        long time = System.currentTimeMillis() - CommonUtils.startTime;
        System.out.println(Thread.currentThread().getName()+" | "+time+" | value = "+obj);
    }

    public static void dt(Object obj){
        long time = System.currentTimeMillis() - CommonUtils.startTime;
        System.out.println(Thread.currentThread().getName()+" | "+time+" | debug = "+obj);
    }

    public static void vt(Object obj){
        long time = System.currentTimeMillis() - CommonUtils.startTime;
        System.out.println(Thread.currentThread().getName()+" | "+time+" | value = "+obj);
    }
}
