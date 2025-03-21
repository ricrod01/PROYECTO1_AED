/**
 * @author Grupo # 5
 * @version 2
 * Clase que crea y almacena ListExpression.
 * fecha_creación = 9/03/2025
 * fecha_modificación = 17/03/2025
 */

import java.util.*;
import java.util.stream.Collectors;

class ListExpression extends Expression
{
    private final List<Expression> elements;

    /**
     * Constructor de la clase.
     * @param elements. Una lista que contiene la expresión que será la ListExpression.
    */

    public ListExpression(List<Expression> elements)
    {
        this.elements = elements;
    }

    /**
     * @return Devuelve la ListExpression.
    */

    public List<Expression> getElements()
    {
        return elements;
    }

    /**
     * @param contexto. Contexto en el que se evaluará la ListExpression.
     * @return Devuelve el valor que resulta de evaluar la ListExpression.
    */

    @Override
    public Integer evaluar(Context contexto)
    {
        if (elements.isEmpty())
        {
            throw new RuntimeException("No se puede evaluar una lista vacía.");
        }
        
        Expression primerElemento = elements.get(0);
        if (!(primerElemento instanceof Atom))
        {
            throw new RuntimeException("El primer elemento debe ser un símbolo.");
        }
        
        String operador = ((Atom) primerElemento).getAtomo().toLowerCase();
        switch (operador)
        {
            case "quote": return null;
            case "setq": return contexto.asignarVariable(elements);
            case "defun": return contexto.definirFuncion(elements);
            case "cond": return Evaluator.evaluarCondicion(elements, contexto);
            case "listp": return Evaluator.evaluarListp(elements, contexto);
            case "atom": return Evaluator.evaluarAtom(elements, contexto);
            case "equals": return Evaluator.evaluarEqual(elements, contexto);
            case "<": return Evaluator.evaluarMenor(elements, contexto);
            case ">": return Evaluator.evaluarMayor(elements, contexto);
            case "+": return elements.get(1).evaluar(contexto) + elements.get(2).evaluar(contexto);
            case "-": return elements.get(1).evaluar(contexto) - elements.get(2).evaluar(contexto);
            case "*": return elements.get(1).evaluar(contexto) * elements.get(2).evaluar(contexto);
            case "/": return elements.get(1).evaluar(contexto) / elements.get(2).evaluar(contexto);
            default:
                if (contexto.funcionDefinida(operador))
                {
                    return Evaluator.evaluarFuncion(operador, elements.subList(1, elements.size()), contexto);
                }
            throw new RuntimeException("Operador desconocido: " + operador);
        }
    }

    /**
     * @peturn Método que sirve para imprimir el valor de la ListExpression.
    */

    @Override
    public String toString()
    {
        return "[" + elements.stream()
                .map(Expression::toString)
                .collect(Collectors.joining(" ")) + "]";
    }
}