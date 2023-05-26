package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public class AppCompatRatingBar extends RatingBar {

    /* renamed from: f  reason: collision with root package name */
    private final AppCompatProgressBarHelper f1883f;

    public AppCompatRatingBar(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.H);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        Bitmap b8 = this.f1883f.b();
        if (b8 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b8.getWidth() * getNumStars(), i8, 0), getMeasuredHeight());
        }
    }

    public AppCompatRatingBar(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        ThemeUtils.a(this, getContext());
        AppCompatProgressBarHelper appCompatProgressBarHelper = new AppCompatProgressBarHelper(this);
        this.f1883f = appCompatProgressBarHelper;
        appCompatProgressBarHelper.c(attributeSet, i8);
    }
}
