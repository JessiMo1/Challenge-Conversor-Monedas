import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import www.alura.Conversor.com.Modelo.ConversorHistorial;
import www.alura.Conversor.com.Servicio.ConversorMoneda;
import www.alura.Conversor.com.Usuario.Archivo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoneda convertir = new ConversorMoneda();
        List<ConversorHistorial> historial = new ArrayList<>();

        System.out.println("=== Conversor de Monedas ===");

        while (true) {
            System.out.println("\n1. Convertir moneda");
            System.out.println("2. Ver historial");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Moneda de origen (ej: USD): ");
                    String from = scanner.nextLine().toUpperCase();

                    System.out.print("Moneda de destino (ej: EUR): ");
                    String to = scanner.nextLine().toUpperCase();

                    System.out.print("Cantidad a convertir: ");
                    double amount;
                    try {
                        amount = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Cantidad inválida.");
                        continue;
                    }

                    Optional<ConversorHistorial> resultado = convertir.convertCurrency(from, to, amount);
                    if (resultado.isPresent()) {
                        ConversorHistorial registro = resultado.get();
                        historial.add(registro);
                        Archivo.guardarHistorial(historial);
                        System.out.println(registro);
                    } else {
                        System.out.println("Error en la conversión.");
                    }
                    break;

                case "2":
                    System.out.println("=== Historial de conversiones ===");
                    if (historial.isEmpty()) {
                        System.out.println("No hay conversiones registradas.");
                    } else {
                        historial.forEach(System.out::println);
                    }
                    break;

                case "3":
                    System.out.println("¡Hasta luego!");
                    return;

                default:
                    System.out.println("Opción no válida.");
                }
            }  // Cerrar el scanner al final
        }
    }

