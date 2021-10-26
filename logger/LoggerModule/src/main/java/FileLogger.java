import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;



public class FileLogger extends LoggerInterface {
    @NotNull
    @Inject
    private Path path; /*= Path.of("data.txt");*/

    @NotNull
    private final String tag;

    @Inject
    public FileLogger(@NotNull String tag) {
        this.tag = tag;
    }

    public void write(@NotNull String info) throws IOException {
        if (!Files.exists(this.path)) {
            Files.createFile(this.path);
        }
        writeLine(info);

    }

    private void writeLine(@NotNull String info) throws IOException {
        info = changeInputString(info);
        Files.write(path, info.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    }

    private String changeInputString(@NotNull String string) {
        return String.format("%d <%s>%s</%s>\n", this.getLineNumber(), this.tag, string, this.tag);
    }



}
