/**
 * @author Grupo #
 * @version 1
 * Clase que evalúa las expresiones.
 * fecha_creación = 15/03/2025
 * fecha_modificación = 17/03/2025
 */

import java.util.*;

class Evaluator
{
    /**
     * @param nombre. Nombre de la función que se desea evaluar.
     * @param argumentos. Lista que contiene la expresión de los argumentos que se le pasan a la función.
     * @param contexto. Contexto en el que se encuentran almacenadas las funciones.
     * @return Devuelve la evaluación de la función según los parámetros que se le pasan y de la estructura almacenada en el contexto.
    */

    public static Integer evaluarFuncion(String nombre, List<Expression> argumentos, Context contexto)
    {
        if (!contexto.funcionDefinida(nombre))
        {
            throw new RuntimeException("La función " + nombre + " no está definida.");
        }

        List<String> parametros = contexto.obtenerParametrosFuncion(nombre);
        if (argumentos.size() != parametros.size())
        {
            throw new RuntimeException("Se ingresó un número incorrecto de argumentos para la función " + nombre);
        }

        Context local = new Context(contexto);
        for (int i = 0; i < parametros.size(); i++)
        {
            Expression argumento = argumentos.get(i);
            Integer valor;
            if (argumento instanceof Atom && contexto.variableDefinida(((Atom) argumento).getAtomo()))
            {
                valor = contexto.obtenerVariable(((Atom) argumento).getAtomo());
            }
            else
            {
                valor = argumento.evaluar(contexto);
            }
    
            if (valor == null)
            {
                throw new RuntimeException("El argumento " + parametros.get(i) + " es nulo.");
            }
            local.asignarVariable(Arrays.asList(new Atom("setq"), new Atom(parametros.get(i)), new Atom(valor.toString())));
        }
    
        ListExpression cuerpoFuncion = contexto.obtenerCuerpoFuncion(nombre);
        if (cuerpoFuncion == null)
        {
            throw new RuntimeException("El cuerpo de la función " + nombre + " no existe dentro del contexto.");
        }
        return cuerpoFuncion.evaluar(local);
    }

    /**
     * @param elementos. Lista de elementos de las condiciones que se evaluarán.
     * @param contexto. Contexto en el que se encuentran almacenada la condiciones que se probarán.
     * @return Devuelve la expresión evaluada en caso de que alguna condiciones resulte verdadera y errror en caso de que ninguna lo sea.
    */
    
    public static Integer evaluarCondicion(List<Expression> elementos, Context contexto)
    {
        for (int i = 1; i < elementos.size(); i++)
        {
            ListExpression par = (ListExpression) elementos.get(i);
            if (par.getElements().get(0).evaluar(contexto) != 0)
            {
                return par.getElements().get(1).evaluar(contexto);
            }
        }
        throw new RuntimeException("Ninguna de las condiciones es verdadera.");
    }

    /**
     * @param elementos. Lista de elementos que se evaluará.
     * @param contexto. Contexto en el que se encuentran almacenada la lista de elementos que se probará.
     * @return Devuelve 1 si el índice 1 de elementos se puede instanciar como ListExpression y 0 en caso contrario.
    */

    public static Integer evaluarListp(List<Expression> elementos, Context contexto)
    {
        return elementos.get(1) instanceof ListExpression ? 1 : 0;
    }

    /**
     * @param elementos. Lista de elementos que se evaluará.
     * @param contexto. Contexto en el que se encuentran almacenada la lista de elementos que se probará.
     * @return Devuelve 1 si el índice 1 de elementos se puede instanciar como un Átomo y 0 en caso contrario.
    */

    public static Integer evaluarAtom(List<Expression> elementos, Context contexto)
    {
        return elementos.get(1) instanceof Atom ? 1 : 0;
    }

    /**
     * @param elementos. Lista de elementos que se evaluará.
     * @param contexto. Contexto en el que se encuentran almacenada la lista de elementos que se probará.
     * @return Devuelve 1 si el índice 1 de elementos es igual al ìndice 2 de elementos y 0 en caso contrario.
    */

    public static Integer evaluarEqual(List<Expression> elementos, Context contexto)
    {
        return elementos.get(1).evaluar(contexto).equals(elementos.get(2).evaluar(contexto)) ? 1 : 0;
    }

    /**
     * @param elementos. Lista de elementos que se evaluará.
     * @param contexto. Contexto en el que se encuentran almacenada la lista de elementos que se probará.
     * @return Devuelve 1 si el índice 1 de elementos es menor al ìndice 2 de elementos y 0 en caso contrario.
    */

    public static Integer evaluarMenor(List<Expression> elementos, Context contexto)
    {
        return elementos.get(1).evaluar(contexto) < elementos.get(2).evaluar(contexto) ? 1 : 0;
    }

    /**
     * @param elementos. Lista de elementos que se evaluará.
     * @param contexto. Contexto en el que se encuentran almacenada la lista de elementos que se probará.
     * @return Devuelve 1 si el índice 1 de elementos es mayor al ìndice 2 de elementos y 0 en caso contrario.
    */

    public static Integer evaluarMayor(List<Expression> elementos, Context contexto)
    {
        return elementos.get(1).evaluar(contexto) > elementos.get(2).evaluar(contexto) ? 1 : 0;
    }
}

