package ee.mtakso.driver.ui.screens.order.arrived.raterider;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentTransaction;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.dialogs.FullScreenDialogFragment;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderContainer;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateRiderDialogFragment.kt */
/* loaded from: classes3.dex */
public final class RateRiderDialogFragment extends FullScreenDialogFragment implements RateRiderContainer {

    /* renamed from: l  reason: collision with root package name */
    private final FragmentFactory f31183l;

    /* renamed from: m  reason: collision with root package name */
    public Map<Integer, View> f31184m;

    @Inject
    public RateRiderDialogFragment(FragmentFactory fragmentFactory) {
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        this.f31184m = new LinkedHashMap();
        this.f31183l = fragmentFactory;
    }

    @Override // ee.mtakso.driver.ui.screens.dialogs.FullScreenDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment
    public void D() {
        this.f31184m.clear();
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderContainer
    public void a(Class<? extends Fragment> fragmentClass, Bundle bundle) {
        Intrinsics.f(fragmentClass, "fragmentClass");
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        FragmentFactory fragmentFactory = this.f31183l;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        beginTransaction.replace(R.id.container, FragmentFactoryUtils.b(fragmentFactory, requireContext, fragmentClass, bundle)).commitNowAllowingStateLoss();
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderContainer
    public void k(Fragment fragment, View view, RiderRatingInfo ratingInfo) {
        Intrinsics.f(fragment, "fragment");
        Intrinsics.f(view, "view");
        Intrinsics.f(ratingInfo, "ratingInfo");
        Function3<DialogFragment, View, Object, Unit> G = G();
        if (G != null) {
            G.l(this, view, ratingInfo);
        }
    }

    @Override // ee.mtakso.driver.ui.screens.dialogs.FullScreenDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        setCancelable(false);
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_fragment_rate_client, viewGroup, false);
    }

    @Override // ee.mtakso.driver.ui.screens.dialogs.FullScreenDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        if (getChildFragmentManager().getFragments().isEmpty() && bundle == null) {
            RateRiderContainer.DefaultImpls.a(this, RateRiderFragment.class, null, 2, null);
        }
    }
}
