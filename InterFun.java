import java.lang.reflect.Array;
import java.util.*;

public class InterFun implements Interpretar{
    private final ArrayList<String> pila;
    private ArrayList<ArrayList<String>> arrayASTFinal;
    private ArrayList<HashMap<String, String>> arrayAST;
    private ArrayList<String> contexto;
    private final ArrayList<String> func = new ArrayList<>();
    private Arbol arbolFun;
    ArrayList<ArrayList<Map<String, String>>> listaFinal = new ArrayList<>();
    private Atom atm=new Atom();



    public InterFun() {
        this.pila = new ArrayList<>();
        this.arrayAST = new ArrayList<HashMap<String, String>>();
        this.arrayASTFinal = new ArrayList<>();
        this.contexto = new ArrayList<>();

        arbolFun = new Arbol();

        func.add("SETQ");
        func.add("DEFUN");
        func.add("QUOTE");
        func.add("IF");
        func.add("<");
        func.add(">");
        func.add("EQUALS");
        func.add("LIST");
        func.add("ATOM");
        func.add("+");
        func.add("-");
        func.add("*");
        func.add("/");
    }

    @Override
    public ArrayList<String> sepTokens(String inputLisp) {
        contexto.clear();
        inputLisp = inputLisp.replace("(", " ( ").replace(")", " ) ");
           /*
        Se crea una pila y un objeto String tokenizer para obtener los tokens de la expresion
        Tambien se crea una arraylist para ordenar la pila de la manera que requiere la sintaxis
         */
        StringTokenizer st = new StringTokenizer(inputLisp);
        StringTokenizer st2 = new StringTokenizer(inputLisp);
        ArrayList<String> d = new ArrayList<>();
        /*
        ciclo while para llenar el arrayList

         */
        while (st2.hasMoreTokens()) {
            d.add(st2.nextToken());

        }
        while(st.hasMoreTokens()){
            contexto.add(st.nextToken());
        }
        /*
        ciclo for para llenar la pila
        ciclo for y revisar que es una operacion aritmetca
        true
         */

        for (int i = contexto.size(); i>0;i--){
            if(contexto.get(i-1).equals(" ")){
                contexto.remove(i-1);

            }else {
                pila.add(contexto.get(i-1).replaceAll(" ", ""));



            }
        }
        System.out.println(contexto.toString());
        
        

        return pila;
    }
    
    
    public ArrayList<String> devolverContexto (){
        
        
        
        return contexto;
        
        
    }
    
    /*
    Se crea el abstract syntax tree
     */
    @Override
    public void crearAST(ArrayList<String> pila) {
        int contador = 0;

        for(int i = 0; i< pila.size();i++){
            if(pila.get(0).equals("(") || pila.get(0).equals("( ") || pila.get(0).equals(" (") ){

                categorizar(pila.get(0));
                pila.remove(0);
                contador ++;

            }else if(pila.get(0).equals(" )") || pila.get(0).equals(")") || pila.get(0).equals(") ") ){
                categorizar(pila.get(0));
                pila.remove(0);
                contador --;

            }else{
                categorizar(pila.get(0));
                pila.remove(0);
                crearAST(pila);

            }
        }
        

    }
    
    public ArrayList<Map<String, String>> crearParentesis(ArrayList<Map<String, String>> h ){

        try {
            for (int i = arrayAST.size(); i>0; i--){
                if(arrayAST.get(i-1).get("ID").equals("Open paren")){
                    ArrayList<Map<String, String>> j = new ArrayList<>();
                    arrayAST.remove(i-1);
                    crearParentesis(j);
                    listaFinal.add(h);
                }else if (arrayAST.get(i-1).get("ID").equals("Close paren")){
                    ArrayList<Map<String, String>> j = new ArrayList<>();
                    arrayAST.remove(i-1);
                    crearParentesis(j);
                    listaFinal.add(h);
                    return h;
                }else{

                    h.add(arrayAST.remove(i-1));
                    return crearParentesis(h);

                }
                System.out.println(listaFinal.toString());
            }
            return null;

        } catch (Exception e) {

        }
        for (int i = 0; i<listaFinal.size();i++){
            if(listaFinal.get(i).isEmpty()){
                listaFinal.remove(i);
            }
        }
        System.out.println(listaFinal.toString());
        return null;

    }
    /*

Se crea la calculadora para LISP
 */
    @Override
    public void interpretarMap(ArrayList<HashMap<String, String>> exp) {
        /*
        aritmeticas
         */


    }


    /*
    codigo para saber si es numerico
    https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
     */
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    /*
    Se categorizan en tres tipos String, numero o funcion
     */
    @Override
    public void categorizar(String input) {


        HashMap<String, String> temp = new HashMap<>();
        if (input.charAt(0) == '"' && input.charAt(-1)=='"'){

            temp.put("ID" , "String");
            temp.put("Value" , input);
            arrayAST.add(temp);

        }else if(isNumeric(input) && input.length()<3){
            temp.put("ID" , "Number");
            temp.put("Value" , input);
            arrayAST.add(temp);
        }else if(input.charAt(0) == '('){
            temp.put("ID" , "Open paren");
            temp.put("Value" , input);
            arrayAST.add(temp);

        }else if(input.charAt(0) == ')'){
            temp.put("ID" , "Close paren");
            temp.put("Value" , input);
            arrayAST.add(temp);

        }
        else {
            if(func.contains(input.toUpperCase(Locale.ROOT))){
                temp.put("ID" , "Function");
                temp.put("Value" , input);
                arrayAST.add(temp);
            }else {
                temp.put("ID" , "Expresion");
                temp.put("Value" , input);
                arrayAST.add(temp);
            }
        }
        }


}
