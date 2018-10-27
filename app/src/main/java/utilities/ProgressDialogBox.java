package utilities;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;

import com.googlecustomsearch.googlecustomsearch.R;

public class ProgressDialogBox extends ProgressDialog {

    private ProgressDialogBox(Context context) {
        super(context);
    }

    /**
     * Method use for show progress dialog
     * @param context
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static ProgressDialogBox showProgressDialog(Context context){
        ProgressDialogBox mProgressDialogBox = new ProgressDialogBox(context);
        mProgressDialogBox.setTitle(context.getResources()
                .getString(R.string.please_wait));
        if (mProgressDialogBox.getWindow()!=null) {
            mProgressDialogBox.getWindow()
                    .setBackgroundDrawable(new ColorDrawable(context.getResources()
                            .getColor(android.R.color.transparent)));
            mProgressDialogBox.getWindow().setDimAmount(0.05f);
        }
        mProgressDialogBox.show();
        mProgressDialogBox.setContentView(R.layout.progress_bar);
        mProgressDialogBox.setCanceledOnTouchOutside(false);
        return mProgressDialogBox;
    }

}
