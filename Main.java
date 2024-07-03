import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                System.out.println("Введите новую цель шагов за день");
                int goal = scanner.nextInt();
                stepTracker.changeStepGoal(goal);
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else if (command == 0) {
                return;
            } else {
                System.out.println("Некоректный ввод - введите цифру от 0 до 3");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберите пункт меню ");
        System.out.println("1. Введите желаемое колличество шагов за день");
        System.out.println("2. изменить цель по количеству шагов в день");
        System.out.println("3. напечатать статистику за определённый месяц");
        System.out.println("0. Выход");
    }
}