package com.heybai.ex.springdata.hello;

import com.heybai.ex.springdata.hello.domain.UserRepository;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/my")
public class MyController {

    @Autowired private UserRepository userRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody public List getMovie() {
        return userRepository.findAll();
    }

}
