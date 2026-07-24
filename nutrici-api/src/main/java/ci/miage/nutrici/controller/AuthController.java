package ci.miage.nutrici.controller;


import ci.miage.nutrici.auth.AuthRequest;
import ci.miage.nutrici.auth.AuthResponse;
import ci.miage.nutrici.auth.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {



    private final AuthService service;



    public AuthController(AuthService service){

        this.service = service;

    }




    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody AuthRequest request){



        AuthResponse response =
                service.connexion(request);



        if(response.getToken()==null){

            return ResponseEntity
                    .status(401)
                    .body(response);

        }



        return ResponseEntity.ok(response);

    }


}