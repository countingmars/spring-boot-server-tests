package countingmars.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ApiResponse get(@PathVariable String name) {
        return ApiResponse.ok("greeting, " + name);
    }
}
