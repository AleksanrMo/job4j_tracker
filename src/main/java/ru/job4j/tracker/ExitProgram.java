package ru.job4j.tracker;

public class ExitProgram implements UserAction {
    @Override
    public String name() {
        return "Exit of program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
