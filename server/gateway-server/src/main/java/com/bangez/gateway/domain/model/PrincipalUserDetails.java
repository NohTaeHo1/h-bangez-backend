package com.bangez.gateway.domain.model;

import com.bangez.gateway.domain.vo.Role;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Getter
public class PrincipalUserDetails implements UserDetails, OAuth2User {
    private UserModel user;
    private Map<String, Object> attributes;

    public PrincipalUserDetails(UserModel user) {
        this.user = user;
    }

    public PrincipalUserDetails(UserModel user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    @Override
    public String getName() {
        return attributes.get(user.getRegistration().name()).toString();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = user.getRoles();
        if (roles == null) {
            roles = new ArrayList<>();
        }
        return roles.stream().map(i -> new SimpleGrantedAuthority(i.name())).toList();
    }
    @Override
    public String getPassword() {
        return null;
    }
    @Override
    public String getUsername() {
        return user.getEmail();
    }
}