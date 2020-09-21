package des;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * des.TestDes
 *
 * @author Created by WXG on 2019/4/9 22:40.
 * @version V1.0
 */






public class TestDes {


    public static void main(String[] args) {
//        testDes();
//        testReadFile();
//        int num = 2147483647;
//        int temp = num + 2;
//        System.out.println(temp);
//
//        boolean flag = 10 % 2 == 1 && 10 / 3 == 0 && 1 / 0 == 0;
//        System.out.println(flag);
//
//        num = 50;
//        num = num++ * 2;
//        System.out.println(num);
//
//        String str = "";
//        for (int i = 0; i < 5; i++) {
//            str += i;
//        }
//
//        System.out.println(str);
//
//        int sum = 0;
//        for (int i = 0; i < 10; i++) {
//            sum += i;
//            if (i % 3 == 0) {
//                break;
//            }
//        }
//
//        System.out.println(sum);

//        System.out.println(inc(10) + inc(8) + inc(-10));

//        char c = 'A';
//        int num = 10;
//        switch (c) {
//            case 'B':
//                num++;
//            case 'A':
//                num++;
//            case 'Y':
//                num++;
//                break;
//
//            default:
//                num--;
//        }
//
//        System.out.println(num);

//        System.out.println(B.c);

        String s1 = "HelloWorld";
        String s2 = new String("HelloWorld");
        StringBuffer s3 = new StringBuffer(s2);
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }
        if (s1.equals(s2)) {
            System.out.println("s1 equals s2");
        } else {
            System.out.println("s1 not equals s2");
        }

        if (s2.equals(s3)) {
            System.out.println("s2 equals s3");
        } else {
            System.out.println("s2 not equals s3");
        }
    }

    int count = 21;
    public void count() {
        System.out.println(++count);
    }

    static class A {

        static {
            System.out.print("A");
        }
    }

    static class B extends A {
        static {
            System.out.print("B");
        }
        public final static String c = "C";
    }

    public static int inc(int temp) {
        if (temp > 0) {
            return temp * 2;
        }
        return -1;
    }

    private static void testReadFile() {
        String path = "D:\\Code\\gitlabRepo\\fetus_voice_meter_app\\native_plugin\\android\\demo27.pcm";
//        path = "E:\\外快项目\\项目5胎心仪\\1.PCM";
//        try {
//            byte[] bytes = Utils.readBytesFromStream(new FileInputStream(new File(path)));
//            for (byte aByte : bytes) {
//                System.out.print(Integer.toHexString(aByte & 0xff) + " ");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static void testDes() {
        try {
            DesCrypt desCrypt = new DesCrypt();

            String encrypt = desCrypt.encrypt(
                    "{\"name\":\"滑雪板盛宴（无限经验版）\",\"version\":\"1.1.8\",\"size\":\"437.61MB\",\"type\":\"gpk\",\"packageName\":\"com.ratrodstudio.snowparty\",\"identifiers\":[{\"name\":\"main.34.com.ratrodstudio.snowparty.obb\",\"md5\":\"1540F06FE1BD39772D6C658B69BE2FFB\",\"size\":431736756}]}"
            );

            System.out.println(encrypt);
            System.out.println(desCrypt.decrypt(encrypt));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


