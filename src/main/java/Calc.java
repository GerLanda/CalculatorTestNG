import java.util.Scanner;

public class Calc {

    static Scanner console = new Scanner(System.in);

    public int sum(Object value1, Object value2) {
        int result = (Integer) value1 + (Integer) value2;
        return result;
    }

    public int diff(Object value1, Object value2) {
        int result = (Integer) value1 - (Integer) value2;
        return result;
    }

    public int multi(Object value1, Object value2) {
        int result = (Integer) value1 * (Integer) value2;
        return result;
    }

    public int deg(Object value1, Object value2) {
        int result = (Integer) value1 / (Integer) value2;
        return result;
    }

    public static int getInt() {
        System.out.println("Введите число:");
        int num;
        if (console.hasNextInt()) {
            num = console.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            console.next();
            num = getInt();
        }
        return num;
    }

    public static char getOperation() {
        System.out.println("Введите операцию:");
        char operation;
        if (console.hasNext()) {
            operation = console.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            console.next();
            operation = getOperation();
        }
        return operation;
    }

    public static void calc(Object value1, Object value2, char operation) {
        switch (operation) {
            case '+':
                System.out.println(new Calc().sum(value1, value2));
                break;
            case '-':
                System.out.println(new Calc().diff(value1, value2));
                break;
            case '*':
                System.out.println(new Calc().multi(value1, value2));
                break;
            case '/':
                System.out.println(new Calc().deg(value1, value2));
                break;
            default:
                System.out.println("Такой операции нет");
                calc(value1,value2,getOperation());
        }
    }

    public static void main(String[] args) {
        Object value1 = getInt();
        Object value2 = getInt();
        char operation = getOperation();
        calc(value1,value2,operation);
    }
}





