package www.alura.Conversor.com.Servicio;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import www.alura.Conversor.com.Modelo.ConversorHistorial;
import www.alura.Conversor.com.Usuario.Usuarios;

import java.util.Optional;

public class ConversorMoneda  {
    private static final String API_KEY = "4c364cac583fb95b7cfc429e";  // tu clave
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public Optional<ConversorHistorial> convertCurrency(String lugar, String donde, double monto) {
        String url = BASE_URL + API_KEY + "/latest/" + lugar;
        String response = Usuarios.get(url);

        if (response == null) {
            return Optional.empty();
        }

        JsonObject json = JsonParser.parseString(response).getAsJsonObject();
        if (!json.has("conversion_rates")) {
            return Optional.empty();
        }

        JsonObject rates = json.getAsJsonObject("conversion_rates");

        if (!rates.has(donde)) {
            return Optional.empty();
        }

        double rate = rates.get(donde).getAsDouble();
        double resultado = rate * monto;

        return Optional.of(new ConversorHistorial(lugar, donde, monto, rate, resultado));
    }

}
