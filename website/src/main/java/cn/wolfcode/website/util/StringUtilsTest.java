package cn.wolfcode.website.util;

import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void test(){
        long start = System.currentTimeMillis();
        String source = "//www1.pconline.com.cn/dl/2010/images/72X72.jpg";
        for (int i = 0; i < 1000; i++) {
            // contains 调用了 indexOf
            if (source.indexOf("72X72") > -1) {// 11
                StringUtils.https2http(source, 1);
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void test2() {
        String keyword = "红苹果家具";
        keyword = keyword.replace("(", "").replace(")", "");
        String[] arr = keyword.split(",");
    }
}
