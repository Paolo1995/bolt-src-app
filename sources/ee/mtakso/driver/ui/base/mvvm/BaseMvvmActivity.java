package ee.mtakso.driver.ui.base.mvvm;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.lifecycle.Observer;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.permission.watchdog.PermissionWatchDog;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseMvvmActivity.kt */
/* loaded from: classes3.dex */
public abstract class BaseMvvmActivity<T extends BaseViewModel> extends AppCompatActivity {

    /* renamed from: l  reason: collision with root package name */
    public static final Companion f26235l = new Companion(null);
    @Inject

    /* renamed from: f  reason: collision with root package name */
    public ScreenAnalytics f26236f;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    public ViewModelFactory f26237g;
    @Inject

    /* renamed from: h  reason: collision with root package name */
    public PermissionManager f26238h;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public FragmentFactory f26239i;

    /* renamed from: j  reason: collision with root package name */
    private PermissionWatchDog f26240j;

    /* renamed from: k  reason: collision with root package name */
    public Map<Integer, View> f26241k = new LinkedHashMap();

    /* compiled from: BaseMvvmActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void U(BaseViewModel baseViewModel) {
        baseViewModel.C();
        baseViewModel.w().i(this, new Observer() { // from class: l2.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMvvmActivity.V(BaseMvvmActivity.this, (Throwable) obj);
            }
        });
        baseViewModel.x().i(this, new Observer() { // from class: l2.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMvvmActivity.W(BaseMvvmActivity.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(BaseMvvmActivity this$0, Throwable it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.X(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(BaseMvvmActivity this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        if (it.booleanValue()) {
            this$0.Y();
        } else {
            this$0.S();
        }
    }

    public final FragmentFactory N() {
        FragmentFactory fragmentFactory = this.f26239i;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Intrinsics.w("fragmentFactory");
        return null;
    }

    public final PermissionManager O() {
        PermissionManager permissionManager = this.f26238h;
        if (permissionManager != null) {
            return permissionManager;
        }
        Intrinsics.w("permissionsManager");
        return null;
    }

    public final ScreenAnalytics P() {
        ScreenAnalytics screenAnalytics = this.f26236f;
        if (screenAnalytics != null) {
            return screenAnalytics;
        }
        Intrinsics.w("screenAnalytics");
        return null;
    }

    protected abstract T Q();

    public final ViewModelFactory R() {
        ViewModelFactory viewModelFactory = this.f26237g;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.w("viewModelFactory");
        return null;
    }

    protected void S() {
    }

    protected abstract void T();

    protected void X(Throwable error) {
        Intrinsics.f(error, "error");
    }

    protected void Y() {
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(Configuration configuration) {
        Configuration configuration2;
        if (configuration != null) {
            int i8 = configuration.uiMode;
            Resources resources = getResources();
            if (resources != null) {
                configuration2 = resources.getConfiguration();
            } else {
                configuration2 = null;
            }
            configuration.setTo(configuration2);
            configuration.uiMode = i8;
        }
        super.applyOverrideConfiguration(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        Intrinsics.f(newBase, "newBase");
        super.attachBaseContext(Injector.f20166d.b().a().b(newBase));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        T();
        getSupportFragmentManager().setFragmentFactory(N());
        super.onCreate(bundle);
        if (bundle != null && bundle.getInt("process_id") != Process.myPid()) {
            AppRoutingManager.f25869b.c(this);
            finish();
        }
        this.f26240j = O().f(this);
        ScreenAnalytics P = P();
        String name = getClass().getName();
        Intrinsics.e(name, "this.javaClass.name");
        P.j1(name);
        U(Q());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i8, String[] permissions, int[] grantResults) {
        Intrinsics.f(permissions, "permissions");
        Intrinsics.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i8, permissions, grantResults);
        PermissionWatchDog permissionWatchDog = this.f26240j;
        if (permissionWatchDog != null) {
            permissionWatchDog.c(i8, permissions, grantResults);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.f(outState, "outState");
        outState.putInt("process_id", Process.myPid());
        super.onSaveInstanceState(outState);
    }

    @Override // android.app.Activity
    public void setTitle(int i8) {
        super.setTitle(getString(i8));
    }
}
