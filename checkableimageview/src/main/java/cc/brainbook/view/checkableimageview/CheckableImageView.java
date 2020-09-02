package cc.brainbook.view.checkableimageview;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.Checkable;

/**
 * Description.
 *
 * @author Robert Han
 * @email brainbook.cc@outlook.com
 * @website www.brainbook.cc
 * @time 2018/7/12 13:35
 */
public class CheckableImageView extends AppCompatImageView implements Checkable{
    private static final int[] CHECKED_STATE_SET = {
            android.R.attr.state_checked
    };

    private boolean mChecked;

    public CheckableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public CheckableImageView(Context context) {
        super(context);
    }

    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    public void toggle() {
        setChecked(!mChecked);
    }

    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;
            refreshDrawableState();
        }
    }

    @Override
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    ///https://stackoverflow.com/questions/5430322/checkable-imageview
//    @Override
//    protected void drawableStateChanged() {
//        super.drawableStateChanged();
//        invalidate();
//    }
}
