package ee.mtakso.driver.ui.screens.destination.active.state;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.destination.active.state.DriverDestinationActiveStateFragment;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.uicore.components.views.CircularWavingButton;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.driver.core.R$style;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverDestinationActiveStateFragment.kt */
/* loaded from: classes3.dex */
public final class DriverDestinationActiveStateFragment extends BazeMvvmFragment<DriverDestinationActiveStateViewModel> {

    /* renamed from: q  reason: collision with root package name */
    public static final Companion f28175q = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final Lazy f28176o;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, View> f28177p;

    /* compiled from: DriverDestinationActiveStateFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(String destinationAddress) {
            Intrinsics.f(destinationAddress, "destinationAddress");
            Bundle bundle = new Bundle();
            bundle.putString("driverDestinationAddress", destinationAddress);
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DriverDestinationActiveStateFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_driver_destination_active_state, Integer.valueOf((int) R$style.Theme_Dark));
        Lazy b8;
        Intrinsics.f(deps, "deps");
        this.f28177p = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: ee.mtakso.driver.ui.screens.destination.active.state.DriverDestinationActiveStateFragment$driverDestinationAddress$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final String invoke() {
                return DriverDestinationActiveStateFragment.this.requireArguments().getString("driverDestinationAddress");
            }
        });
        this.f28176o = b8;
    }

    private final String V() {
        return (String) this.f28176o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Navigator W() {
        FragmentActivity activity = getActivity();
        if (activity instanceof Navigator) {
            return (Navigator) activity;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(DriverDestinationActiveStateFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f28177p.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        ((CircularProgressIndicator) T(R.id.V6)).j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        NotificationDialog c8 = NotificationDialog.Companion.c(companion, requireContext, error, null, 4, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(c8, requireActivity, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        ((CircularProgressIndicator) T(R.id.V6)).q();
    }

    public View T(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28177p;
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
    /* renamed from: Z */
    public DriverDestinationActiveStateViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (DriverDestinationActiveStateViewModel) new ViewModelProvider(this, E.d()).a(DriverDestinationActiveStateViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        int i8 = R.id.animatedPin;
        if (!((CircularWavingButton) T(i8)).d()) {
            ((CircularWavingButton) T(i8)).e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ((CircularWavingButton) T(R.id.animatedPin)).c();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Navigator W = W();
        if (W != null) {
            W.x(new PopupToolbarAppearance(0, new Text.Value(""), false, null, null, null, null, null, null, 509, null));
        }
        ((TextView) T(R.id.destinationAddress)).setText(V());
        ((RoundButton) T(R.id.cancelSearch)).setOnClickListener(new View.OnClickListener() { // from class: h3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DriverDestinationActiveStateFragment.X(DriverDestinationActiveStateFragment.this, view2);
            }
        });
        LiveEvent<Unit> L = M().L();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner, "viewLifecycleOwner");
        final Function1<Unit, Unit> function1 = new Function1<Unit, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.active.state.DriverDestinationActiveStateFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Unit unit) {
                Navigator W2;
                W2 = DriverDestinationActiveStateFragment.this.W();
                if (W2 != null) {
                    W2.c();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                b(unit);
                return Unit.f50853a;
            }
        };
        L.i(viewLifecycleOwner, new Observer() { // from class: h3.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DriverDestinationActiveStateFragment.Y(Function1.this, obj);
            }
        });
    }
}
