package app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String test() {
        return "It workssssss";
    }

    @GetMapping("/{id}")
    public String test(@PathVariable("id") Integer id) {
        return "Works with id " + id;
    }


}
