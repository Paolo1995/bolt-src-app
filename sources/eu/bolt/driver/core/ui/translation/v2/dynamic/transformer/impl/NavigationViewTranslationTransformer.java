package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl;

import android.content.res.Resources;
import android.view.Menu;
import com.google.android.material.navigation.NavigationView;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.AttributeSetUtils;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationViewTranslationTransformer.kt */
/* loaded from: classes5.dex */
public final class NavigationViewTranslationTransformer implements ViewDynamicTranslationTransformer<NavigationView> {

    /* renamed from: a  reason: collision with root package name */
    public static final NavigationViewTranslationTransformer f41279a = new NavigationViewTranslationTransformer();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<NavigationView> f41280b = NavigationView.class;

    private NavigationViewTranslationTransformer() {
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    public Class<NavigationView> b() {
        return f41280b;
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    /* renamed from: c */
    public void a(NavigationView view, String attrName, String attrValue, int i8, Resources resources) {
        boolean a8;
        Intrinsics.f(view, "view");
        Intrinsics.f(attrName, "attrName");
        Intrinsics.f(attrValue, "attrValue");
        Intrinsics.f(resources, "resources");
        if (Intrinsics.a(attrName, "menu")) {
            a8 = true;
        } else {
            a8 = Intrinsics.a(attrName, "app:menu");
        }
        if (a8) {
            Menu menu = view.getMenu();
            Intrinsics.e(menu, "view.menu");
            AttributeSetUtils.f(i8, menu, resources);
        }
    }
}
