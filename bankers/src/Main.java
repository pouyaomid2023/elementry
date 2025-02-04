import java.util.Scanner;
public class Main{
    public int numprocesses;
    public int numresources;
    public int[][] allocation;
    public int[][] max;
    public int[][] need;
    public int[] available;
    public Main(int numprocesses, int numresources){
        this.numprocesses = numprocesses;
        this.numresources = numresources;
        allocation = new int[numprocesses][numresources];
        max = new int[numprocesses][numresources];
        need = new int[numprocesses][numresources];
        available = new int[numresources];
    }
    //calculate need
    public void calculateneed(){
        for(int i=0;i<numprocesses;i++){
            for(int j=0;j<numresources;j++){
                need[i][j]=max[i][j]-allocation[i][j];}}}
    public boolean issafe(){
        calculateneed();
        boolean[] finish=new boolean[numprocesses];
        for (int i=0;i<numprocesses;i++){
            finish[i]=false;
        }
        int[] work=available.clone();
        String safesequence="";

        for(int count=0;count<numprocesses;count++){
            boolean found=false;
            for(int i=0;i<numprocesses;i++){
                if(!finish[i]){
                    int j;
                    for(j=0;j<numresources;j++){
                        if(need[i][j]>work[j]){
                            break;
                        }}
                    if(j==numresources){
                        for(int k=0;k<numresources;k++){
                            work[k]+=allocation[i][k];
                        }
                        int v=i+1;
                        safesequence+="P"+v+" ";
                        finish[i]=true;
                        found=true;
                    }}}
            boolean res=true;
            for (int h=0;h<finish.length;h++){
                if (!finish[h]){
                res =false;}
            }

            if(!found&&!res){
                System.out.println("System is not in a safe state.");
                return false;
            }}

        System.out.println("System is in a safe state.");
        System.out.println("Safe sequence is: " + safesequence);
        return true;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int numprocesses=sc.nextInt();
        System.out.print("Enter number of resource types: ");
        int numresources=sc.nextInt();

        Main b=new Main(numprocesses,numresources);

        System.out.println("Enter Allocation Matrix:");
        for(int i=0;i<numprocesses;i++){
            for(int j=0;j<numresources;j++){
                b.allocation[i][j]=sc.nextInt();
            }}

        System.out.println("Enter Max Matrix:");
        for(int i=0;i<numprocesses;i++){
            for(int j=0;j<numresources;j++){
                b.max[i][j]=sc.nextInt();
            }}

        System.out.println("Enter Available Vector:");
        for(int j=0;j<numresources;j++) {
            b.available[j]=sc.nextInt();
        }
        b.issafe();
        sc.close();
    }}