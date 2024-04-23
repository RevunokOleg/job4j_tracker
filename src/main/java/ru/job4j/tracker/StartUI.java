package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import java.util.ArrayList;
import java.util.List;

public class StartUI {

    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выбрать: ");
            if (select < 0 || select >= actions.size()) {
                output.println("Неверный ввод, вы можете выбрать: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        output.println("Меню:");
        for (UserAction action : actions) {
            output.println(actions.indexOf(action) + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction(output));
                actions.add(new FindAllAction(output));
                actions.add(new ReplaceAction(output));
                actions.add(new DeleteAction(output));
                actions.add(new FindByIdAction(output));
                actions.add(new FindByNameAction(output));
                actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
    }
}