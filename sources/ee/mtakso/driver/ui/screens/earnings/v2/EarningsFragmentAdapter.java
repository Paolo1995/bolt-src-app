package ee.mtakso.driver.ui.screens.earnings.v2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import ee.mtakso.driver.network.client.earnings.Interval;
import ee.mtakso.driver.ui.screens.earnings.v2.balance.BalanceFragment;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsFragmentAdapter.kt */
/* loaded from: classes3.dex */
public final class EarningsFragmentAdapter extends FragmentStateAdapter {

    /* renamed from: l  reason: collision with root package name */
    private final FragmentActivity f28512l;

    /* renamed from: m  reason: collision with root package name */
    private final FragmentFactory f28513m;

    /* renamed from: n  reason: collision with root package name */
    private final List<Interval> f28514n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarningsFragmentAdapter(FragmentActivity fragmentActivity, FragmentFactory fragmentFactory) {
        super(fragmentActivity);
        Intrinsics.f(fragmentActivity, "fragmentActivity");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        this.f28512l = fragmentActivity;
        this.f28513m = fragmentFactory;
        this.f28514n = new ArrayList();
    }

    private final long l0(Interval interval) {
        return interval.a().hashCode();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public boolean Q(long j8) {
        Object obj;
        boolean z7;
        Iterator<T> it = this.f28514n.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (l0((Interval) obj) == j8) {
                    z7 = true;
                    continue;
                } else {
                    z7 = false;
                    continue;
                }
                if (z7) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment R(int i8) {
        return FragmentFactoryUtils.b(this.f28513m, this.f28512l, BalanceFragment.class, BalanceFragment.f28561r.a(this.f28514n.get(i8).a()));
    }

    public final List<Interval> j0() {
        return this.f28514n;
    }

    public final String k0(int i8) {
        return this.f28514n.get(i8).b();
    }

    public final void m0(List<Interval> newIntervals) {
        Intrinsics.f(newIntervals, "newIntervals");
        this.f28514n.clear();
        this.f28514n.addAll(newIntervals);
        w();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int r() {
        return this.f28514n.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long s(int i8) {
        return l0(this.f28514n.get(i8));
    }
}
