package eu.bolt.driver.core.ui.base.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import eu.bolt.driver.core.permission.watchdog.PermissionWatchDog;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseFragment.kt */
/* loaded from: classes5.dex */
public abstract class BaseFragment extends Fragment {

    /* renamed from: f  reason: collision with root package name */
    private final BaseFragmentParams f41036f;

    /* renamed from: g  reason: collision with root package name */
    private PermissionWatchDog f41037g;

    /* renamed from: h  reason: collision with root package name */
    public Map<Integer, View> f41038h;

    public BaseFragment(BaseFragmentParams params) {
        Intrinsics.f(params, "params");
        this.f41038h = new LinkedHashMap();
        this.f41036f = params;
    }

    public void D() {
        this.f41038h.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(Throwable error) {
        Intrinsics.f(error, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G() {
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i8, String[] permissions, int[] grantResults) {
        Intrinsics.f(permissions, "permissions");
        Intrinsics.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i8, permissions, grantResults);
        PermissionWatchDog permissionWatchDog = this.f41037g;
        if (permissionWatchDog == null) {
            Kalev.e(new NullPointerException("Permission watch dog is null"), "Permission watch dog is null");
        } else {
            permissionWatchDog.c(i8, permissions, grantResults);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        this.f41037g = this.f41036f.a().g(this);
    }
}
