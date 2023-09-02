package ept.git.dic2.systeme_vente_velo;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
@OpenAPIDefinition(
        info = @Info(
                title="API POUR VENTE VELO",
                description = "Ce service est destiné à tout le monde",
                contact = @Contact(
                        name = "Momo Wade",
                        email = "wadem@ept.sn",
                        url ="https://mail.google.com"
                ),
                version = "1.0",
                license = @License(name = "Opensource")

        ),
        servers = {@Server(
                url ="{urlDeploiement}",
                variables = {@ServerVariable(
                        name = "urlDeploiement",
                        defaultValue = "http://localhost:8080/Systeme_vente_velo-1.0-SNAPSHOT" )}
        )
        }
)
public class APIApplication extends Application {
//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> resources = new HashSet<>();
//        resources.add(EleveRessource.class);
//        return resources;
//    }
}