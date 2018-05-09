import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test2 {
    static void testStream(String[] array1){
        List<String> list1 = Arrays.asList(array1);
        Optional<String> o = list1.stream()
                .filter(l->l.equals("1"))
                .findAny();
        if (o.isPresent()){
            System.out.print(o.get());
        }
    }
    public static void main(String[] args){
//        String[] s1 = new String[]{"1","2","3","4"};
//        testStream(s1);
        String s = "abcderasdf";
        System.out.println(s.contains("abc"));
        System.out.print(s.indexOf("cde"));
        System.out.print(s.substring(s.indexOf("cde")+3,s.indexOf("cde")+6));
    }
}
