package ee.mtakso.driver.uicore.components.recyclerview.decorations;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListItemDividerDecoration.kt */
/* loaded from: classes5.dex */
public final class ListItemDividerDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final float f34827a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f34828b;

    public ListItemDividerDecoration(float f8) {
        this.f34827a = f8;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f34828b = paint;
    }

    private final float l(DividerModel dividerModel) {
        if (dividerModel.k()) {
            return 0.0f;
        }
        return this.f34827a;
    }

    private final float m(DividerModel dividerModel, View view) {
        int bottom;
        float f8;
        if (dividerModel.j()) {
            bottom = view.getTop();
        } else {
            bottom = view.getBottom();
        }
        float translationY = bottom + view.getTranslationY();
        Float i8 = dividerModel.i();
        if (i8 != null) {
            f8 = i8.floatValue();
        } else {
            f8 = 0.0f;
        }
        return translationY + (f8 / 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void g(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        DiffAdapter diffAdapter;
        DividerModel dividerModel;
        float f8;
        Intrinsics.f(outRect, "outRect");
        Intrinsics.f(view, "view");
        Intrinsics.f(parent, "parent");
        Intrinsics.f(state, "state");
        super.g(outRect, view, parent, state);
        int h02 = parent.h0(view);
        if (h02 == -1) {
            return;
        }
        RecyclerView.Adapter adapter = parent.getAdapter();
        Color color = null;
        if (adapter instanceof DiffAdapter) {
            diffAdapter = (DiffAdapter) adapter;
        } else {
            diffAdapter = null;
        }
        if (diffAdapter == null) {
            return;
        }
        ListModel R = diffAdapter.R(h02);
        if (R instanceof DividerModel) {
            dividerModel = (DividerModel) R;
        } else {
            dividerModel = null;
        }
        if (dividerModel != null) {
            color = dividerModel.d();
        }
        if (color != null) {
            int i8 = outRect.bottom;
            Float i9 = dividerModel.i();
            if (i9 != null) {
                f8 = i9.floatValue();
            } else {
                f8 = 0.0f;
            }
            outRect.bottom = i8 + ((int) f8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void i(Canvas c8, RecyclerView parent, RecyclerView.State state) {
        DiffAdapter diffAdapter;
        DividerModel dividerModel;
        float f8;
        String str;
        Intrinsics.f(c8, "c");
        Intrinsics.f(parent, "parent");
        Intrinsics.f(state, "state");
        super.i(c8, parent, state);
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter instanceof DiffAdapter) {
            diffAdapter = (DiffAdapter) adapter;
        } else {
            diffAdapter = null;
        }
        if (diffAdapter == null) {
            return;
        }
        int childCount = parent.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View view = parent.getChildAt(i8);
            int h02 = parent.h0(view);
            if (h02 != -1) {
                Context context = view.getContext();
                ListModel R = diffAdapter.R(h02);
                if (R instanceof DividerModel) {
                    dividerModel = (DividerModel) R;
                } else {
                    dividerModel = null;
                }
                if (dividerModel != null && dividerModel.e() && dividerModel.d() != null) {
                    Paint paint = this.f34828b;
                    Float i9 = dividerModel.i();
                    if (i9 != null) {
                        f8 = i9.floatValue();
                    } else {
                        f8 = 0.0f;
                    }
                    paint.setStrokeWidth(f8);
                    this.f34828b.setAlpha((int) (view.getAlpha() * 255));
                    float left = view.getLeft() + view.getTranslationX();
                    float translationX = view.getTranslationX() + view.getRight();
                    float l8 = left + l(dividerModel);
                    float l9 = translationX - l(dividerModel);
                    Intrinsics.e(view, "view");
                    float m8 = m(dividerModel, view);
                    Color f9 = dividerModel.f();
                    if (f9 == null) {
                        str = "context";
                    } else {
                        Paint paint2 = this.f34828b;
                        Intrinsics.e(context, "context");
                        paint2.setColor(ColorKt.a(f9, context));
                        str = "context";
                        c8.drawLine(left, m8, translationX, m8, this.f34828b);
                    }
                    Paint paint3 = this.f34828b;
                    Color d8 = dividerModel.d();
                    if (d8 != null) {
                        Intrinsics.e(context, str);
                        paint3.setColor(ColorKt.a(d8, context));
                        c8.drawLine(l8, m8, l9, m8, this.f34828b);
                    }
                }
            }
        }
    }
}
