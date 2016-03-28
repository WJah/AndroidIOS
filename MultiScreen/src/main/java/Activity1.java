import ios.NSObject;
import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;
import ios.foundation.NSArray;
import ios.foundation.NSCoder;
import ios.foundation.NSData;
import ios.foundation.NSDictionary;
import ios.foundation.NSError;
import ios.foundation.NSURL;
import ios.foundation.NSUserActivity;
import ios.uikit.UIAlertView;
import ios.uikit.UIApplication;
import ios.uikit.UIButton;
import ios.uikit.UIColor;
import ios.uikit.UILocalNotification;
import ios.uikit.UIScreen;
import ios.uikit.UIUserNotificationSettings;
import ios.uikit.UIView;
import ios.uikit.UIViewController;
import ios.uikit.UIWindow;
import ios.uikit.c.UIKit;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.protocol.UIApplicationDelegate;

import com.intel.inde.common.ActivityViewController;
//import com.migeran.natj.general.NatJ;
//import com.migeran.natj.general.Pointer;
import com.intel.inde.moe.natj.general.NatJ;
import com.intel.inde.moe.natj.general.Pointer;
/*
import com.migeran.natj.general.ann.ByValue;
import com.migeran.natj.general.ann.Generated;
import com.migeran.natj.general.ann.Mapped;
import com.migeran.natj.general.ann.NInt;
import com.migeran.natj.general.ann.Owned;
*/
import com.intel.inde.moe.natj.general.ann.*;
//import com.intel.inde.moe.natj.general.ann.ByValue;
//import com.migeran.natj.objc.SEL;
import com.intel.inde.moe.natj.objc.SEL;
/*
import com.migeran.natj.objc.ann.IsOptional;
import com.migeran.natj.objc.ann.NotImplemented;
import com.migeran.natj.objc.ann.ObjCBlock;
import com.migeran.natj.objc.ann.Selector;
import com.migeran.natj.general.ann.NUInt;
*/
import com.intel.inde.moe.natj.objc.ann.*;

public class Activity1 extends ActivityViewController{
	static {
		NatJ.register();
	}
	
	@Generated("NatJ")
	@Owned
	@Selector("alloc")
	public static native Activity1 alloc();

	@Generated("NatJ")
	protected Activity1(Pointer peer) {
		super(peer);
		
	   UIButton button;
	   button = UIButton.alloc().initWithFrame(new CGRect(new CGPoint(100, 200), new CGSize(200, 50)));
	   button.setBackgroundColor(UIColor.blueColor());
	   button.setTitleForState("click me", 0);
	   addSubview(button);

	   button.addTargetActionForControlEvents(this, new SEL( "onClick:"), UIControlEvents.TouchUpInside);
	        
	}
	
	public ActivityViewController next;
	
	public void myInit() {
 
	}
	
	@Selector("onClick:")
	public void onClick(final UIButton sender) {
		System.out.printf("captured 1%n");
		next.setVisible();
    }
}
