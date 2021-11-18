package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.*;

public class SqlTrackerTest {

     private  static Connection connection;

     @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() throws SQLException {
         SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertTrue(item.getId() > 0);

    }

    @Test
    public void whenReplaced() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item(0, "item");
        tracker.add(item);
        item.setName("test");
        tracker.replace(item.getId(), item);
        assertEquals("test", tracker.findById(item.getId()).getName());

    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item(0, "Alex");
        tracker.add(item);
        assertTrue(tracker.delete(item.getId()));

    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
            tracker.add(new Item(0, "item1"));
            tracker.add(new Item(0, "item2"));
            List<Item> rsl = tracker.findAll();
            for (int i = 0; i < rsl.size(); i++) {
                assertEquals(String.format("item%d", (i + 1)), rsl.get(i).getName());
            }
     }

    @Test
    public void whenFindByName() throws Exception {
        SqlTracker tracker = new SqlTracker(connection);
            tracker.add(new Item(0, "item"));
            tracker.add(new Item(0, "item"));
            List<Item> rsl = tracker.findByName("item");
            assertEquals(2, rsl.size());
            for (int i = 0; i < rsl.size(); i++) {
                assertEquals("item", rsl.get(i).getName());
            }
    }

    @Test
    public void whenFindById() throws Exception {
        SqlTracker tracker = new SqlTracker(connection);
            Item item = new Item(0, "test");
            tracker.add(item);
            Item rsl = tracker.findById(item.getId());
            assertEquals(rsl.getName(), item.getName());
        }
    }


