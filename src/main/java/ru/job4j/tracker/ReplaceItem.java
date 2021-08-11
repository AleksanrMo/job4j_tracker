package ru.job4j.tracker;

public class ReplaceItem implements UserAction {

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        int id = input.askInt("Enter id: ");
        System.out.print("Enter name: ");
        String name = input.askStr("Select: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка заменина успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
