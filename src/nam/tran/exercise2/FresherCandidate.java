package nam.tran.exercise2;

public class FresherCandidate extends Candidate {

    private String graduationDate;
    private String graduationRank;
    private String education;

    public FresherCandidate(String id, String firstName, String lastName, String birthYear, String address, String phoneNumber, String email, String graduationDate, String graduationRank, String education) {
        super(id, firstName, lastName, birthYear, address, phoneNumber, email);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public int getType() {
        return 2;
    }
}
