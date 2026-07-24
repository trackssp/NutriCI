package ci.miage.nutrici.auth;


import org.springframework.stereotype.Service;


@Service
public class AuthService {



    public AuthResponse connexion(AuthRequest request) {



        if(request.getEmail().equals("admin@nutrici.com")
                &&
                request.getMotDePasse().equals("123456")) {



            return new AuthResponse(
                    "Connexion réussie",
                    "TOKEN-NUTRICI-ADMIN",
                    "ADMIN"
            );

        }



        return new AuthResponse(
                "Identifiants incorrects",
                null,
                null
        );

    }

}