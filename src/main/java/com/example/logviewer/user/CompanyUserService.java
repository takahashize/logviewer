package com.example.logviewer.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyUserService implements UserDetailsService {

    private final CompanyUserRepository companyUserRepository;

    @Autowired
    public CompanyUserService(CompanyUserRepository companyUserRepository) {
        this.companyUserRepository = companyUserRepository;
    }

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        CompanyUser found = companyUserRepository.findOne(username);
        if (found != null) {
            return new CompanyUserDetails(found);
        }
        throw new UsernameNotFoundException("user not found" + username);
    }

    public void updateUser(CompanyUserDetails userDetails, String password) {
        CompanyUser user = userDetails.getCompanyUser();
        user.setPassword(password);
        user.setPasswordExpired(false);
        companyUserRepository.save(user);
    }
}
