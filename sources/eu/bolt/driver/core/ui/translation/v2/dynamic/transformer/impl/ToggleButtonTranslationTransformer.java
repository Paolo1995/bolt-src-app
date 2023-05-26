package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl;

import android.widget.ToggleButton;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer;

/* compiled from: ToggleButtonTranslationTransformer.kt */
/* loaded from: classes5.dex */
public final class ToggleButtonTranslationTransformer implements ViewDynamicTranslationTransformer<ToggleButton> {

    /* renamed from: a  reason: collision with root package name */
    public static final ToggleButtonTranslationTransformer f41295a = new ToggleButtonTranslationTransformer();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<ToggleButton> f41296b = ToggleButton.class;

    private ToggleButtonTranslationTransformer() {
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    public Class<ToggleButton> b() {
        return f41296b;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.widget.ToggleButton r2, java.lang.String r3, java.lang.String r4, int r5, android.content.res.Resources r6) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "attrName"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "attrValue"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r4 = "resources"
            kotlin.jvm.internal.Intrinsics.f(r6, r4)
            int r4 = r3.hashCode()
            switch(r4) {
                case -1841314057: goto L41;
                case -1417853694: goto L38;
                case -877021204: goto L25;
                case 2018812759: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L53
        L1c:
            java.lang.String r4 = "android:textOn"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L2e
            goto L53
        L25:
            java.lang.String r4 = "textOn"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L2e
            goto L53
        L2e:
            java.lang.CharSequence r3 = eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.AttributeSetUtils.c(r5, r6)
            if (r3 == 0) goto L53
            r2.setTextOn(r3)
            goto L53
        L38:
            java.lang.String r4 = "textOff"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L4a
            goto L53
        L41:
            java.lang.String r4 = "android:textOff"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L4a
            goto L53
        L4a:
            java.lang.CharSequence r3 = eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.AttributeSetUtils.c(r5, r6)
            if (r3 == 0) goto L53
            r2.setTextOff(r3)
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.ToggleButtonTranslationTransformer.a(android.widget.ToggleButton, java.lang.String, java.lang.String, int, android.content.res.Resources):void");
    }
}
