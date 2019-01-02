package exception;

/**
 * exception.CrashHandler
 *
 * @author Created by WXG on 2019/1/2 21:11.
 * @version V1.0
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static volatile CrashHandler singleton = null;

    private Thread.UncaughtExceptionHandler mDefaultHandler;

    private CrashHandler() {
        init();
    }

    private void init() {
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        // 将此类设为默认异常处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static CrashHandler getInstance() {
        if (singleton == null) {
            synchronized (CrashHandler.class) {
                if (singleton == null) {
                    singleton = new CrashHandler();
                }
            }
        }
        return singleton;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName() + e.getMessage());
    }

}
