import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

public class ColoredPatternLayout extends Layout {

    @Override
    public String format(LoggingEvent event) {
        String buffer = event.getMessage() + "\n";

        String level = event.getLevel().toString();

        String colorCode;
        switch (level) {
            case "DEBUG":
                colorCode = "\u001B[34m"; // Синий
                break;
            case "INFO":
                colorCode = "\u001B[32m"; // Зеленый
                break;
            case "WARN":
                colorCode = "\u001B[33m"; // Желтый
                break;
            case "ERROR":
                colorCode = "\u001B[31m"; // Красный
                break;
            case "FATAL":
                colorCode = "\u001B[31;1m"; // Жирный красный
                break;
            default:
                colorCode = "";
        }

        String formattedMessage = String.format("%s%s%s%s%s",
                event.getLoggerName(),
                " - ",
                colorCode,
                level,
                "\u001B[0m"
        );

        return String.format("%s : %s - %s\n", event.getThreadName(), formattedMessage, buffer);
    }

    @Override
    public boolean ignoresThrowable() {
        return true;
    }

    @Override
    public void activateOptions() {
        //Nothing to do
    }
}
