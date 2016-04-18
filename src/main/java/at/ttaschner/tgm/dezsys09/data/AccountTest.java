package at.ttaschner.tgm.dezsys09.data;

import at.ttaschner.tgm.dezsys09.data.Account;

/**
 * Die Klasse dient zur Überprüfung der Benutzerdaten.
 * @author Thomas Taschner
 */
public class AccountTest {

    /**
     * Check, ob alle accountrelevanten Felder ausgefüllt wurden.
     *
     * @param account Der Account des Benutzers
     * @return boolean Indikator, ob die Daten erfolgreich ausgefüllt wurden
     */
    public static boolean hasFilledOut(Account account) {
        // True, wenn alle Felder ausgefuellt wurden
        if (account != null && account.getEmail() != null && account.getUsername() != null && account.getPassword() != null) {
            return true;
        }
        return false;
    }

    /**
     * Check, ob der Account eine gültige E-Mail und ein gültiges Passwort hat.
     *
     * @param account Der Account des Benutzers
     * @return boolean Indikator, ob die Daten erfolgreich ausgefüllt wurden
     */
    public static boolean hasLoginData(Account account) {
        //True, wenn alle Felder vorhanden sind
        if (account != null && account.getEmail() != null && account.getPassword() != null) {
            return true;
        }
        return false;
    }
}
