import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;
    Scanner scanner;

    StepTracker() {
        scanner = new Scanner(System.in);
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца от 1 до 12");
        int numberOfMonth = scanner.nextInt();
        if (numberOfMonth < 1) {
            System.out.println("месяц должен начинаться с 1");
            return;
        } else if (numberOfMonth > 12) {
            System.out.println("месяцев должно быть не больше 12");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int days = scanner.nextInt();
        if (days <= 0) {
            System.out.println("Номер дня должен быть положительным числом");
            return;
        } else if (days > 30) {
            System.out.println("Номер дня должен быть не больше 30");
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps <= 0) {
            System.out.println("количество шагов должно быть положительным числом.");
            return;
        }

        MonthData monthData = monthToData[numberOfMonth - 1];
        monthData.days[days - 1] = steps;
    }

    void changeStepGoal(int step) {
        if (step < 1) {
            System.out.println("Введите число больше 0");
            return;
        }
        goalByStepsPerDay = step;
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        int monthNumber = scanner.nextInt();

        if (monthNumber < 0) {
            System.out.println("месяц должен начинаться с 1");
            return;
        } else if (monthNumber >= 12) {
            System.out.println("месяцев должно быть не больше 12");
            return;
        }

        MonthData monthData = monthToData[monthNumber - 1];
        int sumSteps = monthData.sumStepsFromMonth();
        int maxSteps = monthData.maxSteps();
        int averageSteps = monthData.averageSteps();
        int kmDistance = converter.convertToKm(sumSteps);
        int kilocalories = converter.convertStepsToKilocalories(sumSteps);
        int bestSeries = monthData.bestSeries(goalByStepsPerDay);

        monthData.printDaysAndStepsFromMonth();
        System.out.println("за " + monthNumber + " месяц вы прошли " + sumSteps + " шагов");
        System.out.println("максимальное колличество шагов за месяц " + maxSteps);
        System.out.println("в среднем вы прошли " + averageSteps);
        System.out.println("за месяц вы прошли " + kmDistance + " километров");
        System.out.println("за месяц вы сожгли " + kilocalories + " килокалорий");
        System.out.println("лучшая серия " + bestSeries + " дней");
        System.out.println();
    }
}
