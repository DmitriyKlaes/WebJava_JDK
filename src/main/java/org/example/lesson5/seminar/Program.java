package org.example.lesson5.seminar;

/*
Создать свой Java Maven проект;
Добавьте зависимость commons-math3 (предназначена для решения математических задач) и изучить интерфейс библиотеки.
Воспользоваться пакетом org.apache.commons.math3.stat и классом DescriptiveStatistics.
Создать коллекцию из числовых элементов.
С помощью объекта DescriptiveStatistics вычислить минимальное и максимальное значение, сумму и среднее арифметическое.
Воспользоваться пакетом org.apache.commons.math3.util. С помощью класса ArithmeticUtils найти :
факториал числа N.
Наименьшее общее частное двух чисел
Наибольший общий делитель двух чисел
Проверить что число N это степень двойки
*/

import org.apache.commons.math3.stat.descriptive.*;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.CombinatoricsUtils;

public class Program {
    public static void main(String[] args) {
        double[] doubleArray = {1.0, 2.0, 3.0, 4.0};
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(doubleArray);
        System.out.println(descriptiveStatistics.getMin());
        System.out.println(descriptiveStatistics.getMax());
        System.out.println(descriptiveStatistics.getSum());
        System.out.println(descriptiveStatistics.getMean());

        System.out.println(CombinatoricsUtils.factorial(5));
        System.out.println(ArithmeticUtils.lcm(15L, 30L));
        System.out.println(ArithmeticUtils.gcd(15L, 30L));
        System.out.println(ArithmeticUtils.isPowerOfTwo(3));


    }
}
