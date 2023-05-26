package eu.bolt.driver.core.ui.base.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment;
import eu.bolt.driver.core.ui.base.mvvm.BaseViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseMvvmFragment.kt */
/* loaded from: classes5.dex */
public abstract class BaseMvvmFragment<T extends BaseViewModel> extends BaseFragment {

    /* renamed from: i */
    private final ViewModelProvider.Factory f41040i;

    /* renamed from: j */
    private final Lazy f41041j;

    /* renamed from: k */
    public Map<Integer, View> f41042k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMvvmFragment(BaseFragmentParams params, ViewModelProvider.Factory viewModelFactory) {
        super(params);
        Lazy b8;
        Intrinsics.f(params, "params");
        Intrinsics.f(viewModelFactory, "viewModelFactory");
        this.f41042k = new LinkedHashMap();
        this.f41040i = viewModelFactory;
        b8 = LazyKt__LazyJVMKt.b(new Function0<T>(this) { // from class: eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment$viewModel$2

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ BaseMvvmFragment<T> f41045f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.f41045f = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            /* JADX WARN: Type inference failed for: r0v1, types: [eu.bolt.driver.core.ui.base.mvvm.BaseViewModel] */
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final BaseViewModel invoke() {
                return this.f41045f.N();
            }
        });
        this.f41041j = b8;
    }

    public static final void L(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void M(BaseViewModel baseViewModel) {
        baseViewModel.o();
        K(baseViewModel.i(), new Function1<Throwable, Unit>(this) { // from class: eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment$processViewModel$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ BaseMvvmFragment<T> f41043f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f41043f = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.f(it, "it");
                this.f41043f.F(it);
            }
        });
        K(baseViewModel.j(), new Function1<Boolean, Unit>(this) { // from class: eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment$processViewModel$2

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ BaseMvvmFragment<T> f41044f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f41044f = this;
            }

            public final void b(boolean z7) {
                if (z7) {
                    this.f41044f.G();
                } else {
                    this.f41044f.E();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool.booleanValue());
                return Unit.f50853a;
            }
        });
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseFragment
    public void D() {
        this.f41042k.clear();
    }

    public final T J() {
        return (T) this.f41041j.getValue();
    }

    public final <A> void K(LiveData<A> liveData, final Function1<? super A, Unit> observer) {
        Intrinsics.f(liveData, "<this>");
        Intrinsics.f(observer, "observer");
        liveData.i(getViewLifecycleOwner(), new Observer() { // from class: d7.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMvvmFragment.L(Function1.this, obj);
            }
        });
    }

    public abstract T N();

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        M(J());
    }
}
