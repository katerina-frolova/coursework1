public class Main {
    public static void main(String[] args) {
        Employee [] employee = new Employee[10];
        employee[0]=new Employee("Василевская Варвара Алексеевна", 2,114_000);
        employee[1]=new Employee("Никифоров Павел Петрович", 3,47_000);
        employee[2]=new Employee("Дьячкова Кира Андреевна", 3,265_000);
        employee[3]=new Employee("Рожков Савелий Матвеевич", 1,151_000);
        employee[4]=new Employee("Шарова Полина Тимофеевна", 3,139_000);
        employee[5]=new Employee("Панова Софья Петровна", 4,158_000);
        employee[6]=new Employee("Петухов Руслан Аркадьевич", 1,129_000);
        employee[7]=new Employee("Гурьев Тихон Антонович", 4,83_000);
        employee[8]=new Employee("Богданова Диана Даниловна", 5,258_000);
        employee[9]=new Employee("Смирнов Олег Тихонович", 3,127_000);

        printData(employee);
        int total = sumOfSalaries(employee);
        System.out.println("Общая сумма затрат на зарплаты = "+total+" рублей");
        System.out.println("Минимальная зарплата у сотрудника: "+minSalary(employee));
        System.out.println("Максимальная зарплата у сотрудника: "+maxSalary(employee));
        System.out.println("Средняя зарплата = "+middleSalary(total,employee)+" рублей");
        printFullNames(employee);

    }

    public static void printData(Employee[] emps) {
        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i]);
        }
    }

    public static int sumOfSalaries(Employee [] emps) {
        int total=0;
        for (int i = 0; i < emps.length; i++) {
            total=total+emps[i].getSalary();
        }
        return total;
    }

    public static Employee minSalary(Employee [] emps) {
        int minimum = 0;
        for (int i = 1; i < emps.length; i++) {
            if (emps[i].getSalary()<emps[minimum].getSalary()) {
                minimum=i;
            }
        }
        return emps[minimum];
    }

    public static Employee maxSalary(Employee [] emps) {
        int maximum = 0;
        for (int i = 1; i < emps.length; i++) {
            if (emps[i].getSalary()>emps[maximum].getSalary()) {
                maximum=i;
            }
        }
        return emps[maximum];
    }

    public static int middleSalary(int total,Employee[] emps) {
        int middle = total/emps.length;
        return middle;
    }

    public static void printFullNames(Employee[] emps) {
        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i].getFullName());
        }

    }
}