package android.view;

import ios.uikit.UIView;

import com.intel.inde.common.*;

public class View {
    
    public interface OnClickListener {
        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
         void onClick(View v);
    }
    
    public void handleAction(Action action, Object... args) {
        
    }
}
