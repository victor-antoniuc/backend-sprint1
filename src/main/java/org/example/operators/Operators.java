package org.example.operators;

import java.util.Scanner;

public class Operators {
    public static void main(String[] args) {
        double firstNum, secondNum;
        double result = 0;

        Scanner scanObj = new Scanner(System.in);

        while (result != 'q') {
            System.out.println("Введите первое число:");
            firstNum = scanObj.nextDouble();

            System.out.println("Введите оператор:");
            char operator = scanObj.next().charAt(0);

            System.out.println("Введите второе число:");
            secondNum = scanObj.nextDouble();

            switch (operator) {
                case '+':
                    result = firstNum + secondNum;
                    break;

                case '-':
                    result = firstNum - secondNum;
                    break;

                case '*':
                    result = firstNum * secondNum;
                    break;

                case '/':
                    result = firstNum / secondNum;
                    break;

                case '^':
                    result = Math.pow(firstNum, secondNum);
                    break;

                default:
                    System.out.println("Введите ещё раз!");
                    continue;
            }
            System.out.println(firstNum + " " + operator + " " + secondNum + " = " + result);
        }
    }
}
