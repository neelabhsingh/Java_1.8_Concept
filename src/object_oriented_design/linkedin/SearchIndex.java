package object_oriented_design.linkedin;

import java.util.HashMap;
import java.util.List;

public class SearchIndex implements Search {
    HashMap<String,List<Member>> memberNames;
    HashMap<String, List<Company>> companyNames;
    HashMap<String, List<JobPosting>> jobTitles;

    @Override
    public List<Member> searchMember(String name) {
        return null;
    }

    @Override
    public List<Company> searchCompany(String name) {
        return null;
    }

    @Override
    public List<JobPosting> searchJob(String title) {
        return null;
    }
}
