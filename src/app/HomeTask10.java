package app;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeTask10 {

    public static final double PI = 3.1415;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        //1 task
        System.out.println("1. Введіть ціле число: ");
        int value = userInput.nextInt();
        calculateSquare(value);

        //2 task
        System.out.println("2. Введіть радіус циліндра: ");
        double cylinderRadius = userInput.nextDouble();
        System.out.println("Введіть висоту циліндра: ");
        double cylinderHeight = userInput.nextDouble();
        double volume = calculateCylinderVolume(cylinderRadius, cylinderHeight);
        System.out.printf("Об'єм циліндра дорівнює: %f%n", volume);

        //3 task
        int[] arrayNumbers = initializeArray(new int[5]);
        int arraySum = Arrays.stream(arrayNumbers).sum();
        System.out.printf(
            "3. Масив чисел: %s Сума всіх елементів масиву дорівнює %d%n",
            Arrays.toString(arrayNumbers), arraySum
        );

        //4 task
        userInput.nextLine();
        System.out.println("4. Введіть рядок: ");
        String stringInput = userInput.nextLine();
        String reverseUserInput = reverseString(stringInput);
        System.out.printf("Рядок в зворотньому порядку: %s%n", reverseUserInput);

        //5 task
        System.out.println("5. Введіть a: ");
        int aValue = userInput.nextInt();
        System.out.println("Введіть b: ");
        int bValue = userInput.nextInt();

        long raisedPower = calculateRaisedPower(aValue, bValue);
        System.out.printf(
            "Результат %d ^ %d дорівнює %d%n",
            aValue, bValue, raisedPower
        );

        //6 task
        System.out.println("6. Введіть ціле число n: ");
        int nValue = userInput.nextInt();
        userInput.nextLine();
        System.out.println("Введіть текстовий рядок: ");
        String stringValue = userInput.nextLine();

        String reverseUserInputNTimes = printSting(nValue, stringValue);
        System.out.print(reverseUserInputNTimes);

        userInput.close();
    }

    // 1 method that takes an input integer and calculates it`s square
    public static void calculateSquare(int value) {
        int square = value * value;
        System.out.printf(
            "Квадрат числа %d дорівнює %d%n",
            value, square
        );
    }

    //2
    public static double calculateCylinderVolume (double radius, double height ){
        return PI * (radius * radius) * height;
    }

    // 3 method that creates an array and calculates their sum
    public static int[] initializeArray(int[] numbers) {
        Random random = new SecureRandom();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100) + 1;
        }

        return numbers;
    }

    //4
   public static String reverseString(String stringInput){
//        StringBuffer stBufferUse = new StringBuffer(stringInput);
//        return stBufferUse.reverse().toString();
       char[] charInput = stringInput.toCharArray();

       for (int i = 0; i < charInput.length /2; i++) {
            char temp = charInput[i];
           charInput[i] = charInput[charInput.length - 1 - i];
           charInput[charInput.length - 1 - i] = temp;
       }

       return new String(charInput);
   }

    //method that calculates a^b
    public static long calculateRaisedPower(int aValue, int bValue) {
        return (long) Math.pow(aValue, bValue);
//        int result = 1;
//        for (int i = 0; i < bValue ; i++) {
//            result *= aValue;
//        }
//        return result;
    }

    //6
    public static String printSting(int nValue, String stringValue ) {
        StringBuilder enterResult = new StringBuilder();
        for (int i = 0; i < nValue; i++) {
            enterResult.append(stringValue);
            if (i < nValue - 1) {  // Додаємо символ переносу, окрім останнього разу
                enterResult.append("\n");
            }
        }
        return enterResult.toString();
    }
}


