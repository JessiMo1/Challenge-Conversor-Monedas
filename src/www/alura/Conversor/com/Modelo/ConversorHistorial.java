package www.alura.Conversor.com.Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversorHistorial {

    private String lugar;
    private String donde;
    private double monto;
    private double rate;
    private double resultado;
    private LocalDateTime timestamp;

    public ConversorHistorial(String lugar, String donde, double monto, double rate, double resultado) {
        this.lugar = lugar;
        this.donde = donde;
        this.monto = monto;
        this.rate = rate;
        this.resultado = resultado;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("[%s] %.2f %s -> %.2f %s (Rate: %.4f)",
                timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                monto, lugar, resultado, donde, rate);
    }
}
