public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[10];
        employee[0] = new Employee("Василевская Варвара Алексеевна", 2, 114_000);
        employee[1] = new Employee("Никифоров Павел Петрович", 3, 47_000);
        employee[2] = new Employee("Дьячкова Кира Андреевна", 3, 265_000);
        employee[3] = new Employee("Рожков Савелий Матвеевич", 1, 151_000);
        employee[4] = new Employee("Шарова Полина Тимофеевна", 3, 139_000);
        employee[5] = new Employee("Панова Софья Петровна", 4, 158_000);
        employee[6] = new Employee("Петухов Руслан Аркадьевич", 1, 129_000);
        employee[7] = new Employee("Гурьев Тихон Антонович", 4, 83_000);
        employee[8] = new Employee("Богданова Диана Даниловна", 5, 258_000);
        employee[9] = new Employee("Смирнов Олег Тихонович", 3, 127_000);

        printData(employee);
        int total = sumOfSalaries(employee);
        System.out.println("Общая сумма затрат на зарплаты = " + total + " рублей");
        System.out.println("Минимальная зарплата у сотрудника: " + minSalary(employee));
        System.out.println("Максимальная зарплата у сотрудника: " + maxSalary(employee));
        System.out.println("Средняя зарплата = " + middleSalary(total, employee) + " рублей");
        printFullNames(employee);
        toIncreaseSalary(employee, 5);
        int dept = 1;
        minDepartmentSalary(employee, dept);
        maxDepartmentSalary(employee, dept);
        System.out.println("Минимальная зарплата в отделе №" + dept + " у сотрудника: " + minDepartmentSalary(employee, dept));
        System.out.println("Максимальная зарплата в отделе №" + dept + " у сотрудника: " + maxDepartmentSalary(employee, dept));
        int totalDepartment = sumOfDepartmentSalaries(employee,dept);
        System.out.println("Общая сумма затрат на зарплаты в отделе №"+dept+" = " + totalDepartment + " рублей");
        System.out.println("Средняя зарплата в отделе №"+dept+" = " + middleDepartmentSalary(employee,dept,totalDepartment) + " рублей");
        toIncreaseDepartmentSalary(employee,dept,7);
        printDepartmentList(employee,dept);
        printEmployeesSalaryLessNumber(employee,100_000);
        printEmployeesSalaryMoreNumber(employee,150_000);


    }

    public static void printData(Employee[] emps) {
        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i]);
        }
    }

    public static int sumOfSalaries(Employee[] emps) {
        int total = 0;
        for (int i = 0; i < emps.length; i++) {
            total = total + emps[i].getSalary();
        }
        return total;
    }

    public static Employee minSalary(Employee[] emps) {
        int minimum = 0;
        for (int i = 1; i < emps.length; i++) {
            if (emps[i].getSalary() < emps[minimum].getSalary()) {
                minimum = i;
            }
        }
        return emps[minimum];
    }

    public static Employee maxSalary(Employee[] emps) {
        int maximum = 0;
        for (int i = 1; i < emps.length; i++) {
            if (emps[i].getSalary() > emps[maximum].getSalary()) {
                maximum = i;
            }
        }
        return emps[maximum];
    }

    public static int middleSalary(int total, Employee[] emps) {
        int middle = total / emps.length;
        return middle;
    }

    public static void printFullNames(Employee[] emps) {
        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i].getFullName());
        }

    }

    public static void toIncreaseSalary(Employee[] emps, int index) {
        for (int i = 0; i < emps.length; i++) {
            emps[i].setSalary((emps[i].getSalary() * index / 100) + emps[i].getSalary());
        }
    }

    public static Employee minDepartmentSalary(Employee[] emps, int department) {
        int minimum = 0;
        for (int i = 1; i < emps.length; i++) {
            if (emps[i].getSalary() < emps[minimum].getSalary() && emps[i].getDepartment() == department) {
                minimum = i;
            }
        }
        return emps[minimum];
    }

    public static Employee maxDepartmentSalary(Employee[] emps, int department) {
        int max = 0;
        for (int i = 1; i < emps.length; i++) {
            if (emps[i].getSalary() > emps[max].getSalary() && emps[i].getDepartment() == department) {
                max = i;
            }
        }
        return emps[max];
    }

    public static int sumOfDepartmentSalaries(Employee[] emps, int department) {
        int total = 0;
        for (int i = 0; i < emps.length; i++) {
            if (emps[i].getDepartment() == department) {
                total = total + emps[i].getSalary();
            }
        }
        return total;
    }

    public static int middleDepartmentSalary(Employee[] emps,int department, int total) {
        int middle;
        int lenght = 0;
        for (int i = 0; i < emps.length; i++) {
            if (emps[i].getDepartment() == department) {
                lenght++;
            }
        }
        middle = total/lenght;
        return middle;
    }


    public static void toIncreaseDepartmentSalary(Employee[] emps, int department, int index) {
        for (int i = 0; i < emps.length; i++) {
            if (emps[i].getDepartment() == department) {
                emps[i].setSalary((emps[i].getSalary() * index / 100) + emps[i].getSalary());
            }
        }

    }


    public static void printDepartmentList(Employee [] emps, int department){
        System.out.println("Список сотрудников отдела №"+department+":");
        for (int i = 0; i < emps.length; i++) {
            if (emps[i].getDepartment() == department) {
                System.out.println(emps[i].getFullName() + ", зарплата = " + emps[i].getSalary() + ", id " + emps[i].getId());
            }
        }

    }

    public static void printEmployeesSalaryLessNumber(Employee[] emps, int number) {
        System.out.println("Список сотрудников с зарплатой меньше "+number+" рублей:");
        for (int i = 0; i < emps.length; i++) {
            if (emps[i].getSalary()<number){
                System.out.println(emps[i].getFullName() + ", зарплата = " + emps[i].getSalary() + ", id " + emps[i].getId());
            }
        }
    }

    public static void printEmployeesSalaryMoreNumber(Employee[] emps, int number) {
        System.out.println("Список сотрудников с зарплатой больше "+number+" рублей:");
        for (int i = 0; i < emps.length; i++) {
            if (emps[i].getSalary()>=number){
                System.out.println(emps[i].getFullName() + ", зарплата = " + emps[i].getSalary() + ", id " + emps[i].getId());
            }
        }
    }
}