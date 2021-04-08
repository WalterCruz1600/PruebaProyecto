import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]){
        InterFun inter = new InterFun();
        ATOM2 atom=new ATOM2();
        LIST lista=new LIST();
        //(* (+ 1 2 3) 2 3)
        //(SETQ x 5)
        inter.crearAST(inter.sepTokens("(ATOM Hola123)"));
        ArrayList hol=inter.devolverContexto();
        lista.Lista(hol);
        atom.traducir(hol);
        ArrayList<Map<String, String>> j = new ArrayList<>();
        inter.crearParentesis(j);
        


        /*
        1 2 3 2 3
        * +
         */

    }
}
