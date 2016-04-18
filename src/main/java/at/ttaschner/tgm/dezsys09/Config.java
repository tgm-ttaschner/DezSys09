package at.ttaschner.tgm.dezsys09;

import at.ttaschner.tgm.dezsys09.data.AccountEndpoint;
import at.ttaschner.tgm.dezsys09.data.Login;
import at.ttaschner.tgm.dezsys09.data.Registrieren;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Named;

/**
 * Hier werden die Endpunkte definiert
 * Diese Klasse ist für die Definition der Endpunkte zuständig.
 *
 * @author Thomas Taschner
 */
@Named
public class Config extends ResourceConfig {

    public Config() {
        this.register(AccountEndpoint.class);
        this.register(Registrieren.class);
        this.register(Login.class);
        this.register(JacksonFeature.class);
    }
}