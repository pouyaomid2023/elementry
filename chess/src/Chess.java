import java.util.Scanner;

public class Chess extends Safhe{
    public  static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String vorudi[] = new String[n];
        char vorudi2[][] = new char[4][n];
        for (int i = 0; i < n; i++) {
            vorudi[i] = in.next();
        }
        for (int i = 0; i < n; i++) {
            vorudi2[0][i] = vorudi[i].charAt(0);
            vorudi2[1][i] = vorudi[i].charAt(1);
            vorudi2[2][i] = vorudi[i].charAt(2);
            int tab=Integer.parseInt(String.valueOf(vorudi[i].charAt(3)));
            String tab2=tab-1+"";
            vorudi2[3][i]=tab2.charAt(0);

        }
        for (int i = 0; i < n; i++) {
            if (vorudi2[2][i] == 'A') {
                vorudi2[2][i] = '0';
            }
            if (vorudi2[2][i] == 'B') {
                vorudi2[2][i] = '1';
            }
            if (vorudi2[2][i] == 'C') {
                vorudi2[2][i] = '2';
            }
            if (vorudi2[2][i] == 'D') {
                vorudi2[2][i] = '3';
            }
            if (vorudi2[2][i] == 'E') {
                vorudi2[2][i] = '4';
            }
            if (vorudi2[2][i] == 'F') {
                vorudi2[2][i] = '5';
            }
            if (vorudi2[2][i] == 'G') {
                vorudi2[2][i] = '6';
            }
            if (vorudi2[2][i] == 'H') {
                vorudi2[2][i] = '7';
            }
        }
        int m = in.nextInt();
        char[][] makan1 = new char[2][m];
        char[][] makan2 = new char[2][m];
        String[] vorudisoal = new String[m];
        for (int i = 0; i < m; i++) {
            vorudisoal[i] = in.next();
        }
        int tab3,tab5;
        for (int i = 0; i < m; i++) {
            makan1[0][i] = vorudisoal[i].charAt(0);
            tab5=Integer.parseInt(String.valueOf(vorudisoal[i].charAt(1)));
            String tab6=tab5-1+"";
            makan1[1][i] = tab6.charAt(0);
            makan2[0][i] = vorudisoal[i].charAt(2);
            tab3=Integer.parseInt(String.valueOf(vorudisoal[i].charAt(3)));
            String tab4=tab3-1+"";
            makan2[1][i] = tab4.charAt(0);
        }
        for (int i = 0; i < m; i++) {
            if (makan1[0][i] == 'A') {
                makan1[0][i] = '0';
            }
            if (makan1[0][i] == 'B') {
                makan1[0][i] = '1';
            }
            if (makan1[0][i] == 'C') {
                makan1[0][i] = '2';
            }
            if (makan1[0][i] == 'D') {
                makan1[0][i] = '3';
            }
            if (makan1[0][i] == 'E') {
                makan1[0][i] = '4';
            }
            if (makan1[0][i] == 'F') {
                makan1[0][i] = '5';
            }
            if (makan1[0][i] == 'G') {
                makan1[0][i] = '6';
            }
            if (makan1[0][i] == 'H') {
                makan1[0][i] = '7';
            }
        }
        for (int i = 0; i < m; i++) {
            if (makan2[0][i] == 'A') {
                makan2[0][i] = '0';
            }
            if (makan2[0][i] == 'B') {
                makan2[0][i] = '1';
            }
            if (makan2[0][i] == 'C') {
                makan2[0][i] = '2';
            }
            if (makan2[0][i] == 'D') {
                makan2[0][i] = '3';
            }
            if (makan2[0][i] == 'E') {
                makan2[0][i] = '4';
            }
            if (makan2[0][i] == 'F') {
                makan2[0][i] = '5';
            }
            if (makan2[0][i] == 'G') {
                makan2[0][i] = '6';
            }
            if (makan2[0][i] == 'H') {
                makan2[0][i] = '7';
            }
        }

        for (int i = 0; i < n; i++) {
            if (vorudi2[0][i] == 'W' && vorudi2[1][i] == 'K') {
                Kingwhite wk = new Kingwhite();
                wk.makanking(vorudi2[2][i], vorudi2[3][i]);
            }
            if (vorudi2[0][i] == 'W' && vorudi2[1][i] == 'Q') {
                Vazirwhite wv = new Vazirwhite();
                wv.makanvazir(vorudi2[2][i], vorudi2[3][i]);
            }
            if (vorudi2[0][i] == 'W' && vorudi2[1][i] == 'B') {
                Fillwhite wf = new Fillwhite();
                wf.makanfill(vorudi2[2][i], vorudi2[3][i]);
            }
            if (vorudi2[0][i] == 'W' && vorudi2[1][i] == 'N') {
                Asbwhite wa = new Asbwhite();
                wa.makanasb(vorudi2[2][i], vorudi2[3][i]);
            }
            if (vorudi2[0][i] == 'W' && vorudi2[1][i] == 'R') {
                Rokhwhite wr = new Rokhwhite();
                wr.makanrokh(vorudi2[2][i], vorudi2[3][i]);
            }
            if (vorudi2[0][i] == 'W' && vorudi2[1][i] == 'P') {
                Sarbazwhite ws = new Sarbazwhite();
                ws.makansarbaz(vorudi2[2][i], vorudi2[3][i]);
            }
            //
            if (vorudi2[0][i] == 'B' && vorudi2[1][i] == 'K') {
                Kingblack bk = new Kingblack();
                bk.makanking(vorudi2[2][i], vorudi2[3][i]);
            }
            if (vorudi2[0][i] == 'B' && vorudi2[1][i] == 'Q') {
                Vazirblack bv = new Vazirblack();
                bv.makanvazir(vorudi2[2][i], vorudi2[3][i]);
            }
            if (vorudi2[0][i] == 'B' && vorudi2[1][i] == 'B') {
                Fillblack bf = new Fillblack();
                bf.makanfill(vorudi2[2][i], vorudi2[3][i]);
            }
            if (vorudi2[0][i] == 'B' && vorudi2[1][i] == 'N') {
                Asbblack ba = new Asbblack();
                ba.makanasb(vorudi2[2][i], vorudi2[3][i]);
            }
            if (vorudi2[0][i] == 'B' && vorudi2[1][i] == 'R') {
                Rokhblack br = new Rokhblack();
                br.makanrokh(vorudi2[2][i], vorudi2[3][i]);
            }
            if (vorudi2[0][i] == 'B' && vorudi2[1][i] == 'P') {
                Sarbazblack bs = new Sarbazblack();
                bs.makansarbaz(vorudi2[2][i], vorudi2[3][i]);
            }
        }
        //for (int i=0;i<8;i++){
        //for (int j=0;j<8;j++)
        // System.out.println(a[4][1]);
        //}
        for (int i=0;i<m;i++){
            int ae=Integer.parseInt(String.valueOf(makan1[0][i])),be=Integer.parseInt(String.valueOf(makan1[1][i]));

            if (a[ae][be]=="kw"){
                Kingwhite kww=new Kingwhite();
                kww.checksoal(makan1[0][i],makan1[1][i],makan2[0][i],makan2[1][i]);
            }
            if (a[ae][be]=="kb"){
                Kingblack kbb=new Kingblack();
                kbb.checksoal(makan1[0][i],makan1[1][i],makan2[0][i],makan2[1][i]);
            }
            if (a[ae][be]=="vw"){
                Vazirwhite vww=new Vazirwhite();
                vww.checksoal(makan1[0][i],makan1[1][i],makan2[0][i],makan2[1][i]);
            }
            if (a[ae][be]=="vb"){
                Vazirblack vbb=new Vazirblack();
                vbb.checksoal(makan1[0][i],makan1[1][i],makan2[0][i],makan2[1][i]);
            }
            if (a[ae][be]=="rw"){
                Rokhwhite rww=new Rokhwhite();
                rww.checksoal(makan1[0][i],makan1[1][i],makan2[0][i],makan2[1][i]);
            }
            if (a[ae][be]=="rb"){
                Rokhblack rbb=new Rokhblack();
                rbb.checksoal(makan1[0][i],makan1[1][i],makan2[0][i],makan2[1][i]);
            }
            if (a[ae][be]=="fw"){
                Fillwhite fww=new Fillwhite();
                fww.checksoal(makan1[0][i],makan1[1][i],makan2[0][i],makan2[1][i]);
            }
            if (a[ae][be]=="fb"){
                Fillblack fbb=new Fillblack();
                fbb.checksoal(makan1[0][i],makan1[1][i],makan2[0][i],makan2[1][i]);
            }
            if (a[ae][be]=="aw"){
                Asbwhite aww=new Asbwhite();
                aww.checksoal(makan1[0][i],makan1[1][i],makan2[0][i],makan2[1][i]);
            }
            if (a[ae][be]=="ab"){
                Asbblack abb=new Asbblack();
                abb.checksoal(makan1[0][i],makan1[1][i],makan2[0][i],makan2[1][i]);
            }
            if (a[ae][be]=="sw"){
                Sarbazwhite sww=new Sarbazwhite();
                sww.checksoal(makan1[0][i],makan1[1][i],makan2[0][i],makan2[1][i]);
            }
            if (a[ae][be]=="sb"){
                Sarbazblack sbb=new Sarbazblack();
                sbb.checksoal(makan1[0][i],makan1[1][i],makan2[0][i],makan2[1][i]);
            }
        }
    }
}
class Safhe{
    static String[][] a =new String[8][8];
}
class Kingwhite extends Safhe{
    public void makanking(char x,char y){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        a[c][d]="kw";

    }
    public int checksoal(char x,char y,char m,char n){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        int e=Integer.parseInt(String.valueOf(m));
        int f=Integer.parseInt(String.valueOf(n));
        boolean t=false;
        if ((d-f==1||d-f==-1)&&c==e){
            if(a[e][f]!=null&&a[e][f].charAt(1)=='b'){
                System.out.println("TAKE");
                }
                if(a[e][f]!=null&&a[e][f].charAt(1)=='w'){
                    System.out.println("NO");
                }
                if(a[e][f]==null){
                    System.out.println("YES");
                }
            t=true;
        }
            if ((c-e==1||c-e==-1)&&f==d){
                    if(a[e][f]!=null&&a[e][f].charAt(1)=='b'){
                    System.out.println("TAKE");
                    }
                    if(a[e][f]!=null&&a[e][f].charAt(1)=='w'){
                        System.out.println("NO");
                    }
                    if(a[e][f]==null){
                        System.out.println("YES");
                    }
                    t=true;
                }
            if ((c-e==1||c-e==-1)&&(d-f==1||d-f==-1)){
                    if(a[e][f]!=null&&a[e][f].charAt(1)=='b') {
                    System.out.println("TAKE");
                     }
                    if(a[e][f]!=null&&a[e][f].charAt(1)=='w'){
                        System.out.println("NO");
                     }
                    if(a[e][f]==null){
                        System.out.println("YES");
                     }
                    t=true;
                }

        if(t==false) {
            System.out.println("NO");
        }

        return 0;
    }

}
class Vazirwhite extends Safhe{
    public void makanvazir(char x,char y){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        a[c][d]="vw";

    }
    public int checksoal(char x,char y,char m,char n){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        int e=Integer.parseInt(String.valueOf(m));
        int f=Integer.parseInt(String.valueOf(n));
        boolean k=false;
        int meg;
        if (f==d){
            meg=e-c;
            if (meg>0){
                for (int z=c+1;z<e;z++){
                    if (a[z][d]!=null)
                        k=true;
                }}
            if (meg<0){
                for (int z=c-1;z>e;z--){
                    if (a[z][d]!=null)
                        k=true;
                }}
        }
        if (e==c){
            meg=f-d;
            if (meg>0){
                for (int z=d+1;z<f;z++){
                    if (a[c][z]!=null)
                        k=true;
                }}
            if (meg<0){
                for (int z=d-1;z>f;z--){
                    if (a[c][z]!=null)
                        k=true;
                }}
        }
        boolean h=false;
        int megg;
        if (e-c==f-d) {
            megg=e-c;
            int o;
            if (megg>0){
                o=d+1;
                for (int z=c+1;z<e;z++){
                    if(a[z][o]!=null)
                        h=true;
                    o++;
                }}
            if (megg<0){
                o=d-1;
                for (int z=c-1;z>e;z--){
                    if(a[z][o]!=null)
                        h=true;
                    o--;
                }}
        }
        boolean q=false;
        int meggg;
        if (e-c==-(f-d)) {
            meggg=e-c;
            int oo;
            if (meggg>0){
                oo=d-1;
                for (int z=c+1;z<e;z++){
                    if(a[z][oo]!=null)
                        q=true;
                    oo--;
                }}
            if (meggg<0){
                oo=d+1;
                for (int z=c-1;z>e;z--){
                    if(a[z][oo]!=null)
                        q=true;
                    oo++;
                }}
        }

        boolean l=false;
        if ((c==e||d==f)&&a[e][f]==null&&k==false){
            System.out.println("YES");
            l=true;
        }
        if ((c==e||d==f)&&a[e][f]!=null&&k==false){
            if (a[e][f].charAt(1)=='b')
                System.out.println("TAKE");
            else
                System.out.println("NO");
            l=true;
        }
        if ((e-c==f-d)&&a[e][f]==null&&h==false){
            System.out.println("YES");
            l=true;
        }
        if ((e-c==f-d)&&a[e][f]!=null&&h==false){
            if (a[e][f].charAt(1)=='b')
                System.out.println("TAKE");
            else
                System.out.println("NO");
            l=true;
        }
        if ((e-c==-(f-d))&&a[e][f]==null&&q==false){
            System.out.println("YES");
            l=true;
        }
        if ((e-c==-(f-d))&&a[e][f]!=null&&q==false){
            if (a[e][f].charAt(1)=='b')
                System.out.println("TAKE");
            else
                System.out.println("NO");
            l=true;
        }
        if(l==false){
            System.out.println("NO");
        }


        return 0;
    }
}
class Fillwhite extends Safhe{
    public void makanfill(char x,char y){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        a[c][d]="fw";

    }
    public int checksoal(char x,char y,char m,char n){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        int e=Integer.parseInt(String.valueOf(m));
        int f=Integer.parseInt(String.valueOf(n));
        boolean h=false;
        int megg;
        if (e-c==f-d) {
            megg=e-c;
            int o;
            if (megg>0){
                o=d+1;
                for (int z=c+1;z<e;z++){
                    if(a[z][o]!=null)
                        h=true;
                    o++;
                }}
            if (megg<0){
                o=d-1;
                for (int z=c-1;z>e;z--){
                    if(a[z][o]!=null)
                        h=true;
                    o--;
                }}
        }
        boolean q=false;
        int meggg;
        if (e-c==-(f-d)) {
            meggg=e-c;
            int oo;
            if (meggg>0){
                oo=d-1;
                for (int z=c+1;z<e;z++){
                    if(a[z][oo]!=null)
                        q=true;
                    oo--;
                }}
            if (meggg<0){
                oo=d+1;
                for (int z=c-1;z>e;z--){
                    if(a[z][oo]!=null)
                        q=true;
                    oo++;
                }}
        }
        boolean l=false;
        int count=0;
        if ((e-c==f-d)&&a[e][f]==null&&h==false){
            System.out.println("YES");
            l=true;
            count=1;
        }
        if ((e-c==f-d)&&a[e][f]!=null&&h==false){

            if (a[e][f].charAt(1)=='b'){
                System.out.println("TAKE");
            count=1;}
            else{
                System.out.println("NO");}
            l=true;
        }
        if ((e-c==-(f-d))&&a[e][f]==null&&q==false){
            System.out.println("YES");
            l=true;
            count=1;
        }
        if ((e-c==-(f-d))&&a[e][f]!=null&&q==false){
            if (a[e][f].charAt(1)=='b'){
                System.out.println("TAKE");
            count=1;}
            else{
                System.out.println("NO");}
            l=true;
        }
        if(count==0) {
            System.out.println("NO");
        }

        return 0;
    }
}
class Asbwhite extends Safhe{
    public void makanasb(char x,char y){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        a[c][d]="aw";

    }
    public int checksoal(char x,char y,char m,char n){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        int e=Integer.parseInt(String.valueOf(m));
        int f=Integer.parseInt(String.valueOf(n));
        boolean t=false;
        if (e-c==2&&(d+1==f||d-1==f)&&a[e][f]==null){
            System.out.println("YES");
            t=true;
        }
        if (c-e==2&&(d+1==f||d-1==f)&&a[e][f]==null){
            System.out.println("YES");
            t=true;
        }
        if (d-f==2&&(c+1==e||c-1==e)&&a[e][f]==null){
            System.out.println("YES");
            t=true;
        }
        if (f-d==2&&(c+1==e||c-1==e)&&a[e][f]==null){
            System.out.println("YES");
            t=true;
        }
        if (e-c==2&&(d+1==f||d-1==f)&&a[e][f]!=null){
            if (a[e][f].charAt(1)=='b')
            System.out.println("TAKE");
            if (a[e][f].charAt(1)=='w')
                System.out.println("NO");
            t=true;
        }
        if (c-e==2&&(d+1==f||d-1==f)&&a[e][f]!=null){
            if (a[e][f].charAt(1)=='b')
                System.out.println("TAKE");
            if (a[e][f].charAt(1)=='w')
                System.out.println("NO");
            t=true;
        }
        if (d-f==2&&(c+1==e||c-1==e)&&a[e][f]!=null){
            if (a[e][f].charAt(1)=='b')
                System.out.println("TAKE");
            if (a[e][f].charAt(1)=='w')
                System.out.println("NO");
            t=true;
        }
        if (f-d==2&&(c+1==e||c-1==e)&&a[e][f]!=null){
            if (a[e][f].charAt(1)=='b')
                System.out.println("TAKE");
            if (a[e][f].charAt(1)=='w')
                System.out.println("NO");
            t=true;
        }
        if (t==false){
            System.out.println("NO");
        }
        return 0;
    }
}
class Rokhwhite extends Safhe{
    public void makanrokh(char x,char y){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        a[c][d]="rw";

    }
    public int checksoal(char x,char y,char m,char n){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        int e=Integer.parseInt(String.valueOf(m));
        int f=Integer.parseInt(String.valueOf(n));
        boolean k=false;
        int meg;
        if (f==d){
            meg=e-c;
            if (meg>0){
                for (int z=c+1;z<e;z++){
                    if (a[z][d]!=null)
                        k=true;
                }}
            if (meg<0){
                for (int z=c-1;z>e;z--){
                    if (a[z][d]!=null)
                        k=true;
                }}
        }
        if (e==c){
            meg=f-d;
            if (meg>0){
                for (int z=d+1;z<f;z++){
                    if (a[c][z]!=null)
                        k=true;
                }}
            if (meg<0){
                for (int z=d-1;z>f;z--){
                    if (a[c][z]!=null)
                        k=true;
                }}
        }
        boolean l=false;
        if ((c==e||d==f)&&a[e][f]==null&&k==false){
            System.out.println("YES");
            l=true;
        }
        if ((c==e||d==f)&&(a[e][f]!=null)&&(k==false)){
            if (a[e][f].charAt(1)=='b')
                System.out.println("TAKE");
            else
                System.out.println("NO");
            l=true;
        }
        if (l==false){
            System.out.println("NO");
        }
        return 0;
    }
}
class Sarbazwhite extends Safhe{
    public void makansarbaz(char x,char y){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        a[c][d]="sw";

    }
    public int checksoal(char x,char y,char m,char n){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        int e=Integer.parseInt(String.valueOf(m));
        int f=Integer.parseInt(String.valueOf(n));
        boolean t = false;
        if (c==e&&f-d==1&&a[e][f]==null){
            System.out.println("YES");
            t=true;
        }
        if (d==1&&f-d==2&&a[e][f]==null&&c==e){
            System.out.println("YES");
            t=true;
        }
        if (f-d==e-c&&e-c==1&&a[e][f]!=null&&a[e][f].charAt(1)=='b'){
            System.out.println("TAKE");
            t=true;
        }
        if (f-d==c-e&&e-c==1&&a[e][f]!=null&&a[e][f].charAt(1)=='b'){
            System.out.println("TAKE");
            t=true;
        }
        if(t==false){
            System.out.println("NO");
        }
        return 0;
    }
}
//
class Kingblack extends Safhe{
    public void makanking(char x,char y){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        a[c][d]="kb";

    }
    public int checksoal(char x,char y,char m,char n){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        int e=Integer.parseInt(String.valueOf(m));
        int f=Integer.parseInt(String.valueOf(n));
        boolean t=false;
        if ((d-f==1||d-f==-1)&&c==e){
            if(a[e][f]!=null&&a[e][f].charAt(1)=='w'){
                System.out.println("TAKE");
            }
            if(a[e][f]!=null&&a[e][f].charAt(1)=='b'){
                System.out.println("NO");
            }
            if(a[e][f]==null){
                System.out.println("YES");
            }
            t=true;
        }
        if ((c-e==1||c-e==-1)&&f==d){
            if(a[e][f]!=null&&a[e][f].charAt(1)=='w'){
                System.out.println("TAKE");
            }
            if(a[e][f]!=null&&a[e][f].charAt(1)=='b'){
                System.out.println("NO");
            }
            if(a[e][f]==null){
                System.out.println("YES");
            }
            t=true;
        }
        if ((c-e==1||c-e==-1)&&(d-f==1||d-f==-1)){
            if(a[e][f]!=null&&a[e][f].charAt(1)=='w') {
                System.out.println("TAKE");
            }
            if(a[e][f]!=null&&a[e][f].charAt(1)=='b'){
                System.out.println("NO");
            }
            if(a[e][f]==null){
                System.out.println("YES");
            }
            t=true;
        }

        if(t==false) {
            System.out.println("NO");
        }

        return 0;
    }

}
class Vazirblack extends Safhe{
    public void makanvazir(char x,char y){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        a[c][d]="vb";

    }
    public int checksoal(char x,char y,char m,char n){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        int e=Integer.parseInt(String.valueOf(m));
        int f=Integer.parseInt(String.valueOf(n));
        boolean k=false;
        int meg;
        if (f==d){
            meg=e-c;
            if (meg>0){
                for (int z=c+1;z<e;z++){
                    if (a[z][d]!=null)
                        k=true;
                }}
            if (meg<0){
                for (int z=c-1;z>e;z--){
                    if (a[z][d]!=null)
                        k=true;
                }}
        }
        if (e==c){
            meg=f-d;
            if (meg>0){
                for (int z=d+1;z<f;z++){
                    if (a[c][z]!=null)
                        k=true;
                }}
            if (meg<0){
                for (int z=d-1;z>f;z--){
                    if (a[c][z]!=null)
                        k=true;
                }}
        }
        boolean h=false;
        int megg=0;
        int o=0;
        if (e-c==f-d) {
            megg=e-c;
            if (megg>0){
                o=d+1;
                for (int z=c+1;z<e;z++){
                    if(a[z][o]!=null)
                        h=true;
                    o++;
                }}
            if (megg<0){
                o=d-1;
                for (int z=c-1;z>e;z--){
                    if(a[z][o]!=null)
                        h=true;
                    o--;
                }}
        }
        boolean q=false;
        int meggg;
        if (e-c==-(f-d)) {
            meggg=e-c;
            int oo;
            if (meggg>0){
                oo=d-1;
                for (int z=c+1;z<e;z++){
                    if(a[z][oo]!=null)
                        q=true;
                    oo--;
                }}
            if (meggg<0){
                oo=d+1;
                for (int z=c-1;z>e;z--){
                    if(a[z][oo]!=null)
                        q=true;
                    oo++;
                }}
        }

        boolean l=false;
        if ((c==e||d==f)&&a[e][f]==null&&k==false){
            System.out.println("YES");
            l=true;
        }
        if ((c==e||d==f)&&a[e][f]!=null&&k==false){
            if (a[e][f].charAt(1)=='w')
                System.out.println("TAKE");
            else
                System.out.println("NO");
            l=true;
        }
        if ((e-c==f-d)&&a[e][f]==null&&h==false){
            System.out.println("YES");
            l=true;
        }
        if ((e-c==f-d)&&a[e][f]!=null&&h==false){
            if (a[e][f].charAt(1)=='w')
                System.out.println("TAKE");
            else
                System.out.println("NO");
            l=true;
        }
        if ((e-c==-(f-d))&&a[e][f]==null&&q==false){
            System.out.println("YES");
            l=true;
        }
        if ((e-c==-(f-d))&&a[e][f]!=null&&q==false){
            if (a[e][f].charAt(1)=='w')
                System.out.println("TAKE");
            else
                System.out.println("NO");
            l=true;
        }
        if(l==false){
            System.out.println("NO");
        }


        return 0;
    }
}
class Fillblack extends Safhe{
    public void makanfill(char x,char y){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        a[c][d]="fb";

    }
    public int checksoal(char x,char y,char m,char n){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        int e=Integer.parseInt(String.valueOf(m));
        int f=Integer.parseInt(String.valueOf(n));
        boolean h=false;
        int megg;
        if (e-c==f-d) {
            megg=e-c;
            int o;
            if (megg>0){
                o=d+1;
                for (int z=c+1;z<e;z++){
                    if(a[z][o]!=null)
                        h=true;
                    o++;
                }}
            if (megg<0){
                o=d-1;
                for (int z=c-1;z>e;z--){
                    if(a[z][o]!=null)
                        h=true;
                    o--;
                }}
        }
        boolean q=false;
        int meggg;
        if (e-c==-(f-d)) {
            meggg=e-c;
            int oo;
            if (meggg>0){
                oo=d-1;
                for (int z=c+1;z<e;z++){
                    if(a[z][oo]!=null)
                        q=true;
                    oo--;
                }}
            if (meggg<0){
                oo=d+1;
                for (int z=c-1;z>e;z--){
                    if(a[z][oo]!=null)
                        q=true;
                    oo++;
                }}
        }
        boolean l=false;
        int count=0;
        if ((e-c==f-d)&&a[e][f]==null&&h==false){
            System.out.println("YES");
            l=true;
            count=1;
        }
        if ((e-c==f-d)&&a[e][f]!=null&&h==false){

            if (a[e][f].charAt(1)=='w'){
                System.out.println("TAKE");
            count=1;}
            else{
                System.out.println("NO");}
            l=true;
        }
        if ((e-c==-(f-d))&&a[e][f]==null&&q==false){
            System.out.println("YES");
            l=true;
            count=1;
        }
        if ((e-c==-(f-d))&&a[e][f]!=null&&q==false){

            if (a[e][f].charAt(1)=='w'){
                System.out.println("TAKE");
            count=1;}
            else{
                System.out.println("NO");}
            l=true;
        }
        if(count==0) {
            System.out.println("NO");
        }
        return 0;
    }
}
class Asbblack extends Safhe{
    public void makanasb(char x,char y){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        a[c][d]="ab";

    }
    public int checksoal(char x,char y,char m,char n){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        int e=Integer.parseInt(String.valueOf(m));
        int f=Integer.parseInt(String.valueOf(n));
        boolean t=false;
        if (e-c==2&&(d+1==f||d-1==f)&&a[e][f]==null){
            System.out.println("YES");
            t=true;
        }
        if (c-e==2&&(d+1==f||d-1==f)&&a[e][f]==null){
            System.out.println("YES");
            t=true;
        }
        if (d-f==2&&(c+1==e||c-1==e)&&a[e][f]==null){
            System.out.println("YES");
            t=true;
        }
        if (f-d==2&&(c+1==e||c-1==e)&&a[e][f]==null){
            System.out.println("YES");
            t=true;
        }
        if (e-c==2&&(d+1==f||d-1==f)&&a[e][f]!=null){
            if (a[e][f].charAt(1)=='w')
                System.out.println("TAKE");
            if (a[e][f].charAt(1)=='b')
                System.out.println("NO");
            t=true;
        }
        if (c-e==2&&(d+1==f||d-1==f)&&a[e][f]!=null){
            if (a[e][f].charAt(1)=='w')
                System.out.println("TAKE");
            if (a[e][f].charAt(1)=='b')
                System.out.println("NO");
            t=true;
        }
        if (d-f==2&&(c+1==e||c-1==e)&&a[e][f]!=null){
            if (a[e][f].charAt(1)=='w')
                System.out.println("TAKE");
            if (a[e][f].charAt(1)=='b')
                System.out.println("NO");
            t=true;
        }
        if (f-d==2&&(c+1==e||c-1==e)&&a[e][f]!=null){
            if (a[e][f].charAt(1)=='w')
                System.out.println("TAKE");
            if (a[e][f].charAt(1)=='b')
                System.out.println("NO");
            t=true;
        }
        if (t==false){
            System.out.println("NO");
        }
        return 0;
    }
}
class Rokhblack extends Safhe{
    public void makanrokh(char x,char y){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        a[c][d]="rb";

    }
    public int checksoal(char x,char y,char m,char n){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        int e=Integer.parseInt(String.valueOf(m));
        int f=Integer.parseInt(String.valueOf(n));
        boolean k=false;
        int meg;
        if (f==d){
            meg=e-c;
            if (meg>0){
                for (int z=c+1;z<e;z++){
                    if (a[z][d]!=null)
                        k=true;
                }}
            if (meg<0){
                for (int z=c-1;z>e;z--){
                    if (a[z][d]!=null)
                        k=true;
                }}
        }
        if (e==c){
            meg=f-d;
            if (meg>0){
                for (int z=d+1;z<f;z++){
                    if (a[c][z]!=null)
                        k=true;
                }}
            if (meg<0){
                for (int z=d-1;z>f;z--){
                    if (a[c][z]!=null)
                        k=true;
                }}
        }
        boolean l=false;
        if ((c==e||d==f)&&a[e][f]==null&&k==false){
            System.out.println("YES");
            l=true;
        }
        if ((c==e||d==f)&&a[e][f]!=null&&k==false){
            if (a[e][f].charAt(1)=='w')
                System.out.println("TAKE");
            else
                System.out.println("NO");
            l=true;
        }
        if (l==false){
            System.out.println("NO");
        }
        return 0;
    }
}
class Sarbazblack extends Safhe{
    public void makansarbaz(char x,char y){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        a[c][d]="sb";

    }
    public int checksoal(char x,char y,char m,char n){
        int c=Integer.parseInt(String.valueOf(x));
        int d=Integer.parseInt(String.valueOf(y));
        int e=Integer.parseInt(String.valueOf(m));
        int f=Integer.parseInt(String.valueOf(n));
        boolean t = false;
        if (c==e&&d-f==1&&a[e][f]==null){
            System.out.println("YES");
            t=true;
        }
        if (d==6&&d-f==-2&&a[e][f]==null&&c==e){
            System.out.println("YES");
            t=true;
        }
        if (f-d==e-c&&e-c==-1&&a[e][f]!=null&&a[e][f].charAt(1)=='w'){
            System.out.println("TAKE");
            t=true;
        }
        if (f-d==c-e&&e-c==-1&&a[e][f]!=null&&a[e][f].charAt(1)=='w'){
            System.out.println("TAKE");
            t=true;
        }
        if(t==false){
            System.out.println("NO");
        }
        return 0;
    }
}