package com.intel.inde.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ios.uikit.UIView;
import android.view.View;

public class Action {
    
    public Object caller;
	public View view;
	public UIView uiview;
	public String methodName;
	
	public Action(Object c, View v, UIView uiv, String m) {
	    caller = c;
		view = v;
		uiview = uiv;
		methodName = m;
	}
	
	public void involk(Object... args) {
	    Class<?> clazz = caller.getClass();
	    Method method = null;
	    
	    try {
	        if(args.length == 0) {
	            method = clazz.getMethod(methodName);
	            method.invoke(caller);
	        } else if(args.length == 1) {
	            method = clazz.getMethod(methodName, args[0].getClass());
	            method.invoke(caller, args[0]);
	        } else if(args.length == 2) {
                method = clazz.getMethod(methodName, args[0].getClass(), args[1].getClass());
                method.invoke(caller, args[0], args[1]);	            
	        }
	        
	    } catch (NoSuchMethodException 
	            | IllegalAccessException 
	            | IllegalArgumentException
	            | InvocationTargetException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    
	}
}
