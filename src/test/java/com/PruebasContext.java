/**
 * @author Grupo # 5
 * @version 1
 * Pruebas unitarias para la clase Context.
 * fecha_creación = 16/03/2025
 * fecha_modificación = 17/03/2025
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class PruebasContext
{
    @Test
    void testAsignarVariableYObtener()
    {
        Context contexto = new Context();
        contexto.asignarVariable(Arrays.asList(new Atom("setq"), new Atom("x"), new Atom("10")));
        contexto.asignarVariable(Arrays.asList(new Atom("setq"), new Atom("y"), new Atom("40")));
        assertEquals(10, contexto.obtenerVariable("x"));
    }
}
