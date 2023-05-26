package ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.rides;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.driver.RidesSubPeriodData;
import ee.mtakso.driver.ui.base.statistics.BarGraphAdapter;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.RidesMode;
import ee.mtakso.driver.ui.utils.Dates;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class RidesBarGraphAdapter implements BarGraphAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f29679a;

    /* renamed from: b  reason: collision with root package name */
    private final List<RidesSubPeriodData> f29680b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f29681c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f29682d;

    /* renamed from: e  reason: collision with root package name */
    private RidesMode f29683e;

    /* renamed from: ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.rides.RidesBarGraphAdapter$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f29684a;

        static {
            int[] iArr = new int[RidesMode.values().length];
            f29684a = iArr;
            try {
                iArr[RidesMode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29684a[RidesMode.PERCENTAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private RidesBarGraphAdapter(TextView textView, int[] iArr, List<RidesSubPeriodData> list, boolean z7, RidesMode ridesMode) {
        this.f29679a = textView;
        this.f29681c = iArr;
        this.f29680b = list;
        this.f29682d = z7;
        this.f29683e = ridesMode;
    }

    public static RidesBarGraphAdapter g(Context context, List<RidesSubPeriodData> list, boolean z7, RidesMode ridesMode) {
        return new RidesBarGraphAdapter((TextView) View.inflate(context, R.layout.bargraph_tooltip_basic, null), new int[]{ContextUtilsKt.b(context, R.attr.linkAlternative), ContextUtilsKt.b(context, R.attr.contentCritical)}, list, z7, ridesMode);
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BarGraphAdapter
    public View a() {
        return this.f29679a;
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BarGraphAdapter
    public int[] b() {
        return this.f29681c;
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BarGraphAdapter
    public String c(int i8) {
        if (this.f29682d) {
            return Dates.a(this.f29680b.get(i8).b());
        }
        return Dates.c(this.f29680b.get(i8).b());
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BarGraphAdapter
    public int d() {
        return this.f29680b.size();
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BarGraphAdapter
    public void e(int i8) {
        String format;
        RidesSubPeriodData ridesSubPeriodData = this.f29680b.get(i8);
        int i9 = AnonymousClass1.f29684a[this.f29683e.ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                format = String.format(Locale.getDefault(), "%1$d%2$s", Integer.valueOf(ridesSubPeriodData.a()), "%");
            } else {
                throw new IllegalStateException("Unknown activity mode " + this.f29683e);
            }
        } else {
            format = String.format(Locale.getDefault(), "%1$d / %2$d", Integer.valueOf(ridesSubPeriodData.c()), Integer.valueOf(ridesSubPeriodData.d()));
        }
        this.f29679a.setText(format);
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BarGraphAdapter
    public float[] f(int i8) {
        RidesSubPeriodData ridesSubPeriodData = this.f29680b.get(i8);
        int i9 = AnonymousClass1.f29684a[this.f29683e.ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                return new float[]{ridesSubPeriodData.a(), 0.0f};
            }
            throw new IllegalStateException("Unknown activity mode " + this.f29683e);
        }
        return new float[]{ridesSubPeriodData.c(), ridesSubPeriodData.d() - ridesSubPeriodData.c()};
    }

    public void h(RidesMode ridesMode) {
        this.f29683e = ridesMode;
    }
}
