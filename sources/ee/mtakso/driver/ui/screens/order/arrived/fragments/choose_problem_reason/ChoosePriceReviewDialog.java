package ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.price.PriceReviewReason;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChooseReviewReasonDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.utils.ContextUtils;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChoosePriceReviewDialog.kt */
/* loaded from: classes3.dex */
public final class ChoosePriceReviewDialog extends BaseMvvmDialogFragment<ChoosePriceReviewViewModel> {

    /* renamed from: o  reason: collision with root package name */
    public static final Companion f31099o = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    private DiffAdapter f31100l;

    /* renamed from: m  reason: collision with root package name */
    private Function1<? super PriceReviewReason, Unit> f31101m;

    /* renamed from: n  reason: collision with root package name */
    public Map<Integer, View> f31102n;

    /* compiled from: ChoosePriceReviewDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public ChoosePriceReviewDialog(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_choose_review);
        Intrinsics.f(deps, "deps");
        this.f31102n = new LinkedHashMap();
        this.f31101m = new Function1<PriceReviewReason, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChoosePriceReviewDialog$onPriceReviewListener$1
            public final void b(PriceReviewReason it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PriceReviewReason priceReviewReason) {
                b(priceReviewReason);
                return Unit.f50853a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(ChoosePriceReviewDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(ChoosePriceReviewDialog this$0, List reasons) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(reasons, "reasons");
        this$0.b0(reasons);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(ChoosePriceReviewDialog this$0, Throwable th) {
        Intrinsics.f(this$0, "this$0");
        Toast.makeText(this$0.getActivity(), (int) R.string.serverSideError, 0).show();
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(PriceReviewReason priceReviewReason) {
        dismiss();
        this.f31101m.invoke(priceReviewReason);
    }

    private final void b0(List<ChooseReviewReasonDelegate.Model> list) {
        ((ProgressBar) T(R.id.chooseReviewProgressBar)).setVisibility(8);
        DiffAdapter diffAdapter = this.f31100l;
        if (diffAdapter == null) {
            Intrinsics.w("adapter");
            diffAdapter = null;
        }
        DiffAdapter.V(diffAdapter, list, null, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment
    public void F() {
        this.f31102n.clear();
    }

    public View T(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31102n;
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
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment
    /* renamed from: Z */
    public ChoosePriceReviewViewModel N() {
        BaseUiDependencies baseUiDependencies;
        baseUiDependencies = ((BaseMvvmDialogFragment) this).f26249f;
        return (ChoosePriceReviewViewModel) new ViewModelProvider(this, baseUiDependencies.d()).a(ChoosePriceReviewViewModel.class);
    }

    public final void a0(Function1<? super PriceReviewReason, Unit> function1) {
        Intrinsics.f(function1, "<set-?>");
        this.f31101m = function1;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
        setStyle(1, 16973835);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        F();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        Intrinsics.c(dialog);
        Window window2 = dialog.getWindow();
        Intrinsics.c(window2);
        WindowManager.LayoutParams attributes = window2.getAttributes();
        attributes.dimAmount = 0.85f;
        window2.setAttributes(attributes);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        int i8 = ContextUtils.a(requireContext).widthPixels;
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setLayout((int) (i8 * 0.8d), -2);
        }
        window2.setBackgroundDrawableResource(R.drawable.rounded_dialog);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        this.f31100l = new DiffAdapter().P(new ChooseReviewReasonDelegate(new Function1<PriceReviewReason, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChoosePriceReviewDialog$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PriceReviewReason priceReviewReason) {
                Intrinsics.f(priceReviewReason, "priceReviewReason");
                ChoosePriceReviewDialog.this.Y(priceReviewReason);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PriceReviewReason priceReviewReason) {
                b(priceReviewReason);
                return Unit.f50853a;
            }
        }));
        ((RoundButton) T(R.id.chooseReviewBackButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChoosePriceReviewDialog.V(ChoosePriceReviewDialog.this, view2);
            }
        });
        int i8 = R.id.chooseReviewRecyclerView;
        ((RecyclerView) T(i8)).setNestedScrollingEnabled(false);
        ((RecyclerView) T(i8)).h(new ListItemDividerDecoration(Dimens.d(24)));
        RecyclerView recyclerView = (RecyclerView) T(i8);
        DiffAdapter diffAdapter = this.f31100l;
        if (diffAdapter == null) {
            Intrinsics.w("adapter");
            diffAdapter = null;
        }
        recyclerView.setAdapter(diffAdapter);
        H().L().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChoosePriceReviewDialog.W(ChoosePriceReviewDialog.this, (List) obj);
            }
        });
        H().w().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChoosePriceReviewDialog.X(ChoosePriceReviewDialog.this, (Throwable) obj);
            }
        });
    }
}
