package object_oriented_design.linkedin;

import java.util.List;

public class Profile {
    private String summary;
    private List<Experience> experiences;
    private List<Education> educations;
    private List<Skill> skills;
    private List<Accomplishment> accomplishments;
    private List<Recommendation> recommendations;
    private List<Stat> stats;

    public boolean addExperience(Experience experience){
        return false;
    }
    boolean addEducation(Education education){
        return false;
    }
    boolean addSkill(Skill skill){
        return false;
    }

    boolean addAccomplishment(Accomplishment accomplishment){
        return false;
    }
    boolean addRecommendation(Recommendation recommendation){
        return false;
    }

}
