package ee.mtakso.driver.ui.base.mvvm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import eu.bolt.driver.core.permission.watchdog.PermissionWatchDog;
import eu.bolt.driver.core.theme.AppThemeMode;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: BaseFragment.kt */
/* loaded from: classes3.dex */
public abstract class BazeFragment extends Fragment {

    /* renamed from: f  reason: collision with root package name */
    private final BaseUiDependencies f26280f;

    /* renamed from: g  reason: collision with root package name */
    private final int f26281g;

    /* renamed from: h  reason: collision with root package name */
    private final Integer f26282h;

    /* renamed from: i  reason: collision with root package name */
    private PermissionWatchDog f26283i;

    /* renamed from: j  reason: collision with root package name */
    private Context f26284j;

    /* renamed from: k  reason: collision with root package name */
    private final Integer f26285k;

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, View> f26286l;

    public BazeFragment(BaseUiDependencies deps, int i8, Integer num) {
        Intrinsics.f(deps, "deps");
        this.f26286l = new LinkedHashMap();
        this.f26280f = deps;
        this.f26281g = i8;
        this.f26282h = num;
    }

    public void D() {
        this.f26286l.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BaseUiDependencies E() {
        return this.f26280f;
    }

    public Integer F() {
        return this.f26285k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        Context context = this.f26284j;
        if (context == null) {
            return super.getContext();
        }
        return context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        ContextThemeWrapper contextThemeWrapper;
        Intrinsics.f(context, "context");
        super.onAttach(context);
        AppThemeMode c8 = this.f26280f.a().c();
        Integer F = F();
        if (this.f26282h != null) {
            contextThemeWrapper = new ContextThemeWrapper(context, this.f26282h.intValue());
        } else if (c8 == AppThemeMode.LEGACY && F != null) {
            contextThemeWrapper = new ContextThemeWrapper(context, F.intValue());
        } else {
            contextThemeWrapper = null;
        }
        this.f26284j = contextThemeWrapper;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.cloneInContext(getContext()).inflate(this.f26281g, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f26284j = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i8, String[] permissions, int[] grantResults) {
        Intrinsics.f(permissions, "permissions");
        Intrinsics.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i8, permissions, grantResults);
        PermissionWatchDog permissionWatchDog = this.f26283i;
        if (permissionWatchDog != null) {
            permissionWatchDog.c(i8, permissions, grantResults);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Kalev.n(Name.LABEL, getClass().getSimpleName()).a("onViewCreated");
        ScreenAnalytics c8 = this.f26280f.c();
        String simpleName = getClass().getSimpleName();
        Intrinsics.e(simpleName, "this.javaClass.simpleName");
        c8.V1(simpleName);
        this.f26283i = this.f26280f.b().g(this);
    }

    public /* synthetic */ BazeFragment(BaseUiDependencies baseUiDependencies, int i8, Integer num, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(baseUiDependencies, i8, (i9 & 4) != 0 ? null : num);
    }
}
