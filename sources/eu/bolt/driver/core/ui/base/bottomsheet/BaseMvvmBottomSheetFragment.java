package eu.bolt.driver.core.ui.base.bottomsheet;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import eu.bolt.driver.core.ui.base.bottomsheet.BaseMvvmBottomSheetFragment;
import eu.bolt.driver.core.ui.base.mvvm.BaseViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseMvvmBottomSheetFragment.kt */
/* loaded from: classes5.dex */
public abstract class BaseMvvmBottomSheetFragment<T extends BaseViewModel> extends BaseBottomSheetFragment {

    /* renamed from: j  reason: collision with root package name */
    private final ViewModelProvider.Factory f41011j;

    /* renamed from: k  reason: collision with root package name */
    private final Lazy f41012k;

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, View> f41013l;

    public BaseMvvmBottomSheetFragment(ViewModelProvider.Factory viewModelFactory) {
        Lazy b8;
        Intrinsics.f(viewModelFactory, "viewModelFactory");
        this.f41013l = new LinkedHashMap();
        this.f41011j = viewModelFactory;
        b8 = LazyKt__LazyJVMKt.b(new Function0<T>(this) { // from class: eu.bolt.driver.core.ui.base.bottomsheet.BaseMvvmBottomSheetFragment$viewModel$2

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ BaseMvvmBottomSheetFragment<T> f41016f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.f41016f = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            /* JADX WARN: Type inference failed for: r0v1, types: [eu.bolt.driver.core.ui.base.mvvm.BaseViewModel] */
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final BaseViewModel invoke() {
                return this.f41016f.R();
            }
        });
        this.f41012k = b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Q(BaseViewModel baseViewModel) {
        baseViewModel.o();
        O(baseViewModel.i(), new Function1<Throwable, Unit>(this) { // from class: eu.bolt.driver.core.ui.base.bottomsheet.BaseMvvmBottomSheetFragment$processViewModel$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ BaseMvvmBottomSheetFragment<T> f41014f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f41014f = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.f(it, "it");
                this.f41014f.J(it);
            }
        });
        O(baseViewModel.j(), new Function1<Boolean, Unit>(this) { // from class: eu.bolt.driver.core.ui.base.bottomsheet.BaseMvvmBottomSheetFragment$processViewModel$2

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ BaseMvvmBottomSheetFragment<T> f41015f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f41015f = this;
            }

            public final void b(boolean z7) {
                if (z7) {
                    this.f41015f.K();
                } else {
                    this.f41015f.I();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool.booleanValue());
                return Unit.f50853a;
            }
        });
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment
    public void H() {
        this.f41013l.clear();
    }

    protected final T N() {
        return (T) this.f41012k.getValue();
    }

    protected final <A> void O(LiveData<A> liveData, final Function1<? super A, Unit> observer) {
        Intrinsics.f(liveData, "<this>");
        Intrinsics.f(observer, "observer");
        liveData.i(getViewLifecycleOwner(), new Observer() { // from class: c7.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMvvmBottomSheetFragment.P(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T R();

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Q(N());
    }
}
