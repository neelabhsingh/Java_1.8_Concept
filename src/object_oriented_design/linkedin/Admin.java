package object_oriented_design.linkedin;

public class Admin extends Person {
    public boolean blockUser(Customer customer){
        return false;
    }
    public boolean unBlockUser(Customer customer){
        return false;
    }
}
