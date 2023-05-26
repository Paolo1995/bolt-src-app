package ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DidYouGetHelpFragment.kt */
/* loaded from: classes3.dex */
public final class DidYouGetHelpFragment extends BaseMvvmBottomSheetDialogFragment<DidYouGetHelpViewModel> {

    /* renamed from: u  reason: collision with root package name */
    public static final Companion f32614u = new Companion(null);

    /* renamed from: s  reason: collision with root package name */
    private final Lazy f32616s;

    /* renamed from: t  reason: collision with root package name */
    public Map<Integer, View> f32617t = new LinkedHashMap();

    /* renamed from: r  reason: collision with root package name */
    private final int f32615r = R.layout.fragment_did_you_get_help;

    /* compiled from: DidYouGetHelpFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public DidYouGetHelpFragment() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<DidYouGetHelpViewModel>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DidYouGetHelpViewModel invoke() {
                DidYouGetHelpFragment didYouGetHelpFragment = DidYouGetHelpFragment.this;
                return (DidYouGetHelpViewModel) new ViewModelProvider(didYouGetHelpFragment, didYouGetHelpFragment.Q()).a(DidYouGetHelpViewModel.class);
            }
        });
        this.f32616s = b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(DidYouGetHelpFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.P().N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(DidYouGetHelpFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.P().S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(DidYouGetHelpFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.P().X();
        this$0.dismissAllowingStateLoss();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f32617t.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected int L() {
        return this.f32615r;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void S() {
        Injector.f20166d.b().Y1().p(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    public void W(Throwable error) {
        Intrinsics.f(error, "error");
        super.W(error);
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentUtils.b(NotificationDialog.Companion.c(companion, requireContext, error, null, 4, null), this, "error");
    }

    public View b0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32617t;
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
    public DidYouGetHelpViewModel P() {
        return (DidYouGetHelpViewModel) this.f32616s.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics.f(dialog, "dialog");
        super.onCancel(dialog);
        P().X();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreateDialog(bundle);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), getTheme());
        bottomSheetDialog.n().Q0(3);
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        P().Y();
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
        ((RoundButton) b0(R.id.noExtraHelpNeeded)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DidYouGetHelpFragment.d0(DidYouGetHelpFragment.this, view2);
            }
        });
        ((RoundButton) b0(R.id.requestHelpFromBolt)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DidYouGetHelpFragment.e0(DidYouGetHelpFragment.this, view2);
            }
        });
        ((ImageView) b0(R.id.closeToolkit)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DidYouGetHelpFragment.f0(DidYouGetHelpFragment.this, view2);
            }
        });
    }
}
