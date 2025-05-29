**Hello README
**# 🌱 The Game of Live

¡Bienvenido al universo digital donde la vida evoluciona célula a célula!  
**The Game of Live** es una implementación interactiva del famoso autómata celular ideado por John Conway, pero con un giro: aquí, además de observar las reglas de la vida, puedes experimentar y modificar el entorno a tu antojo.

---

## 🚀 ¿Qué es esto?

Este proyecto trae el “Juego de la Vida” al mundo Java, ofreciendo una experiencia visual y educativa sobre cómo reglas simples pueden generar patrones complejos.  
Ideal para curiosos, estudiantes y amantes de la simulación computacional.

---

## 🕹️ Características principales

- **Simulación dinámica:** Observa cómo emergen patrones a partir de células vivas y muertas.
- **Interfaz visual (HTML/Java):** Interactúa y personaliza el tablero.
- **Configuración flexible:** Cambia el tamaño, velocidad y condiciones iniciales.
- **Código modular:** Fácil de entender y extender.
- **Tests incluidos:** Asegura la robustez del autómata.

---

## ⚙️ Instalación rápida

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/n3brrr/The-game-of-Live.git
   cd The-game-of-Live
   ```

2. **Compila y ejecuta con Maven:**
   ```bash
   ./mvnw clean install
   ./mvnw exec:java
   ```
   > En Windows: usa `mvnw.cmd` en vez de `./mvnw`

3. **Abre la interfaz:**
   - Si tiene interfaz web, abre el HTML generado (revisa la carpeta `/src/main`).
   - Si es consola, sigue las instrucciones que aparecen al ejecutar.

---

## 📂 Estructura del proyecto

```
The-game-of-Live/
├── src/
│   ├── main/      # Código fuente Java y recursos (posible HTML)
│   └── test/      # Pruebas automatizadas
├── pom.xml        # Configuración Maven
└── README.md      # ¡Este archivo!
```

---

## 🤖 ¿Cómo funciona el juego?

Cada celda del tablero puede estar “viva” o “muerta”.  
En cada iteración (“generación”), las células evolucionan según reglas simples:

- Una célula viva con 2 o 3 vecinas vivas, sobrevive.
- Una célula muerta con exactamente 3 vecinas vivas, revive.
- En cualquier otro caso, la célula muere o permanece muerta.

¡Experimenta y descubre patrones asombrosos!

---

## 🧩 Personaliza y expande

¿Quieres añadir nuevas reglas, colores o modos de juego?  
El código está diseñado para que puedas experimentar, modificar y aprender.

---

## 📝 Créditos

Desarrollado por [n3brrr](https://github.com/n3brrr).  
Inspirado en el clásico de John Conway.

---

## 📜 Licencia

Este proyecto es de código abierto.  
Consulta el archivo LICENSE (si existe) para más detalles.

---
