package nam.tran.exercise2;

public class ExperienceCandidate extends Candidate {

    private int expInYear;
    private String proSkill;

    public ExperienceCandidate(String id, String firstName, String lastName, String birthYear, String address, String phoneNumber, String email, int expInYear, String proSkill) {
        super(id, firstName, lastName, birthYear, address, phoneNumber, email);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public int getType() {
        return 1;
    }
}
