package bike.rusty.membershipmanager.db.dao;

import java.io.File;
import java.sql.*;

/**
 * Provides basic database functionality for all Table specific DAO classes.
 */
public class BaseDAO {
    public static final String CONNECTION_STRING ="jdbc:sqlite:members.db";

    static Connection connection = null;

    // This is the SQL statement which creates the Club table.
    public static final String CLUB_SQL = String.join(
        "\n",
        "CREATE TABLE club(",
        "    clubId      INTEGER PRIMARY KEY AUTOINCREMENT,",
        "    name        VARCHAR(255),",
        "    description TEXT",
        ");"
    );

    // This is the SQL statement which creates the Member table.
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

    // This is the SQL statement which creates the Class table.
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

    // This is the SQL statement which creates the ClassMember table,
    // which can be thought of as a roster of students for a specific class.
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

    /**
     * This is an SQL statement for inserting data into the Club class
     *
     * This application will only ever have one club, so this is used
     * only when the database is first being created.
     */
    public static final String CLUB_INSERT_SQL = String.join(
        "\n",
        "INSERT INTO club(",
        "    name,",
        "    description",
        ") values (",
        "    'Unknown',",
        "    'The default club'",
        ");"
    );

    public BaseDAO() throws SQLException {
        System.out.println("Inside BaseDAO");

        // Only perform database initialization the first time.
        if(connection == null) {
            System.out.println("Checking to see if the database exists on disk");
            // create the database if it does not exist
            boolean shouldCreateDatabase = !doesDatabaseExist();

            System.out.printf("Does members.db exist: %s\n", !shouldCreateDatabase);

            if (shouldCreateDatabase) {
                System.out.println("Creating members.db");
            } else {
                System.out.println("Opening members.db");
            }
            connection = DriverManager.getConnection(CONNECTION_STRING);

            if (shouldCreateDatabase) {
                System.out.println("Creating database tables");
                createDatabaseTables();
            }

        }

    }

    /**
     * Determines whether the database file exists on disk.
     * @return whether the database file exists on disk.
     */
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

        insertClubRecord();
    }

    /**
     * Creates the Club table.
     *
     * @throws SQLException Thrown if there is an error
     */
    private void createClubTable() throws SQLException {
        Statement statement = connection.createStatement();
        System.out.println(CLUB_SQL);
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

    /**
     * Creates the default club with default values.
     * @throws SQLException Thrown if there is an error
     */
    private void insertClubRecord() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(CLUB_INSERT_SQL);
        statement.close();
    }
}
