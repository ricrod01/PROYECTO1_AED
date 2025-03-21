/**
 * @author Grupo # 5
 * @version 1
 * Pruebas unitarias para la clase Lexer.
 * fecha_creación = 16/03/2025
 * fecha_modificación = 17/03/2025
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class PruebasLexer
{
    @Test
    void testTokenize()
    {
        Lexer lexer = new Lexer("(setq x 10)");
        List<Token> tokens = lexer.Tokenize();
        System.out.println(lexer);
        assertEquals(5, tokens.size());
        assertEquals("setq", tokens.get(1).getValor());
    }
}