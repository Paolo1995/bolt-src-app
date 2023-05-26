package ee.mtakso.driver.ui.screens.order.v2.order.ui;

import android.view.View;
import ee.mtakso.driver.ui.screens.order.v2.order.AppStickyBanner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StickyBannerViewDelegate.kt */
/* loaded from: classes3.dex */
public final class StickyBannerViewDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final View f32420a;

    /* renamed from: b  reason: collision with root package name */
    private AppStickyBanner f32421b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Integer, View> f32422c;

    public StickyBannerViewDelegate(View containerView) {
        Intrinsics.f(containerView, "containerView");
        this.f32422c = new LinkedHashMap();
        this.f32420a = containerView;
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32422c;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View c8 = c();
            if (c8 == null || (findViewById = c8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(ee.mtakso.driver.ui.screens.order.v2.order.AppStickyBanner r8) {
        /*
            r7 = this;
            ee.mtakso.driver.ui.screens.order.v2.order.AppStickyBanner r0 = r7.f32421b
            boolean r0 = kotlin.jvm.internal.Intrinsics.a(r8, r0)
            if (r0 == 0) goto L9
            return
        L9:
            android.view.View r0 = r7.c()
            r1 = 1
            r2 = 0
            if (r8 == 0) goto L1e
            java.lang.CharSequence r3 = r8.c()
            boolean r3 = kotlin.text.StringsKt.y(r3)
            r3 = r3 ^ r1
            if (r3 == 0) goto L1e
            r3 = 1
            goto L1f
        L1e:
            r3 = 0
        L1f:
            r4 = 2
            r5 = 0
            ee.mtakso.driver.uikit.utils.ViewExtKt.d(r0, r3, r2, r4, r5)
            int r0 = ee.mtakso.driver.R.id.minifiedTextView
            android.view.View r0 = r7.a(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r8 == 0) goto L33
            java.lang.CharSequence r3 = r8.c()
            goto L34
        L33:
            r3 = r5
        L34:
            r0.setText(r3)
            java.lang.String r0 = "minifiedStartIcon"
            if (r8 == 0) goto L4f
            ee.mtakso.driver.uikit.utils.Image r3 = r8.b()
            if (r3 == 0) goto L4f
            int r6 = ee.mtakso.driver.R.id.minifiedStartIcon
            android.view.View r6 = r7.a(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            kotlin.jvm.internal.Intrinsics.e(r6, r0)
            ee.mtakso.driver.uikit.utils.ImageKt.b(r3, r6, r5, r4, r5)
        L4f:
            int r3 = ee.mtakso.driver.R.id.minifiedStartIcon
            android.view.View r3 = r7.a(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            kotlin.jvm.internal.Intrinsics.e(r3, r0)
            if (r8 == 0) goto L61
            ee.mtakso.driver.uikit.utils.Image r0 = r8.b()
            goto L62
        L61:
            r0 = r5
        L62:
            if (r0 == 0) goto L65
            goto L66
        L65:
            r1 = 0
        L66:
            if (r1 == 0) goto L69
            goto L6b
        L69:
            r2 = 8
        L6b:
            r3.setVisibility(r2)
            if (r8 == 0) goto L74
            ee.mtakso.driver.uikit.utils.Color r5 = r8.a()
        L74:
            if (r5 == 0) goto L82
            android.view.View r0 = r7.c()
            ee.mtakso.driver.uikit.utils.Color r1 = r8.a()
            ee.mtakso.driver.uikit.utils.ViewExtKt.b(r0, r1)
            goto L91
        L82:
            android.view.View r0 = r7.c()
            ee.mtakso.driver.uikit.utils.Color$Res r1 = new ee.mtakso.driver.uikit.utils.Color$Res
            r2 = 2131099677(0x7f06001d, float:1.7811714E38)
            r1.<init>(r2)
            ee.mtakso.driver.uikit.utils.ViewExtKt.b(r0, r1)
        L91:
            r7.f32421b = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.v2.order.ui.StickyBannerViewDelegate.b(ee.mtakso.driver.ui.screens.order.v2.order.AppStickyBanner):void");
    }

    public View c() {
        return this.f32420a;
    }
}
