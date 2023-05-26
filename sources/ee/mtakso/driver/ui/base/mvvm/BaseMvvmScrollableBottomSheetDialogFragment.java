package ee.mtakso.driver.ui.base.mvvm;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmScrollableBottomSheetDialogFragment;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.uicore.components.dialogs.BaseScrollableBottomSheetDialogFragment;
import eu.bolt.driver.core.permission.watchdog.PermissionWatchDog;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseMvvmScrollableBottomSheetDialogFragment.kt */
/* loaded from: classes3.dex */
public abstract class BaseMvvmScrollableBottomSheetDialogFragment<T extends BaseViewModel> extends BaseScrollableBottomSheetDialogFragment {

    /* renamed from: q  reason: collision with root package name */
    private final BaseUiDependencies f26256q;

    /* renamed from: r  reason: collision with root package name */
    private PermissionWatchDog f26257r;

    /* renamed from: s  reason: collision with root package name */
    private final Lazy f26258s;

    /* renamed from: t  reason: collision with root package name */
    public Map<Integer, View> f26259t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMvvmScrollableBottomSheetDialogFragment(BaseUiDependencies deps, int i8, Integer num) {
        super(i8, num);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        this.f26259t = new LinkedHashMap();
        this.f26256q = deps;
        b8 = LazyKt__LazyJVMKt.b(new Function0<T>(this) { // from class: ee.mtakso.driver.ui.base.mvvm.BaseMvvmScrollableBottomSheetDialogFragment$viewModel$2

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ BaseMvvmScrollableBottomSheetDialogFragment<T> f26262f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.f26262f = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            /* JADX WARN: Type inference failed for: r0v1, types: [ee.mtakso.driver.ui.base.mvvm.BaseViewModel] */
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final BaseViewModel invoke() {
                return this.f26262f.T();
            }
        });
        this.f26258s = b8;
    }

    private final void Q(BaseViewModel baseViewModel) {
        baseViewModel.C();
        LiveData<Throwable> w7 = baseViewModel.w();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>(this) { // from class: ee.mtakso.driver.ui.base.mvvm.BaseMvvmScrollableBottomSheetDialogFragment$processViewModel$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ BaseMvvmScrollableBottomSheetDialogFragment<T> f26260f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f26260f = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                BaseMvvmScrollableBottomSheetDialogFragment<T> baseMvvmScrollableBottomSheetDialogFragment = this.f26260f;
                Intrinsics.e(it, "it");
                baseMvvmScrollableBottomSheetDialogFragment.U(it);
            }
        };
        w7.i(viewLifecycleOwner, new Observer() { // from class: l2.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMvvmScrollableBottomSheetDialogFragment.R(Function1.this, obj);
            }
        });
        LiveData<Boolean> x7 = baseViewModel.x();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>(this) { // from class: ee.mtakso.driver.ui.base.mvvm.BaseMvvmScrollableBottomSheetDialogFragment$processViewModel$2

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ BaseMvvmScrollableBottomSheetDialogFragment<T> f26261f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f26261f = this;
            }

            public final void b(Boolean it) {
                Intrinsics.e(it, "it");
                if (it.booleanValue()) {
                    this.f26261f.V();
                } else {
                    this.f26261f.P();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        x7.i(viewLifecycleOwner2, new Observer() { // from class: l2.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMvvmScrollableBottomSheetDialogFragment.S(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseScrollableBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f26259t.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T O() {
        return (T) this.f26258s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P() {
        Kalev.b("hide loading");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T T();

    /* JADX INFO: Access modifiers changed from: protected */
    public void U(Throwable error) {
        Intrinsics.f(error, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        Kalev.b("show loading");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.BaseBottomSheetDialogTheme);
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseScrollableBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i8, String[] permissions, int[] grantResults) {
        Intrinsics.f(permissions, "permissions");
        Intrinsics.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i8, permissions, grantResults);
        PermissionWatchDog permissionWatchDog = this.f26257r;
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
        ScreenAnalytics c8 = this.f26256q.c();
        String simpleName2 = getClass().getSimpleName();
        Intrinsics.e(simpleName2, "this.javaClass.simpleName");
        c8.V1(simpleName2);
        Q(O());
        this.f26257r = this.f26256q.b().g(this);
    }

    public /* synthetic */ BaseMvvmScrollableBottomSheetDialogFragment(BaseUiDependencies baseUiDependencies, int i8, Integer num, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(baseUiDependencies, i8, (i9 & 4) != 0 ? null : num);
    }
}
