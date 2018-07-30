import java.util.Scanner;

/**
 * Created by BenBen嚓 on 2018/5/4.
 */
public class test2 {
    public static void main(String[] args) {
        String a = "yes";
        String b = "no";
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("输入数据：");
            String str1 = scan.next();
            if(str1.equals(a)){
                System.out.println("输入成功"+str1);
                break;
            }else if(str1.equals(b)){
                System.out.println("输入成功"+str1);
                break;
            }else {
                System.out.println("您输入的值"+str1+"不符合规定,请重新输入！");
            }
        }
        scan.close();

    }

}


