package ci.miage.nutrici.auth;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public AuthResponse connexion(AuthRequest request) {
        if (request == null
                || request.getEmail() == null
                || request.getMotDePasse() == null) {
            return erreur();
        }

        if (request.getEmail().equalsIgnoreCase("admin@nutrici.com")
                && request.getMotDePasse().equals("123456")) {
            return new AuthResponse(
                    "Connexion administrateur réussie",
                    "TOKEN-NUTRICI-ADMIN",
                    "ADMIN"
            );
        }

        if (request.getEmail().equalsIgnoreCase("client@nutrici.com")
                && request.getMotDePasse().equals("client123")) {
            return new AuthResponse(
                    "Connexion client réussie",
                    "TOKEN-NUTRICI-CLIENT",
                    "CLIENT"
            );
        }

        return erreur();
    }

    private AuthResponse erreur() {
        return new AuthResponse(
                "Identifiants incorrects",
                null,
                null
        );
    }
}
