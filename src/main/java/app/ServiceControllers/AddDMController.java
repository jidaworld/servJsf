package app.ServiceControllers;


import BusinessLayer.Handlers.MessageHandler;
import BusinessLayer.ViewModels.DirectMessageViewModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@RestController
public class AddDMController {

    private MessageHandler handler = new MessageHandler();

    @RequestMapping(value = "/writedirectmessage", method = RequestMethod.POST)
    public DirectMessageResponse addDirectMessage(@Valid @RequestBody DirectMessageObject obj){
        return new DirectMessageResponse(handler.AddDirectMessage(obj.senderEmail, obj.receiverEmail, obj.message));
    }

    private static class DirectMessageObject {
        @JsonProperty
        @NotEmpty
        private String senderEmail;
        @JsonProperty
        @NotEmpty
        private String receiverEmail;
        @JsonProperty
        @NotEmpty
        private String message;
    }

    private static class DirectMessageResponse {
        @JsonProperty
        private String message;
        @JsonProperty
        private Date date;
        @JsonProperty
        private String senderEmail;
        @JsonProperty
        private String receiverEmail;

        public DirectMessageResponse(DirectMessageViewModel model) {
            this.message = model.getMessage();
            this.date = model.getDate();
            this.senderEmail = model.getSender();
            this.receiverEmail = model.getReceiver();
        }
    }

}
