package bike.rusty.membershipmanager.model;

/**
 * Represents a paying club member.
 */
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

    /**
     * Creates a new member who has not been saved to the database yet.
     *
     * @param clubId    The id of the club they are a member of
     * @param firstName The members first name
     * @param lastName  The members last name
     */
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

    /**
     * Creates a new member instance when the memberId is already known.
     *
     * @param memberId  The members id
     * @param clubId    The id of the club they are a member at
     * @param firstName Their first name
     * @param lastName  Their last name
     */
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
                "memberId    ="   + memberId  +
                ", clubId    ="   + clubId    +
                ", firstName ='"  + firstName + '\'' +
                ", lastName  ='"  + lastName  + '\'' +
                '}';
    }
}
