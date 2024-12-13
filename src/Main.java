import java.util.Random;

public class Main {

    private final static Random RANDOM = new Random();
    private final static String[] NAMES = {"Иван ", "Петр ", "Андрей ", "Михаил ", "Николай ", "Александр ", "Юрий ", "Евгений ", "Глеб ", "Денис "};
    private final static String[] SURNAME = {"Иванов ", "Петров ", "Андреев ", "Михайлов ", "Николаев ", "Александров ", "Юрьев ", "Судаков ", "Алексеев ", "Васильев "};
    private final static String[] PATRONIC_NAME = {"Иванович ", "Петрович ", "Андреевич ", "Михайлович ", "Николаевич ", "Александрович ", "Юрьевич ", "Валерьевич ", "Алексеевич ", "Васильевич "};


    private final static Employee[] EMPLOYEES = new Employee[10];

    private static void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = SURNAME[RANDOM.nextInt(0, SURNAME.length)] + "" +
                    NAMES[RANDOM.nextInt(0, NAMES.length)] + "" +
                    PATRONIC_NAME[RANDOM.nextInt(0, PATRONIC_NAME.length)] + "";

            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(50000, 100000));
        }
    }

    public static void main(String[] args) {
        initEmployees();
        print();
        System.out.println("Сумма ЗП сотрудников: "+calculateSumOfSalaries());
    }

    private static void print() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int calculateSumOfSalaries() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
            sum += employee.getSalary();
        }
        return sum;

    }
}