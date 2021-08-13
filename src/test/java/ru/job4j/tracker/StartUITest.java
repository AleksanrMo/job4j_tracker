package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

     @Test
     public void whenCreateItem() {
         Output out = new StubOutput();
         Input in = new StubInput(
                 new String[]{"0", "Item name", "1"}
         );
         Tracker tracker = new Tracker();
         UserAction[] actions = {
                 new CreateAction(out),
                 new ExitProgram()
         };
         new StartUI(out).init(in, tracker, actions);
         assertThat(tracker.findAll()[0].getName(), is("Item name"));
     }

     @Test
     public void whenReplaceItem() {

         Tracker tracker = new Tracker();
         Item item = tracker.add(new Item("Replaced item"));
         String replacedName = "New item name";
         Output out = new StubOutput();
         Input in = new StubInput(
                 new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
         );
         UserAction[] actions = {
                 new ReplaceItem(out),
                 new ExitProgram()
         };
         new StartUI(out).init(in, tracker, actions);
         assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
     }

     @Test
     public void whenDeleteItem() {
         Tracker tracker = new Tracker();
         Item item = tracker.add(new Item("Deleted item"));
         Output out = new StubOutput();
         Input in = new StubInput(
                 new String[] {"0", String.valueOf(item.getId()), "1"}
         );
         UserAction[] actions = {
                 new DeleteItem(out),
                 new ExitProgram()
         };
         new StartUI(out).init(in, tracker, actions);
         assertThat(tracker.findById(item.getId()), is(nullValue()));
     }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Show items"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
             new FindAllItem(out),  new ExitProgram()
        };
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
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdItem(out),  new ExitProgram()
        };
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
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Name"));
        String name = "Name";
        Input in = new StubInput(
                new String[]{"0", name, "1"}
        );
        UserAction[] actions = {
                new FindByNameItem(out),  new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);

        assertThat((out.toString()), is("Menu."
                + System.lineSeparator() + "0. Find items by name"
                + System.lineSeparator() + "1. Exit"
                + System.lineSeparator()
                + "=== Find items by name ===="
                + System.lineSeparator()
                + item.toString()
                + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find items by name"
                + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()));

    }
}