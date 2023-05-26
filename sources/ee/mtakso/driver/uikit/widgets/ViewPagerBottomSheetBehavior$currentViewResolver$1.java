package ee.mtakso.driver.uikit.widgets;

import android.view.View;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ViewPagerBottomSheetBehavior.kt */
/* loaded from: classes5.dex */
final class ViewPagerBottomSheetBehavior$currentViewResolver$1 extends Lambda implements Function1<ViewPager, View> {

    /* renamed from: f  reason: collision with root package name */
    public static final ViewPagerBottomSheetBehavior$currentViewResolver$1 f36202f = new ViewPagerBottomSheetBehavior$currentViewResolver$1();

    ViewPagerBottomSheetBehavior$currentViewResolver$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: b */
    public final View invoke(ViewPager viewPager) {
        FragmentStatePagerAdapter fragmentStatePagerAdapter;
        Intrinsics.f(viewPager, "viewPager");
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter instanceof FragmentStatePagerAdapter) {
            fragmentStatePagerAdapter = (FragmentStatePagerAdapter) adapter;
        } else {
            fragmentStatePagerAdapter = null;
        }
        if (fragmentStatePagerAdapter == null || fragmentStatePagerAdapter.getCount() <= viewPager.getCurrentItem()) {
            return null;
        }
        return fragmentStatePagerAdapter.getItem(viewPager.getCurrentItem()).getView();
    }
}
