package nam.tran.exercise2;

public class InternCandidate extends Candidate {

    private String major;
    private String semester;
    private String nameUniversity;

    public InternCandidate(String id, String firstName, String lastName, String birthYear, String address, String phoneNumber, String email, String major, String semester, String nameUniversity) {
        super(id, firstName, lastName, birthYear, address, phoneNumber, email);
        this.major = major;
        this.semester = semester;
        this.nameUniversity = nameUniversity;
    }

    @Override
    public int getType() {
        return 3;
    }
}
