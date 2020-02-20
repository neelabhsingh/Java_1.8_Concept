package java_basics.transient_keyword.demo1;

import java.io.*;
import java.util.logging.Logger;

class Employee implements Serializable{
    private String firstName;
    private String lastName;
    private transient String confidentialInfo;
    private transient final String empId = "neelabh1986";
    private transient final Logger logger = Logger.getLogger("demo");

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getConfidentialInfo() {
        return confidentialInfo;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setConfidentialInfo(String confidentialInfo) {
        this.confidentialInfo = confidentialInfo;
    }

    public String getEmpId() {
        return empId;
    }

    public Logger getLogger() {
        return logger;
    }
}
public class TestTransient {
    public static void main(String[] args) {
        //Serialized Object.
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(("empInfo.ser")));
            Employee emp = new Employee();
            emp.setFirstName("Neelabh");
            emp.setLastName("Singh");
            emp.setConfidentialInfo("password");
            oos.writeObject(emp);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Deserialization of Object
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empInfo.ser"));
            Employee readEmpInfo = (Employee) ois.readObject();
            System.out.println(readEmpInfo.getFirstName());
            System.out.println(readEmpInfo.getLastName());
            System.out.println(readEmpInfo.getConfidentialInfo());
            System.out.println(readEmpInfo.getEmpId());
            System.out.println(readEmpInfo.getLogger());
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }







    }
}
