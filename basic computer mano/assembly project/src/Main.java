import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Memory obj;
    public static String lablefind(String a){
        boolean comma=false;
        int commaindex=0;
        String lable =null;
        boolean flag=true;

        for(int i=0;i<a.length();i++){
            if (a.charAt(i)==','){
                comma=true;
            commaindex=i;}
        }
        if (comma){
            if (a.substring(commaindex+1,commaindex+4).equals("HEX")||a.substring(commaindex+1,commaindex+4).equals("DEC")){
                flag=false;}
            if (flag){
                lable=a.substring(commaindex+5);

                for (int i=0;i<lable.length();i++){
                    if (lable.charAt(i)==' '){
                        lable=lable.substring(0,i);
                    }
                }
            }
        }
        else {
            lable=a.substring(4);
            for (int i=0;i<lable.length();i++){
                if (lable.charAt(i)==' '){
                    lable=lable.substring(0,i);
                }
            }
        }
        return lable;
    }
    public static String codecheck(String a){
        boolean comma=false;
        int commaindex=0;
        int bunpc=0;
        String code;
            for(int i=0;i<a.length();i++){
                if (a.charAt(i)==','){
                    comma=true;
                commaindex=i;
                }
            }
            if (comma){
                 code=a.substring(commaindex+1,commaindex+4);
            }
        else {
            code=a.substring(0,3);
            }
return code;
    }
public static String size16(String a){
    if (a.length()<16){
    int s=a.length();
    for (int i=0;i<16-s;i++){
        a="0"+a;
    }}
    if (a.length()>16){
     a=a.substring(16);
    }
    return a;
}
    public static int binarystringtoint(String a){
        if (a.charAt(0)=='0')
        return Integer.parseInt(a,2);
        short aa=0;
        if (a.charAt(0)=='1'){
            aa = (short) Integer.parseInt(a,2);
            aa= (short) ~aa;
            aa= (short) (aa+1);
        }
        return aa*-1;
    }
    public static int orghandle(int a){

        for (int i=1;i<obj.objlist.size();i++){
            if (obj.objlist.get(i).substring(0,3).equals("ORG")&&Integer.parseInt(obj.objlist.get(i).substring(4))==a){
                obj.orghandle=a;
                obj.orgcounter=i+1;
                obj.orgflag=true;
            }
            if (obj.orghandle<=a&& obj.orgflag){
                obj.orgcounter=obj.orgcounter+(a-obj.orghandle);
                obj.orghandle=a;
                break;
            }
        }
        return obj.orgcounter;
    }
    public void AND (String l){
        int index=0;
        for (int i=0;i<obj.lable.size();i++){
            if (obj.lable.get(i).equals(l)){
                index=i;
                break;
            }
        }
        int temp=obj.ac;
        String shift=size16(Integer.toBinaryString(temp));
        System.out.println("accumulator before and ="+shift);

        System.out.println("and value of mem["+obj.lable.get(index)+"] with accumulator");
        System.out.println("value of mem["+obj.lable.get(index)+"] = "+size16(obj.binary[index]));
       obj.ac= (short) (obj.ac&Integer.parseInt(size16(obj.binary[index]),2));

       temp=obj.ac;
       shift=size16(Integer.toBinaryString(temp));
        System.out.println("accumulator after and ="+shift);
    }
    public void ANDI(String l){
        int index=0;
        for (int i=0;i<obj.lable.size();i++){
            if (obj.lable.get(i).equals(l)){
                index=i;
                break;
            }
        }
        System.out.println("accumulator before AND= "+size16(Integer.toBinaryString(obj.ac)));
        String temp=null;
        int handle=orghandle(binarystringtoint(obj.binary[index]));
        System.out.println("and value of mem[mem["+obj.lable.get(index)+"]] with accumulator");
        if (handle==0){
        temp=obj.objlist.get(binarystringtoint(obj.binary[index])-obj.org);}

        if (handle>0){
            temp=obj.objlist.get(handle);
        }
        if (temp.substring(0,3).equals("HEX")){
            obj.ac= (short) (obj.ac&Integer.parseInt(temp.substring(4),16));
        }
        if (temp.substring(0,3).equals("DEC")) {
            obj.ac = (short) (obj.ac&Integer.parseInt(temp.substring(4)));
        }

        System.out.println("accumulator after and ="+size16(Integer.toBinaryString(obj.ac)));
        }
    public void ADD (String l){
        int index=0;
        for (int i=0;i<obj.lable.size();i++){
            if (obj.lable.get(i).equals(l)){
                index=i;
                break;
            }
        }

        int tempp;
        tempp=obj.ac+Integer.parseInt(obj.binary[index],2);
        if (tempp>32767&&tempp<-32768) {
            obj.e = 1;
            obj.ac= (short) Integer.parseInt(Integer.toBinaryString(tempp).substring(1),2);
        }
        int temp=obj.ac;
        String shift=size16(Integer.toBinaryString(temp));
        System.out.println("accumulator before add ="+shift);
        System.out.println("add value of mem["+obj.lable.get(index)+"] to accumulator");
        System.out.println("value of mem["+obj.lable.get(index)+"] = "+size16(obj.binary[index]));
        obj.ac= (short) (tempp);
        shift=size16(Integer.toBinaryString(tempp));
        System.out.println("accumulator after add ="+shift);
    }
    public void ADDI(String l){
        int index=0;
        for (int i=0;i<obj.lable.size();i++){
            if (obj.lable.get(i).equals(l)){
                index=i;
                break;
            }
        }
        String temp=null;
        int handle=orghandle(binarystringtoint(obj.binary[index]));
        System.out.println("accumulator before ADD= "+size16(Integer.toBinaryString(obj.ac)));
        System.out.println("add value of mem[mem["+obj.lable.get(index)+"]] with accumulator");
        if (handle==0){
            temp=obj.objlist.get(binarystringtoint(obj.binary[index])-obj.org+1);}

        if (handle>0){
            temp=obj.objlist.get(handle);
          //  System.out.println(temp);
           // System.out.println(handle);
        }

        if (temp.substring(0,3).equals("HEX")){
            obj.ac= (short) (obj.ac+Integer.parseInt(temp.substring(4),16));
        }
        if (temp.substring(0,3).equals("DEC")) {
            obj.ac = (short) (obj.ac+Integer.parseInt(temp.substring(4)));
        }
        System.out.println("accumulator after add ="+size16(Integer.toBinaryString(obj.ac)));
    }
    public void LDA (String l){
        int index=0;
        for (int i=0;i<obj.lable.size();i++){
            if (obj.lable.get(i).equals(l)){
                index=i;
                break;
            }
        }

        obj.ac= (short) Integer.parseInt(obj.binary[index],2);
        System.out.println("load accumulator with mem["+obj.lable.get(index)+"]");
        System.out.println("mem["+obj.lable.get(index)+"] = "+size16(obj.binary[index]));
        int temp=obj.ac;
        String shift=size16(Integer.toBinaryString(temp));
        System.out.println("accumulator after load ="+shift);
    }
    public void LDAI(String l){
        int index=0;
        for (int i=0;i<obj.lable.size();i++){
            if (obj.lable.get(i).equals(l)){
                index=i;
                break;
            }
        }
        System.out.println("load accumulator with mem[mem["+obj.lable.get(index)+"]]");
        String temp=null;
        int handle=orghandle(binarystringtoint(obj.binary[index]));
        if (handle==0){
            temp=obj.objlist.get(binarystringtoint(obj.binary[index])-obj.org);

        }

        if (handle>0){
            temp=obj.objlist.get(handle);
        }
        if (temp.substring(0,3).equals("HEX")){
            obj.ac= (short) Integer.parseInt(temp.substring(4),16);
            System.out.println("mem[mem["+obj.lable.get(index)+"]] = "+size16(Integer.toBinaryString(Integer.parseInt(temp.substring(4),16))));
        }
        if (temp.substring(0,3).equals("DEC")){
            obj.ac= (short) Integer.parseInt(temp.substring(4));
            System.out.println("mem[mem["+obj.lable.get(index)+"]] = "+size16(Integer.toBinaryString(Integer.parseInt(temp.substring(4)))));
        }
        System.out.println("accumulator after load ="+size16(Integer.toBinaryString(obj.ac)));
    }
    public void STA (String l){
        int index=0;
        for (int i=0;i<obj.lable.size();i++){
            if (obj.lable.get(i).equals(l)){
                index=i;
                break;
            }
        }

        int temp=obj.ac;
        String shift=size16(Integer.toBinaryString(temp));
        obj.binary[index]=Integer.toBinaryString(obj.ac);
        System.out.println("save accumulator in mem["+obj.lable.get(index)+"]");
        System.out.println("accumulator ="+shift);
        System.out.println("mem["+obj.lable.get(index)+"] after save= "+size16(obj.binary[index]));
    }
    public void STAI(String l){
        int index=0;
        for (int i=0;i<obj.lable.size();i++){
            if (obj.lable.get(i).equals(l)){
                index=i;
                break;
            }
        }
        String temp=obj.objlist.get(binarystringtoint(obj.binary[index])-obj.org);
        System.out.println("save accumulator in mem[mem["+obj.lable.get(index)+"]]");
        System.out.println("accumulator ="+size16(Integer.toBinaryString(obj.ac)));
        for (int i=0;i<obj.lable.size();i++){
            if (obj.lable.get(i).equals(lablefind(temp))){
                index=i;
                break;
            }
        }
        obj.binary[index]=Integer.toBinaryString(obj.ac);
        System.out.println("mem["+obj.lable.get(index)+"] after save= "+size16(obj.binary[index]));
    }
    public void BUN (String l){
        boolean comma=false;
        int commaindex=0;
        int bunpc=0;

        for (int j=0;j<obj.objlist.size();j++){
            for(int i=0;i<obj.objlist.get(j).length();i++){
                if (obj.objlist.get(j).charAt(i)==','){
                    comma=true;
                    commaindex=i;
            }
            if (comma){
              if ( obj.objlist.get(j).substring(0,commaindex).equals(l)){
                  bunpc=j-1;
                  comma=false;
                  break;
              }
            }

        }

        }
        System.out.println("value of programcounter in the line BUN instruction ="+size16(Integer.toBinaryString(obj.programcounter)));
        obj.programcounter=bunpc+obj.org;
        System.out.println("value of programcounter after BUN instruction ="+size16(Integer.toBinaryString(obj.programcounter)));
    }
    public void BUNI(String l){
        int index=0;
        for (int i=0;i<obj.lable.size();i++){
            if (obj.lable.get(i).equals(l)){
                index=i;
                break;
            }
        }
        System.out.println("value of programcounter in the line BUN instruction ="+size16(Integer.toBinaryString(obj.programcounter-1)));
        obj.programcounter=binarystringtoint(obj.binary[index]);
        System.out.println("value of programcounter after BUN instruction ="+size16(Integer.toBinaryString(obj.programcounter-1)));
    }
    public void BSA (String l){
        int index=0;
        for (int i=0;i<obj.lable.size();i++){
            if (obj.lable.get(i).equals(l)){
                index=i;
                break;
            }
        }
        System.out.println("save current address at "+l+" and jump to "+l+" label");
        System.out.println("Mem["+l+"] before BSA="+size16(obj.binary[index]));
        obj.binary[index]=Integer.toBinaryString(obj.programcounter+1);
        System.out.println("Mem["+l+"] after BSA="+size16(obj.binary[index]));
        int find=0;
        String [] test=new String[2];
        for (int i=0;i<obj.objlist.size();i++){
            test=obj.objlist.get(i).split(",");
            if (test[0].equals(l)){
                find=i;
                break;
            }
        }
        System.out.println("programcounter before BSA= "+size16(Integer.toBinaryString(obj.programcounter)));
        obj.programcounter=find+obj.org;
        System.out.println("programcounter after BSA= "+size16(Integer.toBinaryString(obj.programcounter)));
    }
    public void ISZ (String l){
        int index=0;
        for (int i=0;i<obj.lable.size();i++){
            if (obj.lable.get(i).equals(l)){
                index=i;
                break;
            }
        }


        int temp=binarystringtoint(size16(obj.binary[index]));
        if (temp==0){
            obj.programcounter=obj.programcounter+1;
            System.out.println("programcounter+1 if mem["+obj.lable.get(index)+"] = 0");
            System.out.println("programcounter+1");
        }
        else {
            temp = temp + 1;
            System.out.println("mem[" + obj.lable.get(index) + "] before ISZ = " + size16(obj.binary[index]));
            obj.binary[index] = Integer.toBinaryString(temp);
        }
        System.out.println("mem["+obj.lable.get(index)+"] after ISZ = "+size16(obj.binary[index]));

    }
    public void CLA(){
        obj.ac=0;
        System.out.println("accumulator after CLA =0000000000000000");
    }
    public void CLE(){
        obj.e=0;
        System.out.println("e after CLE =0");
    }
    public void CMA(){
        int temp=obj.ac;
        String shift=Integer.toBinaryString(temp);
        shift=size16(shift);
        System.out.println("accumulator before CMA ="+shift);
        obj.ac= (short) ~obj.ac;
        temp=obj.ac;
        shift=Integer.toBinaryString(temp);
        shift=size16(shift);
        System.out.println("accumulator after CMA ="+shift);
    }
    public void CME(){
        System.out.println("e before CME="+obj.e);
        obj.e=~obj.e;
        System.out.println("e after CME="+obj.e);
    }
    public void CIR(){
        int temppp=obj.ac;
        String shiftt=Integer.toBinaryString(temppp);
        shiftt=size16(shiftt);
        System.out.println("accumulator before CIR="+shiftt);
        System.out.println("e before CIR="+obj.e);
        int temp=obj.ac;
        char tempp=Integer.toBinaryString(temp).charAt(0);
        temp = temp >> 1;
        String shift=Integer.toBinaryString(temp);
        int s=shift.length();
        for (int i=0;i<16-s;i++){

            if (i==15-shift.length())
                shift=String.valueOf(obj.e)+shift;
            else {
                shift = "0" + shift;
            }
        }

        obj.e=Integer.parseInt(String.valueOf(tempp));
        obj.ac= (short) Integer.parseInt(shift);
        System.out.println("accumulator after CIR="+shift);
        System.out.println("e after CIR="+obj.e);
    }
    public void CIL(){
    int temp=obj.ac;
        String shift=Integer.toBinaryString(temp);
        char komak=String.valueOf(obj.e).charAt(0);
        shift=size16(shift);

        System.out.println("accumulator before CIL="+shift);
        System.out.println("e before CIL="+obj.e);
        char [] shiftt=new char[17];
        for (int i=0;i<16;i++){
            shiftt[i+1]=shift.charAt(i);
        }

        for (int i=1;i<17;i++){
            shiftt[i-1]=shiftt[i];
        }
        shiftt[16]=komak;
        komak=shiftt[0];

        shift="";
        for (int i=1;i<17;i++){
            shift=shift+shiftt[i];
        }

        obj.e=Integer.parseInt(String.valueOf(komak));
        obj.ac= (short) Integer.parseInt(shift,2);
        System.out.println("e after CIL="+obj.e);
        System.out.println("accumulator after CIL="+shift);
    }
    public void INC(){
        obj.ac= (short) (obj.ac+1);
        int temp=obj.ac;
        String shift=Integer.toBinaryString(temp);
        shift=size16(shift);
        System.out.println("accumulator after INC="+shift);
    }
    public void SPA(){
        System.out.println("programcounter before SPA ="+obj.programcounter);
        if (obj.ac>0){
            obj.programcounter=obj.programcounter+1;
        }
        System.out.println("programcounter after SPA ="+obj.programcounter);
    }
    public void SNA(){
        System.out.println("programcounter before SNA ="+obj.programcounter);
        if (obj.ac<0){
            obj.programcounter=obj.programcounter+1;
        }
        System.out.println("programcounter after SNA ="+obj.programcounter);
    }
    public void SZA(){
        System.out.println("programcounter before SZA ="+obj.programcounter);
        if (obj.ac==0){
            obj.programcounter=obj.programcounter+1;
        }
        System.out.println("programcounter after SZA ="+obj.programcounter);
    }
    public void SZE(){
        System.out.println("programcounter before SZE ="+obj.programcounter);
        if (obj.e==0){
            obj.programcounter=obj.programcounter+1;
        }
        System.out.println("programcounter after SZE ="+obj.programcounter);
    }
    public void INP(){
        obj.ac= (short) binarystringtoint(obj.inputregister);
    }
    public void OUT(){
        obj.outputregister=size16(Integer.toBinaryString(obj.ac)).substring(8);
    }
    public void SKI(){
        if (obj.IF==1){
            obj.programcounter=obj.programcounter+1;
        }
    }
    public void SKO(){
        if (obj.OF==1){
            obj.programcounter=obj.programcounter+1;
        }
    }
    public void ION(){
        obj.IEN=1;
    }
    public void IOF(){
        obj.IEN=0;
    }

    public static void main(String[] args) {
        //گرفتن ورودی ها در لیست ارایه ای
        Scanner in=new Scanner(System.in);
        ArrayList<String> input=new ArrayList<String>();
        int index = 0;

        for (int i=0;in.hasNext();i++){
            input.add(in.nextLine());
            if (input.get(i).equals("HLT")){
                index=i+1;
            }
            if (input.get(i).equals("END")){
                break;
            }
        }

         // System.out.println(input);
         // System.out.println(index);

        //جدا کردن لیبل ها از لیست
        ArrayList<String> label=new ArrayList<>();
        int labelcont=0;

        for (int i=0;i<input.size()-1;i++){
            for (int j=0;j<input.get(i).length();j++)
            if (input.get(i).charAt(j)==','&&(input.get(i).charAt(j+1)=='D'||input.get(i).charAt(j+1)=='H')){
             label.add(input.get(i));
         }}

      //  System.out.println(label.get(0));
      //  System.out.println(label.get(1));
      //  System.out.println(label.get(2));
      //  System.out.println(label.size());
        //جدا کردن لیبل از مقدار و تبدیل به باینری
        String [] binarycount=new String[label.size()];
        String [] temp=new String[2];
        String chek="";
        int lablesize=label.size();
        for (int i=0;i<lablesize;i++){

            temp=label.get(i).split(",");
          label.remove(i);
            label.add(i,temp[0]);
            temp[0]=temp[1].substring(0,3);
            temp[1]=temp[1].substring(4);
            if (temp[0].equals("DEC")){
                if (Integer.toBinaryString(Integer.parseInt(temp[1])).length()>16){
                    chek=Integer.toBinaryString(Integer.parseInt(temp[1])).substring(16);
                    binarycount[i]=chek;}
                else {
                    binarycount[i]=size16(Integer.toBinaryString(Integer.parseInt(temp[1])));
                }}
            if (temp[0].equals("HEX")){
                if (Integer.toBinaryString(Integer.parseInt(temp[1],16)).length()>16){
                    chek=Integer.toBinaryString(Integer.parseInt(temp[1],16)).substring(16);
                    binarycount[i]=chek;}
                else {
                    binarycount[i]=size16(Integer.toBinaryString(Integer.parseInt(temp[1],16)));}
             }
        }

      //     for (int i=0;i<label.size();i++){
        // System.out.println(label.get(i));
        //}

        obj=new Memory(label,binarycount,input);
        int pcsize=input.size();
         Main object=new Main();
         int tempp=0;
        for (obj.programcounter = obj.org;obj.programcounter<pcsize+obj.org;obj.programcounter++){
            //LDA
         // System.out.println(obj.programcounter);
           // System.out.println(obj.org);
          //  System.out.println(codecheck(input.get(obj.programcounter- obj.org)));
            if (codecheck(input.get(obj.programcounter- obj.org)).equals("LDA")){
                if (input.get(obj.programcounter - obj.org).charAt(input.get(obj.programcounter - obj.org).length() - 1) == 'I'){
                    object.LDAI(lablefind(input.get(obj.programcounter-obj.org)));
                }
                else {
                object.LDA(lablefind(input.get(obj.programcounter- obj.org)));}
            }
            //STA

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("STA")){
                if (input.get(obj.programcounter - obj.org).charAt(input.get(obj.programcounter - obj.org).length() - 1) == 'I'){
                    object.STAI(lablefind(input.get(obj.programcounter-obj.org)));
                }
                else {
                object.STA(lablefind(input.get(obj.programcounter- obj.org)));}
            }
            //ADD

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("ADD")){
                if (input.get(obj.programcounter - obj.org).charAt(input.get(obj.programcounter - obj.org).length() - 1) == 'I'){
                    object.ADDI(lablefind(input.get(obj.programcounter-obj.org)));

                }

                else {
                object.ADD(lablefind(input.get(obj.programcounter- obj.org)));}
            }
            //AND

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("AND")){
                if (input.get(obj.programcounter - obj.org).charAt(input.get(obj.programcounter - obj.org).length() - 1) == 'I'){
                    object.ANDI(lablefind(input.get(obj.programcounter-obj.org)));
                }
                else {
                object.AND(lablefind(input.get(obj.programcounter- obj.org)));}
            }
            //BUN

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("BUN")){
                if (input.get(obj.programcounter - obj.org).charAt(input.get(obj.programcounter - obj.org).length() - 1) == 'I'){
                    object.BUNI(lablefind(input.get(obj.programcounter-obj.org)));
                    obj.programcounter=obj.programcounter-1;
                    continue;
                }
                else {
                object.BUN(lablefind(input.get(obj.programcounter- obj.org)));
                    continue;}
            }
            //BSA

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("BSA")){
                if (input.get(obj.programcounter - obj.org).charAt(input.get(obj.programcounter - obj.org).length() - 1) == 'I'){
                    //ناقص
                }
                else {
                object.BSA(lablefind(input.get(obj.programcounter- obj.org)));
                       }
                continue;
            }
            //ISZ
            if (codecheck(input.get(obj.programcounter- obj.org)).equals("ISZ")){
                if (input.get(obj.programcounter - obj.org).charAt(input.get(obj.programcounter - obj.org).length() - 1) == 'I'){
                    //ناقص
                }
                else {
                object.ISZ(lablefind(input.get(obj.programcounter- obj.org)));}
            }
            //CLA

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("CLA")){
                object.CLA();
            }
            //CLE

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("CLE")){
                object.CLE();
            }
            //CMA

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("CMA")){
                object.CMA();
            }
            //CME

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("CME")){
                object.CME();
            }
            //CIR

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("CIR")){
                object.CIR();
            }
            //CIL

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("CIL")){
                object.CIL();
            }
            //INC

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("INC")){
                object.INC();
            }
            //SPA

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("SPA")){
                object.SPA();
            }
            //SNA

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("SNA")){
                object.SNA();
            }
            //SZA

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("SZA")){
                object.SZA();
            }
            //SZE

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("SZE")){
                object.SZE();
            }
            //HLT

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("HLT")){
                break;
            }
            //INP

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("INP")){}
            //OUT

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("OUT")){}
            //SKI

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("SKI")){}
            //SKO

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("SKO")){}
            //ION

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("ION")){}
            //IOF

            if (codecheck(input.get(obj.programcounter- obj.org)).equals("IOF")){}
            System.out.println("" +
                    "");
            tempp++;
        }
        System.out.println("final value of ac:");
        System.out.println(size16(Integer.toBinaryString(obj.ac)));
    }
}
class Memory{
    short ac;
    int orgcounter=0;
    int orghandle;
    int e;
    boolean orgflag=false;
    int programcounter;
    String inputregister="00001111";
    String outputregister;
    int IF=1;
    int OF=1;
    int IEN=1;
    ArrayList<String> lable;
    String [] binary;
    ArrayList<String> objlist=new ArrayList<String>();
    int org;
   public Memory (ArrayList<String> a,String [] b,ArrayList<String> c){
   this.lable=a;
   this.binary=b;
   this.objlist=c;
       org=Integer.parseInt(c.get(0).substring(4));
   }
}