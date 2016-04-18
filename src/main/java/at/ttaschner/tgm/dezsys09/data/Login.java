package at.ttaschner.tgm.dezsys09.data;

import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Klasse, welche für das Einloggen der Benutzer verantwortlich ist.
 *
 * @author Thomas Taschner
 */
@Named
// URL PATH
@Path("/login")
@Produces({MediaType.APPLICATION_JSON})
public class Login {

    @Autowired
    private AccountRepository repository;

    /**
     * Login des Benutzer, sofern er im System vorhanden ist und eine korrekte Eingabe erfolgt ist.
     *
     * @param loginAccount Beutzeraccount, der beim Login verwendet werden soll
     * @return Antwort an den Benutzer, ob der Login geglückt ist und was im Fehlerfall falsch gelaufen sein könnte.
     */
    @POST
    public Response login(Account loginAccount) {
        // Required infos given?
        if (AccountTest.hasLoginData(loginAccount)) {
            Account account = this.repository.findByEmail(loginAccount.getEmail());

            // Does the account exist?
            if (account != null) {
                int status = Status.OK.getStatusCode();
                return Response.status(status).entity(new Message(status, "Der Benutzer '" + account.getUsername() + "' wurde erfolgreich angemeldet.")).build();
            } else {
                int status = Status.FORBIDDEN.getStatusCode();
                return Response.status(status).entity(new Message(status, "Die Anmeldedaten stimmen leider nicht mit den Daten aus der Datenbank überein. " +
                        "Bitte vergewissern Sie sich, dass die korrekte E-Mailadresse und das korrekte Passwort eingegeben wurden.")).build();
            }
        } else {
            int status = Status.BAD_REQUEST.getStatusCode();
            return Response.status(status).entity(new Message(status, "Es wurden nicht alle zur Anmeldung benötigten Daten angegeben. " +
                    "Bitte vergewissern Sie sich, dass E-Mailadresse und Passwort angegeben wurden.")).build();
        }
    }
}