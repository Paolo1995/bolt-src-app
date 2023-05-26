package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl;

import android.content.res.Resources;
import androidx.appcompat.widget.Toolbar;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.AttributeSetUtils;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppCompatToolbarTranslationTransformer.kt */
/* loaded from: classes5.dex */
public final class AppCompatToolbarTranslationTransformer implements ViewDynamicTranslationTransformer<Toolbar> {

    /* renamed from: a  reason: collision with root package name */
    public static final AppCompatToolbarTranslationTransformer f41265a = new AppCompatToolbarTranslationTransformer();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<Toolbar> f41266b = Toolbar.class;

    private AppCompatToolbarTranslationTransformer() {
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    public Class<Toolbar> b() {
        return f41266b;
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    /* renamed from: c */
    public void a(Toolbar view, String attrName, String attrValue, int i8, Resources resources) {
        boolean a8;
        CharSequence c8;
        Intrinsics.f(view, "view");
        Intrinsics.f(attrName, "attrName");
        Intrinsics.f(attrValue, "attrValue");
        Intrinsics.f(resources, "resources");
        if (Intrinsics.a(attrName, "title")) {
            a8 = true;
        } else {
            a8 = Intrinsics.a(attrName, "app:title");
        }
        if (a8 && (c8 = AttributeSetUtils.c(i8, resources)) != null) {
            view.setTitle(c8);
        }
    }
}
