package cn.wolfcode.website.util;

public class RandomUtil {

    /**
     * 随机获取字符串
     * @return
     */
    public static String getRandomString() {
        String source = "1234567890abcdefghijklmnopqrstuvwxyz"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ-_"; // 52 + 10 + 2
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            int index = (int) (Math.random() * 64);
            stringBuilder.append(source.charAt(index));
        }
        return stringBuilder.toString();
    }
}
