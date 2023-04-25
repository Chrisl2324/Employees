import java.util.*;

class Employee {

    int id;
    String dept;
    String name;
    double salary;

    public Employee(int id, String dept, String name, double salary) {
        this.id = id;
        this.dept = dept;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static class Employees {
        static double highest;
        static double lowest;
        static Scanner scan = new Scanner(System.in);
        static ArrayList<Employee> employees = new ArrayList<>();

        public static void addEmployee() {
            System.out.print("Enter employee ID: ");
            int id = scan.nextInt();
            System.out.print("Enter employee name: ");
            String name = scan.next();
            System.out.print("Enter employee department: ");
            String dept = scan.next();
            System.out.print("Enter employee salary: ");
            double salary = scan.nextDouble();
            employees.add(new Employee(id, dept, name, salary));
        }

        public static void removeIndex() {
            System.out.print("Enter index to remove: ");
            int index = scan.nextInt();
            employees.remove(index);
        }

        public static void removeName() {
            System.out.print("Enter name to remove: ");
            String name1 = scan.next();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getName().equals(name1)) {
                    employees.remove(i);
                }
            }
        }

        public static void highestSalary() {
            highest = employees.get(0).getSalary();
            String highestName = employees.get(0).getName();
            int highestID = employees.get(0).getId();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getSalary() > highest) {
                    highest = employees.get(i).getSalary();
                    highestName = employees.get(i).getName();
                    highestID = employees.get(i).getId();
                }
            }
            System.out.println("Highest salary is: " + highest * 12);
            System.out.println(highestName + " has highest salary");
            System.out.println("ID is: " + highestID);
        }

        public static void lowestSalary() {
            lowest = employees.get(0).getSalary();
            String lowestName = employees.get(0).getName();
            int lowestId = employees.get(0).getId();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getSalary() < lowest) {
                    lowest = employees.get(i).getSalary();
                    lowestName = employees.get(i).getName();
                    lowestId = employees.get(i).getId();
                }
            }
            System.out.println("Lowest salary is: " + lowest * 12);
            System.out.println(lowestName + " has lowest salary");
            System.out.println("ID is: " + lowestId);
        }

        public static void removeId() {
            System.out.print("Enter ID to remove: ");
            int id = scan.nextInt();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getId() == id) {
                    employees.remove(i);
                }
            }
        }

        public static void searchDepartment() {
            double total = 0;
            System.out.print("Enter department to search: ");
            String deptSearch = scan.next();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getDept().equals(deptSearch)) {
                    total += employees.get(i).getSalary() * 12;
                    System.out.println("Name: " + employees.get(i).getName());
                    System.out.println("Annual Salary: " + employees.get(i).getSalary() * 12);
                    System.out.println();
                }
            }
            System.out.println("Total annual salary: " + total);
        }

        public static void displayEmployees() {
            double total = 0;
            System.out.println("DEPT \t\t ID \t\t NAME \t\t SALARY \t\t ANNUAL SALARY");
            System.out.println("******************************************************************");
            for (int i = 0; i < employees.size(); i++) {
                total += employees.get(i).getSalary() * 12;
                System.out.println(employees.get(i).getDept() + "\t\t\t" + employees.get(i).getId() + "\t\t\t" + employees.get(i).getName() + "\t\t" + employees.get(i).getSalary() + "\t\t\t" + employees.get(i).getSalary() * 12);
            }
            System.out.println("Total annual salary: " + total);
        }

        public static void main(String[] args) {
            int choice;
            do {
                System.out.println("1. ADD EMPLOYEE");
                System.out.println("2. REMOVE BY INDEX");
                System.out.println("3. REMOVE BY NAME");
                System.out.println("4. REMOVE BY ID");
                System.out.println("5. DISPLAY HIGHEST SALARY");
                System.out.println("6. DISPLAY LOWEST SALARY");
                System.out.println("7. DISPLAY BY DEPARTMENT");
                System.out.println("8. DISPLAY ALL");
                System.out.println("9. END PROGRAM");
                System.out.print("Enter your choice: ");
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        removeIndex();
                        break;
                    case 3:
                        removeName();
                        break;
                    case 4:
                        removeId();
                        break;
                    case 5:
                        highestSalary();
                        break;
                    case 6:
                        lowestSalary();
                        break;
                    case 7:
                        searchDepartment();
                        break;
                    case 8:
                        displayEmployees();
                        break;
                }
            } while (choice != 9);
        }
    }
}


