package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class Guideline extends View {

    /* renamed from: f  reason: collision with root package name */
    private boolean f5180f;

    public Guideline(Context context) {
        super(context);
        this.f5180f = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z7) {
        this.f5180f = z7;
    }

    public void setGuidelineBegin(int i8) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.f5180f && layoutParams.f4994a == i8) {
            return;
        }
        layoutParams.f4994a = i8;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i8) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.f5180f && layoutParams.f4996b == i8) {
            return;
        }
        layoutParams.f4996b = i8;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f8) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.f5180f && layoutParams.f4998c == f8) {
            return;
        }
        layoutParams.f4998c = f8;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5180f = true;
        super.setVisibility(8);
    }
}
