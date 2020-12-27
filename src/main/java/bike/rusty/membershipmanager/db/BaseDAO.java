package bike.rusty.membershipmanager.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {
    public static final String CONNECTION_STRING ="jdbc:sqlite:members.db";

    Connection connection = DriverManager.getConnection(CONNECTION_STRING);
    public static final String CLUB_SQL = String.join(
        "\n",
        "CREATE TABLE club(",
        "    clubId      INTEGER PRIMARY KEY AUTOINCREMENT,",
        "    name        VARCHAR(255),",
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


    private void createDatabaseTables() throws SQLException {
        createClubTable();
        createMemberTable();
        createClassTable();
        createClassMemberTable();
    }

    private void createClubTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(CLUB_SQL);
        statement.close();
    }

    private void createMemberTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(MEMBER_SQL);
        statement.close();
    }

    private void createClassTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(CLASS_SQL);
        statement.close();
    }

    private void createClassMemberTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(CLASS_MEMBER_SQL);
        statement.close();
    }
}
