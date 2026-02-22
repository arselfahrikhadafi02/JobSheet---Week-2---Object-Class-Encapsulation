import  id.ac.polban.employee.model.*;
import  id.ac.polban.employee.service.*;

public class EmployeeMain{
    public static void main(String[] args) {
        System.out.println("Data Employee");

        // Ini merupakan Aggregation karena Employee memiliki Department dan EmploymentType, tetapi Department dan EmploymentType bisa ada tanpa Employee
        Department GameDev = new Department("Game Developer");
        EmploymentType HalfTime = new EmploymentType("Half Time");

        Employee Karyawan1 = new Employee(0, "Arsel Fahri Khadafi", GameDev, HalfTime, 4000.0);

        System.out.println("ID Employee : " + Karyawan1.getId() + "\nNama Employee : " + Karyawan1.getName() + "\nDepartment : " + Karyawan1.getDepartment().getName() + "\nEmployment Type : " + Karyawan1.getType().getType());

        //ini merupakan Dependency karena EmployeeService bergantung pada Employee untuk melakukan operasi seperti menambah karyawan, mendapatkan karyawan, dan menaikkan gaji karyawan
        EmployeeService service = new EmployeeService();
        service.addEmployee(Karyawan1);
        
        System.out.println("Data Karyawan Telah Ditambah");
        System.out.println("Gaji Karyawan " + service.getEmployee(0).getName() + " adalah: " + service.getEmployee(0).getSalary() + "$");
        service.raiseSalary(0, 12.0);
        System.out.println("Setelah Kenaikan Gaji:");
        System.out.println("Gaji Karyawan " + service.getEmployee(0).getName() + " adalah: " + service.getEmployee(0).getSalary() + "$");

        // Mengakses totalEmployee melalui static method
        System.out.println("Total Employee yang terdata: " + Employee.getTotalEmployee());
    }
}