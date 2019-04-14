package des;

import org.jcp.xml.dsig.internal.dom.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * des.TestDes
 *
 * @author Created by WXG on 2019/4/9 22:40.
 * @version V1.0
 */

public class TestDes {

    public static void main(String[] args) {

        testDes();
//        testReadFile();
    }

    private static void testReadFile() {
        String path = "D:\\Code\\gitlabRepo\\fetus_voice_meter_app\\native_plugin\\android\\demo27.pcm";
//        path = "E:\\外快项目\\项目5胎心仪\\1.PCM";
        try {
            byte[] bytes = Utils.readBytesFromStream(new FileInputStream(new File(path)));
            for (byte aByte : bytes) {
                System.out.print(Integer.toHexString(aByte & 0xff) + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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


