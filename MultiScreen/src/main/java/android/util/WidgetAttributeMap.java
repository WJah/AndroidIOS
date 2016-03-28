package android.util;

import com.intel.inde.common.Action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import generated.R;

class AttributeMap {
    public String name;
    public Object val;
}

public class WidgetAttributeMap implements AttributeSet {

    private List<AttributeMap> all;
    
    public static List<AttributeSet> alloc(int id) {
        List<AttributeSet> ret = new ArrayList<AttributeSet>();
        getWamFromR();
        for(WidgetAttributeMap wam : R.canvas.allWidget) {
            if(wam.getAttributeIntValue(null, "parentId", -1) == id) {
                ret.add(wam);
            }
        }
        
        return ret;        
    }

    private static List<AttributeSet> getWamFromR(){
        List<AttributeSet> attributeSets = new ArrayList<AttributeSet>();
        final Class<R.canvas> activityClass = R.canvas.class;
        Class<?> claze[] = activityClass.getClasses();
        for(Class<?> c : claze){
            Class<?> cs = c.getDeclaringClass();
            Field field[] = cs.getFields();

        }
        return null;
    }
    
    public void put(String name, Object val) {
        AttributeMap am = new AttributeMap();
        am.name = name;
        am.val = val;
        all.add(am);
    }
    
    public WidgetAttributeMap() {
        all = new ArrayList<AttributeMap>();
    }
    @Override
    public int getAttributeCount() {
        // TODO Auto-generated method stub
        return all.size();
    }

    @Override
    public String getAttributeName(int index) {
        // TODO Auto-generated method stub
        AttributeMap am = all.get(index);
        return am.name;
    }

    @Override
    public String getAttributeValue(int index) {
        // TODO Auto-generated method stub
        
        return all.get(index).val.toString();
    }

    private int getIndex(String name) {
        for(int i = 0; i < all.size(); i++) {
            if(all.get(i).name.equals(name))
                return i;
        }
        return -1;
    }
    
    @Override
    public int getAttributeIntValue(String namespace, String attribute,
            int defaultValue) {
        // TODO Auto-generated method stub
        int index = getIndex(attribute);
        if( index < 0 )
            return defaultValue;

        if(all.get(index).val instanceof Integer)
            return ((Integer)(all.get(index).val)).intValue();
        else
            return defaultValue;
        
    }

    @Override
    public String getAttributeStringValue(String namespace, String attribute,
            String defaultValue) {
        
        // TODO Auto-generated method stub
        int index = getIndex(attribute);
        if( index < 0 )
            return defaultValue;

        if(all.get(index).val instanceof String)
            return (String)(all.get(index).val);
        else
            return defaultValue;
        
    }

}
