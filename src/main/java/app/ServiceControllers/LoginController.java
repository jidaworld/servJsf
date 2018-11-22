package app.ServiceControllers;


import BusinessLayer.Handlers.UserHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
public class LoginController {

    private UserHandler handler = new UserHandler();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginObjResponse LoginUser(@Valid @RequestBody LoginObj obj) {

        return new LoginObjResponse(handler.Login(obj.email, obj.password));
    }

    private static class LoginObj{
        @JsonProperty
        @NotEmpty
        private String email;
        @JsonProperty
        @NotEmpty
        private String password;
    }

    private static class LoginObjResponse {
        @JsonProperty
        private boolean successful;

        public LoginObjResponse(boolean successful) {
            this.successful = successful;
        }
    }

}
