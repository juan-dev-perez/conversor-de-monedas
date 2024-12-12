import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

    public Conversion buscarCambioDeMoneda(String codigoMonedaOrigen, String codigoMonedaFinal, String montoParaConvertir ){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/859c55ee05125b8d40e328b3/pair/" + codigoMonedaOrigen + "/" + codigoMonedaFinal + "/" + montoParaConvertir + "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversion.class);
        } catch (Exception e) {
            throw new RuntimeException("Código de moneda o monto no valido.");
        }
    }

}
