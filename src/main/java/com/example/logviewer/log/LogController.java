package com.example.logviewer.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;

@Controller
@Slf4j
@RequestMapping("/log")
public class LogController {

    private final LogRepository logRepository;

    @Autowired
    public LogController(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @ModelAttribute(value = "form")
    public LogForm setUpForm() {
        return new LogForm();
    }

    @GetMapping
    public String index() {
        return "log/index";
    }

    @PostMapping("/search")
    public String search(@Validated LogForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            log.warn("error {}", result.getAllErrors());
            return "log/index :: table";
        }
        try {
            // ３秒待つ
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        model.addAttribute("logs", this.logRepository.findByEntryStartsWith(form.getSearchText()));
        return "log/index :: table";
    }
}
