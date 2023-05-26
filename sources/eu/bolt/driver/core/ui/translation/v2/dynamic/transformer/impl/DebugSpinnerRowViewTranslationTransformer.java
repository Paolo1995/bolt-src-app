package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl;

import android.content.res.Resources;
import ee.mtakso.driver.uicore.components.views.debug.DebugSpinnerRowView;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.AttributeSetUtils;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugSpinnerRowViewTranslationTransformer.kt */
/* loaded from: classes5.dex */
public final class DebugSpinnerRowViewTranslationTransformer implements ViewDynamicTranslationTransformer<DebugSpinnerRowView> {

    /* renamed from: a  reason: collision with root package name */
    public static final DebugSpinnerRowViewTranslationTransformer f41273a = new DebugSpinnerRowViewTranslationTransformer();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<DebugSpinnerRowView> f41274b = DebugSpinnerRowView.class;

    private DebugSpinnerRowViewTranslationTransformer() {
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    public Class<DebugSpinnerRowView> b() {
        return f41274b;
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    /* renamed from: c */
    public void a(DebugSpinnerRowView view, String attrName, String attrValue, int i8, Resources resources) {
        boolean a8;
        CharSequence c8;
        Intrinsics.f(view, "view");
        Intrinsics.f(attrName, "attrName");
        Intrinsics.f(attrValue, "attrValue");
        Intrinsics.f(resources, "resources");
        if (Intrinsics.a(attrName, "dsr_title")) {
            a8 = true;
        } else {
            a8 = Intrinsics.a(attrName, "app:dsr_title");
        }
        if (a8 && (c8 = AttributeSetUtils.c(i8, resources)) != null) {
            view.setTitle(c8);
        }
    }
}
