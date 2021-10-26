import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;
import java.util.Scanner;


public class Application {



    public static void main(String[] args) {
        final Injector injector = Guice.createInjector(new ApplicationModule(args));
        injector.getInstance(Application.class).waitForInput();

    }

    public void waitForInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            final Injector injector = Guice.createInjector(new LoggerModule(ApplicationModule.applicationConfig));

            LoggerInterface logger = injector.getInstance(AllLogger.class).getLogger(ApplicationModule.applicationConfig[0]);
                while (scanner.hasNextLine()) {
                    String info = scanner.nextLine();
                    logger.write(info);
//                }
            }
        } catch (IOException e) {
            System.out.println("smt wrong");
        }
    }


}
