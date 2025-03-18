/**
 * @author Grupo #
 * @version 1
 * Clase abstracta que define las expresiones.
 * fecha_creación = 9/03/2025
 * fecha_modificación = 17/03/2025
 */

abstract class Expression
{
    /**
     * Este método exige que tanto ListExpression como Atom contengan su propia lógica para evaluar su contenido.
     * @param contexto. Contexto en el cuál se evaluará la expresión.
    */
    
    public abstract Integer evaluar(Context contexto);
}