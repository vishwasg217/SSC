import java.util.Arrays;
import java.util.Scanner;

class process {
    int pid;
    int at;
    int bt;
    int wt = 0;
    int tat = 0;
    boolean finished=false;
}


public class mysrtf{ 

    public static int getProcess(process[] pcopy,int time)
        { 
        
            int minbt=100;
            int procid=0;
            for(int i=0;i<pcopy.length;i++)
            { 
                if((pcopy[i].at<=time)&& pcopy[i].finished==false)
                { 
                    if(pcopy[i].bt<minbt)
                    { 
                        minbt=pcopy[i].bt;
                        procid=i;
                    }
                }
            }
            return procid;
        }
    public static void main(String[] args)
    { 
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of processes"); 
        int n=sc.nextInt();
        System.out.println("Enter the details of processes");
        process[] p=new process[n];
        for(int i=0;i<n;i++)
        {
            p[i]=new process();
            p[i].pid=i;
            System.out.println("Enter the arrival time");
            p[i].at=sc.nextInt();
            System.out.println("Enter the burst time");
            p[i].bt=sc.nextInt();
        }
        System.out.println(" Process id\tarrival time\tburst time\twaiting time\tturn around time");
        int totaltime=0;
        int index;
        for(int i=0;i<n;i++)
        { 
            System.out.println(p[i].pid+" \t"+p[i].at+"\t"+p[i].bt);
            totaltime+=p[i].bt;
        }
        //processy[] pcopy=Arrays.copyOf(p, p.length);
        process[] pcopy = new process[p.length];
        for (int i = 0; i < p.length; i++) {
            pcopy[i] = new process();
            pcopy[i].pid = p[i].pid;
            pcopy[i].at = p[i].at;
            pcopy[i].bt = p[i].bt;
            pcopy[i].wt = p[i].wt;
            pcopy[i].tat = p[i].tat;
            pcopy[i].finished = p[i].finished;
        }
        int time; 
        int completetime;
        int waittime; 
        for(time=0;time<totaltime;time++)
        { 
            System.out.println("at time :"+time); 
            System.out.println(" process " +(getProcess(pcopy,time)+1)+"  is being executed"); 
            System.out.println();
            index=getProcess(pcopy,time);
            pcopy[index].bt--;
            if(pcopy[index].bt==0)
            { 
                pcopy[index].finished=true;
                p[index].wt=time+1-p[index].at-p[index].bt; // wt = time + 1 - arrival time - burst time
                p[index].tat=p[index].wt+p[index].bt; // tat = wt + bt
            }
        }
        System.out.println(" Process id\tarrival time\tburst time\twaiting time\tturn around time");
        for(int i=0;i<n;i++)
        { 
            System.out.println(p[i].pid+" \t"+p[i].at+"\t"+p[i].bt);
        }
    }

}