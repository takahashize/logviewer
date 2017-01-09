package com.example.logviewer.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RequestMapping("reset")
@Controller
public class ResetController {

    private final CompanyUserService companyUserService;

    @Autowired
    public ResetController(CompanyUserService companyUserService) {
        this.companyUserService = companyUserService;
    }

    @ModelAttribute(value = "resetForm")
    public ResetForm setUpForm() {
        return new ResetForm();
    }

    @GetMapping
    public String showForm() {
        return "reset/index";
    }

    @PostMapping
    public String saveAndRedirect(@Validated ResetForm resetForm, BindingResult result,
                                  RedirectAttributes attributes,
                                  @AuthenticationPrincipal CompanyUserDetails user) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("errors", result.getAllErrors());
            return "redirect:reset";
        }
        companyUserService.updateUser(user, resetForm.getPassword1());
        return "redirect:/log";
    }
}
