package ee.mtakso.driver.ui.screens.history.details.file_upload;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.audio_recording.WebAppLaunchParams;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel;
import ee.mtakso.driver.ui.screens.history.details.file_upload.RetryFileUploadFragment;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.driver.core.ui.common.activity.NoToolbarAppearance;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RetryFileUploadFragment.kt */
/* loaded from: classes3.dex */
public final class RetryFileUploadFragment extends BazeMvvmFragment<OrderHistoryDetailsViewModel> {

    /* renamed from: s  reason: collision with root package name */
    public static final Companion f29549s = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final int f29550o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f29551p;

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f29552q;

    /* renamed from: r  reason: collision with root package name */
    public Map<Integer, View> f29553r;

    /* compiled from: RetryFileUploadFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(OrderHandle orderHandle) {
            Intrinsics.f(orderHandle, "orderHandle");
            Bundle bundle = new Bundle();
            bundle.putParcelable("orderHandle", orderHandle);
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public RetryFileUploadFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_retry_audio_upload, null, 4, null);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        this.f29553r = new LinkedHashMap();
        this.f29550o = 2132017818;
        b8 = LazyKt__LazyJVMKt.b(new Function0<OrderHandle>() { // from class: ee.mtakso.driver.ui.screens.history.details.file_upload.RetryFileUploadFragment$orderHandle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final OrderHandle invoke() {
                Parcelable parcelable = RetryFileUploadFragment.this.requireArguments().getParcelable("orderHandle");
                if (parcelable != null) {
                    return (OrderHandle) parcelable;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        });
        this.f29552q = b8;
    }

    private final Navigator a0() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    private final OrderHandle b0() {
        return (OrderHandle) this.f29552q.getValue();
    }

    private final void c0(OrderHandle orderHandle) {
        M().X0(orderHandle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        Kalev.d("Upload Failed on Retry");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(WebAppLaunchParams webAppLaunchParams) {
        a0().c();
        M().l0(webAppLaunchParams.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(RetryFileUploadFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().V0();
        OrderHandle orderHandle = this$0.b0();
        Intrinsics.e(orderHandle, "orderHandle");
        this$0.c0(orderHandle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(RetryFileUploadFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().T0();
        if (this$0.f29551p) {
            this$0.M().h0();
        }
        this$0.a0().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(RetryFileUploadFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().T0();
        if (this$0.f29551p) {
            this$0.M().h0();
        }
        this$0.a0().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f29553r.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f29550o);
    }

    public View W(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f29553r;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: k0 */
    public OrderHistoryDetailsViewModel Q() {
        BaseUiDependencies E;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        E = E();
        return (OrderHistoryDetailsViewModel) new ViewModelProvider(requireActivity, E.d()).a(OrderHistoryDetailsViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        a0().x(new NoToolbarAppearance());
        M().U0();
        ((RoundButton) W(R.id.tryAgainButton)).setOnClickListener(new View.OnClickListener() { // from class: u3.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RetryFileUploadFragment.f0(RetryFileUploadFragment.this, view2);
            }
        });
        ((AppCompatImageView) W(R.id.close_button)).setOnClickListener(new View.OnClickListener() { // from class: u3.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RetryFileUploadFragment.g0(RetryFileUploadFragment.this, view2);
            }
        });
        ((RoundButton) W(R.id.cancelRetryButton)).setOnClickListener(new View.OnClickListener() { // from class: u3.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RetryFileUploadFragment.h0(RetryFileUploadFragment.this, view2);
            }
        });
        LiveData<Boolean> A0 = M().A0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.file_upload.RetryFileUploadFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean isLoading) {
                RetryFileUploadFragment retryFileUploadFragment = RetryFileUploadFragment.this;
                Intrinsics.e(isLoading, "isLoading");
                retryFileUploadFragment.f29551p = isLoading.booleanValue();
                if (isLoading.booleanValue()) {
                    ((RoundButton) RetryFileUploadFragment.this.W(R.id.tryAgainButton)).k();
                } else {
                    ((RoundButton) RetryFileUploadFragment.this.W(R.id.tryAgainButton)).g();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        A0.i(viewLifecycleOwner, new Observer() { // from class: u3.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RetryFileUploadFragment.i0(Function1.this, obj);
            }
        });
        LiveEvent<Result<WebAppLaunchParams>> I0 = M().I0();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner2, "viewLifecycleOwner");
        final Function1<Result<? extends WebAppLaunchParams>, Unit> function12 = new Function1<Result<? extends WebAppLaunchParams>, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.file_upload.RetryFileUploadFragment$onViewCreated$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Result<? extends WebAppLaunchParams> webAppLaunchParamsResult) {
                Intrinsics.e(webAppLaunchParamsResult, "webAppLaunchParamsResult");
                Object j8 = webAppLaunchParamsResult.j();
                RetryFileUploadFragment retryFileUploadFragment = RetryFileUploadFragment.this;
                if (Result.h(j8)) {
                    WebAppLaunchParams webAppLaunchParams = (WebAppLaunchParams) j8;
                    Object j9 = webAppLaunchParamsResult.j();
                    if (Result.g(j9)) {
                        j9 = null;
                    }
                    WebAppLaunchParams webAppLaunchParams2 = (WebAppLaunchParams) j9;
                    if (webAppLaunchParams2 != null) {
                        retryFileUploadFragment.e0(webAppLaunchParams2);
                    } else {
                        retryFileUploadFragment.d0();
                    }
                }
                RetryFileUploadFragment retryFileUploadFragment2 = RetryFileUploadFragment.this;
                if (Result.e(j8) != null) {
                    retryFileUploadFragment2.d0();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends WebAppLaunchParams> result) {
                b(result);
                return Unit.f50853a;
            }
        };
        I0.i(viewLifecycleOwner2, new Observer() { // from class: u3.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RetryFileUploadFragment.j0(Function1.this, obj);
            }
        });
    }
}
