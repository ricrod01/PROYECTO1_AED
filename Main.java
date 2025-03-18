/**
 * @author Grupo #
 * @version 2
 * Clase principal donde se ingresa la expresi+on LISP a evaluar
 * fecha_creación = 28/02/2025
 * fecha_modificación = 17/03/2025
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> codes = Arrays.asList(
            "(defun factorial (x) (cond ((equals x 1) 1) (t (* x (factorial (- x 1))))))",
            "(setq a 6)",
            "(factorial a)",
            "(factorial 4)",
            "(defun fibonacci (x) (cond ((equals x 0) 0) ((equals x 1) 1) (t (+ (fibonacci (- x 2)) (fibonacci (- x 1))))))",
            "(fibonacci 4)"
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
                    System.out.println(resultado);
                }
            } 
            catch (Exception e) {
                System.err.println("Error al ejecutar: " + code);
                e.printStackTrace();
            }
        }
    }
}
