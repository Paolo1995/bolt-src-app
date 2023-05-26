package ee.mtakso.driver.ui.screens.destination.edit;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment;
import ee.mtakso.driver.ui.screens.destination.edit.DestinationAction;
import ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DestinationEditBottomDialogFragment.kt */
/* loaded from: classes3.dex */
public final class DestinationEditBottomDialogFragment extends BaseMvvmBottomSheetDialogFragment<DestinationsViewModel> {

    /* renamed from: w  reason: collision with root package name */
    public static final Companion f28198w = new Companion(null);

    /* renamed from: s  reason: collision with root package name */
    private final Lazy f28200s;

    /* renamed from: t  reason: collision with root package name */
    private final DiffAdapter f28201t;

    /* renamed from: u  reason: collision with root package name */
    private final Lazy f28202u;

    /* renamed from: v  reason: collision with root package name */
    public Map<Integer, View> f28203v = new LinkedHashMap();

    /* renamed from: r  reason: collision with root package name */
    private final int f28199r = R.layout.fragment_bottom_action_dialog;

    /* compiled from: DestinationEditBottomDialogFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(DriverDestination driverDestination) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("destination", driverDestination);
            return bundle;
        }
    }

    public DestinationEditBottomDialogFragment() {
        Lazy b8;
        Lazy b9;
        b8 = LazyKt__LazyJVMKt.b(new Function0<DestinationsViewModel>() { // from class: ee.mtakso.driver.ui.screens.destination.edit.DestinationEditBottomDialogFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DestinationsViewModel invoke() {
                DestinationEditBottomDialogFragment destinationEditBottomDialogFragment = DestinationEditBottomDialogFragment.this;
                FragmentActivity requireActivity = destinationEditBottomDialogFragment.requireActivity();
                Intrinsics.e(requireActivity, "requireActivity()");
                return (DestinationsViewModel) new ViewModelProvider(requireActivity, destinationEditBottomDialogFragment.Q()).a(DestinationsViewModel.class);
            }
        });
        this.f28200s = b8;
        this.f28201t = new DiffAdapter().P(new TwoLinesItemDelegate(new DestinationEditBottomDialogFragment$diffAdapter$1(this), null, 0, null, 14, null));
        b9 = LazyKt__LazyJVMKt.b(new Function0<DriverDestination>() { // from class: ee.mtakso.driver.ui.screens.destination.edit.DestinationEditBottomDialogFragment$driverDestination$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DriverDestination invoke() {
                return (DriverDestination) DestinationEditBottomDialogFragment.this.requireArguments().getParcelable("destination");
            }
        });
        this.f28202u = b9;
    }

    private final List<ListModel> a0() {
        List<? extends DestinationAction> n8;
        n8 = CollectionsKt__CollectionsKt.n(new DestinationAction.Edit(null, 0, 3, null), new DestinationAction.Delete(null, null, 0, null, 15, null));
        return e0(n8);
    }

    private final DriverDestination b0() {
        return (DriverDestination) this.f28202u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(TwoLinesItemDelegate.Model<DestinationAction> model) {
        DriverDestination b02 = b0();
        if (b02 != null) {
            DestinationAction B = model.B();
            if (B instanceof DestinationAction.Edit) {
                P().D0(b02, true);
            } else if (B instanceof DestinationAction.Delete) {
                P().b0(b02);
            }
        }
        dismiss();
    }

    private final List<ListModel> e0(List<? extends DestinationAction> list) {
        int v7;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (DestinationAction destinationAction : list) {
            String valueOf = String.valueOf(destinationAction.c());
            Image a8 = destinationAction.a();
            arrayList.add(new TwoLinesItemDelegate.Model(valueOf, new Text.Resource(destinationAction.c(), null, 2, null), 2132017735, destinationAction.d(), null, null, null, null, destinationAction.b(), a8, null, null, null, null, null, null, null, null, destinationAction, false, 0, 0, false, null, null, null, false, false, false, 536607984, null));
        }
        return arrayList;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f28203v.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected int L() {
        return this.f28199r;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void S() {
        Injector.f20166d.b().Y1().m(this);
    }

    public View Y(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28203v;
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
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    /* renamed from: c0 */
    public DestinationsViewModel P() {
        return (DestinationsViewModel) this.f28200s.getValue();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R.id.recyclerViewAction;
        ((RecyclerView) Y(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) Y(i8)).setAdapter(this.f28201t);
        DiffAdapter.V(this.f28201t, a0(), null, 2, null);
    }
}
