package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl;

import android.widget.TextView;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer;

/* compiled from: TextViewTranslationTransformer.kt */
/* loaded from: classes5.dex */
public final class TextViewTranslationTransformer implements ViewDynamicTranslationTransformer<TextView> {

    /* renamed from: a  reason: collision with root package name */
    public static final TextViewTranslationTransformer f41293a = new TextViewTranslationTransformer();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<TextView> f41294b = TextView.class;

    private TextViewTranslationTransformer() {
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    public Class<TextView> b() {
        return f41294b;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.widget.TextView r2, java.lang.String r3, java.lang.String r4, int r5, android.content.res.Resources r6) {
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
                case -1026185038: goto L41;
                case -1025831080: goto L2e;
                case 3202695: goto L25;
                case 3556653: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L53
        L1c:
            java.lang.String r4 = "text"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L53
            goto L37
        L25:
            java.lang.String r4 = "hint"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L4a
            goto L53
        L2e:
            java.lang.String r4 = "android:text"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L37
            goto L53
        L37:
            java.lang.CharSequence r3 = eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.AttributeSetUtils.c(r5, r6)
            if (r3 == 0) goto L53
            r2.setText(r3)
            goto L53
        L41:
            java.lang.String r4 = "android:hint"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L4a
            goto L53
        L4a:
            java.lang.CharSequence r3 = eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.AttributeSetUtils.c(r5, r6)
            if (r3 == 0) goto L53
            r2.setHint(r3)
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.TextViewTranslationTransformer.a(android.widget.TextView, java.lang.String, java.lang.String, int, android.content.res.Resources):void");
    }
}
