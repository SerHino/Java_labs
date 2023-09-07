public class Employee {
    private int id;
    private static int nextId = 1;
    private String name;
    private String surname;
    private double salary;

    public Employee(String name, String surname, double salary) throws FieldLengthLimitException, IncorrectSalaryException {
        setId();
        setName(name);
        setSurname(surname);
        setSalary(salary);
    }

    private void setId() {
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws FieldLengthLimitException {
        if (name.length() > 25) {
            throw new FieldLengthLimitException("Ім'я перевищує максимальну довжину (25 символів)");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws FieldLengthLimitException {
        if (surname.length() > 25) {
            throw new FieldLengthLimitException("Прізвище перевищує максимальну довжину (25 символів)");
        }
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws IncorrectSalaryException {
        if (salary < 0) {
            throw new IncorrectSalaryException("Заробітна плата не може бути від'ємною (тільки як штрафи)");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nІм'я: " + name + "\nПрізвище: " + surname + "\nЗаробітна плата: " + salary;
    }
}
