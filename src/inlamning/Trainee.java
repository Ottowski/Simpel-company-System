package inlamning;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Trainee extends Staff {

    private int salary;
    private String gender;
    private String name;
    private LocalDate endDate;
    private String proverb;

    public Trainee(int id, String name, int salary, String gender, String endDate, String proverb) {
        super(id);
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.endDate = LocalDate.parse(endDate);
        this.proverb = proverb;
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

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return "Trainee [ID: " + getId() + ", Name: " + name + ", Salary: " + salary +
                ", Gender: " + gender + ", End Date: " + endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +
                ", Proverb: " + proverb + "]";
    }

    public String getProverb() {
        return proverb;
    }

    public void setProverb(String proverb) {
        this.proverb = proverb;
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