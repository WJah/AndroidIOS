package android.widget;

import com.intel.inde.common.*;

import android.util.AttributeSet;
import android.view.View;
import ios.coregraphics.struct.*;
import ios.uikit.UIButton;
import ios.uikit.UIColor;
import ios.uikit.UILabel;

public class TextView extends View{

	public UILabel uilabel;
    private Context context;
    private ActivityViewController avc;
    
	public TextView(UILabel label) {
		uilabel = label;
	}
	
	public  TextView(Context c, AttributeSet as) {
        context = c;
        avc = context.getActivityViewController();
        
        uilabel = UILabel.alloc().initWithFrame(
                new CGRect(
                    new CGPoint(as.getAttributeIntValue(null, "x", 0), 
                                as.getAttributeIntValue(null, "y", 0)), 
                    new CGSize( as.getAttributeIntValue(null, "width", 0),
                                as.getAttributeIntValue(null, "height", 0))
                )
        );
        
        uilabel.setBackgroundColor(UIColor.blueColor());
        uilabel.setText(as.getAttributeStringValue(null, "text", ""));

        avc.addSubview(uilabel);
	}
	
	public void setText(String string) {
		// TODO Auto-generated method stub
		uilabel.setText(string);
	}

}
