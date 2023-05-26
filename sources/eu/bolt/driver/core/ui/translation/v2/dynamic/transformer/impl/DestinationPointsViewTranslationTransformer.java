package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl;

import android.content.res.Resources;
import ee.mtakso.driver.uicore.components.views.destination.DestinationPointsView;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.AttributeSetUtils;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DestinationPointsViewTranslationTransformer.kt */
/* loaded from: classes5.dex */
public final class DestinationPointsViewTranslationTransformer implements ViewDynamicTranslationTransformer<DestinationPointsView> {

    /* renamed from: a  reason: collision with root package name */
    public static final DestinationPointsViewTranslationTransformer f41277a = new DestinationPointsViewTranslationTransformer();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<DestinationPointsView> f41278b = DestinationPointsView.class;

    private DestinationPointsViewTranslationTransformer() {
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    public Class<DestinationPointsView> b() {
        return f41278b;
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    /* renamed from: c */
    public void a(DestinationPointsView view, String attrName, String attrValue, int i8, Resources resources) {
        boolean a8;
        CharSequence c8;
        Intrinsics.f(view, "view");
        Intrinsics.f(attrName, "attrName");
        Intrinsics.f(attrValue, "attrValue");
        Intrinsics.f(resources, "resources");
        if (Intrinsics.a(attrName, "dpv_change_point_text")) {
            a8 = true;
        } else {
            a8 = Intrinsics.a(attrName, "app:dpv_change_point_text");
        }
        if (a8 && (c8 = AttributeSetUtils.c(i8, resources)) != null) {
            view.setChangeText(c8);
        }
    }
}
