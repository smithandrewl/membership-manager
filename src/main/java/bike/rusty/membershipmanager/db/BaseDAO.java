package bike.rusty.membershipmanager.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    public static final String CONNECTION_STRING ="jdbc:sqlite:members.db";

    Connection connection = DriverManager.getConnection(CONNECTION_STRING);
    public static final String Club_SQL = String.join(
        "\n",
        "CREATE TABLE club(",
        "    clubId INTEGER PRIMARY KEY AUTOINCREMENT,",
        "    name VARCHAR(255),",
        "    description TEXT",
        ");"
    );

    public static final String MEMBER_SQL = String.join(
        "\n",
        "Create table member(",
        "    memberId  INTEGER PRIMARY KEY AUTOINCREMENT,",
        "    firstname VARCHAR(255),",
        "    lastname  VARCHAR(255),",
        "    clubId    INTEGER,",
        "    FOREIGN KEY(clubId) REFERENCES club(clubId)",
        ");"
    );

    public static final String CLASS_SQL = String.join(
            "\n",
            "Create table class(",
            "    classId     INTEGER PRIMARY KEY AUTOINCREMENT,",
            "    name        VARCHAR(255),",
            "    description TEXT,",
            "    clubId      INTEGER,",
            "    FOREIGN KEY(clubId) REFERENCES club(clubid)",
            ");"

    );

    public static final String CLASS_MEMBER_SQL = String.join(
            "\n",
            "create Table class_member(",
            "    classId INTEGER,",
            "    memberId INTEGER,",
            "    primary KEY(",
            "        classId,",
            "        memberId",
            "    )",
            ");"
    );
    
    public BaseDAO() throws SQLException {
        // create the database if it does not exist
        createDatabaseTables();
    }


    private void createDatabaseTables() {
        createClubTable();
        createMemberTable();
        createClassTable();
        createClassMemberTable();
    }

    private void createClubTable() {

    }

    private void createMemberTable() {

    }

    private void createClassTable() {

    }

    private void createClassMemberTable() {

    }
}
