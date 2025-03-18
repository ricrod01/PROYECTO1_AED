/**
 * @author Grupo #
 * @version 1
 * Pruebas unitarias para la clase Evaluator.
 * fecha_creación = 16/03/2025
 * fecha_modificación = 17/03/2025
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class PruebasEvaluator
{
    @Test
    void testEvaluarFuncion() 
    {
        Context contexto = new Context();
        contexto.definirFuncion(Arrays.asList(
            new Atom("defun"),
            new Atom("suma"),
            new ListExpression(Arrays.asList(new Atom("x"), new Atom("y"))),
            new ListExpression(Arrays.asList(new Atom("+"), new Atom("x"), new Atom("y")))
        ));
        List<Expression> args = Arrays.asList(new Atom("3"), new Atom("7"));
        Integer resultado = Evaluator.evaluarFuncion("suma", args, contexto);
        assertEquals(10, resultado);
    }
}
