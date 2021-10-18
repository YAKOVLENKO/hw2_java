import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;


public class LoggerModule extends AbstractModule {

    private String[] applicationConfig = new String[]{};

    public LoggerModule(@NotNull String[] configParams) {
        this.applicationConfig = configParams;
    }

    @Override
    protected void configure() {
        bind(LoggerInterface.class).to(ConsoleLogger.class);
        bind(Path.class).toInstance(Path.of("data.txt"));
        if (applicationConfig.length == 2) {
            bind(LoggerInterface.class).annotatedWith(Names.named("file_logger")).toInstance(new FileLogger(applicationConfig[1]));
        } else
        {
            bind(LoggerInterface.class).annotatedWith(Names.named("file_logger")).toInstance(new FileLogger(""));
        }
    }
}