/**
 * @author Grupo # 5
 * @version 2
 * Clase que crea y almacena Átomos (palabras/números/operadores)
 * fecha_creación = 9/03/2025
 * fecha_modificación = 17/03/2025
 */

class Atom extends Expression
{
    private final String atomo;

    /**
     * Constructor de la clase.
     * @param atomo. El String que se almacena como átomo.
    */

    public Atom(String atomo)
    {
        this.atomo = atomo;
    }

    /**
     * @return Devuelve el átomo.
    */

    public String getAtomo()
    {
        return atomo;
    }

    /**
     * @param contexto. Contexto en el que se evaluará el átomo.
     * @return Devuelve el valor que resulta de evaluar el átomo.
    */

    @Override
    public Integer evaluar(Context contexto)
    {
        if (atomo.equalsIgnoreCase("t"))
        {
            return 1;
        }
        if (contexto.variableDefinida(atomo))
        {
            return contexto.obtenerVariable(atomo);
        }
        try 
        {
            return Integer.parseInt(atomo);
        } catch (NumberFormatException e)
        {
            throw new RuntimeException("El átomo: " + atomo + ", no se encuentra dentro del contexto: " + contexto);
        }
    }

    /**
     * @peturn Método que sirve para imprimir el valor del átomo.
    */

    @Override
    public String toString()
    {
        return atomo;
    }
}