/**
 * @author Grupo #
 * @version 2
 * Clase que crea y almacena el tipo de Token.
 * fecha_creación = 28/02/2025
 * fecha_modificación = 19/03/2025
 */

class Token 
{

    /**
     * Lista enum
    */

    enum Tipo {NUMBER, SYMBOL, LPAREN, RPAREN}

    private final Tipo tipo;
    private String valor;

    /**
     * Constructor del objeto
     * @param valor. Es la representación tipo String del token.
    */

    Token(String valor)
    {
        this.tipo = Tipos(valor.toLowerCase());
        this.valor = valor.toLowerCase();
    }

    /**
     * @return Devuelve el tipo del token.
    */

    public Tipo getTipo()
    {
        return tipo;
    }

    /**
     * @return Devuelve el valor del token en un String.
    */

    public String getValor()
    {
        return valor;
    }

    /**
     * @param str. String a evaluar si es número.
     * @return Indica si str es un número.
    */

    public static boolean esNumero(String str)
    {
        try
        {
            Double.parseDouble(str);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    /**
     * @param simbolo. String que contiene el símbolo que se le desea asignar el tipo de token.
     * @return Devuelve el tipo de Token del símbolo.
    */

    public Token.Tipo Tipos(String simbolo)
    {
        if(esNumero(simbolo))
        {
            return Token.Tipo.NUMBER;
        }
        else
        {
            switch (simbolo)
            {
                case "(": return Token.Tipo.LPAREN;
                case ")": return Token.Tipo.RPAREN;
                default: return Token.Tipo.SYMBOL;
            }
        }
    }
}