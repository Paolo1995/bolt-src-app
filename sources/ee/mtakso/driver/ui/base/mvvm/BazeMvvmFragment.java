package ee.mtakso.driver.ui.base.mvvm;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MvvmFragment.kt */
/* loaded from: classes3.dex */
public abstract class BazeMvvmFragment<T extends BaseViewModel> extends BazeFragment {

    /* renamed from: m */
    private final Lazy f26287m;

    /* renamed from: n */
    public Map<Integer, View> f26288n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BazeMvvmFragment(BaseUiDependencies deps, int i8, Integer num) {
        super(deps, i8, num);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        this.f26288n = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<T>(this) { // from class: ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment$viewModel$2

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ BazeMvvmFragment<T> f26289f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.f26289f = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            /* JADX WARN: Type inference failed for: r0v1, types: [ee.mtakso.driver.ui.base.mvvm.BaseViewModel] */
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final BaseViewModel invoke() {
                return this.f26289f.Q();
            }
        });
        this.f26287m = b8;
    }

    public static final /* synthetic */ BaseUiDependencies L(BazeMvvmFragment bazeMvvmFragment) {
        return bazeMvvmFragment.E();
    }

    private final void N(BaseViewModel baseViewModel) {
        baseViewModel.C();
        baseViewModel.w().i(getViewLifecycleOwner(), new Observer() { // from class: l2.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BazeMvvmFragment.O(BazeMvvmFragment.this, (Throwable) obj);
            }
        });
        baseViewModel.x().i(getViewLifecycleOwner(), new Observer() { // from class: l2.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BazeMvvmFragment.P(BazeMvvmFragment.this, (Boolean) obj);
            }
        });
    }

    public static final void O(BazeMvvmFragment this$0, Throwable it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.H(it);
    }

    public static final void P(BazeMvvmFragment this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        if (it.booleanValue()) {
            this$0.I();
        } else {
            this$0.G();
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f26288n.clear();
    }

    public final T M() {
        return (T) this.f26287m.getValue();
    }

    public abstract T Q();

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        N(M());
    }

    public /* synthetic */ BazeMvvmFragment(BaseUiDependencies baseUiDependencies, int i8, Integer num, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(baseUiDependencies, i8, (i9 & 4) != 0 ? null : num);
    }
}
