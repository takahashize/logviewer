package com.example.logviewer.user;

import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class CompanyUserDetails extends User {
    @Getter
    private CompanyUser companyUser;

    public CompanyUserDetails(CompanyUser companyUser) {

        super(companyUser.getUserName(), companyUser.getPassword(), AuthorityUtils
                .createAuthorityList("ROLE_USER"));
        this.companyUser = companyUser;
    }
}
