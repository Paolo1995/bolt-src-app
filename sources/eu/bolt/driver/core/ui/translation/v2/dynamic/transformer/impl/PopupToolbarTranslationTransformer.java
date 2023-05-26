package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl;

import android.content.res.Resources;
import ee.mtakso.driver.uicore.components.views.PopupToolbar;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.AttributeSetUtils;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupToolbarTranslationTransformer.kt */
/* loaded from: classes5.dex */
public final class PopupToolbarTranslationTransformer implements ViewDynamicTranslationTransformer<PopupToolbar> {

    /* renamed from: a  reason: collision with root package name */
    public static final PopupToolbarTranslationTransformer f41281a = new PopupToolbarTranslationTransformer();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<PopupToolbar> f41282b = PopupToolbar.class;

    private PopupToolbarTranslationTransformer() {
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    public Class<PopupToolbar> b() {
        return f41282b;
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    /* renamed from: c */
    public void a(PopupToolbar view, String attrName, String attrValue, int i8, Resources resources) {
        boolean a8;
        CharSequence c8;
        Intrinsics.f(view, "view");
        Intrinsics.f(attrName, "attrName");
        Intrinsics.f(attrValue, "attrValue");
        Intrinsics.f(resources, "resources");
        if (Intrinsics.a(attrName, "ptb_titleText")) {
            a8 = true;
        } else {
            a8 = Intrinsics.a(attrName, "app:ptb_titleText");
        }
        if (a8 && (c8 = AttributeSetUtils.c(i8, resources)) != null) {
            view.setTitle(c8.toString());
        }
    }
}
