package object_oriented_design.linkedin;

import java.util.Date;
import java.util.List;

public class Member extends Person{
    private Date dateOfMembership;
    private String headline;
    private byte [] photo;
    private List<Member> memberSuggestion;
    private List<Member> memberFollows;
    private List<Member> memberConnection;
    private List<Company> companyFollows;
    private List<Group> groupFollows;
}
