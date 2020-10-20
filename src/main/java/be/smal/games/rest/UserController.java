package be.smal.games.rest;

import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;


@RestController
public class UserController {

    @CrossOrigin
    @GetMapping("/users")
    public PrincipalDto user(Authentication authentication) {

        if (authentication != null) {
            return new PrincipalDto(authentication.getName(), authentication.getAuthorities());
        } else {
            return null;
        }
    }
}

    @Getter
    class PrincipalDto {
    private final String name;
    private final List<GrantedAuthority> authorities;

    public PrincipalDto(String name, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.authorities = (List<GrantedAuthority>) authorities;
    }
}
