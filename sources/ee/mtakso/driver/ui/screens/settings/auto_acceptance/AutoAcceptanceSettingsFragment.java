package ee.mtakso.driver.ui.screens.settings.auto_acceptance;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.settings.AutoAcceptanceState;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.PopupToolbarAppearance;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AutoAcceptanceSettingsFragment.kt */
/* loaded from: classes5.dex */
public final class AutoAcceptanceSettingsFragment extends BazeMvvmFragment<AutoAcceptanceSettingsViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private int f33157o;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, View> f33158p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public AutoAcceptanceSettingsFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_auto_acceptance_settings, null, 4, null);
        Intrinsics.f(deps, "deps");
        this.f33158p = new LinkedHashMap();
        this.f33157o = 2132017818;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(AutoAcceptanceSettingsFragment this$0, CompoundButton compoundButton, boolean z7) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().J(z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(AutoAcceptanceSettingsFragment this$0, AutoAcceptanceState autoAcceptanceState) {
        boolean z7;
        Intrinsics.f(this$0, "this$0");
        SwitchCompat switchCompat = (SwitchCompat) this$0.T(R.id.switchAutoAcceptance);
        if (autoAcceptanceState == AutoAcceptanceState.ACTIVATED) {
            z7 = true;
        } else {
            z7 = false;
        }
        switchCompat.setChecked(z7);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f33158p.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f33157o);
    }

    public View T(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33158p;
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
    /* renamed from: W */
    public AutoAcceptanceSettingsViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (AutoAcceptanceSettingsViewModel) new ViewModelProvider(this, E.d()).a(AutoAcceptanceSettingsViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Navigator navigator;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity instanceof Navigator) {
            navigator = (Navigator) activity;
        } else {
            navigator = null;
        }
        if (navigator != null) {
            navigator.n(new PopupToolbarAppearance(0, new Text.Resource(R.string.auto_accept, null, 2, null), false, 5, null));
        }
        ((SwitchCompat) T(R.id.switchAutoAcceptance)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ee.mtakso.driver.ui.screens.settings.auto_acceptance.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
                AutoAcceptanceSettingsFragment.U(AutoAcceptanceSettingsFragment.this, compoundButton, z7);
            }
        });
        M().I().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.settings.auto_acceptance.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AutoAcceptanceSettingsFragment.V(AutoAcceptanceSettingsFragment.this, (AutoAcceptanceState) obj);
            }
        });
        ((TextView) T(R.id.autoAcceptanceDescription)).setText(getString(R.string.auto_accept_description));
    }
}
