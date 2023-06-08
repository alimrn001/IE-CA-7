package com.baloot.baloot.controllers.authentication;

import com.baloot.baloot.services.BalootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private BalootService balootService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Map<String, Object> payLoad) {
        try {
            balootService.login(payLoad.get("username").toString(), payLoad.get("password").toString());
            return ResponseEntity.ok("ok");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

}
