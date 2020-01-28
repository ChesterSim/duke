package tasks;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private LocalTime finishByTime;
    private LocalDate finishByDate;

    public Deadline(String description, String finishBy) {
        super(description);
        String[] fields = finishBy.split(" ");
        this.finishByTime = fields[0].equals("-")
                ? null
                : LocalTime.parse(fields[0]);
        this.finishByDate = fields[1].equals("-")
                ? LocalDate.now()
                : LocalDate.parse(fields[1]);
    }

    @Override
    public String toString() {
        String date = this.finishByDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        String dateTime = this.finishByTime != null
                ? this.finishByTime + ", " + date
                : date;

        return "[D]" + super.toString() + " (by: " + dateTime + ")";
    }

    public LocalDate getDate() {
        return this.finishByDate;
    }
}
