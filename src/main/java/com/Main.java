/**
 * @author Grupo # 5
 * @version 2
 * Clase principal donde se ingresa la expresi+on LISP a evaluar
 * fecha_creación = 28/02/2025
 * fecha_modificación = 21/03/2025
 */

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        List<String> codes = Arrays.asList(
            "(defun factorial (x) (cond ((equals x 1) 1) (t (* x (factorial (- x 1))))))",
            "(setq a 6)",
            "(factorial a)",
            "(factorial 4)",
            "(defun fibonacci (x) (cond ((equals x 0) 0) ((equals x 1) 1) (t (+ (fibonacci (- x 2)) (fibonacci (- x 1))))))",
            "(fibonacci 4)",
            "(fibonacci 5)",
            "(defun temperatura (c) (+ (/ (* c 9) 5) 32))",
            "(temperatura 0)",
            "(temperatura 10)",
            "(defun malan (m n) (cond ((equals n 0) 1) (t (* m (malan m (- n 1))))))",
            "(malan 7 5)"
        );

        Context contexto = new Context();
        for (String code : codes) 
        {
            try
            {
                Lexer lexer = new Lexer(code);
                List<Token> tokens = lexer.Tokenize();
                Expression expression = Parser.parse(tokens);
                Integer resultado = expression.evaluar(contexto);
                if(resultado != null)
                {
                    System.out.println(expression);
                    System.out.println(resultado);
                }
            } 
            catch (Exception e)
            {
                System.err.println("Error al ejecutar: " + code);
            }
        }
    }
}
