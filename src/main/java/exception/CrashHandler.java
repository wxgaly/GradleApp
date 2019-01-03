package exception;

/**
 * exception.CrashHandler
 *
 * @author Created by WXG on 2019/1/2 21:11.
 * @version V1.0
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static final String TAG = "CrashHandler";

    private static volatile CrashHandler singleton = null;

    private CrashHandler() {

    }

    /**
     * must be call the method, the handler will be work.
     */
    public void init() {
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
        System.err.println(TAG + t.getName() + e.getMessage());
    }

}
