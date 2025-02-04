import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String v=in.nextLine();
        String[] arr = v.split(" ");
        Stack<String> s=new Stack<String>();
        Stack<String> tes=new Stack<String>();
        for (int i= arr.length-1;i>=0;i--){
         s.push(arr[i]);
         tes.push(arr[i]);
        }
        if (!test(tes)){
            System.out.println("bracket error");
        }
        else {
        String result=jamm(zarbt(paran(s)));
        System.out.println(result);
    }
    }
    static   boolean test (Stack<String> s){
        Stack<String> aa=new Stack<String>();
        aa=s;
        boolean error1=false;
        boolean error2=false;
        int counterpbaz=0;
        int counterpbas=0;
        int counteramalgar=0;
        int counteradad=0;
        boolean adad=true;
        int size=s.size();
for (int i=0;i<size;i++){
if ("(".equals(aa.peek())){adad=false;counterpbaz++;}
if (")".equals(aa.peek())){adad=false;counterpbas++;}
if ("/".equals(aa.peek())||"+".equals(aa.peek())||"-".equals(aa.peek())||"*".equals(aa.peek())){adad=false;counteramalgar++;}
if (adad){counteradad++;}
adad=true;
aa.pop();

}
if (counterpbas==counterpbaz){
    error1=true;}
if (counteradad-1==counteramalgar){
    error2=true;}
       return  error1&&error2;
    }
        public static Stack<String> paran (Stack<String> s ){
        Stack<String> re=new Stack<String>();
        Stack<String> komak=new Stack<String>();
        int m=s.size();
        String result;
        boolean kom=true;
        boolean kommm=false;
        boolean sho=false;
        int counterbaz=1;
        int counterbast=0;
        Stack<String> rereverse=new Stack<String>();
        int resize;
        for (int i=0;i<100;i++){
            if (s.size()==0)
                break;
            if("(".equals(s.peek())){
                s.pop();
                kom=false;
                for (int j=0;j<100;j++){
                    if ("(".equals(s.peek()))
                        counterbaz++;
                    if (")".equals(s.peek())){
                        counterbast++;
                        if (counterbast<counterbaz)
                            re.push(s.pop());
                        if (counterbast==counterbaz)
                              break;
                    }
                   else re.push(s.pop());
                }
            }
            if (")".equals(s.peek())){
                sho=true;
                s.pop();
            }
            if (kom){
                komak.push(s.pop());
                kommm=true;
            }
            if (sho){
                resize=re.size();
                for (int z=0;z<resize;z++){
                    rereverse.push(re.pop());
                }
           result= jamm(zarbt(paran(rereverse)));
              s.push(result);
                if (kommm){
                    int k=komak.size();
                    for (int z=0;z<k;z++){
                        s.push(komak.pop());
                    }
                }
            }
            kom=true;
            sho=false;
        }
        int mm=komak.size();
        for (int k=0;k<mm;k++){
            s.push(komak.pop());
        }
        return s;
        }
        public static Stack zarbt(Stack<String>  s) {
            Stack<String> k = new Stack<String>();
            int m = s.size();
            int n = 0;
            int aaaa;
            int bbbb;
            String check;
            boolean a = true;
            k.push(s.pop());
            for (int i = 0; i < m; i++) {
                if (s.size()==0){break;}
                if ("*".equals(s.peek()) || "/".equals(s.peek())) {
                    a = false;
                    check = s.pop();
                    aaaa = Integer.parseInt(s.pop());
                    bbbb = Integer.parseInt(k.pop());
                    if (check.equals("*")) {
                        aaaa = aaaa * bbbb;
                        k.push(String.valueOf(aaaa));
                    }
                    if (check.equals("/")) {
                        aaaa = bbbb / aaaa;
                        k.push(String.valueOf(aaaa));
                    }
                }
                if (a) {
                    k.push(s.pop());
                }
                a=true;
            }
                return k;
            }
            public static String jamm (Stack < String > s) {
                int sum = 0;
                int m = s.size();
                Stack<String> k=new Stack<String>();
                for (int i=0;i<m;i++){
                    k.push(s.pop());
                }
                sum = Integer.parseInt(k.pop());
                for (int i = 0; i < m; i++) {
                    if (k.size()==0)
                        break;
                    if ( "+".equals(k.peek())) {
                        k.pop();
                        sum = sum + Integer.parseInt(k.pop());
                    }
                    else  {
                        k.pop();
                        sum = sum - Integer.parseInt(k.pop());
                    }
                }
                return String.valueOf(sum);
            }
        }
