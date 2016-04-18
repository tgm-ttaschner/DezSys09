package at.ttaschner.tgm.dezsys09.data;

import at.ttaschner.tgm.dezsys09.data.Account;
import at.ttaschner.tgm.dezsys09.data.AccountRepository;
import at.ttaschner.tgm.dezsys09.data.Message;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Die Klasse ist für das Lesen der Accountdaten aus der Datenbank zuständig.
 *
 * @author Thomas Taschner
 */
@Named
// URL PATH
@Path("/account")
@Produces({MediaType.APPLICATION_JSON})
public class AccountEndpoint {

    @Inject
    private AccountRepository repository;

    /**
     * Gibt den Account, der einer bestimmten E-Mailadresse zugeordnert ist, zurück.
     * Sollte keine E-Mailadresse angegeben werden, so werden alle Accounts zurückgegeben.
     *
     * @param email Die E-Mailadresse, die einem Account zugeordnet ist
     * @return Einer oder mehrere Benutzeraccounts
     */
    @GET
    public Response getAccount(@QueryParam("email") String email) {
        // Wenn die E-Mail nicht NULL ist, dann wird nach der E-Mail gesucht.
        if (email != null) {
            Account account = this.repository.findByEmail(email);

            if (account != null) {
                return Response.status(Status.OK).entity(account).build();
            } else {
                int status = Status.NOT_FOUND.getStatusCode();
                return Response.status(status).entity(new Message(status, "Es konnte kein Benutzer zu dieser E-Mailadresse gefunden werden.")).build();
            }
        }
        return Response.status(Status.OK).entity(this.repository.findAll()).build();
    }
}
