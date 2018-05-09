//import javax.script.ScriptException;
//import javax.script.SimpleBindings;
//import java.util.Map;
//
//public class ScriptEngineTest {
//    public static void main(String[] args){
//        new ScriptEngineTest().invokeGroovy();
//    }
//    private boolean invokeGroovy(Map context, String scriptContent) {
//        try {
//            return (boolean) scriptEngineManager.getEngineByExtension("groovy").eval(scriptContent.intern(), new SimpleBindings(new HashedMap(ImmutableMap.of("message", context))));
//        } catch (ScriptException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
