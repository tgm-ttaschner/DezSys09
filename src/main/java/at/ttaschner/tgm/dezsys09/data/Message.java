package at.ttaschner.tgm.dezsys09.data;

/**
 * Die Klasse ist für die Bearbeitung von REST-Anfragen zuständig.
 *
 * @author Thomas Taschner
 */
public class Message {

    private int status;
    private String message;

    /**
     * Konstruktor
     * @param status Der Status der Nachricht
     * @param message Der Inhalt der Nachricht
     */
    public Message(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
