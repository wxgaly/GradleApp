package exception;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * exception.ExceptionMain
 *
 * @author Created by WXG on 2019/1/3 0:16.
 * @version V1.0
 */

public class ExceptionMain {

    public static void main(String[] args) {
        CrashHandler instance = CrashHandler.getInstance();
//        new Thread(() -> {
//
//        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int a = 1 / 0;
    }

}
