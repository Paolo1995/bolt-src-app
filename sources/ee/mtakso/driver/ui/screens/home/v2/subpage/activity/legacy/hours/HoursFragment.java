package ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.hours;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.network.client.driver.HoursPeriodData;
import ee.mtakso.driver.network.client.driver.HoursSubPeriodData;
import ee.mtakso.driver.ui.base.statistics.BarGraphView;
import ee.mtakso.driver.ui.base.statistics.BaseStatisticsFragment;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.hours.HoursFragment;
import ee.mtakso.driver.ui.utils.Dates;
import ee.mtakso.driver.ui.utils.Seconds;
import java.util.Date;

/* loaded from: classes3.dex */
public class HoursFragment extends BaseStatisticsFragment {

    /* renamed from: g  reason: collision with root package name */
    private TextView f29676g;

    /* renamed from: h  reason: collision with root package name */
    private BarGraphView f29677h;

    /* renamed from: i  reason: collision with root package name */
    private HoursPeriodData f29678i;

    private long G() {
        long j8 = 0;
        for (HoursSubPeriodData hoursSubPeriodData : this.f29678i.a()) {
            j8 += hoursSubPeriodData.a();
        }
        return j8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(int i8) {
        this.f29677h.f(i8);
    }

    public static HoursFragment I(HoursPeriodData hoursPeriodData, boolean z7) {
        HoursFragment hoursFragment = new HoursFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("driverHours", hoursPeriodData);
        bundle.putBoolean("isMonthlyPeriod", z7);
        hoursFragment.setArguments(bundle);
        return hoursFragment;
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BaseStatisticsFragment
    protected void D() {
        Injector.f2().H0(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_activity_hours, viewGroup, false);
        this.f29676g = (TextView) inflate.findViewById(R.id.activity_totalHours);
        this.f29677h = (BarGraphView) inflate.findViewById(R.id.activity_hoursGraph);
        return inflate;
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BaseStatisticsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        int i8;
        super.onViewCreated(view, bundle);
        this.f29678i = (HoursPeriodData) getArguments().getParcelable("driverHours");
        boolean z7 = getArguments().getBoolean("isMonthlyPeriod");
        if (this.f29678i != null) {
            E(z7);
            this.f29676g.setText(Seconds.a(getContext(), G()));
            if (!z7 && this.f29678i.a() != null) {
                i8 = -1;
                for (int i9 = 0; i9 < this.f29678i.a().size(); i9++) {
                    Date e8 = Dates.e(this.f29678i.a().get(i9).b());
                    if (e8 != null && DateUtils.isToday(e8.getTime())) {
                        i8 = i9;
                    }
                }
            } else {
                i8 = -1;
            }
            this.f29677h.setAdapter(HoursBarGraphAdapter.g(view.getContext(), this.f29678i.a(), z7));
            this.f29677h.setOnBarClickListener(new BarGraphView.OnBarClickListener() { // from class: w3.a
                @Override // ee.mtakso.driver.ui.base.statistics.BarGraphView.OnBarClickListener
                public final void w(int i10) {
                    HoursFragment.this.H(i10);
                }
            });
            if (i8 > -1) {
                this.f29677h.f(i8);
            }
        }
    }
}
