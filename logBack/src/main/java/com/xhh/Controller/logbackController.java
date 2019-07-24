package com.xhh.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author： sunfy
 * @Date: Created in 22:21 2019-7-11
 */
@Controller
@RequestMapping("/logback")
public class logbackController {

    private static final Logger logger = LoggerFactory.getLogger(logbackController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testLogback(){

        return null;
    }
}
