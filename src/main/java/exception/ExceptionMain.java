package exception;

/**
 * exception.ExceptionMain
 *
 * @author Created by WXG on 2019/1/3 0:16.
 * @version V1.0
 */

public class ExceptionMain {

    public static void main(String[] args) {
//        CrashHandler instance = CrashHandler.getInstance();
//        System.out.println("3:00" + " -> " + TimeUtil.convertNumber2String4Time("3:00"));
//        System.out.println("3:01" + " -> " + TimeUtil.convertNumber2String4Time("3:01"));
//        System.out.println("3:10" + " -> " + TimeUtil.convertNumber2String4Time("3:10"));
//        System.out.println("3:15" + " -> " + TimeUtil.convertNumber2String4Time("3:15"));
//        System.out.println("3:28" + " -> " + TimeUtil.convertNumber2String4Time("3:28"));
//        System.out.println("3:30" + " -> " + TimeUtil.convertNumber2String4Time("3:30"));
//        System.out.println("3:31" + " -> " + TimeUtil.convertNumber2String4Time("3:31"));
//        System.out.println("3:45" + " -> " + TimeUtil.convertNumber2String4Time("3:45"));
//        System.out.println("3:49" + " -> " + TimeUtil.convertNumber2String4Time("3:49"));
        System.out.println(System.getProperties().getProperty("user.home"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int a = 1 / 0;
    }

}
