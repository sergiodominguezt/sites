package com.wom.sites.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));

    };

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> athenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));

    };

    @GetMapping("/protected-data")
    public ResponseEntity<String> protectedData(@AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        String role = userDetails.getAuthorities().stream().findFirst().get().getAuthority();
        return ResponseEntity.ok("Welcome " + username + " This is protected data " + role);
    }
}
