public class Palavra {

    public static void main(String[] args) {

        String v = "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";

        System.out.println(v.length());
        for(int i=1;i<=100;i++){
         int j=9;
              if(i==j){
                  String substring = v.substring(i);
                  substring.length();
                  int total = v.length() - substring.length();
                  String substring1 = v.substring(substring.length() - total + 1);
                  System.out.println(substring1);

              }

        }
    }

    public static void values(){
        String values = "?";
        for(int i=0; i<2;i++){
            System.out.print(values.concat(","));
            if(i==2-1){
                String v = values.replace(",","");
                System.out.print(v);
            }
        }
    }
}


