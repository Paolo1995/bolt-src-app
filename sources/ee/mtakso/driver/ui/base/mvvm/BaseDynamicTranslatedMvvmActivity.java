package ee.mtakso.driver.ui.base.mvvm;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import eu.bolt.driver.core.ui.translation.TranslatedContext;
import eu.bolt.driver.core.ui.translation.TranslatedResources;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseDynamicTranslatedMvvmActivity.kt */
/* loaded from: classes3.dex */
public abstract class BaseDynamicTranslatedMvvmActivity<T extends BaseViewModel> extends BaseMvvmActivity<T> {

    /* renamed from: m  reason: collision with root package name */
    private Resources f26233m;

    /* renamed from: n  reason: collision with root package name */
    public Map<Integer, View> f26234n = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        Intrinsics.f(newBase, "newBase");
        super.attachBaseContext(TranslatedContext.f41187b.a(newBase));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.f26233m;
        if (resources == null) {
            Resources resources2 = super.getResources();
            Intrinsics.e(resources2, "super.getResources()");
            resources = new TranslatedResources(resources2);
        }
        this.f26233m = resources;
        return resources;
    }
}
