package app.ServiceControllers;

import BusinessLayer.Handlers.UserHandler;
import BusinessLayer.ViewModels.UserViewModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
public class GetUsersController {
    private UserHandler userHandler = new UserHandler();

    @RequestMapping(value = "/getusers", method = RequestMethod.POST)
    public GetUserObjResponse getUsers(@Valid @RequestBody GetUsersObj obj){

        return new GetUserObjResponse(userHandler.getUsers(obj.name));
    }

    private static class GetUsersObj{
        @JsonProperty
        private String name;
    }

    private static class GetUserObjResponse{
        @JsonProperty
        private List<UserViewModel> list;

        GetUserObjResponse(List<UserViewModel> list) {
            this.list = list;
        }
    }
}
