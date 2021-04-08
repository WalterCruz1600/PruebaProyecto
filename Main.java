import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        
        
        Scanner scan = new Scanner(System.in);
        boolean acabar=false;
        InterFun inter = new InterFun();
        
        System.out.println("Bienvenido a nuestro interprete");
        do{
        System.out.println("Que desea hacer?\n1.Ingresar lisp con operaciones aritmeticas\n2. Ingrsar lisp con Quote\n3. Ingresar lisp con DEFUN\n4.Ingresar lisp con SETQ\n5.Ingresa lisp con predicados\n6.Ingresa lisp con COND\n7. Ingresa lisp con paso de parametros\n8. Salir");
        
        int opcion = Integer.parseInt(scan.next());
        ArrayList<Map<String, String>> j = new ArrayList<>();
        switch (opcion){
            //Operaciones aritmeticas
            case 1: 
                System.out.println("Escriba la linea del codigo de lisp que desea interpretar");
                
                inter.crearAST(inter.sepTokens("(* (+ 1 2 3) 2 3)"));
                inter.crearParentesis(j);
        
                
                break;
            //Quote
            case 2:
                
                break;
            //Defun
            case 3: 
                
                break;
            //SETQ
            case 4:
                inter.crearAST(inter.sepTokens("(SETQ x 5)"));
                inter.crearParentesis(j);
                break;
            //predicados
            case 5: 
                
                System.out.println("Que desea hacer?\n1.Ingresar lisp con ATOM\n2. Ingrsar lisp con LIST\n3. Ingresar lisp con EQUAL\n4.Ingresar lisp con <>");
        
                int menu1 = Integer.parseInt(scan.next());
                
                
                switch(menu1){
                    //Atom
                    case 1:
                        ATOM2 atom=new ATOM2();
                        inter.crearAST(inter.sepTokens("(ATOM Hola123)"));
                        ArrayList hol=inter.devolverContexto();
                        atom.traducir(hol);
                        break;
                    //List    
                    case 2:
                        LIST lista=new LIST();
                        inter.crearAST(inter.sepTokens("(LIST Hola123)"));
                        ArrayList hol2=inter.devolverContexto();
                        lista.Lista(hol2);
                        
                        break;
                    //Equal    
                    case 3:
                        
                        break;
                    //<>  
                    case 4:
                        
                        break;
                    
                    default:
                        
                        System.out.println("Opcion no valida");
                    
                }
                
                
                break;
            //COND
            case 6:
                
                break;
            //Paso de parametros 
            case 7:
                
                
                break;
                
            //Salir   
            case 8:
                acabar=true;
                break;
            //no valido  
            default:
                
                System.out.println("Opcion no valida");
            
            
            
        }
        
        }while(acabar==false);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //(* (+ 1 2 3) 2 3)
        //(SETQ x 5)
        
        
        
        


        /*
        1 2 3 2 3
        * +
         */

    }
}
