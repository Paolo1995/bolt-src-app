package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer;

import android.content.res.Resources;
import android.view.View;

/* compiled from: ViewDynamicTranslationTransformer.kt */
/* loaded from: classes5.dex */
public interface ViewDynamicTranslationTransformer<T extends View> {
    void a(T t7, String str, String str2, int i8, Resources resources);

    Class<T> b();
}
