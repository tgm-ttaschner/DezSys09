package at.ttaschner.tgm.dezsys09.data;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Klasse, die für die Accountobjekte zuständig ist.
 *
 * @author Thomas Taschner
 */
@Entity
public class Account implements Serializable {

    @Id
    @Size(max = 20)
    @NotEmpty
    private String email;

    @Size(max = 20)
    private String username;

    private String password;

    public Account() {

    }

    /**
     * Konstruktor
     *
     * @param email    Die E-Mailadresse, mit der sich der Benutzer anmelden soll
     * @param username Der Benutzername des Benutzers
     * @param password Das Passwort des Benutzers
     */
    public Account(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
