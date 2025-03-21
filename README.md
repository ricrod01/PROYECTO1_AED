# Intérprete LISP Básico

## Descripción del Proyecto
Este proyecto consiste en el desarrollo de un intérprete básico de LISP, un lenguaje de programación conocido por su simplicidad y flexibilidad. El intérprete permite evaluar expresiones LISP, incluyendo operaciones aritméticas, definiciones de funciones, y soporte para recursividad.

## Objetivos
- Implementar un intérprete que evalúe expresiones LISP.
- Soportar operaciones aritméticas básicas: suma, resta, multiplicación y división.
- Permitir la definición de funciones mediante la instrucción `DEFUN`.
- Implementar la instrucción `SETQ` para la asignación de variables.
- Incluir predicados como `ATOM`, `LIST`, `EQUAL`, `<`, y `>`.
- Soportar condicionales a través de la instrucción `COND`.
- Permitir el paso de parámetros a funciones, incluyendo la recursividad.

## Estructura del Programa
El intérprete está compuesto por varias clases que trabajan en conjunto:

- Atom: Representa los elementos básicos del lenguaje (números, palabras, símbolos).
- Context: Maneja el entorno de evaluación, incluyendo variables y funciones definidas.
- Evaluator: Evalúa expresiones y funciones, manejando la lógica de evaluación.
- ListExpression: Representa listas de expresiones, permitiendo la evaluación de expresiones complejas.
- Lexer: Tokeniza el texto de entrada, dividiendo el código LISP en componentes manejables.
- Parser: Convierte la lista de tokens en una estructura de árbol que el intérprete puede evaluar.

Ejemplos de Uso
Aquí hay algunos ejemplos de expresiones LISP que puedes evaluar con el intérprete:

Definición de una función factorial:
(defun factorial (x) (cond ((equals x 1) 1) (t (* x (factorial (- x 1))))))

Asignación de una variable:
(setq a 6)

Evaluación de la función factorial:
(factorial a)
Definición de una función Fibonacci:
(defun fibonacci (x) (cond ((equals x 0) 0) ((equals x 1) 1) (t (+ (fibonacci (- x 2)) (fibonacci (- x 1))))))

Pruebas
Se han implementado pruebas unitarias para asegurar el correcto funcionamiento de las clases principales. Las pruebas están ubicadas en los archivos PruebasAtom.java, PruebasContext.java, PruebasEvaluator.java, PruebasLexer.java, PruebasListExpression.java, PruebasParser.java, y PruebasToken.java.

Contribuciones
Este proyecto fue desarrollado por el Grupo 1, como parte del curso de Algoritmos y Estructura de Datos en la Universidad del Valle de Guatemala. Agradecemos a todos los miembros del grupo por su colaboración y esfuerzo.


Videos demostrativos de todo el proceso de desarrollo y del intérprete funcionando

URL: https://uvggt-my.sharepoint.com/:v:/g/personal/car24458_uvg_edu_gt/EVI3n1rqVqNNmR54TvceirQBMLHt6C5B8PTJSV568B1k7g?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&e=P2NbEK

## Referencias
OpenAI. (2025). ChatGPT (versión del 15 de marzo) [Intérprete LISP en Java]. https://chat.openai.com/
