import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Scanner;

public abstract class LoggerInterface {
    private static int lineNumber = 0;

    public String read(@NotNull Scanner scanner){
        String info = scanner.nextLine();
        return info;
    }

    public abstract void write(@NotNull String info) throws IOException;

    public int getLineNumber() {
        return ++lineNumber;
    }
}

