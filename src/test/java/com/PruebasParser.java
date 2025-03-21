/**
 * @author Grupo # 5
 * @version 1
 * Pruebas unitarias para la clase Parser.
 * fecha_creación = 16/03/2025
 * fecha_modificación = 17/03/2025
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class PruebasParser
{
    @Test
    void testParse()
    {
        Lexer lexer = new Lexer("(setq x 10)");
        List<Token> tokens = lexer.Tokenize();
        Expression expression = Parser.parse(tokens);
        assertNotNull(expression);
    }
}
