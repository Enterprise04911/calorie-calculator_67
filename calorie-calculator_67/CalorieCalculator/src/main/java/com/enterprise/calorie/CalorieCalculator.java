package com.enterprise.calorie;

/**
 * 热量计算工具类
 * 用于计算基础代谢率（BMR）和每日所需热量
 */
public class CalorieCalculator {

    /**
     * 计算基础代谢率（BMR）
     * 使用Mifflin-St Jeor公式
     * @param gender 性别（male/female）
     * @param age 年龄
     * @param height 身高（厘米）
     * @param weight 体重（公斤）
     * @return 基础代谢率（大卡）
     */
    public static double calculateBMR(String gender, int age, double height, double weight) {
        double bmr;
        // 男性公式：10 × 体重(kg) + 6.25 × 身高(cm) - 5 × 年龄(岁) + 5
        if (gender.equalsIgnoreCase("male")) {
            bmr = 10 * weight + 6.25 * height - 5 * age + 5;
        }
        // 女性公式：10 × 体重(kg) + 6.25 × 身高(cm) - 5 × 年龄(岁) - 161
        else if (gender.equalsIgnoreCase("female")) {
            bmr = 10 * weight + 6.25 * height - 5 * age - 161;
        } else {
            throw new IllegalArgumentException("性别只能是male或female");
        }
        return bmr;
    }

    /**
     * 计算每日所需总热量（TDEE）
     * 根据活动系数乘以基础代谢率
     * @param bmr 基础代谢率
     * @param activityFactor 活动系数：
     *                      久坐（1.2）、轻度活动（1.375）、中度活动（1.55）
     *                      高度活动（1.725）、极度活动（1.9）
     * @return 每日所需热量
     */
    public static double calculateDailyCalorie(double bmr, double activityFactor) {
        if (activityFactor < 1.2 || activityFactor > 1.9) {
            throw new IllegalArgumentException("活动系数范围：1.2 ~ 1.9");
        }
        return bmr * activityFactor;
    }


    public static void main(String[] args) {

        double bmr = calculateBMR("male", 20, 175, 65);
        double dailyCal = calculateDailyCalorie(bmr, 1.55);


        System.out.printf("基础代谢率（BMR）：%.2f 大卡%n", bmr);
        System.out.printf("每日所需热量（TDEE）：%.2f 大卡%n", dailyCal);


        double femaleBmr = calculateBMR("female", 22, 165, 50);
        double femaleDailyCal = calculateDailyCalorie(femaleBmr, 1.375);
        System.out.println("------------------------");
        System.out.printf("22岁女性（165cm/50kg，轻度活动）BMR：%.2f 大卡%n", femaleBmr);
        System.out.printf("22岁女性每日所需热量：%.2f 大卡%n", femaleDailyCal);
    }
}