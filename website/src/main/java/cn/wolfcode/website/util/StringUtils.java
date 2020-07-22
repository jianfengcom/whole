package cn.wolfcode.website.util;

public class StringUtils {
    public static String https2http(String source, int choose) {
        if (choose == 1) {
            // 因为需要处理正则表达式，所以性能弱, 功能强大
            source.replaceAll("https", "http");
        } else {
            source.replace("https", "http");
        }
        return source;
    }
}
