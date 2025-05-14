package www.alura.Conversor.com.Usuario;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import www.alura.Conversor.com.Modelo.ConversorHistorial;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Archivo {
    private static final String FILE_NAME = "historial.json";

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new AdaptadorTime()) // AQUI
            .setPrettyPrinting()
            .create();

    public static void guardarHistorial(List<ConversorHistorial> historial) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(historial, writer);
        } catch (IOException e) {
            System.out.println("Error guardando historial: " + e.getMessage());
        }
    }

    public static List<ConversorHistorial> cargarHistorial() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<List<ConversorHistorial>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
