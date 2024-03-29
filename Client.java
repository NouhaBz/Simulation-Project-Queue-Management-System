/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l.miniproject;

/**
 *
 * @author welcome
 */
public class Client {
    private int id ;
    private int tpr;
    private int atime ;
    private int stime ;
    private int dtime ;
    private int ptime;
    public Client (int id ,int  atime ){
        this.id = id ;
        this.atime = atime ;
   
    }
    public int settpr(){
        return this.tpr=(this.dtime-this.atime)-this.stime;
    }
    
    public int getid(){
        return this.id;
    }
    
    public int setdtime(int thedtime){
        int d = this.atime+this.stime;
       return this.dtime=d;
    }
    public int setstime(int thestime){
        return this.stime =thestime;
    }
    public int getatime(){
        return this.atime;
    }
    public int getdtime(){
          return this.dtime;
    }
    public int getstime(){
        return this.stime;
    }
    public int getptime(){
       return this.ptime;
    }
    public int setptime(int t){
        return this.ptime=t;
    }
    public int changeptime(){
        int newpt =this.ptime-1;
        return this.ptime=newpt;
        
    }
}
