package annotation;

import java.lang.annotation.Annotation;
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
//        apiUtils.getNews("aaa");
        Method[] methods = apiUtils.getClass().getMethods();
        for (Method method : methods) {
            Annotation[] methodAnnotations = method.getAnnotations();
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
//            GET annotation = method.getAnnotation(GET.class);
            if (methodAnnotations != null && methodAnnotations.length > 0) {
                for (Annotation annotation : methodAnnotations) {
                    parseMethodAnnotation(annotation);
                }
            }

            if (parameterAnnotations != null && parameterAnnotations.length > 0) {
                for (Annotation[] parameterAnnotation : parameterAnnotations) {
                    parseParameterAnnotation(parameterAnnotation);
                }
            }

        }
    }

    private void parseParameterAnnotation(Annotation[] parameterAnnotation) {
        for (Annotation annotation : parameterAnnotation) {
            if (annotation instanceof Path) {
                System.out.println("Path annotation value is : " + ((Path) annotation).value());
            }
        }
    }

    private void parseMethodAnnotation(Annotation annotation) {
        if (annotation instanceof GET) {
            System.out.println("GET annotation value is : " + ((GET) annotation).value());
        }
    }

    public static class ApiUtils {

        @GET("/api/news")
        public void getNews(@Path("/id") String path) {
            System.out.println("getNews : " + path);
        }
    }


}
