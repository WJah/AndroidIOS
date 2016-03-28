package com.intel.inde.common;

import java.util.HashMap;
import java.util.Map;

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

//import com.migeran.natj.general.NatJ;
import com.intel.inde.moe.natj.general.NatJ;
import com.intel.inde.moe.natj.general.ann.ByValue;
import com.intel.inde.moe.natj.general.ann.Generated;
import com.intel.inde.moe.natj.general.ann.Mapped;
import com.intel.inde.moe.natj.general.ann.NInt;
import com.intel.inde.moe.natj.general.ann.Owned;
//import com.migeran.natj.general.Pointer;
import com.intel.inde.moe.natj.general.Pointer;
/*
import com.migeran.natj.general.ann.ByValue;
import com.migeran.natj.general.ann.Generated;
import com.migeran.natj.general.ann.Mapped;
import com.migeran.natj.general.ann.NInt;
import com.migeran.natj.general.ann.Owned;
*/
//import com.migeran.natj.objc.SEL;
import com.intel.inde.moe.natj.objc.SEL;
import com.intel.inde.moe.natj.objc.ann.ObjCBlock;
import com.intel.inde.moe.natj.objc.ann.IsOptional;
import com.intel.inde.moe.natj.objc.ann.NotImplemented;
import com.intel.inde.moe.natj.objc.ann.Selector;
import com.intel.inde.moe.natj.general.ann.NUInt;
/*
import com.migeran.natj.objc.ann.IsOptional;
import com.migeran.natj.objc.ann.NotImplemented;
import com.migeran.natj.objc.ann.ObjCBlock;
import com.migeran.natj.objc.ann.Selector;
import com.migeran.natj.general.ann.NUInt;
*/

import android.support.v7.app.Activity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.*;

public class ActivityViewController extends NSObject {
    
    private Map<UIView, Action> uiview2action;
    
    static {
        NatJ.register();
    }
    
    @Generated("NatJ")
    @Owned
    @Selector("alloc")
    public static native ActivityViewController alloc();

    @Generated("NatJ")
    protected ActivityViewController(Pointer peer) {
        super(peer);
        uiViewController = UIViewController.alloc().init();
        uiview2action = new HashMap<UIView, Action>();
    }
    
    private UIWindow window;
    private UIViewController uiViewController;
    private Context context;
    
    public void setWindow(UIWindow w) {
        window = w;
    }
    
    public void setContext(Context c) {
        context = c;
    }
    
    public UIViewController getViewController() {
        return uiViewController;
    }

    public void addSubview(UIView view) {
        uiViewController.view().addSubview(view);
    }
    
    public void setVisible() {
        window.setRootViewController(getViewController());
        window.makeKeyAndVisible();
    }
    
    public void registerAction(UIView uiview, Action action) {
        uiview2action.put(uiview, action);
        if(uiview instanceof UIButton) {
            ((UIButton)uiview).addTargetActionForControlEvents(this, new SEL( "onTouchUpInside:"), UIControlEvents.TouchUpInside);
        }
    }

    public void unregisterAction(UIView uiview) {
        uiview2action.remove(uiview);
    }
    
    @Selector("onTouchUpInside:")
    public void onTouchUpInside(final UIButton sender) {
        Action action = uiview2action.get(sender);
        action.view.handleAction(action);
    }
    
    
}
