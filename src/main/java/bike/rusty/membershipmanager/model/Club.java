package bike.rusty.membershipmanager.model;

/**
 * Represents the Club
 */
public class Club {
    public int getClubId() {
        return clubId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Club{" +
                "clubId        = "  + clubId      +
                ", name        = '" + name        + '\'' +
                ", description = '" + description + '\'' +
        '}';
    }

    private final int    clubId;
    private final String name;
    private final String description;

    /**
     * Creates a club without an id (for when it hasn't been saved yet).
     *
     * @param name        The name of the club
     * @param description A description for the club.
     */
    public Club(
        String name,
        String description
    ) {
        this(-99, name, description);
    }

    /***
     * Creates a club.
     *
     * @param clubId      The database id of the club.
     * @param name        The name of the club.
     * @param description A description for the club.
     */
    public Club(
        int    clubId,
        String name,
        String description
    ) {
        this.clubId      = clubId;
        this.name        = name;
        this.description = description;
    }

}
