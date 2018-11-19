package BusinessLayer.ViewModels;

import java.util.Date;

public class FeedMessageViewModel {

    private String message;
    private Date date;
    private String name;
    private String lastName;

    public FeedMessageViewModel(String message, Date date, String name, String lastName) {
        this.message = message;
        this.date = date;
        this.name = name;
        this.lastName = lastName;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() { return date; }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
