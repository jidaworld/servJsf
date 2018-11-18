package app.ServiceControllers;


import BusinessLayer.Handlers.MessageHandler;
import BusinessLayer.ViewModels.FeedMessageViewModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@RestController
public class AddFMController {

    private MessageHandler handler = new MessageHandler();

    @RequestMapping(value = "/writefeedmessage", method = RequestMethod.POST)
    public FeedMessageResponse AddFeedMessage(@Valid @RequestBody FeedMessageObj obj){

        return new FeedMessageResponse(handler.AddFeedMessage(obj.email, obj.message));
    }

    private static class FeedMessageObj{
        @JsonProperty
        @NotEmpty
        private String message;
        @JsonProperty
        @NotEmpty
        private String email;
    }

    private static class FeedMessageResponse{
        @JsonProperty
        private String message;
        @JsonProperty
        private Date date;
        @JsonProperty
        private String name;
        @JsonProperty
        private String lastName;

        public FeedMessageResponse(FeedMessageViewModel message) {
            this.message = message.getMessage();
            this.date = message.getDate();
            this.name = message.getName();
            this.lastName = message.getLastName();
        }
    }

}
