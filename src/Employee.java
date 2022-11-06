public class Employee {

    private String fullName;

    private double salary;

    private int department;
    private int id;

    private static int counter = 0;

    public Employee(String fullName, double salary, int department) {
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
        counter++;
        id = counter;

    }

    public String getFullName() {
        return fullName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("%d. %s; Номер отдела: %d, Зарплата: %.2f", id, fullName, department, salary);
    }
    public String toStringWithoutDep(){
        return String.format("%d. %s; Зарплата: %.2f", id, fullName, salary);
    }
}
