package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.impl;

import android.content.res.Resources;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.AttributeSetUtils;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpinnerTranslationTransformer.kt */
/* loaded from: classes5.dex */
public final class SpinnerTranslationTransformer implements ViewDynamicTranslationTransformer<Spinner> {

    /* renamed from: a  reason: collision with root package name */
    public static final SpinnerTranslationTransformer f41285a = new SpinnerTranslationTransformer();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<Spinner> f41286b = Spinner.class;

    private SpinnerTranslationTransformer() {
    }

    private final void c(Spinner spinner, int i8, Resources resources) {
        CharSequence[] b8 = AttributeSetUtils.b(i8, resources);
        if (b8 != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(spinner.getContext(), 17367048, b8);
            arrayAdapter.setDropDownViewResource(17367049);
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    public Class<Spinner> b() {
        return f41286b;
    }

    @Override // eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewDynamicTranslationTransformer
    /* renamed from: d */
    public void a(Spinner view, String attrName, String attrValue, int i8, Resources resources) {
        boolean a8;
        Intrinsics.f(view, "view");
        Intrinsics.f(attrName, "attrName");
        Intrinsics.f(attrValue, "attrValue");
        Intrinsics.f(resources, "resources");
        if (Intrinsics.a(attrName, "entries")) {
            a8 = true;
        } else {
            a8 = Intrinsics.a(attrName, "android:entries");
        }
        if (a8) {
            c(view, i8, resources);
        }
    }
}
