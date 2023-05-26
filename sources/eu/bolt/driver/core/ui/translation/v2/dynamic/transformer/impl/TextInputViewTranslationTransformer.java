package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl;

import android.content.res.Resources;
import ee.mtakso.driver.uicore.components.views.input.TextInputView;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.AttributeSetUtils;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextInputViewTranslationTransformer.kt */
/* loaded from: classes5.dex */
public final class TextInputViewTranslationTransformer implements ViewDynamicTranslationTransformer<TextInputView> {

    /* renamed from: a  reason: collision with root package name */
    public static final TextInputViewTranslationTransformer f41291a = new TextInputViewTranslationTransformer();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<TextInputView> f41292b = TextInputView.class;

    private TextInputViewTranslationTransformer() {
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    public Class<TextInputView> b() {
        return f41292b;
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    /* renamed from: c */
    public void a(TextInputView view, String attrName, String attrValue, int i8, Resources resources) {
        Intrinsics.f(view, "view");
        Intrinsics.f(attrName, "attrName");
        Intrinsics.f(attrValue, "attrValue");
        Intrinsics.f(resources, "resources");
        int hashCode = attrName.hashCode();
        if (hashCode != -1026185038) {
            if (hashCode != 3202695) {
                if (hashCode != 1133306944 || !attrName.equals("app:hint")) {
                    return;
                }
            } else if (!attrName.equals("hint")) {
                return;
            }
        } else if (!attrName.equals("android:hint")) {
            return;
        }
        CharSequence c8 = AttributeSetUtils.c(i8, resources);
        if (c8 != null) {
            view.setHint(c8.toString());
        }
    }
}
