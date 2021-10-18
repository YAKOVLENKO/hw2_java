import com.google.inject.AbstractModule;
import org.jetbrains.annotations.NotNull;


public class ApplicationModule extends AbstractModule {

    public static String[] applicationConfig;

    public ApplicationModule(@NotNull String[] configParams) {
        if (configParams.length == 0) {
            applicationConfig = new String[]{""};
        }
        else {
            applicationConfig = configParams;
        }
    }

    @Override
    protected void configure() {

    }
}