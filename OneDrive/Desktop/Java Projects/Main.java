import java.util.Scanner;

public class Main {

    public static double cube(double a) {
        return Math.pow(a, 3);
    }

    public static void table(double start, double end, double step, int prec) {
        System.out.printf("+----------------+----------------+\n");
        System.out.printf("|   Argument     |   Cube Value    |\n");
        System.out.printf("+----------------+----------------+\n");

        if (start > end) {
            for (double a = start; a >= end; a -= step) {
                double cubed = cube(a);
                System.out.printf("| %14." + prec + "f | %14." + prec + "f |\n", a, cubed);
            }
        } else {
            for (double a = start; a <= end; a += step) {
                double cubed = cube(a);
                System.out.printf("| %14." + prec + "f | %14." + prec + "f |\n", a, cubed);
            }
        }

        System.out.printf("+----------------+----------------+\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String quit = "quit";

        while (true) { //if true
            try {
                System.out.print("Початкове значення (-100 до 100): ");
                double start = Double.parseDouble(sc.nextLine());
                if (start < -100 || start > 100) {
                    throw new RuntimeException("Помилка: [-100, 100].");
                }

                System.out.print("Кінцеве значення (-100 до 100): ");
                double end = Double.parseDouble(sc.nextLine());
                if (end < -100 || end > 100) {
                    throw new RuntimeException("Помилка: [-100, 100].");
                }

                System.out.print("Крок (більше 0): ");
                double step = Double.parseDouble(sc.nextLine());
                if (step <= 0) {
                    throw new RuntimeException("Помилка: > 0.");
                }

                System.out.print("Знаків після коми: ");
                int prec = Integer.parseInt(sc.nextLine());
                if (prec < 0) {
                    throw new RuntimeException("Помилка: невід'ємне.");
                }

                table(start, end, step, prec);

                System.out.print("Введіть 'quit' для виходу, або натисніть Enter для продовження: ");
                String cmd = sc.nextLine();
                if (cmd.equals(quit)) {
                    System.out.println("Програма завершена.");
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Помилка: некоректне число.");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}
