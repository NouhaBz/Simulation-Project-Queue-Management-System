/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l.miniproject;

/**
 *
 * @author welcome
 */
public class Employe {
    private int timers ;
    private int idc; 
    private int id;
    private boolean etat ;
    public Employe(int id, boolean etat ){
        this.id=id;
        this.etat=etat;
    }
 
    public int setidc(int t){
       return this.idc=t;
   }
   public int getidc(){
       return this.idc;
   }
    
    
    public boolean getetat(){
        return this.etat;
    }
   public boolean setetat(boolean newetat){
       return this.etat=newetat;
   }
   public int settimers(int t){
       return this.timers=t;
   }
   public int gettimers(){
       return this.timers;
   }
   public int changetimers(){
       int newrts =this.timers-1;
       return this.timers=newrts;
   }
   public void affich(){
       System.out.println("\n time service remind for this client :"+this.timers+"\n.......");
   }
    
}
