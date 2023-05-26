package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl;

import android.content.res.Resources;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.AttributeSetUtils;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoundButtonTranslationTransformer.kt */
/* loaded from: classes5.dex */
public final class RoundButtonTranslationTransformer implements ViewDynamicTranslationTransformer<RoundButton> {

    /* renamed from: a  reason: collision with root package name */
    public static final RoundButtonTranslationTransformer f41283a = new RoundButtonTranslationTransformer();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<RoundButton> f41284b = RoundButton.class;

    private RoundButtonTranslationTransformer() {
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    public Class<RoundButton> b() {
        return f41284b;
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    /* renamed from: c */
    public void a(RoundButton view, String attrName, String attrValue, int i8, Resources resources) {
        boolean a8;
        CharSequence c8;
        Intrinsics.f(view, "view");
        Intrinsics.f(attrName, "attrName");
        Intrinsics.f(attrValue, "attrValue");
        Intrinsics.f(resources, "resources");
        if (Intrinsics.a(attrName, "text")) {
            a8 = true;
        } else {
            a8 = Intrinsics.a(attrName, "android:text");
        }
        if (a8 && (c8 = AttributeSetUtils.c(i8, resources)) != null) {
            view.setText(c8);
        }
    }
}
