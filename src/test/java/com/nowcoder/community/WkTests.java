package com.nowcoder.community;

import java.io.IOException;

/**
 * @author zjh
 * @version 1.0
 * @date 2022/8/3 16:52
 */

public class WkTests {
    public static void main(String[] args) {
        String cmd = "d:/work/wkhtmltopdf/bin/wkhtmltoimage --quality 75  https://www.nowcoder.com d:/work/data/wk-images/2.png";
        try {
            Runtime.getRuntime().exec(cmd);
            System.out.println("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
