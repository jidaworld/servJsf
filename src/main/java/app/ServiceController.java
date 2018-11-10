package app;

import BusinessLayer.Handlers.UserHandler;
import BusinessLayer.ViewModels.UserViewModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
public class ServiceController {
    private UserHandler userHandler;

    @RequestMapping(value = "/getusers", method = RequestMethod.POST)
    public GetUserObjResponse getUsers(@Valid @RequestBody GetUsersObj obj){
        userHandler = new UserHandler();
        System.out.println("rest worked");
        return new GetUserObjResponse(userHandler.getUsers(obj.name));

    }

    private static class GetUsersObj{
        @JsonProperty
        @NotEmpty
        private String name;
    }

    private static class GetUserObjResponse{
        @JsonProperty
        private List<UserViewModel> list;

        public GetUserObjResponse(List<UserViewModel> list) {
            this.list = list;
        }
    }
}
