import java.util.Random;

public class EmployeeBook {
    private static final Random RANDOM = new Random();
    private static final String[] NAMES = {"Иван", "Петр", "Андрей", "Михаил", "Николай", "Александр", "Юрий", "Евгений", "Глеб", "Денис"};
    private static final String[] SURNAMES = {"Иванов", "Петров", "Андреев", "Михайлов", "Николаев", "Александров", "Юрьев", "Судаков", "Алексеев", "Васильев"};
    private static final String[] PATRONICS = {"Иванович", "Петрович", "Андреевич", "Михайлович", "Николаевич", "Александрович", "Юрьевич", "Валерьевич", "Алексеевич", "Васильевич"};

    private final Employee[] employees = new Employee[10];

    public void initEmployees() {
        for (int i = 0; i < employees.length; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(SURNAMES.length)] + " " +
                    NAMES[RANDOM.nextInt(NAMES.length)] + " " +
                    PATRONICS[RANDOM.nextInt(PATRONICS.length)];
            employees[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(50000, 100000));
        }
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public boolean addEmployee(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    public void removeEmployeeById(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                return;
            }
        }
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void handleDepartmentTasks(int department, double percent) {
        System.out.println("Сотрудники отдела: " + department);
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println(employee);
            }
        }

        indexDepartmentSalaries(department, percent);
    }

    private void indexDepartmentSalaries(int department, double percent) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                int newSalary = (int) (employee.getSalary() * (1 + percent / 100));
                employee.setSalary(newSalary);
            }
        }
    }
}

