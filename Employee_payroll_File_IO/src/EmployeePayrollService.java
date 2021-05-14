import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public enum IOService { CONSOLE_IO, FILE_IO, DB_IO, REST_IO }
    private List<EmployeePayrollData> employeePayrollList;

    /**
     * plain constructor
     */
    public EmployeePayrollService() {
    }

    /**
     * parameterized constructor for initializing list
     */
    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    /**
     * to read from the console
     * @param consoleInputReader scanner object
     */
    private void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Please enter employee name");
        String name = consoleInputReader.nextLine();
        System.out.println("Please enter employee ID");
        int id = consoleInputReader.nextInt();
        System.out.println("Please enter employee salary");
        double salary = consoleInputReader.nextDouble();

        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    /**
     * to write into the console
     */
    public void writeEmployeePayrollData(EmployeePayrollService.IOService ioService) {
        if(ioService.equals(IOService.CONSOLE_IO)) {
            System.out.println("\n Writing Employee Payroll Roster to Console\n" + employeePayrollList);
        }
        else if(ioService.equals(IOService.FILE_IO)){
            new EmployeePayrollFileIOService().writeData(employeePayrollList);
        }
    }

    /**
     * main method
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Employee Payroll service program!");
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);

        /**
         * UC2:-Check File Exists, Delete File and Check File Not Exist, Create Directory,
         *      Create Empty File, List Files, Directories as well as Files with Extension.
         */
        FileOperations fileOperations = new FileOperations();
        fileOperations.fileOperationDemonstrator();
    }

    /**
     * counts entries into the file
     * @param ioService enum type
     * @return file entry count
     */
    public long countEntries(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO));
        return new EmployeePayrollFileIOService().countEntries();
    }

    /**
     *
     * @return
     */
    public List<EmployeePayrollData> printEntries(IOService ioService){
        if(ioService.equals(IOService.FILE_IO));
        return new EmployeePayrollFileIOService().readData();
    }

    /**
     * prints data into the file
     * @param ioService
     */
    public void printData(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO));
        new EmployeePayrollFileIOService().printData();
    }
}