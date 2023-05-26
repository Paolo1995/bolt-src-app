package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer;

import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.AppCompatToolbarTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.BottomNavigationViewTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.CustomListItemTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.DebugItemRowViewTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.DebugSpinnerRowViewTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.DestinationButtonTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.DestinationPointsViewTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.NavigationViewTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.PopupToolbarTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.RoundButtonTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.SpinnerTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.SwipeButtonTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.SwitchTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.TextInputViewTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.TextViewTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.ToggleButtonTranslationTransformer;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl.ToolbarTranslationTransformer;
import java.util.HashMap;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: ViewTranslationTransformerManager.kt */
/* loaded from: classes5.dex */
public final class ViewTranslationTransformerManager {

    /* renamed from: a  reason: collision with root package name */
    public static final ViewTranslationTransformerManager f41263a;

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<Class<View>, ViewDynamicTranslationTransformer<View>> f41264b;

    static {
        ViewTranslationTransformerManager viewTranslationTransformerManager = new ViewTranslationTransformerManager();
        f41263a = viewTranslationTransformerManager;
        f41264b = new HashMap<>();
        viewTranslationTransformerManager.a(AppCompatToolbarTranslationTransformer.f41265a);
        viewTranslationTransformerManager.a(BottomNavigationViewTranslationTransformer.f41267a);
        viewTranslationTransformerManager.a(CustomListItemTranslationTransformer.f41269a);
        viewTranslationTransformerManager.a(DebugItemRowViewTranslationTransformer.f41271a);
        viewTranslationTransformerManager.a(DebugSpinnerRowViewTranslationTransformer.f41273a);
        viewTranslationTransformerManager.a(DestinationButtonTranslationTransformer.f41275a);
        viewTranslationTransformerManager.a(NavigationViewTranslationTransformer.f41279a);
        viewTranslationTransformerManager.a(PopupToolbarTranslationTransformer.f41281a);
        viewTranslationTransformerManager.a(SpinnerTranslationTransformer.f41285a);
        viewTranslationTransformerManager.a(SwipeButtonTranslationTransformer.f41287a);
        viewTranslationTransformerManager.a(SwitchTranslationTransformer.f41289a);
        viewTranslationTransformerManager.a(TextViewTranslationTransformer.f41293a);
        viewTranslationTransformerManager.a(ToggleButtonTranslationTransformer.f41295a);
        viewTranslationTransformerManager.a(ToolbarTranslationTransformer.f41297a);
        viewTranslationTransformerManager.a(TextInputViewTranslationTransformer.f41291a);
        viewTranslationTransformerManager.a(DestinationPointsViewTranslationTransformer.f41277a);
        viewTranslationTransformerManager.a(RoundButtonTranslationTransformer.f41283a);
    }

    private ViewTranslationTransformerManager() {
    }

    public final <T extends View> ViewDynamicTranslationTransformer<View> a(ViewDynamicTranslationTransformer<T> transformer) {
        Intrinsics.f(transformer, "transformer");
        HashMap<Class<View>, ViewDynamicTranslationTransformer<View>> hashMap = f41264b;
        Class<T> b8 = transformer.b();
        Intrinsics.d(b8, "null cannot be cast to non-null type java.lang.Class<android.view.View>");
        return hashMap.put(b8, transformer);
    }

    public final View b(View view, AttributeSet attributeSet, Resources resources) {
        boolean L;
        ViewDynamicTranslationTransformer<View> viewDynamicTranslationTransformer;
        Intrinsics.f(resources, "resources");
        if (view == null || attributeSet == null) {
            return null;
        }
        Set<Class<View>> keySet = f41264b.keySet();
        Intrinsics.e(keySet, "transformers.keys");
        int attributeCount = attributeSet.getAttributeCount();
        for (int i8 = 0; i8 < attributeCount; i8++) {
            String attributeValue = attributeSet.getAttributeValue(i8);
            if (attributeValue != null) {
                L = StringsKt__StringsJVMKt.L(attributeValue, "@", false, 2, null);
                if (L) {
                    String attrName = attributeSet.getAttributeName(i8);
                    int attributeResourceValue = attributeSet.getAttributeResourceValue(i8, 0);
                    for (Class<View> cls : keySet) {
                        if (cls.isAssignableFrom(view.getClass()) && (viewDynamicTranslationTransformer = f41264b.get(cls)) != null) {
                            Intrinsics.e(attrName, "attrName");
                            viewDynamicTranslationTransformer.a(view, attrName, attributeValue, attributeResourceValue, resources);
                        }
                    }
                }
            }
        }
        return view;
    }
}
