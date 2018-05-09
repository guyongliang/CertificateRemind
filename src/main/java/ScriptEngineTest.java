import com.google.common.collect.ImmutableMap;
import org.apache.commons.collections.map.HashedMap;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;
import java.util.HashMap;
import java.util.Map;

public class ScriptEngineTest {

    public static void main(String[] args) {

        new ScriptEngineTest().invokeGroovy();
    }

    private void invokeGroovy() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        Teacher teacher = new Teacher("xiaoli", 25);
        Student student = new Student("xiaoming", 16);
        Student student2 = new Student("xiaoming", 17);

        Map map1 = new HashMap<String,Object>();
        Map map2 = new HashMap<String,Object>();
        map1.put("teacher",teacher);
        map2.put("student",student);
        map2.put("student",student2);


        Map context = new HashMap();
        context.put("a",map1);
        context.put("b",map2);

//        Map map = new HashMap();
//        map.put("message",context);
        String script = "message.b.student.age=='15'";
        try {
            System.out.println(engine.eval(script.intern(), new SimpleBindings(new HashedMap(ImmutableMap.of("message", context)))));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
//    }            return (boolean) scriptEngineManager.getEngineByExtension("groovy").eval(scriptContent.intern(), new SimpleBindings(new HashedMap(ImmutableMap.of("message", context))));
//scriptEngineManager.getEngineByExtension("groovy").eval(scriptContent.intern(), new SimpleBindings(new HashedMap(ImmutableMap.of("message", context))));

    }
}