package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl;

import android.content.res.Resources;
import ee.mtakso.driver.uicore.components.views.swipe.SwipeButton;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.AttributeSetUtils;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipeButtonTranslationTransformer.kt */
/* loaded from: classes5.dex */
public final class SwipeButtonTranslationTransformer implements ViewDynamicTranslationTransformer<SwipeButton> {

    /* renamed from: a  reason: collision with root package name */
    public static final SwipeButtonTranslationTransformer f41287a = new SwipeButtonTranslationTransformer();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<SwipeButton> f41288b = SwipeButton.class;

    private SwipeButtonTranslationTransformer() {
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    public Class<SwipeButton> b() {
        return f41288b;
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    /* renamed from: c */
    public void a(SwipeButton view, String attrName, String attrValue, int i8, Resources resources) {
        boolean a8;
        CharSequence c8;
        Intrinsics.f(view, "view");
        Intrinsics.f(attrName, "attrName");
        Intrinsics.f(attrValue, "attrValue");
        Intrinsics.f(resources, "resources");
        if (Intrinsics.a(attrName, "sb_swipeText")) {
            a8 = true;
        } else {
            a8 = Intrinsics.a(attrName, "app:sb_swipeText");
        }
        if (a8 && (c8 = AttributeSetUtils.c(i8, resources)) != null) {
            view.setSwipeText(c8.toString());
        }
    }
}
