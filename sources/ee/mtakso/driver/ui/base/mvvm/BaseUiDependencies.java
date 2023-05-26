package ee.mtakso.driver.ui.base.mvvm;

import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseUiDependencies.kt */
/* loaded from: classes3.dex */
public final class BaseUiDependencies {

    /* renamed from: a  reason: collision with root package name */
    private final ScreenAnalytics f26263a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewModelProvider.Factory f26264b;

    /* renamed from: c  reason: collision with root package name */
    private final PermissionManager f26265c;

    /* renamed from: d  reason: collision with root package name */
    private final AppThemeManager f26266d;

    @Inject
    public BaseUiDependencies(ScreenAnalytics screenAnalytics, ViewModelProvider.Factory viewModelFactory, PermissionManager permissionManager, AppThemeManager appThemeManager) {
        Intrinsics.f(screenAnalytics, "screenAnalytics");
        Intrinsics.f(viewModelFactory, "viewModelFactory");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(appThemeManager, "appThemeManager");
        this.f26263a = screenAnalytics;
        this.f26264b = viewModelFactory;
        this.f26265c = permissionManager;
        this.f26266d = appThemeManager;
    }

    public final AppThemeManager a() {
        return this.f26266d;
    }

    public final PermissionManager b() {
        return this.f26265c;
    }

    public final ScreenAnalytics c() {
        return this.f26263a;
    }

    public final ViewModelProvider.Factory d() {
        return this.f26264b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BaseUiDependencies) {
            BaseUiDependencies baseUiDependencies = (BaseUiDependencies) obj;
            return Intrinsics.a(this.f26263a, baseUiDependencies.f26263a) && Intrinsics.a(this.f26264b, baseUiDependencies.f26264b) && Intrinsics.a(this.f26265c, baseUiDependencies.f26265c) && Intrinsics.a(this.f26266d, baseUiDependencies.f26266d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f26263a.hashCode() * 31) + this.f26264b.hashCode()) * 31) + this.f26265c.hashCode()) * 31) + this.f26266d.hashCode();
    }

    public String toString() {
        ScreenAnalytics screenAnalytics = this.f26263a;
        ViewModelProvider.Factory factory = this.f26264b;
        PermissionManager permissionManager = this.f26265c;
        AppThemeManager appThemeManager = this.f26266d;
        return "BaseUiDependencies(screenAnalytics=" + screenAnalytics + ", viewModelFactory=" + factory + ", permissionManager=" + permissionManager + ", appThemeManager=" + appThemeManager + ")";
    }
}
