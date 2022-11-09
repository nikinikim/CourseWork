public class Main {
    private static Employee[] employees;

    public static void main(String[] args) {
        employees = new Employee[10];
        employees[0] = new Employee("Петров Петр Петрович",78000, 1);
        employees[1] = new Employee("Санкин Александр Александрович",95000, 3);
        employees[2] = new Employee("Козлов Евгений Сергеевич",25000, 4);
        employees[3] = new Employee("Владимиров Петр Дмитриевич",85000, 3);
        employees[4] = new Employee("Мартынов Олег Геннадьевич",23000, 5);
        employees[5] = new Employee("Олегин Андрей Романович",32000, 4);
        printList();
       /* System.out.printf("Сумма зарплат работников: %.2f \n", sumOfSalaries());
        System.out.printf("Сотрудник с минимальной зарплатой: %s \n", findMinSalary());
        System.out.printf("Сотрудник с максимальной зарплатой: %s \n", findMaxSalary());
        System.out.printf("Средняя заработная плата: %.2f \n", findAverageSalary());
        printFullName();
        increaseSalary(12,employees);
        printList();*/
        int departmentNum = 5;
        Employee[] depFinder = filterDepartment(departmentNum);
        System.out.printf("Сотрудник с минимальной зарплатой в отделе %d: %s \n", departmentNum, findMinSalary(depFinder));
        System.out.printf("Сотрудник с максимальной зарплатой в отделе %d: %s \n", departmentNum, findMaxSalary(depFinder));
        System.out.printf("Сумма зарплат сотрудников в отделе %d: %.2f \n", departmentNum, sumOfSalaries(depFinder));
        System.out.printf("Средняя зарплата сотрудников в отделе %d: %.2f \n", departmentNum, findAverageSalary(depFinder));
        increaseSalaryInDepartment(5,12);
        depFinder =  filterDepartment(departmentNum);
        System.out.printf("Зарплата сотрудников отдела %d после индексации: \n", departmentNum);
        printList(departmentNum);
        System.out.println("Сотрудники с зарплатой меньше, чем 34т:");
        printLessSalary(34000);
        System.out.println("Сотрудники с зарплатой больше или равной 34т:");
        printMoreSalary(34000);
        System.out.println("EmployeeBook");
        EmployeeBook employeeBook = new EmployeeBook(10);
        Employee oneEmployee = new Employee("Бородин Петр Сергеевич", 23000, 1);
        Employee twoEmployee = new Employee("Аксарин Сергей Власович", 33000, 4);
        Employee threeEmployee = new Employee("Майков Вячеслав Александрович", 56000, 1);
        Employee fourEmployee = new Employee("Богданов Дмитрий Станиславович", 28000, 1);
        Employee fiveEmployee = new Employee("Дмитриев Дмитрий Николаевич", 76000, 5);
        Employee sixEmployee = new Employee("Балаганов Станислав Артемович", 29000, 2);
        employeeBook.addEmployee(oneEmployee);
        employeeBook.addEmployee(twoEmployee);
        employeeBook.addEmployee(threeEmployee);
        employeeBook.addEmployee(fourEmployee);
        employeeBook.addEmployee(fiveEmployee);
        employeeBook.addEmployee(sixEmployee);
        System.out.println(employeeBook);
        employeeBook.findAndDeleteByFullName("Бородин Петр Сергеевич");
        employeeBook.findAndDeleteById(8);
        employeeBook.changeEmployeeInformation("Майков Вячеслав Александрович",72000, 3);
        System.out.println(employeeBook);
        employeeBook.printEmployeesByDepartment();
    }

    public static void printList() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }
    public static void printList(int department){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                System.out.println(employees[i].toStringWithoutDep());
            }
        }

    }
    public static double sumOfSalaries(Employee[] employees1){
        double sum = 0;
        for (int i = 0; i < employees1.length; i++) {
            if (employees1[i] != null) {
                sum += employees1[i].getSalary();
            }
        }
        return sum;
    }
    public static Employee findMinSalary(Employee[] employees1) {
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
    public static Employee findMaxSalary(Employee[] employees1) {
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
    public static double findAverageSalary(Employee[] employees1){
        double counter = 0;
        for (int i = 0; i < employees1.length; i++) {
            if (employees1[i] != null) {
                counter++;
            }
        }
        return sumOfSalaries(employees1) / counter;
    }
    public static void printFullName(){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFullName());
            }
        }
    }
    public static void increaseSalary(double multiply){
        double rate = 1 + multiply / 100;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() * rate);
            }
        }
    }
    public static void increaseSalaryInDepartment(int department, double multiply){
        double rate = 1 + multiply / 100;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                employees[i].setSalary(employees[i].getSalary() * rate);
            }
        }
    }
    public static Employee[] filterDepartment(int department) {
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

    public static void printLessSalary(double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < salary) {
                System.out.println(employees[i].toStringWithoutDep());
            }
        }
    }
    public static void printMoreSalary(double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= salary) {
                System.out.println(employees[i].toStringWithoutDep());
            }
        }
    }
}