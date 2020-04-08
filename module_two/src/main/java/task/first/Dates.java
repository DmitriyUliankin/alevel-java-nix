package task.first;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class Dates {

    private static final List<String> TIME_FORMATTERS = Arrays.asList("yyyy/MM/dd", "dd/MM/yyyy", "MM-dd-yyyy");

    private static final DateTimeFormatter FINAL_PATTERN = DateTimeFormatter.ofPattern("yyyyMMdd");

    public Collection<String> getDate(List<String> dates) {
        List<String> parsedDates = new ArrayList<>();
        for (String date : dates) {
            parsedDates.add(parse(date));
        }
        return parsedDates;
    }

    private static String parse(String date) {
        for (String pattern : TIME_FORMATTERS) {
            try {
                var toPattern = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
                return toPattern.format(FINAL_PATTERN);
            } catch (DateTimeParseException e) {
                e.getParsedString();
            }
        }
        throw new IllegalArgumentException("couldn't parse the date for all patterns given");
    }

}
