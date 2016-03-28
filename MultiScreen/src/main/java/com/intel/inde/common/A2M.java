package com.intel.inde.common;

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
import ios.uikit.UIViewController;
import ios.uikit.UIWindow;
import ios.uikit.c.UIKit;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.protocol.UIApplicationDelegate;

import com.intel.inde.moe.natj.general.*;
/**
import com.migeran.natj.general.NatJ;
import com.migeran.natj.general.Pointer;
import com.migeran.natj.general.ann.ByValue;
import com.migeran.natj.general.ann.Generated;
import com.migeran.natj.general.ann.Mapped;
import com.migeran.natj.general.ann.NInt;
import com.migeran.natj.general.ann.Owned;
import com.migeran.natj.objc.SEL;
import com.migeran.natj.objc.ann.IsOptional;
import com.migeran.natj.objc.ann.NotImplemented;
import com.migeran.natj.objc.ann.ObjCBlock;
import com.migeran.natj.objc.ann.Selector;
import com.migeran.natj.general.ann.NUInt;
**/

public class A2M {
	
	static private UIWindow window;
	
	static public void setWindow(UIWindow w) {
		window = w;
	}
	
	static public ActivityViewController allocActivityViewController() {
		ActivityViewController avc = ActivityViewController.alloc();
		avc.setWindow(window);
		return avc;
	}
	
}
