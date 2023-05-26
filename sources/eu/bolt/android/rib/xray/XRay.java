package eu.bolt.android.rib.xray;

import android.view.View;
import eu.bolt.android.rib.ViewBuilder;
import java.util.WeakHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: XRay.kt */
/* loaded from: classes5.dex */
public final class XRay {

    /* renamed from: a  reason: collision with root package name */
    public static final XRay f37400a = new XRay();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f37401b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final WeakHashMap<View, Object> f37402c = new WeakHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static boolean f37403d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f37404e;

    private XRay() {
    }

    private final String b(ViewBuilder<?, ?> viewBuilder) {
        String F;
        String simpleName = viewBuilder.getClass().getSimpleName();
        Intrinsics.e(simpleName, "javaClass.simpleName");
        F = StringsKt__StringsJVMKt.F(simpleName, "Builder", "", false, 4, null);
        return F;
    }

    public final void a(ViewBuilder<?, ?> viewBuilder, View view) {
        Intrinsics.f(viewBuilder, "viewBuilder");
        Intrinsics.f(view, "view");
        XRayDrawable xRayDrawable = new XRayDrawable(b(viewBuilder), new Function0<Boolean>() { // from class: eu.bolt.android.rib.xray.XRay$addOverlay$drawable$1
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Boolean invoke() {
                return Boolean.valueOf(XRay.f37400a.d());
            }
        });
        f37402c.put(view, f37401b);
        view.getOverlay().add(xRayDrawable);
    }

    public final boolean c() {
        return f37404e;
    }

    public final boolean d() {
        return f37403d;
    }
}
