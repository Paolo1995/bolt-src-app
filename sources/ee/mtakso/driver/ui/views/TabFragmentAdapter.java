package ee.mtakso.driver.ui.views;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TabFragmentAdapter.kt */
/* loaded from: classes5.dex */
public final class TabFragmentAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final List<Fragment> f34340a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f34341b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabFragmentAdapter(FragmentManager fm) {
        super(fm);
        Intrinsics.f(fm, "fm");
        this.f34340a = new ArrayList();
        this.f34341b = new ArrayList();
    }

    public final void a(Fragment fragment, String title) {
        Intrinsics.f(fragment, "fragment");
        Intrinsics.f(title, "title");
        this.f34340a.add(fragment);
        this.f34341b.add(title);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f34340a.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i8) {
        return this.f34340a.get(i8);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i8) {
        return this.f34341b.get(i8);
    }
}
