import java.util.*;
public class MyClass {
    public static String order(String[] arr,String s1,String s2,int p1,int p2){
        String c="Clockwise";
        String a="Anti-Clockwise";
        if(p1==arr.length-1 && p2==0) return c;
        else if(p1==0 && p2==arr.length-1) return a;
        else if(p1<p2) return c;
        else return a;
    }
    
    public static void distribute(int[] received,int p1,int gift,String order){
        for(int i=1;i<=gift;i++){
            received[p1]++;
            p1=order.equals("Clockwise")?(p1+1)%received.length:(p1 - 1+received.length)%received.length;
        }
    }
    
    public static void changeOrder(String[] inorder,int f1,int f2, String order,int max){
        String[] s=new String[inorder.length];
        int f=0,l=0,t=0;
        boolean flag=false;
        if(order.equals("Clockwise")){
            if(f1==inorder.length-1){
                s[t++]=inorder[inorder.length-1];
                f=0;
                l=inorder.length-1;
            }
            else if(f1==0){
                s[t++]=inorder[0];
                f=1;
                l=inorder.length;
            }
            else{
                f=f1;
                flag=true;
            }
            if(flag==true){
                for(int i=f1;i<inorder.length;i++){
                    s[t++]=inorder[i];
                }
                for(int i=0;i<f;i++){
                    s[t++]=inorder[i];
                }
            }
            else{
                for(int i=f;i<l;i++){
                    s[t++]=inorder[i];
                }
            }
        }
        else{
            if(f1==inorder.length-1){
                s[t++]=inorder[inorder.length-1];
                f=inorder.length-2;
                l=0;
            }
            else if(f1==0){
                s[t++]=inorder[0];
                f=inorder.length-1;
                l=1;
            }
            else{
                f=f1;
                flag=true;
            }
            if(flag==true){
                for(int i=f1;i>=0;i--){
                    s[t++]=inorder[i];
                }
                for(int i=f1+1;i<inorder.length;i++){
                    s[t++]=inorder[i];
                }
            }
            else{
                for(int i=f;i>=l;i--){
                    s[t++]=inorder[i];
                }
            }
        }
        
        for(int i=0;i<s.length;i++){
            System.out.println(s[i]+"-"+max);
        }
        System.out.println(s[s.length-1]);
    }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        // String[] arr={"a","b","c","d","e"};
        String[] arr=new String[n];
        in.nextLine();
        // String s1="d",s2="e";
        for(int i=0;i<n;i++) arr[i]=in.nextLine();
        int gift=in.nextInt();
        in.nextLine();
        String s1=in.nextLine(),s2=in.nextLine();
        // int gift=13;
      
        int p1=0,p2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(s1)) p1=i;
            if(arr[i].equals(s2)) p2=i;
        }
      
        String order=order(arr,s1,s2,p1,p2);
        System.out.println(order);
      
        int received[]=new int[arr.length];
        distribute(received,p1,gift,order);
        // System.out.println(Arrays.toString(received));
        
        int max=-1;
        for(int i=0;i<arr.length;i++){
            if(received[i]>max){
                max=received[i];
            }
        }
        
        List<String> li=new ArrayList<String>();
        
        for(int i=0;i<arr.length;i++){
            if(received[i]==max){
                // System.out.println(arr[i]+"-"+max);
                li.add(arr[i]);
            }
        }
        String inorder[] = new String[li.size()];
        for(int i=0;i<li.size();i++) inorder[i]=li.get(i);
        // System.out.println(Arrays.toString(inorder));
        
        if(inorder.length>1){
            int f1=0,f2=0;
            for(int i=0;i<inorder.length;i++){
                if(inorder[i].equals(s1)) f1=i;
                if(inorder[i].equals(s2)) f2=i;
            }
            changeOrder(inorder,f1,f2,order,max);
        }
        else{
            
        }
    }
}


/*input
5 -> number of kids
Nick
joe
John
Noah
Damon
13 -> gits count
Damon -> starting name
Noah -> after stating name*/
