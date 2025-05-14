#  Conversor de Monedas en Java

Este es un proyecto simple en Java que permite convertir entre diferentes tipos de monedas utilizando una API externa. Además, guarda un historial de conversiones con marca de tiempo en formato JSON.

---

##  Características

- Entrada por consola para el usuario
- Conversión de monedas usando la API pública [ExchangeRate-API](https://www.exchangerate-api.com/)
- Historial de conversiones guardado en memoria y en archivo JSON
- Marca de tiempo de cada conversión usando `LocalDateTime`
- Soporte para múltiples conversiones hasta que el usuario escriba `salir`

---

## 🛠️ Requisitos

- Java 
- Conexión a internet (para usar la API)
- [Gson](https://github.com/google/gson) (para trabajar con JSON)

---

##  Cómo ejecutar el programa

1. **Clona el repositorio o descarga los archivos**
2. **Abre el proyecto en tu IDE favorito** (Eclipse, IntelliJ, VS Code, etc.)
3. **Asegúrate de agregar la biblioteca Gson** al classpath (puedes descargarla o usar Maven/Gradle)
4. **Ejecuta la clase `Principal`**

---

##  Cómo usar

- El programa te pedirá:
  - Cantidad a convertir
  - Moneda origen (ej: USD)
  - Moneda destino (ej: MXN)
- El resultado se muestra por pantalla
- El historial de conversiones se guarda en `historial.json`
- Para salir, escribe `salir` cuando se te pregunte una nueva cantidad

---
