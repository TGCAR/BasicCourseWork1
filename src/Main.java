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

            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(1, 10), RANDOM.nextInt(50000, 100000));
        }
    }

    public static void main(String[] args) {
        initEmployees();
        print();

        // Вызов методов для работы с отделами
        int department = 3; // Пример: номер отдела
        double percent = 10; // Пример: процент индексации
        handleDepartmentTasks(department, percent);

        // Вызов методов для фильтрации по зарплате
        int salaryThreshold = 70000;
        System.out.println("Сотрудники с ЗП меньше " + salaryThreshold + ":");
        printEmployeesWithSalaryLessThan(salaryThreshold);

        System.out.println("Сотрудники с ЗП больше (или равно) " + salaryThreshold + ":");
        printEmployeesWithSalaryGreaterThanOrEqual(salaryThreshold);

        System.out.println("Сумма ЗП сотрудников: " + calculateSumOfSalaries());
        System.out.println("Сотрудник с мин ЗП: " + findEmployeeWithMinsalary());
        System.out.println("Сотрудник с макс ЗП: " + findEmployeeWithMaxsalary());
        System.out.println("Средняя ЗП: " + calculateAverageOfSalaries());
        printFullName();

        indexSalaries(10);
        print();
        System.out.println("\nИндексация ЗП:\n");
        System.out.println("Индексация зарплат на 10%  ");
        System.out.println("Сумма ЗП сотрудников после индексации: " + calculateSumOfSalaries());

        EmployeeBook employeeBook = new EmployeeBook();

        // Инициализация сотрудников
        employeeBook.initEmployees();
        employeeBook.printAllEmployees();

        // Добавление нового сотрудника
        System.out.println("Добавление нового сотрудника:");
        boolean added = employeeBook.addEmployee(new Employee("Семен Семенович Семенов", 3, 75000));
        System.out.println("Сотрудник добавлен: " + added);

        // Удаление сотрудника
        System.out.println("Удаление сотрудника с ID: 3");
        employeeBook.removeEmployeeById(3);

        // Получение сотрудника по ID
        System.out.println("Получение сотрудника с ID: 2");
        Employee employee = employeeBook.getEmployeeById(2);
        System.out.println(employee);

        // Работа с отделами
        System.out.println("Работа с отделом 3:");
        employeeBook.handleDepartmentTasks(3, 10);

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

    private static Employee findEmployeeWithMinsalary() {
        Employee employeeWithMinSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMinSalary == null || employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxsalary() {
        Employee findEmployeeWithMaxsalary = null;
        for (Employee employee : EMPLOYEES) {
            if (findEmployeeWithMaxsalary == null || employee.getSalary() > findEmployeeWithMaxsalary.getSalary()) {
                findEmployeeWithMaxsalary = employee;
            }
        }
        return findEmployeeWithMaxsalary;
    }

    private static double calculateAverageOfSalaries() {
        return (double) calculateSumOfSalaries() / EMPLOYEES.length;
    }

    private static void printFullName() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }

    }

    //    Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)
    private static void indexSalaries(double percent) {
        for (Employee employee : EMPLOYEES) {
            int newSalary = (int) (employee.getSalary() * (1 + percent / 100));
            employee.setSalary(newSalary);
        }
    }

//    Получить в качестве параметра номер отдела (1-5) и найти (всего 6 методов):
//    Сотрудника с минимальной зп;
//    Сотрудника с максимальной зп;
//    Сумму затрат на зп по отделу;
//    Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
//    Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
//    Напечатать всех сотрудников отдела (все данные, кроме отдела).


    private static void handleDepartmentTasks(int department, double percent) {
        System.out.println("Задачи для отдела: " + department);

        Employee minSalaryEmployee = findMinSalaryInDepartment(department);
        System.out.println("Сотрудник с минимальной ЗП: " + minSalaryEmployee);

        Employee maxSalaryEmployee = findMaxSalaryInDepartment(department);
        System.out.println("Сотрудник с максимальной ЗП: " + maxSalaryEmployee);

        int totalSalary = calculateDepartmentSalary(department);
        System.out.println("Сумма затрат на ЗП: " + totalSalary);

        double averageSalary = calculateDepartmentAverageSalary(department);
        System.out.println("Средняя ЗП: " + averageSalary);

        System.out.println("Индексация ЗП отдела на " + percent + "%");
        indexDepartmentSalaries(department, percent);

        System.out.println("Сотрудники отдела:");
        printDepartmentEmployees(department);
    }

    private static Employee findMinSalaryInDepartment(int department) {
        Employee minEmployee = null;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department &&
                    (minEmployee == null || employee.getSalary() < minEmployee.getSalary())) {
                minEmployee = employee;
            }
        }
        return minEmployee;
    }

    private static Employee findMaxSalaryInDepartment(int department) {
        Employee maxEmployee = null;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department &&
                    (maxEmployee == null || employee.getSalary() > maxEmployee.getSalary())) {
                maxEmployee = employee;
            }
        }
        return maxEmployee;
    }

    private static int calculateDepartmentSalary(int department) {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    private static double calculateDepartmentAverageSalary(int department) {
        int sum = 0;
        int count = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
                count++;
            }
        }
        return count == 0 ? 0 : (double) sum / count;
    }

    private static void indexDepartmentSalaries(int department, double percent) {
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                int newSalary = (int) (employee.getSalary() * (1 + percent / 100));
                employee.setSalary(newSalary);
            }
        }
    }

    private static void printDepartmentEmployees(int department) {
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                System.out.println("ФИО: " + employee.getFullName() + ", ЗП: " + employee.getSalary());
            }
        }
    }

    // Метод для вывода сотрудников с ЗП меньше указанного числа
    private static void printEmployeesWithSalaryLessThan(int salary) {
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() < salary) {
                System.out.println("ID: " + employee.hashCode() + ", ФИО: " + employee.getFullName() + ", ЗП: " + employee.getSalary());
            }
        }
    }

    // Метод для вывода сотрудников с ЗП больше (или равно) указанного числа
    private static void printEmployeesWithSalaryGreaterThanOrEqual(int salary) {
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() >= salary) {
                System.out.println("ID: " + employee.hashCode() + ", ФИО: " + employee.getFullName() + ", ЗП: " + employee.getSalary());
            }
        }
    }

}