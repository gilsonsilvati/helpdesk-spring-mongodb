package br.com.helpdesk.api.resource;

import br.com.helpdesk.api.entity.User;
import br.com.helpdesk.api.security.jwt.JwtAuthenticationRequest;
import br.com.helpdesk.api.security.jwt.JwtToken;
import br.com.helpdesk.api.security.model.CurrentUser;
import br.com.helpdesk.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthenticationResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private UserService userService;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String token = jwtToken.generateToken(userDetails);
        final User user = userService.findByEmail(authenticationRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Not found"));
        user.setPassword(null);

        return ResponseEntity.ok(new CurrentUser(token, user));
    }

//    @PostMapping("/refresh")
//    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
//        String token = request.getHeader("Authorization");
//        String username = jwtToken.getUsernameFromToken(token);
//        final User user = userService.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Not found"));
//
//        if (jwtToken.canTokenBeRefreshed(token)) {
//            String refreshedToken = jwtToken.refreshToken(token);
//            return ResponseEntity.status(HttpStatus.CREATED).body(new CurrentUser(refreshedToken, user));
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//    }

}
