public class Main {
    public static void main(String[] args) {
        try {
            Employee employee = new Employee("Сергій", "Штонда", 200000.0);
            System.out.println("Інформація про співробітника:");
            System.out.println(employee);
        } catch (FieldLengthLimitException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (IncorrectSalaryException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        
        try {
            Employee employee = new Employee("Дмитро", "Абоба", -2000.0);
            System.out.println("Інформація про співробітника:");
            System.out.println(employee);
        } catch (FieldLengthLimitException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (IncorrectSalaryException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}

