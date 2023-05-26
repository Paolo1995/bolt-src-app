package ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.ui.VoipAddressLineDelegate;
import ee.mtakso.driver.uicore.components.views.CircularWavingButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoAnswerFragment.kt */
/* loaded from: classes3.dex */
public final class NoAnswerFragment extends ContactMethodsBaseBottomSheetDialog<NoAnswerViewModel> {

    /* renamed from: w  reason: collision with root package name */
    private VoipAddressLineDelegate f28052w;

    /* renamed from: x  reason: collision with root package name */
    private final Lazy f28053x;

    /* renamed from: y  reason: collision with root package name */
    public Map<Integer, View> f28054y = new LinkedHashMap();

    /* renamed from: v  reason: collision with root package name */
    private final int f28051v = R.layout.fragment_no_answer;

    public NoAnswerFragment() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<NoAnswerViewModel>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.NoAnswerFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final NoAnswerViewModel invoke() {
                NoAnswerFragment noAnswerFragment = NoAnswerFragment.this;
                return (NoAnswerViewModel) new ViewModelProvider(noAnswerFragment, noAnswerFragment.Q()).a(NoAnswerViewModel.class);
            }
        });
        this.f28053x = b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(NoAnswerFragment this$0, NoAnswerCallDetails noAnswerCallDetails) {
        Intrinsics.f(this$0, "this$0");
        ((TextView) this$0.d0(R.id.passengerName)).setText(noAnswerCallDetails.b());
        VoipAddressLineDelegate voipAddressLineDelegate = this$0.f28052w;
        if (voipAddressLineDelegate == null) {
            Intrinsics.w("voipAddressLineDelegate");
            voipAddressLineDelegate = null;
        }
        voipAddressLineDelegate.c(noAnswerCallDetails.a(), noAnswerCallDetails.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(NoAnswerFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.P().H();
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(NoAnswerFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f28054y.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected int L() {
        return this.f28051v;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void S() {
        Injector.f20166d.b().Y1().l(this);
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog
    protected boolean Z() {
        return true;
    }

    public View d0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28054y;
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
    /* renamed from: e0 */
    public NoAnswerViewModel P() {
        return (NoAnswerViewModel) this.f28053x.getValue();
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        TextView passengerAddress = (TextView) d0(R.id.passengerAddress);
        Intrinsics.e(passengerAddress, "passengerAddress");
        this.f28052w = new VoipAddressLineDelegate(requireContext, passengerAddress);
        P().G().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NoAnswerFragment.f0(NoAnswerFragment.this, (NoAnswerCallDetails) obj);
            }
        });
        ((CircularWavingButton) d0(R.id.recallButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NoAnswerFragment.g0(NoAnswerFragment.this, view2);
            }
        });
        ((CircularWavingButton) d0(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NoAnswerFragment.h0(NoAnswerFragment.this, view2);
            }
        });
    }
}
