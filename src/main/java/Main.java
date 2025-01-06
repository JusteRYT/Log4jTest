import org.apache.log4j.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());
    private static final Logger licenseLog = Logger.getLogger("flashphoner_license");

    public static void main(String[] args) {
        log.debug("This is a debug message.");
        log.info("This is an info message.");
        log.warn("This is a warning message.");
        log.error("This is an error message.");
        log.fatal("This is a fatal message.");

        licenseLog.info("License log info message");
    }
}
