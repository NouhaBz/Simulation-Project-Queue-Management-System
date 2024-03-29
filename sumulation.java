/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package l.miniproject;

import java.util.Scanner;

/**
 *
 * @author welcome
 */
public class sumulation {

    public static void main(String[] args) {
        System.out.println("..................Sumilation project .............");
        System.out.println("/n/n");
        
        System.out.println("\n name of agence  :");
       Scanner input = new Scanner (System.in);
        String name = input.nextLine();
         System.out.println("\n adress of agence  :");
        input = new Scanner (System.in);
        String adress = input.nextLine();
        
        Agence agence = new Agence(name ,adress);
        
        System.out.println("duree de la sumation :");
        input = new Scanner(System.in);
        int dureet = input.nextInt();
         System.out.println("\n nombre de emloyee :");
        input = new Scanner (System.in);
        int nemploy = input.nextInt();
        System.out.println("\n temps de service minimum :");
        input = new Scanner (System.in);
        int smin = input.nextInt();
        System.out.println("\n temps de service maximum :");
        input = new Scanner (System.in);
        int smax = input.nextInt();
        System.out.println("\n interval darrive client  :");
        input = new Scanner (System.in);
        int arrivc = input.nextInt();
        System.out.println("\n temps de^patience de client  :");
        input = new Scanner (System.in);
        int ptime = input.nextInt();
        
       Queue q =new Queue(ptime); 
        
        //crreat employee
        for(int j=0;j<nemploy;j++){
            agence.createmploye();
        }
        
        for (int i =1 ;i<=dureet;i++){
            
         System.out.println("\n===================================== new unit=======================================================");

             if(i%arrivc==0||i==1){
                ///creat client 
            Client c= agence.creatclient(i, smin, smax,ptime);
            
            if(agence.verfetae()==false){
                q.addclient(c);
              
            }else{
                if(q.falistsize()==0){
                     agence.getfreeemploy(c);
                }else{
                    q.addclient(c); 
                }
               
            }
            /*if (q.falistsize()>0){
                  q.addclient(c);
              }else{
                  if(agence.verfetae()==true){
                      
                  }
             }  µ*/
            }
            
            
             
             
            if(q.falistsize()>0){
                q.apdatetpatince();
            }
            agence.apdaterts(i);
            
           
            if(agence.verfetae()==true){
                if(q.falistsize()>0){
                    Client client = q.getfirstclient();
                    agence.getfreeemploy(client);
                    q.removefirst();
                }
            }
            
           
            
        }
                System.out.println("\n\n\n...........................................................................");

        agence.ptoccE(dureet);
        agence.affichcs();
        q.afichtp();
        
        System.out.println("La duree : "+dureet);
        System.out.println("\n nombre de client servis : "+agence.getnbrclientserv());
        System.out.println("\n temps attend moyen de client : "+q.moyenatt());
        System.out.println("\n temps moyen servis : "+agence.tmoyensercls());
        System.out.println("\n taux occopat : "+agence.getpt()+" %");
        System.out.println("\n nobre client non servis : "+q.ncnons());


        
    }
}
