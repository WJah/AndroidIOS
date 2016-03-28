package android.content;

import com.intel.inde.common.Context;

public class Intent {
    
    public Context context;
    public String className;
    
    public Intent setClassName(Context p, String c) {
        context = p;
        className = c;
        return this;
    }
}
