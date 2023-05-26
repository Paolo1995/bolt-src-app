package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class Placeholder extends View {

    /* renamed from: f  reason: collision with root package name */
    private int f5181f;

    /* renamed from: g  reason: collision with root package name */
    private View f5182g;

    /* renamed from: h  reason: collision with root package name */
    private int f5183h;

    public void a(ConstraintLayout constraintLayout) {
        if (this.f5182g == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f5182g.getLayoutParams();
        layoutParams2.f5037v0.j1(0);
        ConstraintWidget.DimensionBehaviour A = layoutParams.f5037v0.A();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        if (A != dimensionBehaviour) {
            layoutParams.f5037v0.k1(layoutParams2.f5037v0.W());
        }
        if (layoutParams.f5037v0.T() != dimensionBehaviour) {
            layoutParams.f5037v0.L0(layoutParams2.f5037v0.x());
        }
        layoutParams2.f5037v0.j1(8);
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f5181f == -1 && !isInEditMode()) {
            setVisibility(this.f5183h);
        }
        View findViewById = constraintLayout.findViewById(this.f5181f);
        this.f5182g = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.LayoutParams) findViewById.getLayoutParams()).f5013j0 = true;
            this.f5182g.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f5182g;
    }

    public int getEmptyVisibility() {
        return this.f5183h;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i8) {
        View findViewById;
        if (this.f5181f == i8) {
            return;
        }
        View view = this.f5182g;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.LayoutParams) this.f5182g.getLayoutParams()).f5013j0 = false;
            this.f5182g = null;
        }
        this.f5181f = i8;
        if (i8 != -1 && (findViewById = ((View) getParent()).findViewById(i8)) != null) {
            findViewById.setVisibility(8);
        }
    }

    public void setEmptyVisibility(int i8) {
        this.f5183h = i8;
    }
}
