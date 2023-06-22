package api;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.HttpDelete;

public class APIClient {
    private static CloseableHttpClient httpClient;

    public static CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            // Création d'un client HttpClient
            httpClient = HttpClients.createDefault();
        }
        return httpClient;
    }

    public static String get(String url) throws Exception {
        // Création de la requête GET
        HttpGet httpGet = new HttpGet(url);

        // Exécution de la requête et récupération de la réponse
        HttpResponse response = getHttpClient().execute(httpGet);

        // Traitement de la réponse
        HttpEntity entity = response.getEntity();
        String responseBody = EntityUtils.toString(entity);
        EntityUtils.consume(entity);

        return responseBody;
    }

    public static String post(String url, String requestBody) throws Exception {
        // Création de la requête POST
        HttpPost httpPost = new HttpPost(url);

        // Configuration du corps de la requête
        httpPost.setEntity(new StringEntity(requestBody, ContentType.APPLICATION_JSON));
        System.out.println(EntityUtils.toString(httpPost.getEntity()));

        // Exécution de la requête et récupération de la réponse
        HttpResponse response = getHttpClient().execute(httpPost);

        // Traitement de la réponse
        HttpEntity entity = response.getEntity();
        String responseBody = EntityUtils.toString(entity);
        EntityUtils.consume(entity);

        return responseBody;
    }
    
    
    public static void update(String url, String requestBody) throws Exception {
        // Création de la requête PUT
        HttpPut httpPut = new HttpPut(url);

        // Configuration du corps de la requête
        StringEntity requestEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
        httpPut.setEntity(requestEntity);

        // Exécution de la requête
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(httpPut);

        // Vérification de la réponse (statut HTTP)
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            System.out.println("Mise à jour réussie");
        } else {
            System.out.println("Échec de la mise à jour. Statut HTTP : " + statusCode);
        }

        // Fermeture du client HTTP
        httpClient.close();
    }
    
    
    public static void delete(String url) throws Exception {
        // Create the DELETE request
        HttpDelete httpDelete = new HttpDelete(url);

        // Execute the request
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(httpDelete);

        // Check the response (HTTP status)
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 204) {
            System.out.println("Suppression réussie");
        } else {
            System.out.println("Échec de la suppression. Statut HTTP : " + statusCode);
        }

        // Close the HTTP client
        httpClient.close();
    }

}