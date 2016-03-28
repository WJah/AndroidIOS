package com.intel.inde.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.util.AttributeSet;
import android.util.WidgetAttribute;
import android.util.WidgetAttributeMap;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.intel.inde.common.*;

public class Context {
	private ActivityViewController avc;
	private Map<Integer, View> id2view;
	private List<AttributeSet> was;
	private Bundle bundle;
	
	public Context() {
		avc = A2M.allocActivityViewController();
		avc.setContext(this);
		
		id2view = new HashMap<Integer, View>();
		was = null;
		bundle = null;
	}
	public ActivityViewController getActivityViewController() {
		return avc;
	}
	public View findViewById(int id) {
		return id2view.get(id);
	}
	
	public void setContentView(int layoutResID) {
		was = WidgetAttributeMap.alloc(layoutResID);
		
		for(AttributeSet as : was) {
		    
		    String typeName = as.getAttributeStringValue(null, "type", "unkown");
		    int id = as.getAttributeIntValue(null, "id", -1);
		    
		    if(typeName.equals("Button")) {
			    Button button = new Button(this, as);
			    id2view.put(id, button);
		    }
		    
		    if(typeName.equals("TextView")) {
		        TextView textView = new TextView(this, as);
		        id2view.put(id, textView);
		    }
		}
	}
	
	public void onCreate(Bundle savedInstanceState) {
	    
	}
	
	public void setVisible() {
	    avc.setVisible();
	}
}
