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
import java.util.List;

@RestController
public class GetFeedController {

    private MessageHandler handler = new MessageHandler();

    @RequestMapping(value = "/getfeedmessages", method = RequestMethod.POST)
    public GetMessagesObjResponse getMessages(@Valid @RequestBody GetMessagesObj obj){
        System.out.println("got in post " + obj.email);
        return new GetMessagesObjResponse(handler.GetFeedMessages(obj.email));
    }

    private static class GetMessagesObj{
        @JsonProperty
        @NotEmpty
        private String email;

    }

    private static class GetMessagesObjResponse {
        @JsonProperty
        private List<FeedMessageViewModel> list;

        public GetMessagesObjResponse(List<FeedMessageViewModel> list) {
            this.list = list;
        }
    }
}
