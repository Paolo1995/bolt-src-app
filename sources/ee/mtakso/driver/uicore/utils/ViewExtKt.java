package ee.mtakso.driver.uicore.utils;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewExt.kt */
/* loaded from: classes5.dex */
public final class ViewExtKt {
    public static final void a(final View view) {
        Intrinsics.f(view, "<this>");
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ee.mtakso.driver.uicore.utils.ViewExtKt$forceFreeBoundsWhenPossible$$inlined$doOnPreDraw$1
            /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:5:0x0017 -> B:6:0x0018). Please submit an issue!!! */
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onPreDraw() {
                /*
                    r3 = this;
                    android.view.View r0 = r1
                    android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()
                    r0.removeOnPreDrawListener(r3)
                    android.view.View r0 = r2
                    android.view.ViewParent r0 = r0.getParent()
                    boolean r1 = r0 instanceof android.view.ViewGroup
                    r2 = 0
                    if (r1 == 0) goto L17
                    android.view.ViewGroup r0 = (android.view.ViewGroup) r0
                    goto L18
                L17:
                    r0 = r2
                L18:
                    if (r0 == 0) goto L2c
                    r1 = 0
                    r0.setClipChildren(r1)
                    r0.setClipToPadding(r1)
                    android.view.ViewParent r0 = r0.getParent()
                    boolean r1 = r0 instanceof android.view.ViewGroup
                    if (r1 == 0) goto L17
                    android.view.ViewGroup r0 = (android.view.ViewGroup) r0
                    goto L18
                L2c:
                    r0 = 1
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uicore.utils.ViewExtKt$forceFreeBoundsWhenPossible$$inlined$doOnPreDraw$1.onPreDraw():boolean");
            }
        });
    }

    public static final boolean b(View view) {
        Intrinsics.f(view, "<this>");
        if (view.getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public static final void c(final View view, final Function0<Unit> action) {
        Intrinsics.f(view, "<this>");
        Intrinsics.f(action, "action");
        if (!view.getViewTreeObserver().isAlive()) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ee.mtakso.driver.uicore.utils.ViewExtKt$onGlobalLayout$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (!view.getViewTreeObserver().isAlive()) {
                    return;
                }
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                action.invoke();
            }
        });
    }

    public static final void d(View view, boolean z7, int i8) {
        Intrinsics.f(view, "<this>");
        if (z7) {
            view.setVisibility(0);
        } else {
            view.setVisibility(i8);
        }
    }

    public static /* synthetic */ void e(View view, boolean z7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            z7 = true;
        }
        if ((i9 & 2) != 0) {
            i8 = 8;
        }
        d(view, z7, i8);
    }
}
