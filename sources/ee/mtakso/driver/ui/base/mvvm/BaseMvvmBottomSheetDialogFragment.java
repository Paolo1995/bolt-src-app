package ee.mtakso.driver.ui.base.mvvm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.lifecycle.Observer;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.permission.watchdog.PermissionWatchDog;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseMvvmBottomSheetDialogFragment.kt */
/* loaded from: classes3.dex */
public abstract class BaseMvvmBottomSheetDialogFragment<T extends BaseViewModel> extends BaseBottomSheetDialogFragment {
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public ScreenAnalytics f26242k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public ViewModelFactory f26243l;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public PermissionManager f26244m;

    /* renamed from: n  reason: collision with root package name */
    private PermissionWatchDog f26245n;

    /* renamed from: o  reason: collision with root package name */
    private Context f26246o;

    /* renamed from: p  reason: collision with root package name */
    private final Integer f26247p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f26248q = new LinkedHashMap();

    private final void T(BaseViewModel baseViewModel) {
        baseViewModel.C();
        baseViewModel.w().i(getViewLifecycleOwner(), new Observer() { // from class: l2.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMvvmBottomSheetDialogFragment.U(BaseMvvmBottomSheetDialogFragment.this, (Throwable) obj);
            }
        });
        baseViewModel.x().i(getViewLifecycleOwner(), new Observer() { // from class: l2.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMvvmBottomSheetDialogFragment.V(BaseMvvmBottomSheetDialogFragment.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(BaseMvvmBottomSheetDialogFragment this$0, Throwable it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.W(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(BaseMvvmBottomSheetDialogFragment this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        if (it.booleanValue()) {
            this$0.X();
        } else {
            this$0.R();
        }
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f26248q.clear();
    }

    protected abstract int L();

    protected Integer M() {
        return this.f26247p;
    }

    public final PermissionManager N() {
        PermissionManager permissionManager = this.f26244m;
        if (permissionManager != null) {
            return permissionManager;
        }
        Intrinsics.w("permissionManager");
        return null;
    }

    public final ScreenAnalytics O() {
        ScreenAnalytics screenAnalytics = this.f26242k;
        if (screenAnalytics != null) {
            return screenAnalytics;
        }
        Intrinsics.w("screenAnalytics");
        return null;
    }

    protected abstract T P();

    public final ViewModelFactory Q() {
        ViewModelFactory viewModelFactory = this.f26243l;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.w("viewModelFactory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R() {
        Kalev.b("hide loading");
    }

    protected abstract void S();

    /* JADX INFO: Access modifiers changed from: protected */
    public void W(Throwable error) {
        Intrinsics.f(error, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X() {
        Kalev.b("show loading");
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        Context context = this.f26246o;
        if (context == null) {
            return super.getContext();
        }
        return context;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.f(context, "context");
        super.onAttach(context);
        Integer M = M();
        if (M != null && M.intValue() != 0) {
            this.f26246o = new ContextThemeWrapper(context, M.intValue());
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.BaseBottomSheetDialogTheme);
        S();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(L(), viewGroup, false);
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i8, String[] permissions, int[] grantResults) {
        Intrinsics.f(permissions, "permissions");
        Intrinsics.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i8, permissions, grantResults);
        PermissionWatchDog permissionWatchDog = this.f26245n;
        if (permissionWatchDog != null) {
            permissionWatchDog.c(i8, permissions, grantResults);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        String simpleName = getClass().getSimpleName();
        Kalev.b(simpleName + " onViewCreated");
        ScreenAnalytics O = O();
        String simpleName2 = getClass().getSimpleName();
        Intrinsics.e(simpleName2, "this.javaClass.simpleName");
        O.V1(simpleName2);
        T(P());
        this.f26245n = N().g(this);
    }
}
