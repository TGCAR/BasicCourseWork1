public class Employee {

    private static int idGenerato = 1;

    private final int id;
    private final String fullName;
    private int department;
    private int salary;

    public Employee(String fullName, int department, int salary) {
        id = idGenerato++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", salary=" + salary;
    }
}
