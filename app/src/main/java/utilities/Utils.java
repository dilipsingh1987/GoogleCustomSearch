package utilities;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public class Utils {

    /**
     * Method use for show snack bar
     *
     * @param coordinatorLayout this is for pass coordinatorLayout value
     * @param mMessage          this is pass message
     */
    public static void showSnackBar(CoordinatorLayout coordinatorLayout, String mMessage) {
        Snackbar snackbar = Snackbar.make(
                coordinatorLayout,
                mMessage,
                Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        TextView tv = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        tv.setMaxLines(3);
        snackbar.show();
    }

    /**
     * Hides the soft keyboard
     */
    public static void hideSoftKeyboard(Context context) {
        Activity activity = (Activity) context;
        if (activity.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager)
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            assert inputMethodManager != null;
            inputMethodManager.hideSoftInputFromWindow(activity
                    .getCurrentFocus().getWindowToken(), 0);
        }
    }
}
