/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l.miniproject;

import java.util.ArrayList;

/**
 *
 * @author welcome
 */
public class Queue {
     ArrayList<Client>faclient =new ArrayList<Client>();
     ArrayList<Client>tcinfa= new ArrayList<Client>();
     private int tp;
     private int minatt , maxatt ;
     private int moyenatt;
     private int nbclientenfa=0;
     private int nbcnons=0;
    public Queue(int tp){this.tp=tp;}
    public int falistsize(){
        return faclient.size();
    }
    public int setminatt(int min){
        return this.minatt=min;
    }
     public int setmaxatt(int max){
        return this.maxatt=max;
    }
     public int moyenatt(){
         this.maxmin();
          moyenatt = ((this.maxatt+this.minatt)/2);
         return moyenatt ;
     }
     
    public void addclient(Client c){
         System.out.println("\n ^^^^^^^^^^^^^^^^^^ADD CLIENT in fille d'attent^^^^^^^^^^^^^^^^^^^^^^^^");
         this.nbclientenfa++;
        faclient.add(c);
        tcinfa.add(c);
    }
    public void maxmin(){
        if(tcinfa.size()>0){
           this.minatt =tcinfa.get(0).getptime();
         this.maxatt =tcinfa.get(0).getptime(); 
        }else{
            this.maxatt=0;
            this.minatt=0;
        }
         
         for(int i=0;i<tcinfa.size();i++){
            if(tcinfa.get(i).getptime()<this.minatt){
                this.minatt=tcinfa.get(i).getptime();
            }else{
                if(tcinfa.get(i).getptime()>this.maxatt){
                    this.maxatt=tcinfa.get(i).getptime();
                }
            }         
       

         }
    }
    public Client getfirstclient(){
        
        return faclient.get(0);
       
        
    }
    public void removefirst(){
        faclient.remove(faclient.get(0));
        
    
    }
    public void apdatetpatince(){
      for(int i =0;i<faclient.size();i++){
          faclient.get(i).changeptime();
          if(faclient.get(i).getptime()==0){
              faclient.remove(faclient.get(i));
              this.nbcnons=this.nbcnons+1;
              System.out.println("\n client N° :"+faclient.get(i).getid()+" leave fd \n");
          }
      }
       
    }
    public int ncnons(){
     int n = this.nbcnons+faclient.size();
     return this.nbcnons=n;
    }
   public void afichtp(){
        System.out.println("\n\n ..................................CLIENTS IN WAIT :.......................... ");
       for(int i =0;i<faclient.size();i++){
           System.out.println("\n CLIENT N°:"+faclient.get(i).getid());
           System.out.println("\n clint start at "+faclient.get(i).getatime()+" in fa");
           System.out.println("\n time patient"+faclient.get(i).getptime()+"/n");
           System.out.println("..............................................");
           
       }
   }
    
}
