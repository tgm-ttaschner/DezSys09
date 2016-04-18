package at.ttaschner.tgm.dezsys09.data;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Die Klasse ist für die Registrierung der Benutzer zuständig.
 *
 * @author Thomas Taschner
 */
@Named
// URL PATH
@Path("/register")
@Produces({MediaType.APPLICATION_JSON})
public class Registrieren {

    @Inject
    private AccountRepository repository;

    /**
     * Erstellt einen Benutzeraccount, sofern dieser noch nicht im System vorhanden ist.
     *
     * @param account Account, der angelegt werden soll
     * @return Antwort, ob der Benutzer bereits im System vorhanden ist oder nicht
     */
    @POST
    public Response register(Account account) {
        // Ueberprueft ob die angegeben Daten fuer eine Anmeldung passen.
        if (AccountTest.hasFilledOut(account)) {
            // Ueberprueft ob der Benutzer schon existiert anhand der bereits gespeicherten Email Daten
            if (this.repository.findByEmail(account.getEmail()) == null) {
                Account newAccount = new Account(account.getEmail(), account.getUsername(), account.getPassword());
                this.repository.save(newAccount);
                int status = Response.Status.CREATED.getStatusCode();
                return Response.status(status).entity(new Message(status,
                        "Der Account wurde erfolgreich erstellt. " +
                                "Benutzername: " + newAccount.getUsername() + " Email: " + newAccount.getEmail())).build();
            } else {
                int status = Response.Status.FORBIDDEN.getStatusCode();
                return Response.status(status).entity(new Message(status, "Benutzer bereits im System vorhanden!")).build();
            }
        } else {
            int status = Response.Status.BAD_REQUEST.getStatusCode();
            return Response.status(status).entity(new Message(status, "Unzureichende Logindaten! Bitte vergewissern Sie sich, dass alle benötigten Felder ausgefüllt wurden.")).build();
        }
    }
}