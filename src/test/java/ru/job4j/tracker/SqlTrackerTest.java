package ru.job4j.tracker;

import org.junit.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;

@Ignore
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

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();

        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplaced() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        item.setName("test");
        tracker.replace(item.getId(), item);
        assertEquals("test", tracker.findById(item.getId()).getName());

    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("Alex");
        tracker.add(item);
        assertTrue(tracker.delete(item.getId()));

    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1); tracker.add(item2);
        List<Item> rsl = tracker.findAll();
        assertThat(rsl, is(List.of(item1, item2)));
    }

    @Test
    public void whenFindByName() throws Exception {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        List<Item> rsl = tracker.findByName("item1");
        assertThat(rsl, is(List.of(item1)));
     }

    @Test
    public void whenFindById() throws Exception {
        SqlTracker tracker = new SqlTracker(connection);
            Item item = new Item("test");
            tracker.add(item);
            Item rsl = tracker.findById(item.getId());
            assertEquals(rsl.getName(), item.getName());
        }
    }


