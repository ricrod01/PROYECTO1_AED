/**
 * @author Grupo #
 * @version 1
 * Pruebas unitarias para la clase ListExpression.
 * fecha_creación = 16/03/2025
 * fecha_modificación = 17/03/2025
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class PruebasListExpression
{
    @Test
    void testEvaluar()
    {
        Context contexto = new Context();
        contexto.asignarVariable(Arrays.asList(new Atom("setq"), new Atom("x"), new Atom("10")));
        contexto.asignarVariable(Arrays.asList(new Atom("setq"), new Atom("y"), new Atom("5")));
        ListExpression suma = new ListExpression(Arrays.asList(new Atom("+"), new Atom("x"), new Atom("y")));
        assertEquals(15, suma.evaluar(contexto));
    }
}