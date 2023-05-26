package ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SafetyToolkitMapper_Factory implements Factory<SafetyToolkitMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PermissionManager> f32827a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<HtmlEngine> f32828b;

    public SafetyToolkitMapper_Factory(Provider<PermissionManager> provider, Provider<HtmlEngine> provider2) {
        this.f32827a = provider;
        this.f32828b = provider2;
    }

    public static SafetyToolkitMapper_Factory a(Provider<PermissionManager> provider, Provider<HtmlEngine> provider2) {
        return new SafetyToolkitMapper_Factory(provider, provider2);
    }

    public static SafetyToolkitMapper c(PermissionManager permissionManager, HtmlEngine htmlEngine) {
        return new SafetyToolkitMapper(permissionManager, htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SafetyToolkitMapper get() {
        return c(this.f32827a.get(), this.f32828b.get());
    }
}
