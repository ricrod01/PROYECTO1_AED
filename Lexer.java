/**
 * @author Grupo #
 * @version 2
 * Clase encargada de revisar el correcto uso de paréntesis y hacer una lista de Tokens.
 * fecha_creación = 28/02/2025
 * fecha_modificación = 17/03/2025
 */

import java.util.ArrayList;
import java.util.List;

public class Lexer
{
    private final String texto;
    private int posicion = -1;

    /**
     * Constructor de la clase.
     * @param texto Se pasa el texto del cuál se extraerá los tokens.
    */

    public Lexer(String texto)
    {
        this.texto = texto;
    }

    /**
     * @return Devuelve la lista de tokens que se extraen del atributo texto.
    */

    public List<Token> Tokenize()
    {
        List<Token> tokens = new ArrayList<>();
        String token_continuo = "";

        while (posicion < texto.length() - 1)
        {
            posicion++;
            char car = texto.charAt(posicion);

            if (car == ' ')
            {
                continue;
            }
            if (car == '(' || car == ')')
            {
                tokens.add(new Token(String.valueOf(car)));
                continue;
            } 
            if (Character.isDigit(car))
            {
                if (posicion < texto.length() - 1 && Character.isDigit(texto.charAt(posicion + 1)))
                {
                    token_continuo = token_continuo + car;
                }
                else
                {
                    if (token_continuo.equals(""))
                    {
                        tokens.add(new Token(String.valueOf(car)));
                    }
                    else
                    {
                        token_continuo = token_continuo + car;
                        tokens.add(new Token(token_continuo));
                        token_continuo = "";
                    }
                }
                continue;
            }
            if (Character.isLetter(car))
            {
                if (posicion < texto.length() - 1 && Character.isLetter(texto.charAt(posicion + 1)))
                {
                    token_continuo = token_continuo + car;
                }
                else
                {
                    if (token_continuo.equals(""))
                    {
                        tokens.add(new Token(String.valueOf(car)));
                    }
                    else
                    {
                        token_continuo = token_continuo + car;   
                        tokens.add(new Token(token_continuo));
                        token_continuo = "";
                    }
                }
                continue;
            }
            tokens.add(new Token(String.valueOf(car)));
        }
        if(BalanceParentesis(tokens))
        {
            return tokens;
        }
        else
        {
            throw new RuntimeException("Paréntesis desbalanceados, la expresión no se puede evaluar.");
        }
    }

    /**
     * @param tokens. Lista de tokens en la cual se contarán los paréntesis y verificará el orden.
     * @return Indica si hay la misma cantidad de paréntesis que abren y que cierran y en el orden correcto.
    */

    public boolean BalanceParentesis(List<Token> tokens)
    {
        int contLPAREN = 0;
        int contRPAREN = 0;
    
        for (Token token : tokens) {
            if (token.getTipo() == Token.Tipo.LPAREN)
            {
                contLPAREN++;
            }
            if (token.getTipo() == Token.Tipo.RPAREN)
            {
                contRPAREN++;
                if (contRPAREN > contLPAREN)
                {
                    return false;
                }
            }
        }
        return contLPAREN == contRPAREN;
    }
    
}