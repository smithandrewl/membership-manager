package bike.rusty.membershipmanager.model;

public class Member {
    private final int    memberId;
    private final int    clubId;
    private final String firstName;
    private final String lastName;

    public int getMemberId() {
        return memberId;
    }

    public int getClubId() {
        return clubId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Member(
        int    clubId,
        String firstName,
        String lastName
    ) {
        this.memberId  = -99;
        this.clubId    = clubId;
        this.firstName = firstName;
        this.lastName  = lastName;
    }
    public Member(
        int    memberId,
        int    clubId,
        String firstName,
        String lastName
    ) {
        this.memberId  = memberId;
        this.clubId    = clubId;
        this.firstName = firstName;
        this.lastName  = lastName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId="     + memberId  +
                ", clubId="     + clubId    +
                ", firstName='" + firstName + '\'' +
                ", lastName='"  + lastName  + '\'' +
                '}';
    }
}
