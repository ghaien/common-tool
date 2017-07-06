package cn.ghaien;

/**
 * @author ghaien on 2017/7/6.
 * @see String
 * @see StringBuilder
 * @see StringBuffer
 * @since 1.5
 */
public class StringUtils {

    /**
     * 将字符串对象转换为StringBuilder对象
     * @param s 要转换的字符串
     * @return StringBuilder对象
     */
    public static StringBuilder stringToStringBuilder(String s) {
        if (s == null)
            return null;
        return new StringBuilder(s);
    }

    /**
     * 判断字符串是否为空或是否全为空格
     * @param s 要进行判空的字符串
     * @return 若为空或全为空格则为true否则为false
     * @since 1.6
     */
    public static boolean isEmpty(String s) {
        return s == null ? true : s.trim().isEmpty();
    }

    /**
     * 将数组中的对象以字符串的形式拼接
     * @param arr 需要拼接的数组
     * @return 拼接后的字符串
     */
    public static String concat(Object[] arr) {
        if (arr == null)
            return null;
        StringBuilder sb = new StringBuilder();
        for (Object o : arr)
            sb.append(o);
        return sb.toString();
    }

    /**
     * 去除字符串中的所有空格
     * @param s 需要除去空格的字符串
     * @return 除去空格后的字符串
     */
    public static String clearWhitespace(String s) {
        if (s == null)
            return s;
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != 32) // 空格对应的char值为32
                sb.append(c);
        }
        return sb.toString();
    }

}
