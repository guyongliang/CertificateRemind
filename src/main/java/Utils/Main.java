package Utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        SimpleBindings simpleBindings = new SimpleBindings();
        String jsCript = "for(var i=0; i<test.length; i++){test[i] = test[i].replaceAll(',' , '')} ; test";
        simpleBindings.put("test", Arrays.asList("1,2,37", "1,223", "3,932"));
        Object result = engine.eval(jsCript, simpleBindings);
        System.out.println(result);




    }
}
