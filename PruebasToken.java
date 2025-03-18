/**
 * @author Grupo #
 * @version 1
 * Pruebas unitarias para la clase Token.
 * fecha_creación = 16/03/2025
 * fecha_modificación = 17/03/2025
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PruebasToken
{
    @Test
    void testTipos()
    {
        Token numberToken = new Token("123");
        assertEquals(Token.Tipo.NUMBER, numberToken.getTipo());
        
        Token symbolToken = new Token("abc");
        assertEquals(Token.Tipo.SYMBOL, symbolToken.getTipo());
        
        Token lparenToken = new Token("(");
        assertEquals(Token.Tipo.LPAREN, lparenToken.getTipo());
        
        Token rparenToken = new Token(")");
        assertEquals(Token.Tipo.RPAREN, rparenToken.getTipo());
    }
}