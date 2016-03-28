package android.widget;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.util.AttributeSet;
import android.view.View;
import ios.coregraphics.struct.*;
import ios.uikit.UIButton;
import ios.uikit.UIColor;
import ios.uikit.UIView;

import com.intel.inde.common.*;

public class Button extends View {
    public UIButton uibutton;
    private Context context;
    private ActivityViewController avc;

	public Button(Context c, AttributeSet as) {
		
		context = c;
		avc = context.getActivityViewController();
		
        uibutton = UIButton.alloc().initWithFrame(
        		new CGRect(
        		    new CGPoint(as.getAttributeIntValue(null, "x", 0), 
        		                as.getAttributeIntValue(null, "y", 0)), 
        		    new CGSize( as.getAttributeIntValue(null, "width", 0),
        				        as.getAttributeIntValue(null, "height", 0))
        		)
        );
        
        uibutton.setBackgroundColor(UIColor.greenColor());
        uibutton.setTitleForState(as.getAttributeStringValue(null, "text", ""), 0);
        
        avc.addSubview(uibutton);
        
        String onClickAction = as.getAttributeStringValue(null, "onClick", null);
        
        if(onClickAction != null && !onClickAction.equals("")) {
        	Action action = new Action(context, this, uibutton, onClickAction);
        	avc.registerAction(uibutton, action);
        }
	}
	
	public void setOnClickListener(OnClickListener l) {
	    Action action = new Action(l, this, uibutton, "onClick");
	    avc.registerAction(uibutton, action);
	}
	
	public void SetText(String str) {
		uibutton.setTitleForState(str, 0);
	}
	
    public void handleAction(Action action, Object... args) {
        
        if(action.caller instanceof OnClickListener) {
            ((OnClickListener)(action.caller)).onClick(action.view);
            return;
        }
        
        Class<?> clazz = action.caller.getClass();
        Method method;
        
        try {
            method = clazz.getMethod(action.methodName, View.class);
            method.invoke(action.caller, action.view);
        } catch ( NoSuchMethodException 
                | IllegalAccessException 
                | IllegalArgumentException
                | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
