# calorie-calculator_67
markdown<br># my-calorie-project_67<br>基于Java的热量计算工具类项目，学号67的个人练习项目。<br>## 项目功能<br>1. 采用Mifflin-St Jeor公式计算基础代谢率（BMR）<br>2. 根据活动系数计算每日所需总热量（TDEE）<br>3. 支持男性/女性不同的BMR计算逻辑<br>## 核心代码类<br>- `CalorieCalculator.java`：工具类，包含`calculateBMR()`和`calculateDailyCalorie()`两个静态方法<br>## 使用示例<br>java
// 计算 20 岁男性（175cm/65kg）的 BMR 和中度活动的每日热量
double bmr = CalorieCalculator.calculateBMR("male", 20, 175, 65);
double dailyCal = CalorieCalculator.calculateDailyCalorie(bmr, 1.55);
System.out.printf ("BMR：%.2f 大卡，每日热量：%.2f 大卡 % n", bmr, dailyCal);
<br>## 公式说明<br>- 男性BMR：10 × 体重(kg) + 6.25 × 身高(cm) - 5 × 年龄 + 5<br>- 女性BMR：10 × 体重(kg) + 6.25 × 身高(cm) - 5 × 年龄 - 161<br>- 每日热量：BMR × 活动系数（1.2~1.9）<br>
