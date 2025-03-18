/**
 * @author Grupo #
 * @version 2
 * Clase encargada de crear estructura de árbol de la expresión LISP pasada por el usuario.
 * fecha_creación = 9/03/2025
 * fecha_modificación = 17/03/2025
 */

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Parser
{
    
    /**
     * Constructor de la clase.
     * @param tokens. Lista con los tokens de la expresión LISP.
     * @return Devuelve la Expression en el formato correspondiente (Atom o ListExpression).
    */

    public static Expression parse(List<Token> tokens)
    {
        ListIterator<Token> iterator = tokens.listIterator();
        return parseExpression(iterator);
    }

    /**
     * @param iterator. Lista iterada con los tokens de la expresión LISP.
     * @return Devuelve la Expression en el formato correspondiente (Atom o ListExpression).
    */

    private static Expression parseExpression(ListIterator<Token> iterator)
    {
        if (!iterator.hasNext())
        {
            throw new RuntimeException("La entrada no se puede evaluar, puede estar mal escrita.");
        }

        Token token = iterator.next();
        if (token.getTipo() == Token.Tipo.LPAREN)
        {
            List<Expression> elementos = new ArrayList<>();
            while (iterator.hasNext())
            {
                Token siguiente_Token = iterator.next();
                if (siguiente_Token.getTipo() == Token.Tipo.RPAREN)
                {
                    if (elementos.isEmpty())
                    {
                        throw new RuntimeException("La expresión está vacía, no tiene sentido.");
                    }
                    return new ListExpression(elementos);
                }
                iterator.previous();
                elementos.add(parseExpression(iterator));
            }
        }
        return new Atom(token.getValor());
    }
}
