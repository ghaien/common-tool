package cn.ghaien;

import java.text.NumberFormat;
import java.util.Random;

/**
 * @author ghaien on 2017/7/7.
 * @see Random
 * @see Double
 */
public class RandomUtil {

    /**
     * 获取0到某个整数之间的随机值
     * 注: 包含0和最大值
     * @param maxNum 最大值
     * @return 随机值
     */
    public static int getRandomInt(int maxNum) {
        return getRandomInt(0, maxNum);
    }

    /**
     * 获取两个整数之间的随机值
     * 注: 包含最小值与最大值
     * @param minNum 最小值
     * @param maxNum 最大值
     * @return 随机值
     */
    public static int getRandomInt(int minNum, int maxNum) {
        Random random = new Random();
        int bound = maxNum - minNum + 1;

        int result = random.nextInt(bound) + minNum;
        return result;
    }

    /**
     * 获取0到某个小数之间的随机值并保留指定小数位数
     * @param maxNum 最大值
     * @param digits 保留小数位数
     * @return 随机值
     */
    public static double getRandomDou(double maxNum, int digits) {
        return getRandomDou(0, maxNum, digits);
    }

    /**
     * 获取两个小数之间的随机值并保留指定小数位数
     * 注: 包含最小值与最大值
     * @param minNum 最小值
     * @param maxNum 最大值
     * @param digits 保留小数位数
     * @return 随机值
     */
    public static double getRandomDou(double minNum, double maxNum, int digits) {
        if (maxNum < minNum)
            throw new RuntimeException("最小值: " + minNum + "  最大值: " + maxNum);
        Random random = new Random();
        double bound = maxNum - minNum;
        double result = random.nextDouble() * bound + minNum;
        //保留指定小数位
        NumberFormat ddf1=NumberFormat.getNumberInstance();
        ddf1.setMaximumFractionDigits(digits);
        String str = ddf1.format(result);
        return new Double(str);
    }

}
