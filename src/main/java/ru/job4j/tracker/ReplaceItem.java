package ru.job4j.tracker;

public class ReplaceItem implements UserAction {

    private final Output out;

    public ReplaceItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Edit item ====");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Заявка заменина успешно.");
        } else {
           out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
