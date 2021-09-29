package com.qrebl.users;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public class KeycloakConfig {

    static Keycloak keycloak = null;
    final static String serverUrl = "YOUR_SERVER_URL";
    public final static String realm = "YOUR_REALM_NAME";
    final static String clientId = "YOUR_CLIENT_ID";
    final static String clientSecret = "YOUR_CLIENT_SECRET_KEY";
    final static String userName = "YOUR_REALM_ADMIN_USERNAME";
    final static String password = "Your_REALM_ADMIN_PASSWORD";


    public KeycloakConfig() {
    }

    public static Keycloak getInstance(){
        if(keycloak == null){

            keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverUrl)
                    .realm(realm)
                    .grantType(OAuth2Constants.PASSWORD)
                    .username(userName)
                    .password(password)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .resteasyClient(new ResteasyClientBuilder()
                            .connectionPoolSize(10)
                            .build()
                                   )
                    .build();
        }
        return keycloak;
    }
}
