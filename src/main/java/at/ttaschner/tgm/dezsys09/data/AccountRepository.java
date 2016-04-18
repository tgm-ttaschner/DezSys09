package at.ttaschner.tgm.dezsys09.data;

import at.ttaschner.tgm.dezsys09.data.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Interface, welches zur Persistierung und Verwaltung der Accounts dient.
 *
 * @author Thomas Taschner
 */
public interface AccountRepository extends CrudRepository<Account, String> {

    /**
     * Liefert, sofern vorhanden, den zugehörigen Account zur gegebenen E-Mailadresse.
     *
     * @param email Die E-Mailadresse, die an einen Account gebunden ist
     * @return Der gesuchte Benutzeraccount
     */
    Account findByEmail(String email);

    /**
     * Gibt eine Liste sämtlicher Accounts, die in der Datenbank abgespeichert wurden, zurück.
     *
     * @return Eine Liste mit allen Benutzeraccounts
     */
    List<Account> findAll();
}
