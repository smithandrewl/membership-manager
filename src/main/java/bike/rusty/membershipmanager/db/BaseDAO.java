package bike.rusty.membershipmanager.db;

import java.io.File;
import java.sql.*;

/**
 * Provides basic database functionality for all Table specific DAO classes.
 */
public class BaseDAO {
    public static final String CONNECTION_STRING ="jdbc:sqlite:members.db";

    Connection connection = null;
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
        System.out.println("Inside BaseDAO");

        System.out.println("Checking to see if the database exists on disk");
        // create the database if it does not exist
        boolean shouldCreateDatabase = !doesDatabaseExist();

        System.out.printf("Does members.db exist: %s\n", !shouldCreateDatabase);

        if(shouldCreateDatabase) {
            System.out.println("Creating members.db");
        } else {
            System.out.println("Opening members.db");
        }
        connection = DriverManager.getConnection(CONNECTION_STRING);

        if(!doesDatabaseExist()) {
            System.out.println("Creating database tables");
            createDatabaseTables();
        }

    }

    private boolean doesDatabaseExist() {
        File database = new File("members.db");

        return database.exists();
    }

    /**
     * Creates the database tables.
     *
     * @throws SQLException Thrown if there is an error
     */
    private void createDatabaseTables() throws SQLException {
        createClubTable();
        createMemberTable();
        createClassTable();
        createClassMemberTable();
    }

    /**
     * Creates the Club table.
     *
     * @throws SQLException Thrown if there is an error
     */
    private void createClubTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(CLUB_SQL);
        statement.close();
    }

    /**
     * Creates the Member table.
     *
     * @throws SQLException Thrown if there is an error
     */
    private void createMemberTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(MEMBER_SQL);
        statement.close();
    }

    /**
     * Creates the Class table.
     *
     * @throws SQLException Thrown if there is an error
     */
    private void createClassTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(CLASS_SQL);
        statement.close();
    }

    /**
     * Creates the ClassMember table.
     *
     * @throws SQLException Thrown if there is an error
     */
    private void createClassMemberTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(CLASS_MEMBER_SQL);
        statement.close();
    }
}
