package eu.bolt.driver.core.ui.base.activity;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import eu.bolt.driver.core.di.helper.CoreFragmentFactory;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.permission.watchdog.PermissionWatchDog;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseActivity.kt */
/* loaded from: classes5.dex */
public abstract class BaseActivity extends AppCompatActivity {
    @Inject

    /* renamed from: f  reason: collision with root package name */
    public CoreFragmentFactory f41000f;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    public PermissionManager f41001g;

    /* renamed from: h  reason: collision with root package name */
    private PermissionWatchDog f41002h;

    /* renamed from: i  reason: collision with root package name */
    public Map<Integer, View> f41003i = new LinkedHashMap();

    public final CoreFragmentFactory L() {
        CoreFragmentFactory coreFragmentFactory = this.f41000f;
        if (coreFragmentFactory != null) {
            return coreFragmentFactory;
        }
        Intrinsics.w("fragmentFactory");
        return null;
    }

    public final PermissionManager M() {
        PermissionManager permissionManager = this.f41001g;
        if (permissionManager != null) {
            return permissionManager;
        }
        Intrinsics.w("permissionManager");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getSupportFragmentManager().setFragmentFactory(L());
        super.onCreate(bundle);
        M().f(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i8, String[] permissions, int[] grantResults) {
        Intrinsics.f(permissions, "permissions");
        Intrinsics.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i8, permissions, grantResults);
        PermissionWatchDog permissionWatchDog = this.f41002h;
        if (permissionWatchDog == null) {
            Kalev.e(new NullPointerException("Permission watch dog is null"), "Permission watch dog is null");
        } else {
            permissionWatchDog.c(i8, permissions, grantResults);
        }
    }
}
