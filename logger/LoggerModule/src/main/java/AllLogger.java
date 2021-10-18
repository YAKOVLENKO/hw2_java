import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

import javax.inject.Named;
import java.io.IOException;

public class AllLogger extends LoggerInterface {

    @NotNull
    private final LoggerInterface fileLogger;

    @NotNull
    private final LoggerInterface consoleLogger;

    @Inject
    public AllLogger(@Named("file_logger") @NotNull LoggerInterface fileLogger,
                              @NotNull LoggerInterface consoleLogger) {
        this.fileLogger = fileLogger;
        this.consoleLogger = consoleLogger;
    }

    public void write(@NotNull String info) throws IOException {
        consoleLogger.write(info);
        fileLogger.write(info);
    }

    public LoggerInterface getLogger(String loggerConfig) {
        if (loggerConfig.equals("file_logger")) {
            return this.fileLogger;
        }
        else if (loggerConfig.equals("all_logger")) {
            return this;
        }
        return this.consoleLogger;
    }


}
