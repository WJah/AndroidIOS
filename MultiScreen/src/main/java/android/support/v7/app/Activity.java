package android.support.v7.app;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;

import com.intel.inde.common.*;

public class Activity extends Context{
    
    static List<Intent> intentQueue;
    static {
        intentQueue = new ArrayList<Intent>();
    }
    
    static public void pushIntent(Intent i) {
        intentQueue.add(i);
    }
    
    static public Intent popIntent() {
        
        if(intentQueue.isEmpty())
            return null;
        
        int last = intentQueue.size() - 1;
        Intent intent = intentQueue.get(last);
        intentQueue.remove(last);
        return intent;
    }
    
    public void startActivity(Intent intent) {
        Class  cc = entry.BackActivity.class;
        System.out.println(cc.getName());
        
        try {
            Class clazz;
            clazz = Class.forName(intent.className);
            Context context = (Context)clazz.newInstance();
            Activity.pushIntent(intent);
            context.setVisible();
            context.onCreate(null);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    public void finish() {
        Intent intent = Activity.popIntent();
        intent.context.setVisible();
    }
}
