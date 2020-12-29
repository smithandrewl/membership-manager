package bike.rusty.membershipmanager.db.model;

/**
 * Represents a class offered by the club.
 */
public class Class {
    private final int    classId;
    private final int    clubId;
    private final String name;
    private final String description;

    public int getClassId() {
        return classId;
    }

    public int getClubId() {
        return clubId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Creates a new Class without a class id, for use when creating a new Class.
     * @param clubId      The id of the club offering the class
     * @param name        The name of the class
     * @param description A description for the class
     */
    public Class(
        int    clubId,
        String name,
        String description
    ) {
        this(-99, clubId, name, description);
    }

    /**
     * Creates a new Class instance when the classId is already known.
     *
     * @param classId     The id of the class
     * @param clubId      The id of the club
     * @param name        The name of the class
     * @param description A description for the class
     */
    public Class(
        int    classId,
        int    clubId,
        String name,
        String description
    ) {
        this.classId     = classId;
        this.clubId      = clubId;
        this.name        = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, description);
    }
}
