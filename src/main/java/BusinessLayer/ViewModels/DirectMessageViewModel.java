package BusinessLayer.ViewModels;

import java.sql.Timestamp;
import java.util.Date;

public class DirectMessageViewModel {

    private String sender;
    private String receiver;
    private String message;
    private Date date;

    public DirectMessageViewModel(String sender, String receiver, String message, Date date) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
}
