
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WALTER1
 */
public class ATOM2 {
    
    public void traducir(ArrayList <String> index){
        int contador=0;
        boolean atm=false;
        for(int i=0;i<index.size();i++){
        
            if(index.get(i).equals("ATOM")){
            
            
            
            }else if(index.get(i).equals("(") || index.get(i).equals("( ") || index.get(i).equals(" (") ){
        
            
        
            }else if(index.get(i).equals(")") || index.get(i).equals(") ") || index.get(i).equals(" )")){
                
            
            
            }else{  
            
                contador++;
                
            }
        }
        if(contador==1||contador==2){
            atm=true;
            System.out.println(atm);
        }else{
            
            System.out.println(atm);
        }
        
        
    }
    
    
    
    
}
