package be.fooda.security.tokenizer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    private final Logger LOG = LoggerFactory.getLogger(HomePageController.class);

    @GetMapping("/")
    public String index() {
        LOG.info("Request received for index.html");
        return "index";
    }
}