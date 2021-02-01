import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task40 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<String> routes = new ArrayList<String>();
        System.out.println("Enter route information of 15 entries:\n");
        for(int i=0; i<15; i++){
            routes.add(s.nextLine());
        }
        String[] routes1 = new String[5];
        System.out.println("SNo."+"\t"+"From"+"\t"+"To"+"\t"+"Distance in Kms"+"\t"+"Travel Time"+"\t"+"Typical Airfare");
        for(int i=0; i<15;i++){
            int j=0;
            routes1 = routes.get(i).split(",");
            System.out.print((i+1)+".\t"+routes1[j]+"\t"+routes1[j+1]+"\t"+routes1[j+2]+"\t"+routes1[j+3]+"\t"+routes1[j+4]+"\n");
        }System.out.println("\n\n");

        System.out.println("Enter source city for direct flights:"); String fromCity= s.nextLine();
        Task40.showDirectFlights(routes, fromCity);
        System.out.println("Enter source city and Destination city for direct/connected flights:");
        fromCity= s.next();
        System.out.println("Enter destination city");
        String toCity = s.next();
        Task40.showAllConnections(routes, fromCity, toCity);


        s.close();
    }

    private static void showAllConnections(ArrayList<String> routes, String fromCity, String toCity) {
        String routes1[] = new String[routes.size()];
        String routes2[] = new String[routes.size()];
        String routes3[] = new String[routes.size()];
        String fromconn[] = new String[routes.size()];
        String toconn[] = new String[routes.size()]; int a=0,b=0,i=0;int c=0;
        System.out.println("\nSNo.\t\tFrom\t\tTo\tDistanceinKms\tTravel Time\tTypical Airfare");
        // for(int i=0;i<routes.size();i++){
            for(int j=0;j<routes.size();j++){
                routes1 = routes.get(j).split(",");routes1[0] = routes1[0].trim();routes1[1] = routes1[1].trim();
                if((routes1[0].equals(fromCity)) && (routes1[1].equals(toCity))){
                    System.out.print((c+1)+"\t\t"+routes1[0]+"\t\t"+routes1[1]+"\t\t"+routes1[2]+"\t"+routes1[3]+"\t"+routes1[4]+"\n");
                    c++;
                }
                if(routes1[0].equals(fromCity)){
                    fromconn[a] = routes1[1]; 
                    a++;
                }
                
                if(routes1[1].equals(toCity)){
                    toconn[b] = routes1[0]; 
                    b++;
                }
            }
        // }

        // for(i=0;i<routes.size();i++){
            
            for(int j=0;j<fromconn.length;j++){
                routes1 = routes.get(j).split(","); routes1[0] = routes1[0].trim();routes1[1] = routes1[1].trim();
                if(fromCity.equals(routes1[0])){
                for(int x=0;x<fromconn.length;x++){
                        if(routes1[1].equals(fromconn[x])){
                            for(i=0; i<routes.size();i++){
                                routes2= routes.get(i).split(",");
                                for(int m=0;m<5;m++){
                                    routes1[m] =routes1[m].trim();
                                    routes2[m] =routes2[m].trim();
                                }
                                //  routes2[0] = routes2[0].trim();routes2[1] = routes2[1].trim();
                                if(routes1[1].equals(routes2[0]) && routes2[1].equals(toCity)){
                                    System.out.print((c+1)+"\t\t"+routes1[0]+"\t\t"+routes1[1]+"\t\t"+routes1[2]+"\t"+routes1[3]+"\t"+routes1[4]+"\n");c++;
                                    System.out.print(" \t\t"+routes2[0]+"\t\t"+routes2[1]+"\t\t"+routes2[2]+"\t"+routes2[3]+"\t"+routes2[4]+"\n");                  
                                    int d=Integer.parseInt(routes1[2]); int v=  Integer.parseInt(routes2[2]);
                                    int dist =  d +v ; int cur1=0,cur2=0;
                                    final float GBP	=94.5f;final float EUR	=85.37f; final float USD=74.3f; String cur = "INR"; 
                                    String temp = (routes1[4].substring(0,3)); int amnt = Integer.parseInt((routes1[4].substring(3,routes1[4].length())));
                                    String temp1 = (routes2[4].substring(0,3)); int amnt1 = Integer.parseInt((routes2[4].substring(3,routes2[4].length())));  
                                    int tot1=amnt,tot2=amnt1;
                                    int tot3;

                                    // if(!(routes1[4].substring(0,3)).equals(cur) || !((routes2[4].substring(0,3)).equals(cur))){
                                    if(!(routes1[4].substring(0,3)).equals(cur)){  float inr=0f;
                                         
                                        if(temp.equals("GBP")){ inr = GBP*amnt;}
                                        else if(temp.equals("EUR")){ inr = EUR*amnt;}
                                        else if(temp.equals("USD")){ inr = USD*amnt;}

                                        cur1 = (int) inr;
                                        tot1 =(int) cur1+amnt;
                                    } 

                                    if(!(routes2[4].substring(0,3)).equals(cur)){  float inr=0f;
                                       
                                        if(temp1.equals("GBP")){ inr = GBP*amnt;}
                                        else if(temp1.equals("EUR")){ inr = EUR*amnt;}
                                        else if(temp1.equals("USD")){ inr = USD*amnt;}
                                        cur2 = (int) inr; tot2 = (int) cur2+amnt1;
                                    } 
                                    // tot3 = tot1+tot2;
                                    // } else 
                                    tot3 = tot1+tot2;
                                    String split[] = new String[2]; String split1[] = new String[2];
                                    split = routes1[3].split(":"); split[1] = split[1].trim();split[0] = split[0].trim();
                                    split1 = routes2[3].split(":"); split1[1] = split1[1].trim(); split1[0] = split1[0].trim();
                                    int hr = Integer.parseInt(split[0]); int min= Integer.parseInt(split[1]);
                                    int hr1 = Integer.parseInt(split1[0]); int min1= Integer.parseInt(split1[1]);
                                
                                    int hour =  hr+hr1; int minutes = min+min1;

                                    if(minutes>=60){
                                        if(minutes ==60){
                                            minutes = 00;
                                            hour = hour+1;
                                        }else {
                                            int f =minutes%60;
                                        minutes = f; hour = hour+1;
                                        }
                                        
                                    }

                                    System.out.print(" \t\t\t"+"Total\t\t"+ dist+"\t\t"+hour+":"+minutes+"\tINR"+tot3+"\n");                              
                                    
                                }
                            }      
                        }   
                    }
                    
                }
            }
      
    }

    private static String[] showDirectFlights(ArrayList<String> routes, String fromCity) {
        System.out.println("-----------------showDirectFlights----------------");
        String routes2[] = new String[routes.size()];
        String temp[] = new String[routes.size()]; int a=0;
        for(int i=0; i<15;i++){
            int j=0;
            temp = routes.get(i).split(",");
            if(temp[j].equals(fromCity)){
                a++;
            }
        }

        String routes3[] = new String[a]; int b=0;
        System.out.println("\nSNo.\tFrom\tTo\tDistance in Kms\tTravel Time\tTypical Airfare");
        for(int i=0; i<15;i++){
            int j=0;
            routes2 = routes.get(i).split(",");         
            if(routes2[j].equals(fromCity)){
                routes3[b] = routes2[j+1]; b++;
            }
        }
        Arrays.sort(routes3);
        System.out.println();
        // for(int i=0; i<routes3.size();i++){
        //     System.out.println(routes3[i]);
        // }
        
        for(int i=0;i<routes3.length;i++){
            for(int j=0;j<15;j++){
                routes2 = routes.get(j).split(",");      
                if(routes3[i].equals(routes2[1]) && fromCity.equals(routes2[0])){
                    System.out.print((i+1)+"\t"+routes2[0]+"\t"+routes3[i]+"\t"+routes2[2]+"\t"+routes2[3]+"\t"+routes2[4]+"\n");
                }
            }
        }System.out.println("\n");
        return routes2;
    }
    
}
