public class EmployeeBook {

    private static Employee[] employees;

    public EmployeeBook(int size){
        this.employees = new Employee[size];
    }

    public void printList() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }
    public void printList(int department){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                System.out.println(employees[i].toStringWithoutDep());
            }
        }

    }
    public double sumOfSalaries(Employee[] employees1){
        double sum = 0;
        for (int i = 0; i < employees1.length; i++) {
            if (employees1[i] != null) {
                sum += employees1[i].getSalary();
            }
        }
        return sum;
    }
    public Employee findMinSalary(Employee[] employees1) {
        Employee result = employees1[0];
        double minSalary = Double.MAX_VALUE;
        for (int i = 0; i < employees1.length; i++) {
            if (employees1[i] != null && employees1[i].getSalary() < minSalary) {
                minSalary = employees1[i].getSalary();
                result = employees1[i];
            }
        }
        return result;
    }
    public Employee findMaxSalary(Employee[] employees1) {
        Employee result = employees1[0];
        double maxSalary = Double.MIN_VALUE;
        for (int i = 0; i < employees1.length; i++) {
            if (employees1[i] != null && employees1[i].getSalary() > maxSalary) {
                maxSalary = employees1[i].getSalary();
                result = employees1[i];
            }
        }
        return result;
    }
    public double findAverageSalary(Employee[] employees1){
        double counter = 0;
        for (int i = 0; i < employees1.length; i++) {
            if (employees1[i] != null) {
                counter++;
            }
        }
        return sumOfSalaries(employees1) / counter;
    }
    public void printFullName(){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFullName());
            }
        }
    }
    public void increaseSalary(double multiply){
        double rate = 1 + multiply / 100;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() * rate);
            }
        }
    }
    public void increaseSalaryInDepartment(int department, double multiply){
        double rate = 1 + multiply / 100;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                employees[i].setSalary(employees[i].getSalary() * rate);
            }
        }
    }
    public Employee[] filterDepartment(int department) {
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                counter++;
            }
        }
        Employee[] result = new Employee[counter];
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                result[index] = employees[i];
                index++;
            }
        }
        return result;
    }

    public void printLessSalary(double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < salary) {
                System.out.println(employees[i].toStringWithoutDep());
            }
        }
    }
    public void printMoreSalary(double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= salary) {
                System.out.println(employees[i].toStringWithoutDep());
            }
        }
    }
    public void addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null){
                employees[i] = employee;
                return;
            }
        }
    }
    public void findAndDeleteByFullName(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && fullName.equals(employees[i].getFullName())) {
                employees[i] = null;
                return;
            }
        }
    }
    public void findAndDeleteById(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                return;
            }
        }
    }

    public void changeEmployeeInformation(String fullName, double newSalary, int newDepartment) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && fullName.equals(employees[i].getFullName())) {
                employees[i].setSalary(newSalary);
                employees[i].setDepartment(newDepartment);
                return;
            }
        }
    }

    public void printEmployeesByDepartment() {
        for (int i = 1; i <= 5; i++){
                System.out.printf("Номер отдела %d:\n", i);
                for (Employee employee : employees){
                    if (employee != null && employee.getDepartment() == i){
                        System.out.println(employee.getId() + ". " + employee.getFullName());
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmployeeBook:");
        for(Employee employee : employees){
            if (employee != null);
            sb.append("\n").append(employee);
        }
        return sb.toString();
    }
}
