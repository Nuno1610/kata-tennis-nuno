# 🎾 Tennis Kata – Implementación con TDD

## 📌 Descripción

Este proyecto es una implementación del clásico Tennis Kata, desarrollada aplicando principios de Test-Driven Development (TDD).

El objetivo no fue únicamente hacer que los tests pasaran, sino evolucionar el diseño progresivamente mediante refactorizaciones, modelando correctamente el dominio real del tenis:
*	Puntuación de juego (Love, Fifteen, Thirty, Forty)
*	Deuce y Advantage
*	Regla de victoria por diferencia de 2 puntos
*	Reglas de Set (6 juegos y diferencia de 2)
*	Tie-break en 6–6
*	Diseño limpio y extensible

⸻

## 🧪 Enfoque TDD

El desarrollo siguió el ciclo clásico:

Red → Green → Refactor
1.	Escribir un test que falle.
2.	Implementar el mínimo código necesario para hacerlo pasar.
3.	Refactorizar manteniendo los tests en verde.
4.	Repetir el proceso.

Además:
*	Se utilizaron tests unitarios clásicos.
*	Se introdujeron tests parametrizados para cubrir múltiples escenarios.
*	Se ajustaron algunos tests cuando el modelo de dominio lo exigía.

⸻

## 🏗 Evolución del Diseño

El diseño evolucionó en varias etapas.

### 1️⃣ Implementación inicial del Game

Se implementó la lógica básica de puntuación:
*	Love-Love
*	Fifteen-All
*	Thirty
*	Forty
*	Deuce
*	Advantage
*	Victoria por diferencia de 2 puntos

Posteriormente se refactorizó para:
*	Eliminar duplicaciones.
*	Centralizar el cálculo de diferencias.
*	Sustituir números mágicos por constantes.
*	Mejorar legibilidad.

⸻

### 2️⃣ Introducción del patrón Strategy

Para soportar tanto:
* Juego normal 
* Tie-break

Se introdujo el patrón Strategy.

#### Interfaz GameStrategy

```java
public interface GameStrategy {
    void playerOneScores();
    void playerTwoScores();
    boolean isFinished();
    String getWinner();
}
```

Implementaciones
*	Game → Lógica estándar del tenis.
*	TieBreakGame → Lógica especial de tie-break (primero a 7 con diferencia de 2).

Esto permite que TennisSet delegue el comportamiento del juego actual sin conocer sus detalles internos.

⸻

## 🎾 TennisSet

TennisSet modela:	
* Juegos ganados por cada jugador.	
* Activación automática del tie-break en 6–6.	
* Regla de finalización del set.	
* Integración con GameStrategy.

Comportamiento clave	
* En 6–6 se activa automáticamente un TieBreakGame.	
* El ganador del tie-break gana el set.	
* En sets normales se requiere:	
* Al menos 6 juegos.	
* Diferencia mínima de 2.

⸻

## 🧠 Decisiones de diseño

✔ Uso de Strategy

Se utilizó Strategy para:
* Eliminar flags booleanos (tieBreak).	
* Separar responsabilidades.	
* Cumplir el principio Open/Closed.	
* Facilitar extensiones futuras.

⸻

✔ No uso de mocks

No se utilizaron mocks porque:	
* No existen dependencias externas.	
* El dominio es puro y determinista.	
* No hay infraestructura (BD, APIs, etc.). 
* Mockear no aportaba valor en este contexto.

⸻

✔ Uso de tests parametrizados

Se utilizaron @ParameterizedTest para:
* Reducir duplicación.	
* Cubrir múltiples escenarios.	
* Hacer los tests más expresivos.	
* Modelar mejor las variaciones del dominio.

⸻

## 🧪 Cobertura funcional

La suite de tests cubre:

Game
*	Puntuación básica.
*	Deuce.
*	Advantage.
*	Victoria por diferencia de 2.

Set
*	Progresión normal.
*	6–5 no finaliza.
*	7–5 finaliza.
*	Activación del tie-break en 6–6.
*	Tie-break con diferencia de 2 (7–5, 8–6, etc.).
*	Finalización correcta del set tras tie-break.
⸻

