package ee.mtakso.driver.ui.screens.home.v2.subpage.destination.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: AboutDriverDestinationsFragment.kt */
/* loaded from: classes3.dex */
public final class AboutDriverDestinationsFragment extends Fragment {

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f29739h = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final ScreenAnalytics f29740f;

    /* renamed from: g  reason: collision with root package name */
    public Map<Integer, View> f29741g;

    /* compiled from: AboutDriverDestinationsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(int i8, int i9) {
            Bundle bundle = new Bundle();
            bundle.putInt("extra_remaining_destinations", i8);
            bundle.putInt("extra_max_destinations", i9);
            return bundle;
        }
    }

    @Inject
    public AboutDriverDestinationsFragment(ScreenAnalytics screenAnalytics) {
        Intrinsics.f(screenAnalytics, "screenAnalytics");
        this.f29741g = new LinkedHashMap();
        this.f29740f = screenAnalytics;
    }

    private final void F(Integer num, Integer num2) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String string = getString(R.string.driver_destinations_quota);
        Intrinsics.e(string, "getString(R.string.driver_destinations_quota)");
        String format = String.format(string, Arrays.copyOf(new Object[]{num, num2}, 2));
        Intrinsics.e(format, "format(format, *args)");
        ((TextView) E(R.id.aboutDriverDestinationsQuota)).setText(format);
    }

    public void D() {
        this.f29741g.clear();
    }

    public View E(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f29741g;
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_about_driver_destinations, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Integer num;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        this.f29740f.V3(AboutDriverDestinationsFragment.class);
        Bundle arguments = getArguments();
        Integer num2 = null;
        if (arguments != null) {
            num = Integer.valueOf(arguments.getInt("extra_remaining_destinations"));
        } else {
            num = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            num2 = Integer.valueOf(arguments2.getInt("extra_max_destinations"));
        }
        F(num, num2);
    }
}
