package org.example.operators;

import java.util.Scanner;
import java.util.Set;

public class Operators {
    public static void main(String[] args) {
        Set<Character> supportedOperators = Set.of('+', '-', '*', '/', '^');
        double firstNumber, secondNumber;
        double result = 0;

        Scanner scanner = new Scanner(System.in);

        while (result != 'q') {
            System.out.println("Введите первое число:");
            try {
                scanner = new Scanner(System.in);
                firstNumber = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Некорректный ввод, попробуйте еще раз");
                continue;
            }

            System.out.println("Введите оператор:");
            char operator = scanner.next().charAt(0);
            if (!supportedOperators.contains(operator)) {
                System.out.println("Оператор " + operator + " не поддерживается");
                continue;
            }

            System.out.println("Введите второе число:");
            try {
                scanner = new Scanner(System.in);
                secondNumber = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Некорректный ввод, попробуйте еще раз");
                continue;
            }

            switch (operator) {
                case '+':
                    result = firstNumber + secondNumber;
                    break;

                case '-':
                    result = firstNumber - secondNumber;
                    break;

                case '*':
                    result = firstNumber * secondNumber;
                    break;

                case '/':
                    result = firstNumber / secondNumber;
                    break;

                case '^':
                    result = Math.pow(firstNumber, secondNumber);
                    break;

                default:
                    System.out.println("Введите ещё раз!");
                    continue;
            }
            System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + result);
        }
    }
}
