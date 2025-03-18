/**
 * @author Grupo #
 * @version 1
 * Clase que almacena el contexto de las funciones y variables globales.
 * fecha_creación = 15/03/2025
 * fecha_modificación = 17/03/2025
 */

import java.util.*;

class Context
{
    private final Map<String, Integer> variables;
    private final Map<String, ListExpression> funciones;
    private final Map<String, List<String>> parametrosFunciones;

    /**
     * Construtor de la clase.
    */

    public Context()
    {
        this.variables = new HashMap<>();
        this.funciones = new HashMap<>();
        this.parametrosFunciones = new HashMap<>();
    }

    /**
     * Constructor de la clase.
     * @param contexto Se pasa el contexto existente para trabajar contextos locales.
    */

    public Context(Context contexto)
    {
        this.variables = new HashMap<>(contexto.variables);
        this.funciones = contexto.funciones;
        this.parametrosFunciones = contexto.parametrosFunciones;
    }

    /**
     * @param nombre. Nombre de la variable a verificar.
     * @return Indica si la variable está definida en la definida en el diccionario de variables.
    */

    public boolean variableDefinida(String nombre)
    {
        return variables.containsKey(nombre);
    }

    /**
     * @param nombre. Nombre de la variable a obtener.
     * @return Devuelve la variable que está en el diccionario de variables (si se encuentra).
    */

    public Integer obtenerVariable(String nombre)
    {
        if (!variables.containsKey(nombre)) 
        {
            throw new RuntimeException("La variable " + nombre + " no está definida.");
        }
        return variables.get(nombre);
    }

    /**
     * @param nombre. Nombre de la variable a obtener.
     * @return Devuelve la variable que está en el diccionario de variables (si se encuentra).
    */

    public Integer asignarVariable(List<Expression> elementos)
    {
        if (elementos.size() != 3)
        {
            throw new RuntimeException("SETQ necesita dos argumentos.");
        }
        
        if (!(elementos.get(1) instanceof Atom))
        {
            throw new RuntimeException("El primer argumento de SETQ debe ser un símbolo.");
        }
        
        String nombre = ((Atom) elementos.get(1)).getAtomo();
        Integer valor = elementos.get(2).evaluar(this);

        if (valor == null)
        {
            throw new RuntimeException("El valor de SETQ para '" + nombre + "' es nulo.");
        }
        
        variables.put(nombre, valor);
        return null;
    }

    /**
     * @param elementos. Lista de una expresión la cual sirve para almacenar la función.
     * @return Devuelve un Integer, ya que para este programa los returns serán de números enteros, se retorna null ya que no se requiere el valor.
    */
    
    public Integer definirFuncion(List<Expression> elementos)
    {
        if (elementos.size() < 4)
        {
            throw new RuntimeException("La cláusula defun necesita al menos 3 argumentos.");
        }  
        String nombre = ((Atom) elementos.get(1)).getAtomo();
        List<String> parametros = new ArrayList<>();
        for (Expression exp : ((ListExpression) elementos.get(2)).getElements())
        {
            if (!(exp instanceof Atom))
            {
                throw new RuntimeException("Los parámetros deberían ser átomos.");
            }
            parametros.add(((Atom) exp).getAtomo());
        }
        ListExpression cuerpoFuncion = (ListExpression) elementos.get(3);
        parametrosFunciones.put(nombre, parametros);
        funciones.put(nombre, cuerpoFuncion);
        return null;
    }
    
    /**
     * @param nombre. Nombre de la función a verificar.
     * @return Indica si la función está definida en el diccionario de funciones.
    */

    public boolean funcionDefinida(String nombre)
    {
        return funciones.containsKey(nombre);
    }

    /**
     * @param nombre. Nombre de la función del cual se quiere obtener su estructura.
     * @return Devuelve la estructura de la función que está en el diccionario de funciones (si se encuentra).
    */

    public ListExpression obtenerCuerpoFuncion(String nombre)
    {
        return funciones.get(nombre);
    }

    /**
     * @param nombre. Nombre de la función del cual se quiere obtener sus parámetros.
     * @return Devuelve los parámetros que pertenecen a una función (si existe la función).
    */

    public List<String> obtenerParametrosFuncion(String nombre)
    {
        return parametrosFunciones.get(nombre);
    }

    /**
     * @return Devuelve en un String para ver las variables de las funciones que imprime.
    */

    @Override
    public String toString()
    {
        return "Variables: " + variables + ", Funciones: " + funciones.keySet();
    }  
}
