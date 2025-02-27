package ru.job4j.tracker;

import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(out),
                new ExitProgram());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {

        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new ReplaceItem(out),
                new ExitProgram()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new DeleteItem(out),
                new ExitProgram());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                new ExitProgram()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllItem() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Show items"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new FindAllItem(out), new ExitProgram()
        );
        new StartUI(out).init(in, tracker, actions);

        assertThat((out.toString()), is("Menu."
                + System.lineSeparator() + "0. Show all items"
                + System.lineSeparator() + "1. Exit"
                + System.lineSeparator() + "===Show all items===="
                + System.lineSeparator()
                + item
                + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Show all items"
                + System.lineSeparator()
                + "1. Exit"
                + System.lineSeparator()
        ));

    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Find item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new FindByIdItem(out), new ExitProgram()
        );
        new StartUI(out).init(in, tracker, actions);

        assertThat((out.toString()), is("Menu."
                + System.lineSeparator() + "0. Find item by id"
                + System.lineSeparator() + "1. Exit"
                + System.lineSeparator()
                + "=== Find item by id ===="
                + System.lineSeparator()
                + item
                + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find item by id"
                + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()));

    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Name"));
        String name = "Name";
        Input in = new StubInput(
                new String[]{"0", name, "1"}
        );
       List<UserAction> actions = Arrays.asList(
                new FindByNameItem(out), new ExitProgram()
       );
        new StartUI(out).init(in, tracker, actions);

        assertThat((out.toString()), is("Menu."
                + System.lineSeparator() + "0. Find items by name"
                + System.lineSeparator() + "1. Exit"
                + System.lineSeparator()
                + "=== Find items by name ===="
                + System.lineSeparator()
                + item
                + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find items by name"
                + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()));

    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"9", "0"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                new ExitProgram()
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                )
        );
    }

    @Test
    public void whenDeleteItemWithMock() {
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Output out = new StubOutput();
        Input in = mock(Input.class);
        Mockito.when(in.askInt(any(String.class))).thenReturn(1);
        DeleteItem delete = new DeleteItem(out);
        delete.execute(in, tracker);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindByIdMock() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Find item"));
        Input in = mock(Input.class);
        Mockito.when(in.askInt(any(String.class))).thenReturn(1);
        FindByIdItem find = new FindByIdItem(out);
        find.execute(in,  tracker);
        assertThat((out.toString()), is("=== Find item by id ====" + System.lineSeparator()
                + item + System.lineSeparator()));

    }

    @Test
    public void whenFindByNameMock() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        FindByNameItem nameItem =  new FindByNameItem(out);
        Item item = tracker.add(new Item("Name"));
        Input in = mock(Input.class);
        Mockito.when(in.askStr(any(String.class))).thenReturn("Name");
        nameItem.execute(in, tracker);
        assertThat(out.toString(), is("=== Find items by name ===="
                + System.lineSeparator()
                + item + System.lineSeparator()));
    }
}