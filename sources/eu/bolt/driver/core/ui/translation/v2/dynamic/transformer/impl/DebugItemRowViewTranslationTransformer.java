package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl;

import android.content.res.Resources;
import ee.mtakso.driver.uicore.components.views.debug.DebugItemRowView;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.AttributeSetUtils;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugItemRowViewTranslationTransformer.kt */
/* loaded from: classes5.dex */
public final class DebugItemRowViewTranslationTransformer implements ViewDynamicTranslationTransformer<DebugItemRowView> {

    /* renamed from: a  reason: collision with root package name */
    public static final DebugItemRowViewTranslationTransformer f41271a = new DebugItemRowViewTranslationTransformer();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<DebugItemRowView> f41272b = DebugItemRowView.class;

    private DebugItemRowViewTranslationTransformer() {
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    public Class<DebugItemRowView> b() {
        return f41272b;
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    /* renamed from: c */
    public void a(DebugItemRowView view, String attrName, String attrValue, int i8, Resources resources) {
        boolean a8;
        CharSequence c8;
        Intrinsics.f(view, "view");
        Intrinsics.f(attrName, "attrName");
        Intrinsics.f(attrValue, "attrValue");
        Intrinsics.f(resources, "resources");
        if (Intrinsics.a(attrName, "dir_title")) {
            a8 = true;
        } else {
            a8 = Intrinsics.a(attrName, "app:dir_title");
        }
        if (a8 && (c8 = AttributeSetUtils.c(i8, resources)) != null) {
            view.setTitle(c8);
        }
    }
}
