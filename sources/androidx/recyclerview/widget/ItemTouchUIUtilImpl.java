package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R$id;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ItemTouchUIUtilImpl implements ItemTouchUIUtil {

    /* renamed from: a  reason: collision with root package name */
    static final ItemTouchUIUtil f7121a = new ItemTouchUIUtilImpl();

    ItemTouchUIUtilImpl() {
    }

    private static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f8 = 0.0f;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = recyclerView.getChildAt(i8);
            if (childAt != view) {
                float y7 = ViewCompat.y(childAt);
                if (y7 > f8) {
                    f8 = y7;
                }
            }
        }
        return f8;
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void a(View view) {
        int i8 = R$id.item_touch_helper_previous_elevation;
        Object tag = view.getTag(i8);
        if (tag instanceof Float) {
            ViewCompat.A0(view, ((Float) tag).floatValue());
        }
        view.setTag(i8, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void b(View view) {
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void c(Canvas canvas, RecyclerView recyclerView, View view, float f8, float f9, int i8, boolean z7) {
        if (z7) {
            int i9 = R$id.item_touch_helper_previous_elevation;
            if (view.getTag(i9) == null) {
                Float valueOf = Float.valueOf(ViewCompat.y(view));
                ViewCompat.A0(view, e(recyclerView, view) + 1.0f);
                view.setTag(i9, valueOf);
            }
        }
        view.setTranslationX(f8);
        view.setTranslationY(f9);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void d(Canvas canvas, RecyclerView recyclerView, View view, float f8, float f9, int i8, boolean z7) {
    }
}
