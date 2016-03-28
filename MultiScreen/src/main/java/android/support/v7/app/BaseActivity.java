package android.support.v7.app;

import java.util.HashMap;
import java.util.Map;

import android.view.View;

public class BaseActivity {
	protected Map<Integer, View> id2view;
	
	public BaseActivity() {
        id2view = new HashMap<Integer, View>();
	}
	
	View findViewById(int id) {
		return id2view.get(id);
	}
}
