package bike.rusty.membershipmanager.model;

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

    public Class(
        int    clubId,
        String name,
        String description
    ) {
        this(-99, clubId, name, description);
    }

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
        return "Class{" +
            "classId=" + classId +
            ", clubId=" + clubId +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            '}';
    }
}
