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
import java.util.List;

@RestController
public class GetDMController {

    private MessageHandler handler = new MessageHandler();

    @RequestMapping(value = "/getdirectmessages", method = RequestMethod.POST)
    public GetMessageObjResponse getMessages(@Valid @RequestBody GetMessageObj obj){

        return new GetMessageObjResponse(handler.GetDirectMessage(obj.senderEmail, obj.receiverEmail));
    }

    private static class GetMessageObj{
        @JsonProperty
        @NotEmpty
        private String senderEmail;
        @JsonProperty
        @NotEmpty
        private String receiverEmail;
    }

    private static class GetMessageObjResponse{
        @JsonProperty
        private List<DirectMessageViewModel> list;

        public GetMessageObjResponse(List<DirectMessageViewModel> list) {
            this.list = list;
        }
    }
}
