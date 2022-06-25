package command;

import command.commands.CityCommand;
import command.commands.JsonCommand;
import command.commands.SexCommand;
import command.commands.VoteCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("json", new JsonCommand());
        commands.put("city", new CityCommand());
        commands.put("sex", new SexCommand());
        commands.put("vote", new VoteCommand());
    }

    public static Command getByName(String command) {
        return commands.get(command);
    }
}
