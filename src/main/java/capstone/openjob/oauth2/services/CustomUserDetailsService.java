/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.openjob.oauth2.services;

import capstone.openjob.dao.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author developer
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IAccountRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo
                .findAccountEntitiesByEmailEquals(username)
                .map(u -> new org.springframework.security.core.userdetails.User(
                u.getEmail(),
                u.getPassword(),
                true,
                true,
                true,
                true,
                AuthorityUtils.createAuthorityList(new String[]{})))
                .orElseThrow(() -> new UsernameNotFoundException("No user with "
                        + "the name " + username + "was found in the database"));
    }

    public Date convertLocalDateTimeToDate(LocalDate localDate) {
        return  Date.valueOf(localDate);
    }
}
