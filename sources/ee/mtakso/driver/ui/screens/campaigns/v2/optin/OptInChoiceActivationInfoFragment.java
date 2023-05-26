package ee.mtakso.driver.ui.screens.campaigns.v2.optin;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInChoiceActivationInfoFragment;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OptInChoiceActivationInfoFragment.kt */
/* loaded from: classes3.dex */
public final class OptInChoiceActivationInfoFragment extends BazeFragment {

    /* renamed from: m  reason: collision with root package name */
    private final int f27631m;

    /* renamed from: n  reason: collision with root package name */
    public Map<Integer, View> f27632n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public OptInChoiceActivationInfoFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_opt_in_choice_activation_info, null, 4, null);
        Intrinsics.f(deps, "deps");
        this.f27632n = new LinkedHashMap();
        this.f27631m = 2132017818;
    }

    private final Navigator M() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(OptInChoiceActivationInfoFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(OptInChoiceActivationInfoFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().c();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f27632n.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f27631m);
    }

    public View L(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27632n;
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        ((AppCompatImageView) L(R.id.f19838z2)).setOnClickListener(new View.OnClickListener() { // from class: y2.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OptInChoiceActivationInfoFragment.N(OptInChoiceActivationInfoFragment.this, view2);
            }
        });
        ((RoundButton) L(R.id.closeActionButton)).setOnClickListener(new View.OnClickListener() { // from class: y2.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OptInChoiceActivationInfoFragment.O(OptInChoiceActivationInfoFragment.this, view2);
            }
        });
    }
}
