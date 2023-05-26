package ee.mtakso.driver.ui.screens.earnings.v2.mode;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.network.client.earnings.EarningsReportPeriod;
import ee.mtakso.driver.network.client.earnings.EarningsReportScreenConfig;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.screens.earnings.v2.EarningsViewModel;
import ee.mtakso.driver.ui.screens.earnings.v2.mode.ModeChooserBottomDialog;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.chooser.ChooserItemDelegate;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModeChooserBottomDialog.kt */
/* loaded from: classes3.dex */
public final class ModeChooserBottomDialog extends BaseMvvmBottomSheetDialogFragment<EarningsViewModel> {

    /* renamed from: r  reason: collision with root package name */
    private final Lazy f28582r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f28583s;

    /* renamed from: t  reason: collision with root package name */
    private final int f28584t;

    /* renamed from: u  reason: collision with root package name */
    private final DiffAdapter f28585u;

    /* renamed from: v  reason: collision with root package name */
    public Map<Integer, View> f28586v = new LinkedHashMap();

    public ModeChooserBottomDialog() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<EarningsViewModel>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.mode.ModeChooserBottomDialog$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final EarningsViewModel invoke() {
                FragmentActivity requireActivity = ModeChooserBottomDialog.this.requireActivity();
                Intrinsics.e(requireActivity, "requireActivity()");
                return (EarningsViewModel) new ViewModelProvider(requireActivity, ModeChooserBottomDialog.this.Q()).a(EarningsViewModel.class);
            }
        });
        this.f28582r = b8;
        this.f28583s = true;
        this.f28584t = R.layout.bottom_dialog_mode_chooser;
        this.f28585u = new DiffAdapter().P(new ChooserItemDelegate(new Function1<ChooserItemDelegate.Model, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.mode.ModeChooserBottomDialog$diffAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ChooserItemDelegate.Model it) {
                Intrinsics.f(it, "it");
                if (!it.o()) {
                    ModeChooserBottomDialog.this.P().z0(it.m());
                }
                ModeChooserBottomDialog.this.dismissAllowingStateLoss();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChooserItemDelegate.Model model) {
                b(model);
                return Unit.f50853a;
            }
        }));
    }

    private final void T(BaseViewModel baseViewModel) {
        baseViewModel.C();
        baseViewModel.x().i(getViewLifecycleOwner(), new Observer() { // from class: n3.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModeChooserBottomDialog.f0(ModeChooserBottomDialog.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(DialogInterface dialogInterface) {
        BottomSheetDialog bottomSheetDialog;
        FrameLayout frameLayout;
        if (dialogInterface instanceof BottomSheetDialog) {
            bottomSheetDialog = (BottomSheetDialog) dialogInterface;
        } else {
            bottomSheetDialog = null;
        }
        if (bottomSheetDialog == null || (frameLayout = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet)) == null) {
            return;
        }
        BottomSheetBehavior.k0(frameLayout).Q0(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(ModeChooserBottomDialog this$0, EarningsReportScreenConfig earningsReportScreenConfig) {
        int v7;
        boolean z7;
        Intrinsics.f(this$0, "this$0");
        IndeterminateProgressView progressView = (IndeterminateProgressView) this$0.b0(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, false, 0, 2, null);
        String a8 = ((EarningsReportPeriod) LiveDataExtKt.b(this$0.P().Z())).a();
        List<EarningsReportPeriod> c8 = earningsReportScreenConfig.c();
        v7 = CollectionsKt__IterablesKt.v(c8, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : c8) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            EarningsReportPeriod earningsReportPeriod = (EarningsReportPeriod) obj;
            if (i8 == earningsReportScreenConfig.c().size() - 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            arrayList.add(new ChooserItemDelegate.Model(earningsReportPeriod.a(), earningsReportPeriod.b(), Intrinsics.a(earningsReportPeriod.a(), a8), !z7, null, null, 0.0f, false, false, 496, null));
            i8 = i9;
        }
        DiffAdapter.V(this$0.f28585u, arrayList, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(ModeChooserBottomDialog this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        if (it.booleanValue()) {
            this$0.X();
        } else {
            this$0.R();
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f28586v.clear();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    protected boolean I() {
        return this.f28583s;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected int L() {
        return this.f28584t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    public void R() {
        IndeterminateProgressView progressView = (IndeterminateProgressView) b0(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, false, 0, 2, null);
        RecyclerView recyclerView = (RecyclerView) b0(R.id.H9);
        Intrinsics.e(recyclerView, "recyclerView");
        ViewExtKt.e(recyclerView, true, 0, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void S() {
        Injector.f20166d.b().Y1().C(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    public void X() {
        IndeterminateProgressView progressView = (IndeterminateProgressView) b0(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, true, 0, 2, null);
        RecyclerView recyclerView = (RecyclerView) b0(R.id.H9);
        Intrinsics.e(recyclerView, "recyclerView");
        ViewExtKt.e(recyclerView, false, 0, 2, null);
    }

    public View b0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28586v;
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
    public EarningsViewModel P() {
        return (EarningsViewModel) this.f28582r.getValue();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 2132017805);
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
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: n3.a
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    ModeChooserBottomDialog.d0(dialogInterface);
                }
            });
        }
        RecyclerView recyclerView = (RecyclerView) b0(R.id.H9);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.f28585u);
        recyclerView.h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        T(P());
        P().Y().i(getViewLifecycleOwner(), new Observer() { // from class: n3.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModeChooserBottomDialog.e0(ModeChooserBottomDialog.this, (EarningsReportScreenConfig) obj);
            }
        });
    }
}
