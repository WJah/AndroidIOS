package generated;

import java.util.ArrayList;
import java.util.List;

import android.util.WidgetAttributeMap;

public final class R {

    public static final class id {
         public static final int backactivity=0x7f08003f;
         public static final int button=0x7f080043;
         public static final int button2=0x7f080041;
         public static final int button3=0x7f080044;
         public static final int button4=0x7f080049;
         public static final int mainactivity=0x7f080042;
         public static final int textView = 0x7f080040;
         public static final int textView2 = 0x7f080050;
     }
    
    public static final class layout {
         public static final int activity_back=0x7f030017;
         public static final int activity_main=0x7f030018;
    }
  
    public static final class canvas {
        
        static public List<WidgetAttributeMap> allWidget;
        
        static {
             allWidget = new ArrayList<WidgetAttributeMap>();
             
             WidgetAttributeMap wam;
             
             wam = new WidgetAttributeMap();
             wam.put("parentId", layout.activity_main);
             wam.put("id", id.textView);
             wam.put("type", "TextView");
             wam.put("x", 0);
             wam.put("y", 0);
             wam.put("width", 200);
             wam.put("height", 80);
             wam.put("text", "hello");
             allWidget.add(wam);
             
             wam = new WidgetAttributeMap();
             wam.put("parentId", layout.activity_main);
             wam.put("id", id.button);
             wam.put("type", "Button");
             wam.put("x", 0);
             wam.put("y", 100);
             wam.put("width", 200);
             wam.put("height", 80);
             wam.put("text", "++");  
             //wam.put("onClick", "onInc");
             allWidget.add(wam);
             
             wam = new WidgetAttributeMap();
             wam.put("parentId", layout.activity_main);
             wam.put("id", id.button2);
             wam.put("type", "Button");
             wam.put("x", 0);
             wam.put("y", 200);
             wam.put("width", 200);
             wam.put("height", 80);
             wam.put("text", "switch");             
             allWidget.add(wam);
             
             wam = new WidgetAttributeMap();
             wam.put("parentId", layout.activity_back);
             wam.put("id", id.textView2);
             wam.put("type", "TextView");
             wam.put("x", 0);
             wam.put("y", 0);
             wam.put("width", 200);
             wam.put("height", 80);
             wam.put("text", "hello");
             allWidget.add(wam);
             
             wam = new WidgetAttributeMap();
             wam.put("parentId", layout.activity_back);
             wam.put("id", id.button3);
             wam.put("type", "Button");
             wam.put("x", 0);
             wam.put("y", 100);
             wam.put("width", 200);
             wam.put("height", 80);
             wam.put("text", "--");  
             //wam.put("onClick", "onInc");
             allWidget.add(wam);
             
             wam = new WidgetAttributeMap();
             wam.put("parentId", layout.activity_back);
             wam.put("id", id.button4);
             wam.put("type", "Button");
             wam.put("x", 0);
             wam.put("y", 200);
             wam.put("width", 200);
             wam.put("height", 80);
             wam.put("text", "back");             
             allWidget.add(wam);
        }
        
        public static final class mainactivity {
            
            public static final class textView {
                public static final int id = R.id.textView;
                public static final String type = "TextView";
                public static final int x = 0;
                public static final int y = 0;
                public static final int width = 200;
                public static final int height = 100;                   
            }
            
            public static final class button {
                public static final int id = R.id.button;
                public static final String type = "Button";
                public static final int x = 0;
                public static final int y = 100;
                public static final int width = 200;
                public static final int height = 100;
                public static final String text = "++";
                public static final String onClick = "onInc";
            }
            
            public static final class button3 {
                public static final int id = R.id.button3;
                public static final String type = "Button";
                public static final int x = 0;
                public static final int y = 200;
                public static final int width = 200;
                public static final int height = 100;
                public static final String text = "switch";
                public static final String onClick = "onSwitch";
            }
        }
        
        public static final class backactivity {
            
            public static final class button2 {
                public static final int id = R.id.button2;
                public static final String type = "Button";
                public static final int x = 0;
                public static final int y = 100;
                public static final int width = 200;
                public static final int height = 100;
                public static final String text = "--";
                public static final String onClick = "onDec";
            }
            
        }
    }
}
