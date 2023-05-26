package ee.mtakso.driver.ui.screens.navigator_chooser;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.IntRange;

/* compiled from: NavigatorChooserItemDivider.kt */
/* loaded from: classes3.dex */
public final class NavigatorChooserItemDivider extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f30924a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    private float f30925b;

    /* renamed from: c  reason: collision with root package name */
    private float f30926c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f30927d;

    public NavigatorChooserItemDivider() {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.f30927d = paint;
    }

    private final IntRange n(int i8, int i9) {
        if (i9 <= Integer.MIN_VALUE) {
            return IntRange.f51059j.a();
        }
        return new IntRange(i8, i9 - 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void k(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        int i8;
        int width;
        int b8;
        Intrinsics.f(canvas, "canvas");
        Intrinsics.f(parent, "parent");
        Intrinsics.f(state, "state");
        super.k(canvas, parent, state);
        canvas.save();
        if (parent.getClipToPadding()) {
            i8 = parent.getPaddingLeft() + ((int) this.f30925b);
            width = (parent.getWidth() - parent.getPaddingRight()) - ((int) this.f30926c);
            canvas.clipRect(i8, parent.getPaddingTop(), width, parent.getHeight() - parent.getPaddingBottom());
        } else {
            i8 = (int) this.f30925b;
            width = parent.getWidth() - ((int) this.f30926c);
        }
        IntRange n8 = n(0, parent.getChildCount());
        int g8 = n8.g();
        int i9 = n8.i();
        if (g8 <= i9) {
            while (true) {
                View childAt = parent.getChildAt(g8);
                parent.l0(childAt, this.f30924a);
                int i10 = this.f30924a.bottom;
                b8 = MathKt__MathJVMKt.b(childAt.getTranslationY());
                float f8 = i10 + b8;
                canvas.drawLine(i8, f8, width, f8, this.f30927d);
                if (g8 == i9) {
                    break;
                }
                g8++;
            }
        }
        canvas.restore();
    }

    public final void l(int i8) {
        this.f30927d.setColor(i8);
    }

    public final void m(float f8) {
        this.f30925b = f8;
        this.f30926c = f8;
    }
}
