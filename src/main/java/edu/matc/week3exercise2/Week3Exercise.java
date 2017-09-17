package edu.matc.week3exercise2;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDateTime;

public class Week3Exercise extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();

        LocalDateTime localDateTime = LocalDateTime.now();

        String message;
        int second = localDateTime.getSecond();

        if ((second % 2) == 0) {
            message = "The second (" + second + ") is even!";
        } else {
            message = "The second (" + second + ") is ODD!";
        }

        message += " <br> ";

        switch (localDateTime.getDayOfWeek()) {
            case MONDAY:
                message += "Monday :(";
            case TUESDAY:
                message += "Tuesday ... starting to make progress";
            case WEDNESDAY:
                message += "Wedneday ... get ready for class tonight";
            case THURSDAY:
                message += "Majority of the week is over, almost the weekend.";
            case FRIDAY:
                message += "Happy Friday!";
            case SATURDAY:
                message += "Time to get some housework done (and watch UW football)";
            case SUNDAY:
                message += "Weekend is almost over, but the Packers should be on!";
        }

        /*out.println("Month: " + localDateTime.getMonthValue() + " Day: " + localDateTime.getDayOfMonth()
                + " Hour: " + localDateTime.getHour() + " Minute: " + localDateTime.getMinute()
                + " Second: " + localDateTime.getSecond());*/
        out.println(message);
    }
}

