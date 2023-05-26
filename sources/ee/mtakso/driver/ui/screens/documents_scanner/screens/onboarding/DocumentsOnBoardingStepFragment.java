package ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.airbnb.lottie.LottieAnimationView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.utils.AssertUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DocumentsOnBoardingStepFragment.kt */
/* loaded from: classes3.dex */
public final class DocumentsOnBoardingStepFragment extends BazeMvvmFragment<DocumentsOnBoardingViewModel> {

    /* renamed from: p  reason: collision with root package name */
    public static final Companion f28453p = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    public Map<Integer, View> f28454o;

    /* compiled from: DocumentsOnBoardingStepFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(DocumentsOnBoardingStep onBoardingStep) {
            Intrinsics.f(onBoardingStep, "onBoardingStep");
            Bundle bundle = new Bundle();
            bundle.putParcelable("args.onboarding_step", onBoardingStep);
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DocumentsOnBoardingStepFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_documents_onboarding_step, null, 4, null);
        Intrinsics.f(deps, "deps");
        this.f28454o = new LinkedHashMap();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f28454o.clear();
    }

    public View R(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28454o;
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

    public final DocumentsOnBoardingStep S() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return (DocumentsOnBoardingStep) arguments.getParcelable("args.onboarding_step");
        }
        return null;
    }

    public final void T() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: U */
    public DocumentsOnBoardingViewModel Q() {
        BaseUiDependencies E;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        E = E();
        return (DocumentsOnBoardingViewModel) new ViewModelProvider(requireActivity, E.d()).a(DocumentsOnBoardingViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        DocumentsOnBoardingStep S = S();
        if (S == null) {
            AssertUtils.a("OnBoarding step fragment was launched without propper step");
            T();
            return;
        }
        ((LottieAnimationView) R(R.id.animationView)).setAnimation(S.a());
        ((TextView) R(R.id.cc)).setText(getResources().getString(S.c()));
        ((TextView) R(R.id.f19832m3)).setText(getResources().getString(S.b()));
    }
}
