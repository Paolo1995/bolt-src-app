package ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.rides;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.network.client.driver.RidesPeriodData;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import ee.mtakso.driver.ui.base.statistics.BarGraphView;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityViewModel;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.RidesMode;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.DriverActivityBaseFragment;
import ee.mtakso.driver.ui.utils.Dates;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class RidesFragment extends DriverActivityBaseFragment implements BarGraphView.OnBarClickListener {

    /* renamed from: g  reason: collision with root package name */
    private TextView f29685g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f29686h;

    /* renamed from: i  reason: collision with root package name */
    private BarGraphView f29687i;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    ViewModelFactory f29688j;

    /* renamed from: k  reason: collision with root package name */
    private DriverActivityViewModel f29689k;

    /* renamed from: l  reason: collision with root package name */
    private RidesPeriodData f29690l;

    /* renamed from: m  reason: collision with root package name */
    private RidesBarGraphAdapter f29691m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.rides.RidesFragment$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f29692a;

        static {
            int[] iArr = new int[RidesMode.values().length];
            f29692a = iArr;
            try {
                iArr[RidesMode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29692a[RidesMode.PERCENTAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view) {
        L();
    }

    public static RidesFragment J(RidesPeriodData ridesPeriodData, boolean z7) {
        RidesFragment ridesFragment = new RidesFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("driverRides", ridesPeriodData);
        bundle.putBoolean("isMonthlyPeriod", z7);
        ridesFragment.setArguments(bundle);
        return ridesFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public void I(RidesMode ridesMode) {
        if (this.f29690l != null) {
            N(ridesMode);
            M(ridesMode);
            this.f29691m.h(ridesMode);
            this.f29687i.e(true);
        }
    }

    private void M(RidesMode ridesMode) {
        int i8 = AnonymousClass1.f29692a[ridesMode.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                this.f29686h.setText(R.string.activity_rides_percentage_disclaimer);
                return;
            }
            return;
        }
        this.f29686h.setText(R.string.activity_rides_disclaimer);
    }

    private void N(RidesMode ridesMode) {
        int i8 = AnonymousClass1.f29692a[ridesMode.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                this.f29685g.setText(String.format(Locale.getDefault(), "%1$d%2$s", Integer.valueOf(this.f29690l.a()), "%"));
                return;
            }
            return;
        }
        this.f29685g.setText(String.format("%s / %s", this.f29690l.c(), Integer.valueOf(this.f29690l.d())));
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BaseStatisticsFragment
    protected void D() {
        Injector.f2().c1(this);
    }

    void L() {
        this.f29689k.W();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_activity_rides, viewGroup, false);
        this.f29685g = (TextView) inflate.findViewById(R.id.activity_totalRides);
        this.f29686h = (TextView) inflate.findViewById(R.id.activity_ridesDisclaimer);
        this.f29687i = (BarGraphView) inflate.findViewById(R.id.activity_ridesGraph);
        return inflate;
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BaseStatisticsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        int i8;
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.activity_totalRidesLayout).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.rides.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RidesFragment.this.H(view2);
            }
        });
        this.f29690l = (RidesPeriodData) getArguments().getParcelable("driverRides");
        boolean z7 = getArguments().getBoolean("isMonthlyPeriod");
        if (this.f29690l != null) {
            E(z7);
            if (!z7 && this.f29690l.b() != null) {
                i8 = -1;
                for (int i9 = 0; i9 < this.f29690l.b().size(); i9++) {
                    Date e8 = Dates.e(this.f29690l.b().get(i9).b());
                    if (e8 != null && DateUtils.isToday(e8.getTime())) {
                        i8 = i9;
                    }
                }
            } else {
                i8 = -1;
            }
            RidesBarGraphAdapter g8 = RidesBarGraphAdapter.g(view.getContext(), this.f29690l.b(), z7, RidesMode.NUMERIC);
            this.f29691m = g8;
            this.f29687i.setAdapter(g8);
            this.f29687i.setOnBarClickListener(this);
            if (i8 > -1) {
                this.f29687i.f(i8);
            }
        }
        DriverActivityViewModel driverActivityViewModel = (DriverActivityViewModel) new ViewModelProvider(requireParentFragment(), this.f29688j).a(DriverActivityViewModel.class);
        this.f29689k = driverActivityViewModel;
        driverActivityViewModel.O().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.rides.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RidesFragment.this.I((RidesMode) obj);
            }
        });
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BarGraphView.OnBarClickListener
    public void w(int i8) {
        if (this.f29687i.getSelectedPosition() == i8) {
            L();
        } else {
            this.f29687i.f(i8);
        }
    }
}
