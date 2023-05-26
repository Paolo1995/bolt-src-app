package ee.mtakso.driver.ui.base.mvvm;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import eu.bolt.driver.core.permission.watchdog.PermissionWatchDog;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseMvvmDialogFragment.kt */
/* loaded from: classes3.dex */
public abstract class BaseMvvmDialogFragment<T extends BaseViewModel> extends DialogFragment {

    /* renamed from: f  reason: collision with root package name */
    private final BaseUiDependencies f26249f;

    /* renamed from: g  reason: collision with root package name */
    private final int f26250g;

    /* renamed from: h  reason: collision with root package name */
    private PermissionWatchDog f26251h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f26252i;

    /* renamed from: j  reason: collision with root package name */
    private final Lazy f26253j;

    /* renamed from: k  reason: collision with root package name */
    public Map<Integer, View> f26254k;

    public BaseMvvmDialogFragment(BaseUiDependencies deps, int i8) {
        Lazy b8;
        Intrinsics.f(deps, "deps");
        this.f26254k = new LinkedHashMap();
        this.f26249f = deps;
        this.f26250g = i8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<T>(this) { // from class: ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment$viewModel$2

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ BaseMvvmDialogFragment<T> f26255f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.f26255f = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            /* JADX WARN: Type inference failed for: r0v1, types: [ee.mtakso.driver.ui.base.mvvm.BaseViewModel] */
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final BaseViewModel invoke() {
                return this.f26255f.N();
            }
        });
        this.f26253j = b8;
    }

    private final void K(BaseViewModel baseViewModel) {
        baseViewModel.C();
        baseViewModel.w().i(getViewLifecycleOwner(), new Observer() { // from class: l2.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMvvmDialogFragment.L(BaseMvvmDialogFragment.this, (Throwable) obj);
            }
        });
        baseViewModel.x().i(getViewLifecycleOwner(), new Observer() { // from class: l2.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMvvmDialogFragment.M(BaseMvvmDialogFragment.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(BaseMvvmDialogFragment this$0, Throwable it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.O(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(BaseMvvmDialogFragment this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        if (it.booleanValue()) {
            this$0.P();
        } else {
            this$0.I();
        }
    }

    public void F() {
        this.f26254k.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T H() {
        return (T) this.f26253j.getValue();
    }

    protected void I() {
        Kalev.b("hide loading");
    }

    protected boolean J() {
        return this.f26252i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T N();

    protected void O(Throwable error) {
        Intrinsics.f(error, "error");
    }

    protected void P() {
        Kalev.b("show loading");
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Window window;
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.e(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        if (J() && (window = onCreateDialog.getWindow()) != null) {
            window.addFlags(4194304);
            window.addFlags(524288);
            window.addFlags(2097152);
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(this.f26250g, viewGroup, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        F();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i8, String[] permissions, int[] grantResults) {
        Intrinsics.f(permissions, "permissions");
        Intrinsics.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i8, permissions, grantResults);
        PermissionWatchDog permissionWatchDog = this.f26251h;
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
        ScreenAnalytics c8 = this.f26249f.c();
        String simpleName2 = getClass().getSimpleName();
        Intrinsics.e(simpleName2, "this.javaClass.simpleName");
        c8.V1(simpleName2);
        K(H());
        this.f26251h = this.f26249f.b().g(this);
    }
}
