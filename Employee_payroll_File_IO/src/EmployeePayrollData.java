public class EmployeePayrollData {
    int id;
    String name;
    Double salary;

    public EmployeePayrollData(int id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;


    }

    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
