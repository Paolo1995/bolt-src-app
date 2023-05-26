package ee.mtakso.driver.ui.screens.time_limit;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.work_time.WorkingTimeInfo;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.helper.LoadingDialogDelegate;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.PopupToolbarAppearance;
import ee.mtakso.driver.ui.screens.home.v3.HomeContainer;
import ee.mtakso.driver.ui.screens.home.v3.footer.appearance.NoTabsAppearance;
import ee.mtakso.driver.ui.screens.home.v3.header.appearance.SubPageAppearance;
import ee.mtakso.driver.ui.screens.time_limit.WorkTimeFragment;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import eu.bolt.driver.core.network.client.driver.DriverFeaturesConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkTimeFragment.kt */
/* loaded from: classes5.dex */
public final class WorkTimeFragment extends BazeMvvmFragment<WorkTimeViewModel> {

    /* renamed from: q  reason: collision with root package name */
    private static final Companion f33475q = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private LoadingDialogDelegate f33476o;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, View> f33477p;

    /* compiled from: WorkTimeFragment.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WorkTimeFragment.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33478a;

        static {
            int[] iArr = new int[DriverFeaturesConfig.WorkingTimeMode.values().length];
            try {
                iArr[DriverFeaturesConfig.WorkingTimeMode.ROLLING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverFeaturesConfig.WorkingTimeMode.ACCUMULATING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverFeaturesConfig.WorkingTimeMode.DISABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f33478a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public WorkTimeFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_work_time, null, 4, null);
        Intrinsics.f(deps, "deps");
        this.f33477p = new LinkedHashMap();
    }

    private final void T(WorkingTimeInfo workingTimeInfo) {
        boolean z7;
        TextView workTimeSummary = (TextView) S(R.id.workTimeSummary);
        Intrinsics.e(workTimeSummary, "workTimeSummary");
        ViewExtKt.e(workTimeSummary, false, 0, 2, null);
        if (workingTimeInfo.g() < TimeUnit.HOURS.toSeconds(2L)) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            TextView workTimeValueLeft = (TextView) S(R.id.workTimeValueLeft);
            Intrinsics.e(workTimeValueLeft, "workTimeValueLeft");
            TextViewExtKt.i(workTimeValueLeft, new Color.Attr(R.attr.contentPrimary));
        } else {
            TextView workTimeValueLeft2 = (TextView) S(R.id.workTimeValueLeft);
            Intrinsics.e(workTimeValueLeft2, "workTimeValueLeft");
            TextViewExtKt.i(workTimeValueLeft2, new Color.Attr(R.attr.contentCritical));
        }
        ((TextView) S(R.id.workTimeValueLeft)).setText(workingTimeInfo.f());
        ((TextView) S(R.id.workTimeValueRight)).setText(workingTimeInfo.e());
        ((TextView) S(R.id.textOnlineHoursLimitDesc)).setText(getString(R.string.fatigue_limited_online_hours_explanation_placeholder, workingTimeInfo.h()));
        ((TextView) S(R.id.textOfflineHoursLimitDesc)).setText(getString(R.string.fatigue_offline_hours_explanation_placeholder, workingTimeInfo.h(), workingTimeInfo.b()));
        ((TextView) S(R.id.textHealthSafetyDesc)).setText(getString(R.string.fatigue_health_and_safety_explanation_placeholder, workingTimeInfo.b()));
    }

    private final void U(WorkingTimeInfo workingTimeInfo) {
        boolean z7;
        int i8 = R.id.workTimeSummary;
        TextView workTimeSummary = (TextView) S(i8);
        Intrinsics.e(workTimeSummary, "workTimeSummary");
        ViewExtKt.e(workTimeSummary, false, 0, 3, null);
        ((TextView) S(i8)).setText(getString(R.string.working_time_rolling_summary, workingTimeInfo.c(), workingTimeInfo.d()));
        TextView textOfflineHoursLimitDesc = (TextView) S(R.id.textOfflineHoursLimitDesc);
        Intrinsics.e(textOfflineHoursLimitDesc, "textOfflineHoursLimitDesc");
        ViewExtKt.e(textOfflineHoursLimitDesc, false, 0, 2, null);
        TextView titleOfflineHours = (TextView) S(R.id.titleOfflineHours);
        Intrinsics.e(titleOfflineHours, "titleOfflineHours");
        ViewExtKt.e(titleOfflineHours, false, 0, 2, null);
        if (workingTimeInfo.g() < TimeUnit.HOURS.toSeconds(2L)) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            TextView workTimeValueRight = (TextView) S(R.id.workTimeValueRight);
            Intrinsics.e(workTimeValueRight, "workTimeValueRight");
            TextViewExtKt.i(workTimeValueRight, new Color.Attr(R.attr.contentPrimary));
        } else {
            TextView workTimeValueRight2 = (TextView) S(R.id.workTimeValueRight);
            Intrinsics.e(workTimeValueRight2, "workTimeValueRight");
            TextViewExtKt.i(workTimeValueRight2, new Color.Attr(R.attr.contentCritical));
        }
        ((TextView) S(R.id.workTimeValueLeft)).setText(workingTimeInfo.a());
        ((TextView) S(R.id.workTimeTitleLeft)).setText(getString(R.string.working_time_active_driving));
        ((TextView) S(R.id.workTimeValueRight)).setText(workingTimeInfo.f());
        ((TextView) S(R.id.workTimeTitleRight)).setText(getString(R.string.driving_time_left));
        ((TextView) S(R.id.textOnlineHoursLimitDesc)).setText(getString(R.string.working_time_online_hours_rolling, workingTimeInfo.c(), workingTimeInfo.d()));
        ((TextView) S(R.id.textHealthSafetyDesc)).setText(getString(R.string.fatigue_health_and_safety_explanation_placeholder, 8));
    }

    private final HomeContainer V() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof HomeContainer) {
            return (HomeContainer) parentFragment;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(WorkTimeFragment this$0, WorkingTimeInfo it) {
        Intrinsics.f(this$0, "this$0");
        int i8 = WhenMappings.f33478a[this$0.M().I().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    throw new IllegalStateException();
                }
                return;
            }
            Intrinsics.e(it, "it");
            this$0.T(it);
            return;
        }
        Intrinsics.e(it, "it");
        this$0.U(it);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f33477p.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        LoadingDialogDelegate loadingDialogDelegate = this.f33476o;
        if (loadingDialogDelegate == null) {
            Intrinsics.w("loadingDialogDelegate");
            loadingDialogDelegate = null;
        }
        loadingDialogDelegate.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        LoadingDialogDelegate loadingDialogDelegate = this.f33476o;
        if (loadingDialogDelegate == null) {
            Intrinsics.w("loadingDialogDelegate");
            loadingDialogDelegate = null;
        }
        loadingDialogDelegate.b();
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33477p;
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
    /* renamed from: X */
    public WorkTimeViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (WorkTimeViewModel) new ViewModelProvider(this, E.d()).a(WorkTimeViewModel.class);
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
            navigator.n(new PopupToolbarAppearance(0, null, false, 7, null));
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        this.f33476o = new LoadingDialogDelegate(requireActivity);
        HomeContainer V = V();
        if (V != null) {
            V.b(new SubPageAppearance(""), new NoTabsAppearance());
        }
        M().H().i(getViewLifecycleOwner(), new Observer() { // from class: g5.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkTimeFragment.W(WorkTimeFragment.this, (WorkingTimeInfo) obj);
            }
        });
    }
}
