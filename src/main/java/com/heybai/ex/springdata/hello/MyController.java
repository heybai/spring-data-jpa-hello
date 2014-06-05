package com.heybai.ex.springdata.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/my")
public class MyController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody public Map getMovie() {
        return new HashMap<String, Object>(){{
            put("message", "Test");
            put("date", new Date());
        }};
    }

}
