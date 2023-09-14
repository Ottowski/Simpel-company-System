package inlamning;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

import java.time.format.DateTimeFormatter;

public class Employee extends Staff {

    private int salary;
    private String gender;
    private String name;
    private LocalDate startDate;

    public Employee(int id) {
        super(id);
    }

    public Employee(int id, String name, int salary, String gender, String startDate) {
        super(id);
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
            throw new IllegalArgumentException("Gender must be 'male' or 'female'");
        }
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Employee [id=" + getId() + ", name=" + name + ", gender=" + gender + ", salary=" + salary +
                ", startDate=" + startDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "]";
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
            throw new IllegalArgumentException("Gender must be 'male' or 'female'");
        }
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
