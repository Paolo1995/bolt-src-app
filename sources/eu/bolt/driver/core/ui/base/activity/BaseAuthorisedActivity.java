package eu.bolt.driver.core.ui.base.activity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import eu.bolt.driver.core.DriverCore;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.translation.v2.TranslationHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseAuthorisedActivity.kt */
/* loaded from: classes5.dex */
public abstract class BaseAuthorisedActivity extends BaseActivity {

    /* renamed from: m  reason: collision with root package name */
    public static final Companion f41004m = new Companion(null);
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public RoutingManager f41005j;

    /* renamed from: k  reason: collision with root package name */
    private int f41006k;

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, View> f41007l = new LinkedHashMap();

    /* compiled from: BaseAuthorisedActivity.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final boolean O() {
        int i8 = this.f41006k;
        if (i8 != 0 && i8 != Process.myPid()) {
            return false;
        }
        return true;
    }

    public final RoutingManager N() {
        RoutingManager routingManager = this.f41005j;
        if (routingManager != null) {
            return routingManager;
        }
        Intrinsics.w("routingManager");
        return null;
    }

    public abstract void P(Bundle bundle);

    public abstract void Q(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        Intrinsics.f(newBase, "newBase");
        DriverCore driverCore = DriverCore.f40758a;
        super.attachBaseContext(driverCore.a().H().d(newBase, driverCore.a().a().d()));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        TranslationHelper H = DriverCore.f40758a.a().H();
        Resources resources = super.getResources();
        Intrinsics.e(resources, "super.getResources()");
        return H.e(resources);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.driver.core.ui.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i8;
        if (bundle != null) {
            i8 = bundle.getInt("process_id");
        } else {
            i8 = 0;
        }
        this.f41006k = i8;
        if (O()) {
            Q(bundle);
            super.onCreate(bundle);
            P(bundle);
            return;
        }
        RoutingManager.d(N(), RoutingCommand.RestartAppCommand.f41154a, false, 2, null);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.f(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt("process_id", Process.myPid());
    }
}
