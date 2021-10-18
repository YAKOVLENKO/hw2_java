import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ConsoleLogger extends LoggerInterface {

    public void write(@NotNull String info) throws IOException {
        info = changeInputString(info);
        System.out.println(info);
    }

    private String changeInputString(@NotNull String string) {
        return String.format("%d %s", super.getLineNumber(), string);
    }

}
