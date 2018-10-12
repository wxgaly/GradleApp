package annotation;

import java.lang.reflect.Method;

/**
 * annotation.NewsTest
 *
 * @author Created by WXG on 2018/10/12 012 17:13.
 * @version V1.0
 */

public class NewsTest {

    private static volatile NewsTest singleton = null;

    private NewsTest() {

    }

    public static NewsTest getInstance() {
        if (singleton == null) {
            synchronized (NewsTest.class) {
                if (singleton == null) {
                    singleton = new NewsTest();
                }
            }
        }
        return singleton;
    }

    public void test() {
        ApiUtils apiUtils = new ApiUtils();
//        apiUtils.getNews();
        Method[] methods = apiUtils.getClass().getMethods();
        for (Method method : methods) {
            GET annotation = method.getAnnotation(GET.class);
            if (annotation != null) {
                System.out.println("get annotation value is : " + annotation.value());
            }
        }
    }

    public static class ApiUtils {

        @GET("/api/news")
        public void getNews() {
            System.out.println("getNews");
        }
    }


}
