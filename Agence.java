/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l.miniproject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author welcome
 */
public class Agence {
    ArrayList<Client>clist=new ArrayList<Client>();
    ArrayList<Client>clists= new ArrayList<Client>();
    ArrayList<Employe>elist= new ArrayList<Employe>();
    private int nombreclientserv=0;
   private int tmsclient;
   private int mins,maxs;
   private int maxo;
   private int mino;
   private double ptocc ;
    int i =1;int j =1;
    private String name ;
    private String adress ;
    public Agence(String name , String adress){
        this.name=name ;
        this.adress= adress;
        
    }
    
    public Client creatclient(int atime,int smin , int smax,int ptime){
        
        Client client = new Client (i,atime);
        client.setptime(ptime);
        i++;
        Random rn = new Random();
        int stime= rn.nextInt((smax-smin)+1) +smin;
        client.setstime(stime);
        
        clist.add(client);
        System.out.println("\n ____________________New Client Added__________________________ \n");
       return client; 
    }
    public Employe createmploye(){
        
        Employe employe = new Employe(j,false);
        j++;
        elist.add(employe);
        return employe;
    }
    /////check if is there 1 employe is free
    public boolean verfetae(){
        boolean s=false;
        for(int v=0;v<elist.size();v++){
            if(elist.get(v).getetat()==false){
                s=true;
                break;
                
            }
        }
        if(s==true){
            return s;
        }else{
            return false;
        }
    }
    //get one emplyee free///////////////////////////////////
    public void changeetat(Employe e,Client c){
        e.setetat(true);
        e.settimers(c.getstime());
        e.setidc(c.getid());
        this.nombreclientserv++;
        clists.add(c);
       
    }
    
     public void getfreeemploy(Client c){
         for(int k=0;k<elist.size();k++){
             if(elist.get(k).getetat()==false){
                 //change etat 
                 this.changeetat(elist.get(k),c);
                 break;
             }
         }
     }
     //verfier///////////////////////////////////////////
     public void setempfree(Employe e,int r){
         e.setetat(false);
         e.settimers(0);
         for(int m=0 ;m<clists.size();m++){
             if(clists.get(m).getid()==e.getidc()){
                 clist.get(m).setdtime(r);
             }
         }
     }
    
    public void apdaterts(int r){
        for(int l=0;l<elist.size();l++){
            if(elist.get(l).getetat()==true){
                elist.get(l).changetimers();
             System.out.println("\n ....CLIENT N° :"+elist.get(l).getidc());   
                elist.get(l).affich();
                if(elist.get(l).gettimers()==0){
                this.setempfree(elist.get(l),r);
            }
            }
            
        }
    }
    ///////////////////
    public int getnbrclientserv(){
        return this.nombreclientserv;
    }
    public int tmoyensercls(){
        this.maxs=clist.get(0).getstime();
        this.mins=clist.get(0).getstime();
        for(int l=0;l<clist.size();l++){
            if(clist.get(l).getstime()<this.mins){
                this.mins=clist.get(l).getstime();
            }else{
               if(clist.get(l).getstime()>this.maxs){
                this.maxs=clist.get(l).getstime();
            } 
            }
        }
        this.tmsclient=((this.mins+this.maxs)/2);
        return this.tmsclient;
    }
    public void minmax(){
         maxo=clist.get(0).getstime();
         mino=clist.get(0).getstime();
        for(int l =0;l<clists.size();l++){
             if(clists.get(l).getstime()<this.mino){
            this.mino=clists.get(l).getstime();
        }else{
           if(clists.get(l).getstime()>this.maxo){
            this.maxo=clists.get(l).getstime();
        }  
        }
        }
    }
 public void ptoccE(int duree){
     int d =duree;
     this.minmax();
     System.out.println(" \n max em ser "+ this.maxo+" \n min em ser "+ this.mino);
     DecimalFormat _numberFormat= new DecimalFormat("#0.000");
     int min = this.mino;
     int max = this.maxo;
     double to=(double)  (min+max)/2;
    double t= (double)(to/d);
     System.out.println("\n "+t+" "+to +" "+ d);
     this.ptocc=(t*100);
    
 } 
 public double getpt(){
     
     return this.ptocc;
 }
 public void affichcs(){
     System.out.println(".......................SERVE CLIENTS........................");
     for(int l=0;l<clists.size();l++){
         System.out.println("\n Client N° :"+clist.get(l).getid());
         System.out.println("\n... Client arrive :"+clist.get(l).getatime());
         System.out.println("\n....Client client departur :"+clist.get(l).getdtime());
        

        
     }
 }
}
