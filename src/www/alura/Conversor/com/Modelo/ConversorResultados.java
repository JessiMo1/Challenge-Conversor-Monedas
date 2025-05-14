package www.alura.Conversor.com.Modelo;

public class ConversorResultados {
    private String lugar;
    private String donde;
    private double monto;
    private double resultado;

    public ConversorResultados(String lugar, String donde, double monto, double resultado) {
        this.lugar = lugar;
        this.donde= donde;
        this.monto = monto;
        this.resultado = resultado;
    }

    public String getFrom() { return lugar; }
    public String getTo() { return donde; }
    public double getAmount() { return monto; }
    public double getResult() { return resultado; }

    @Override
    public String toString() {
        return String.format("%.2f %s = %.2f %s", monto, lugar, resultado, donde);
    }
}
