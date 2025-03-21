/**
 * @author Grupo # 5
 * @version 1
 * Pruebas unitarias para la clase Atom.
 * fecha_creación = 16/03/2025
 * fecha_modificación = 17/03/2025
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class PruebasAtom
{
    @Test
    void testEvaluar()
    {
        Context contexto = new Context();
        Atom atomNumero = new Atom("10");
        assertEquals(10, atomNumero.evaluar(contexto));
        
        contexto.asignarVariable(Arrays.asList(new Atom("setq"), new Atom("x"), new Atom("5")));
        Atom atomVariable = new Atom("x");
        assertEquals(5, atomVariable.evaluar(contexto));
    }
}
