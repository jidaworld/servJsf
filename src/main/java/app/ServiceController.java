package app;

import BusinessLayer.Handlers.UserHandler;
import BusinessLayer.ViewModels.UserViewModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ServiceController {
    private UserHandler userHandler;
    private String searchName;
    private List<UserViewModel> list;

    @RequestMapping(value = "/getusers", method = RequestMethod.GET)
    public List<UserViewModel> getUsers(@RequestParam(value="name") String searchName){
        userHandler = new UserHandler();
        return list = userHandler.getUsers(searchName);

    }


}
