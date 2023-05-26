package ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.cancels;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.google.android.material.tabs.TabLayout;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.network.client.driver.DriverCancels;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.DriverActivityBaseFragment;
import ee.mtakso.driver.ui.views.WrapContentPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class CancelsFragment extends DriverActivityBaseFragment {

    /* renamed from: g  reason: collision with root package name */
    private WrapContentPager f29656g;

    /* renamed from: h  reason: collision with root package name */
    private TabLayout f29657h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f29658i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f29659j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f29660k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f29661l;

    /* renamed from: m  reason: collision with root package name */
    private View f29662m;

    /* renamed from: n  reason: collision with root package name */
    private View f29663n;

    /* renamed from: o  reason: collision with root package name */
    private View f29664o;

    /* renamed from: p  reason: collision with root package name */
    private View f29665p;

    /* renamed from: q  reason: collision with root package name */
    private DriverCancels f29666q;

    /* renamed from: r  reason: collision with root package name */
    private ProTipsPagerAdapter f29667r;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class ProTipsPagerAdapter extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final LayoutInflater f29668a;

        /* renamed from: b  reason: collision with root package name */
        private List<Pair<String, String>> f29669b;

        public ProTipsPagerAdapter() {
            ArrayList arrayList = new ArrayList();
            this.f29669b = arrayList;
            arrayList.add(new Pair(CancelsFragment.this.getString(R.string.pro_tip_1_title), CancelsFragment.this.getString(R.string.pro_tip_1_content)));
            this.f29669b.add(new Pair<>(CancelsFragment.this.getString(R.string.pro_tip_2_title), CancelsFragment.this.getString(R.string.pro_tip_2_content)));
            this.f29669b.add(new Pair<>(CancelsFragment.this.getString(R.string.pro_tip_3_title), CancelsFragment.this.getString(R.string.pro_tip_3_content)));
            this.f29668a = (LayoutInflater) CancelsFragment.this.getContext().getSystemService("layout_inflater");
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i8, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f29669b.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i8) {
            View inflate = this.f29668a.inflate(R.layout.list_item_pro_tips, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.proTipsTitle)).setText((CharSequence) this.f29669b.get(i8).first);
            ((TextView) inflate.findViewById(R.id.proTipsContent)).setText((CharSequence) this.f29669b.get(i8).second);
            viewGroup.addView(inflate);
            return inflate;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    private float F(int i8) {
        if (this.f29666q.e() != 0) {
            return (i8 / this.f29666q.e()) * 100.0f;
        }
        return 0.0f;
    }

    public static CancelsFragment G(DriverCancels driverCancels) {
        CancelsFragment cancelsFragment = new CancelsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("driverCancels", driverCancels);
        cancelsFragment.setArguments(bundle);
        return cancelsFragment;
    }

    private void H(View view, float f8) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = f8;
        view.setLayoutParams(layoutParams);
        view.requestLayout();
    }

    private void I() {
        H(this.f29662m, F(this.f29666q.d()));
        H(this.f29663n, F(this.f29666q.c()));
        H(this.f29664o, F(this.f29666q.a()));
        H(this.f29665p, F(this.f29666q.b()));
    }

    private void J() {
        ProTipsPagerAdapter proTipsPagerAdapter = new ProTipsPagerAdapter();
        this.f29667r = proTipsPagerAdapter;
        this.f29656g.setAdapter(proTipsPagerAdapter);
        this.f29657h.R(this.f29656g, true);
        Iterator<View> it = this.f29657h.getTouchables().iterator();
        while (it.hasNext()) {
            it.next().setClickable(false);
        }
        this.f29656g.setClipToPadding(false);
        this.f29656g.setPageMargin(20);
    }

    private void K() {
        this.f29658i.setText(String.format(Locale.getDefault(), "%.0f%s", Float.valueOf(F(this.f29666q.d())), "%"));
        this.f29659j.setText(String.format(Locale.getDefault(), "%.0f%s", Float.valueOf(F(this.f29666q.c())), "%"));
        this.f29660k.setText(String.format(Locale.getDefault(), "%.0f%s", Float.valueOf(F(this.f29666q.a())), "%"));
        this.f29661l.setText(String.format(Locale.getDefault(), "%.0f%s", Float.valueOf(F(this.f29666q.b())), "%"));
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BaseStatisticsFragment
    protected void D() {
        Injector.f2().K0(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_activity_cancels, viewGroup, false);
        this.f29656g = (WrapContentPager) inflate.findViewById(R.id.cancelsProTipsPager);
        this.f29657h = (TabLayout) inflate.findViewById(R.id.cancelsProTopPageIndicator);
        this.f29658i = (TextView) inflate.findViewById(R.id.activity_cancels_by_driver_text);
        this.f29659j = (TextView) inflate.findViewById(R.id.activity_cancels_missed_text);
        this.f29660k = (TextView) inflate.findViewById(R.id.activity_cancels_by_client_text);
        this.f29661l = (TextView) inflate.findViewById(R.id.activity_cancels_clientDidNotShowText);
        this.f29662m = inflate.findViewById(R.id.cancelsDriversCancelledDivision);
        this.f29663n = inflate.findViewById(R.id.cancelsMissedRequestDivision);
        this.f29664o = inflate.findViewById(R.id.cancelsClientCancelledDivision);
        this.f29665p = inflate.findViewById(R.id.cancelsClientDidNotShowDivision);
        return inflate;
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BaseStatisticsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        DriverCancels driverCancels = (DriverCancels) getArguments().getParcelable("driverCancels");
        this.f29666q = driverCancels;
        if (driverCancels != null) {
            K();
            J();
            I();
        }
    }
}
