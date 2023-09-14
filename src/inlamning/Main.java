package inlamning;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        List<Staff> staffList = new ArrayList<>();

        Employee employee1 = new Employee(1, "Andreas", 34000, "Male", "2001-01-05");
        Employee employee2 = new Employee(2, "Johanna", 23000, "Female", "2011-05-29");
        Employee employee3 = new Employee(3, "Kajsa", 27000, "Female", "2004-01-09");
        Employee employee4 = new Employee(4, "Mikael", 24000, "Male", "1988-04-09");
        Employee employee5 = new Employee(5, "Maja", 21000, "Female", "1976-11-29");

        Trainee trainee1 = new Trainee(101, "Martin", 16000, "Male", "2005-07-30", "Proverb, this trainee have now quit.");
        Trainee trainee2 = new Trainee(102, "Hugo", 15000, "Male","2005-07-30", "This trainee have now quit too.");

        staffList.add(employee1);
        staffList.add(employee2);
        staffList.add(employee3);
        staffList.add(employee4);
        staffList.add(employee5);
        staffList.add(trainee1);
        staffList.add(trainee2);

        modifyEmployeeInformation(employee1, "Andreas", 50000, "Male", LocalDate.parse("2001-01-04"));
        modifyTraineeInformation(trainee1, "Martin", 18000, "Male");

        // deleteStaffMember(staffList, employee2);

        staffList.forEach(System.out::println);
        int totalPeopleCount = getTotalPeopleCount(staffList);
        System.out.println("Total number of people in the system: " + totalPeopleCount);

        List<Employee> employees = staffList.stream()
                .filter(s -> s instanceof Employee)
                .map(s -> (Employee) s)
                .collect(Collectors.toList());

        calculateAverageSalary(employees, "Male");
        calculateAverageSalary(employees, "Female");
        createEmployeeHierarchy(employees);
    }
    private static void modifyEmployeeInformation(Employee employee, String name, int salary, String gender, LocalDate startDate) {
        employee.setName(name);
        employee.setSalary(salary);
        employee.setGender(gender);
        employee.setStartDate(LocalDate.parse(String.valueOf(startDate)));
    }
    private static void modifyTraineeInformation(Trainee trainee, String name, int salary, String gender) {
        trainee.setName(name);
        trainee.setSalary(salary);
        trainee.setGender(gender);
    }
    private static void deleteStaffMember(List<Staff> staffList, Staff staff) {
        staffList.remove(staff);
    }
    private static int getTotalPeopleCount(List<Staff> staffList) {
        return staffList.size();
    }
    private static void calculateAverageSalary(List<Employee> employees, String gender) {
        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> e.getGender().equalsIgnoreCase(gender))
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .toList();

        int totalEmployees = filteredEmployees.size();
        if (totalEmployees == 0) {
            System.out.println("No " + gender + " employees to calculate the average salary.");
            return;
        }

        int middleIndex = totalEmployees / 2;

        if (totalEmployees % 2 == 0) {
            Employee middleEmployee1 = filteredEmployees.get(middleIndex - 1);
            Employee middleEmployee2 = filteredEmployees.get(middleIndex);
            double middleAverageSalary = (middleEmployee1.getSalary() + middleEmployee2.getSalary()) / 2.0;
            System.out.println(gender + " Middle Average Salary: " + middleAverageSalary);
        } else {
            Employee middleEmployee = filteredEmployees.get(middleIndex);
            double middleSalary = middleEmployee.getSalary();
            System.out.println(gender + " Middle Average Salary: " + middleSalary);
        }
    }

    private static void createEmployeeHierarchy(List<Employee> employees) {
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getStartDate))
                .toList();

        System.out.println("Employee Hierarchy (Earliest to Latest):");
        sortedEmployees.forEach(System.out::println);
    }
}