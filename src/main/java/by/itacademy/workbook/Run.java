package by.itacademy.workbook;

import by.itacademy.workbook.constants.MenuConstants;
import by.itacademy.workbook.constants.NumberMenuConstants;
import by.itacademy.workbook.service.EmployeeService;
import by.itacademy.workbook.utils.ConsoleReaderWriter;
import by.itacademy.workbook.utils.SessionManager;

import java.io.IOException;

public class Run {


    public static void main(String[] args) throws IOException {
        EmployeeService employeeService = new EmployeeService();

        ConsoleReaderWriter.write("Hello.\n");
        ConsoleReaderWriter.write(MenuConstants.mainMenu);
        String command = ConsoleReaderWriter.read();

        while (!command.equals(NumberMenuConstants.ZERO)) {
            switch (command) {
                case NumberMenuConstants.ONE:
                    ConsoleReaderWriter.write(MenuConstants.employeeMenu);
                    command = ConsoleReaderWriter.read();
                    while (!command.equals(NumberMenuConstants.ZERO)){
                        switch (command){
                            case NumberMenuConstants.ONE:
                                employeeService.add();
                                break;
                            case NumberMenuConstants.TWO:
                                employeeService.update();
                                break;
                            case NumberMenuConstants.THREE:
                                employeeService.delete();
                                break;
                            case NumberMenuConstants.FOUR:
                                employeeService.show();
                                break;
                            case NumberMenuConstants.FIVE:
                                employeeService.showAll();
                                break;
                            case NumberMenuConstants.ZERO:
                                break;
                            default:{
                                ConsoleReaderWriter.write("Incorrect command.");
                            }
                        }
                        ConsoleReaderWriter.write(MenuConstants.employeeMenu);
                        command = ConsoleReaderWriter.read();
                    }
                    break;

                case NumberMenuConstants.TWO:
                    ConsoleReaderWriter.write(MenuConstants.addressMenu);
                    command = ConsoleReaderWriter.read();
                    while (!command.equals(NumberMenuConstants.ZERO)){
                        switch (command){
                            case NumberMenuConstants.ONE:
                                break;
                            case NumberMenuConstants.TWO:
                                break;
                            case NumberMenuConstants.THREE:
                                break;
                            case NumberMenuConstants.ZERO:
                                break;
                            default:{
                                ConsoleReaderWriter.write("Incorrect command.");
                            }
                        }
                        ConsoleReaderWriter.write(MenuConstants.addressMenu);
                        command = ConsoleReaderWriter.read();
                    }
                    break;

                case NumberMenuConstants.THREE:
                    ConsoleReaderWriter.write(MenuConstants.departmentMenu);
                    command = ConsoleReaderWriter.read();
                    while (!command.equals(NumberMenuConstants.ZERO)){
                        switch (command){
                            case NumberMenuConstants.ONE:
                                break;
                            case NumberMenuConstants.TWO:
                                break;
                            case NumberMenuConstants.THREE:
                                break;
                            case NumberMenuConstants.FOUR:
                                break;
                            case NumberMenuConstants.ZERO:
                                break;
                            default:{
                                ConsoleReaderWriter.write("Incorrect command.");
                            }
                        }
                        ConsoleReaderWriter.write(MenuConstants.departmentMenu);
                        command = ConsoleReaderWriter.read();
                    }
                    break;

                default: {
                    ConsoleReaderWriter.write("Incorrect command.");
                }
            }
            System.out.println(MenuConstants.mainMenu);
            command = ConsoleReaderWriter.read();
        }

        ConsoleReaderWriter.write("Good Bye!");
        SessionManager.shutdown();
    }
}
