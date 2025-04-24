import java.util.ArrayList;
import java.util.List;

//abstract class 
abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Abstract method
    public abstract double calculateSalary();

    
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

//fulltime employee class
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);                      //super keyword
        this.monthlySalary = monthlySalary;
    }

    
    public double calculateSalary() {
        return monthlySalary;
    }
}

//parttime employee class
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);                     
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}


//payroll class
class PayrollSystem {
    private List<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

      // to add employees
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

       // to removee employees
    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }
         
    //to display employees details
    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("Nidhi Priya", 101, 80000.0);
        FullTimeEmployee emp2 = new FullTimeEmployee("Rishu Raj", 102, 70000.0);
        PartTimeEmployee emp3 = new PartTimeEmployee("Suhani Sahai", 201, 40, 100.0);
        PartTimeEmployee emp4 = new PartTimeEmployee("Piyush Kumar", 202, 30, 150.0);


        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);

        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();

        System.out.println("\nRemoving Employee...");
        payrollSystem.removeEmployee(201);

        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmployees();
    }
}

