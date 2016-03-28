package android.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import generated.*;

public class WidgetAttribute implements AttributeSet {

    private Field[] fields;
    private Class clazz;
    private String name, simpleName;
    
    private static Class getRSubClass(String subClassName) {
        Class Rclazz;
        try {
            Rclazz = Class.forName("generated.R");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        
        System.out.print(Rclazz.toString());
        
        Class clazzs[] = Rclazz.getDeclaredClasses();;
        
        for(Class c : clazzs) {
            if(c.getSimpleName().equals(subClassName))
                return c;
        }
        
        return null;
    }

    /*
    private static Class getRSubClass(String subClassName) {
        Class cl = R.class;
        
        System.out.println(R.dummy);
        
        try {
            Field f = R.class.getField("dummy");
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Class clazzs[] = R.class.getDeclaredClasses();
        for(Class c : clazzs) {
            if(c.getSimpleName().equals(subClassName))
                return c;
        }
      
        return null;       
    }
    */
    
    private static String id2name(int id) {
        //Field fields[] = getRSubClass("layout").getDeclaredFields();
        Class R2clazz = R.layout.class;
        Field fields[] = R2clazz.getDeclaredFields();
        for(Field f : fields) {
            try {
                if(f.getInt(null) == id) {
                    return f.getName(); 
                }
            } catch (IllegalAccessException | IllegalArgumentException e) {
                // TODO Auto-generated catch block
                continue;
            }
        }    
        return null;
    }
    
    private static Class getActivityClazz(String clazzName) {
        
        //Class clazzs[] = getRSubClass("canvas").getDeclaredClasses();
        Class clazzs[] = R.canvas.class.getDeclaredClasses();
        
        for(Class clazz : clazzs) {
            if(clazz.getSimpleName().equals(clazzName)){
                return clazz;
            }
        }
        
        return null;
    }
    
    static List<AttributeSet> allocAllWidget(Class activityClazz) {
        
        List<AttributeSet> was = new ArrayList<AttributeSet>();
        
        Class<?> clazzs[] = activityClazz.getDeclaredClasses();
        
        for(Class<?> c : clazzs) {
            was.add(new WidgetAttribute(c));
        }
        
        return was;
    }
    
    public static List<AttributeSet> alloc(int activityId) {
        List<AttributeSet> was = new ArrayList<AttributeSet>();
        String cname = id2name(activityId);
        if(cname == null) 
            return was;
        
        Class clazz = getActivityClazz(cname);
        if(clazz == null)
            return was;
        
        return allocAllWidget(clazz);
    }
    
    WidgetAttribute(Class c) {
        clazz = c;
        fields = clazz.getDeclaredFields();      
        name = clazz.getName();
        simpleName = clazz.getSimpleName();
    }
    
    @Override
    public int getAttributeCount() {
        // TODO Auto-generated method stub
        return fields.length;
    }

    @Override
    public String getAttributeName(int index) {
        // TODO Auto-generated method stub
        return fields[index].getName();
    }

    @Override
    public String getAttributeValue(int index) {
        // TODO Auto-generated method stub
        try {
            return fields[index].get(null).toString();
        } catch (IllegalAccessException | IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public int getAttributeIntValue(String namespace, String attribute,
            int defaultValue) {
        // TODO Auto-generated method stub
        
        try {
            Field f = clazz.getField(attribute);
            return f.getInt(null);
        } catch (NoSuchFieldException | IllegalAccessException | IllegalArgumentException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.out.printf("can not access %s of %s", attribute, namespace);
            return defaultValue;
        }
                
    }
        
    @Override
    public String getAttributeStringValue(
            String namespace, 
            String attribute,
            String defaultValue) {
        try {
			Field f = clazz.getField(attribute);
			Object val = f.get(null);
			return val.toString();
		} catch (NoSuchFieldException | IllegalAccessException | IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.printf("can not access %s of %s", attribute, namespace);
			return defaultValue;
		}
        
    }

}
