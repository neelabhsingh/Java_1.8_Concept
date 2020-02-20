package object_oriented_design.linkedin;

import java.util.List;

public class Group {
    private String name;
    private String description;
    private int totalMembers;
    public List<Member> members;
    public boolean addMember(Member member){
        return false;
    }
    public boolean updateDescription(String description){
        return false;
    }
}
