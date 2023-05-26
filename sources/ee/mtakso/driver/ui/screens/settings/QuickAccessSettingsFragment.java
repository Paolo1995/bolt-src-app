package ee.mtakso.driver.ui.screens.settings;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.PopupToolbarAppearance;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickAccessSettingsFragment.kt */
/* loaded from: classes5.dex */
public final class QuickAccessSettingsFragment extends BazeMvvmFragment<QuickAccessSettingsViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private int f33022o;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, View> f33023p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public QuickAccessSettingsFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_quick_access_settings, null, 4, null);
        Intrinsics.f(deps, "deps");
        this.f33023p = new LinkedHashMap();
        this.f33022o = 2132017818;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(QuickAccessSettingsFragment this$0, CompoundButton compoundButton, boolean z7) {
        Intrinsics.f(this$0, "this$0");
        QuickAccessSettingsViewModel.J(this$0.M(), z7, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(QuickAccessSettingsFragment this$0, CompoundButton compoundButton, boolean z7) {
        Intrinsics.f(this$0, "this$0");
        QuickAccessSettingsViewModel.H(this$0.M(), z7, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(QuickAccessSettingsFragment this$0, Boolean it) {
        float f8;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        ((SwitchCompat) this$0.W(R.id.switchQuickAccessGeneral)).setChecked(it.booleanValue());
        ((SwitchCompat) this$0.W(R.id.switchQuickAccessExtended)).setEnabled(it.booleanValue());
        FrameLayout frameLayout = (FrameLayout) this$0.W(R.id.containerWidgetPreview);
        if (it.booleanValue()) {
            f8 = 1.0f;
        } else {
            f8 = 0.5f;
        }
        frameLayout.setAlpha(f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(QuickAccessSettingsFragment this$0, Boolean it) {
        float f8;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        ((SwitchCompat) this$0.W(R.id.switchQuickAccessExtended)).setChecked(it.booleanValue());
        ImageView imageView = (ImageView) this$0.W(R.id.widgetPreview);
        if (it.booleanValue()) {
            f8 = 1.0f;
        } else {
            f8 = 0.5f;
        }
        imageView.setAlpha(f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(QuickAccessSettingsFragment this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        LinearLayout containerExtendedToggle = (LinearLayout) this$0.W(R.id.containerExtendedToggle);
        Intrinsics.e(containerExtendedToggle, "containerExtendedToggle");
        Intrinsics.e(it, "it");
        ViewExtKt.e(containerExtendedToggle, it.booleanValue(), 0, 2, null);
        TextView tvExtendedWidgetDescription = (TextView) this$0.W(R.id.tvExtendedWidgetDescription);
        Intrinsics.e(tvExtendedWidgetDescription, "tvExtendedWidgetDescription");
        ViewExtKt.e(tvExtendedWidgetDescription, it.booleanValue(), 0, 2, null);
        FrameLayout containerWidgetPreview = (FrameLayout) this$0.W(R.id.containerWidgetPreview);
        Intrinsics.e(containerWidgetPreview, "containerWidgetPreview");
        ViewExtKt.e(containerWidgetPreview, it.booleanValue(), 0, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f33023p.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f33022o);
    }

    public View W(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33023p;
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
    /* renamed from: c0 */
    public QuickAccessSettingsViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (QuickAccessSettingsViewModel) new ViewModelProvider(this, E.d()).a(QuickAccessSettingsViewModel.class);
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
            navigator.n(new PopupToolbarAppearance(0, new Text.Resource(R.string.title_quick_access_widget, null, 2, null), false, 5, null));
        }
        ((SwitchCompat) W(R.id.switchQuickAccessGeneral)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ee.mtakso.driver.ui.screens.settings.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
                QuickAccessSettingsFragment.X(QuickAccessSettingsFragment.this, compoundButton, z7);
            }
        });
        ((SwitchCompat) W(R.id.switchQuickAccessExtended)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ee.mtakso.driver.ui.screens.settings.h
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
                QuickAccessSettingsFragment.Y(QuickAccessSettingsFragment.this, compoundButton, z7);
            }
        });
        M().E().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.settings.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickAccessSettingsFragment.Z(QuickAccessSettingsFragment.this, (Boolean) obj);
            }
        });
        M().D().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.settings.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickAccessSettingsFragment.a0(QuickAccessSettingsFragment.this, (Boolean) obj);
            }
        });
        M().F().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.settings.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickAccessSettingsFragment.b0(QuickAccessSettingsFragment.this, (Boolean) obj);
            }
        });
    }
}
