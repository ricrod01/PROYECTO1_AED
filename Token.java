/**
 * @author Grupo #
 * @version 2
 * Clase que crea y almacena el tipo de Token.
 * fecha_creación = 28/02/2025
 * fecha_modificación = 17/03/2025
 */

class Token 
{
    enum Tipo {NUMBER, SYMBOL, LPAREN, RPAREN}

    final Tipo tipo;
    final String valor;

    Token(String valor)
    {
        this.tipo = Tipos(valor);
        this.valor = valor.toLowerCase();
    }

    public Tipo getTipo()
    {
        return tipo;
    }

    public String getValor()
    {
        return valor;
    }

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
                //Parentesis
                case "(": return Token.Tipo.LPAREN;
                case ")": return Token.Tipo.RPAREN;
                default: return Token.Tipo.SYMBOL;
            }
        }
    }
}