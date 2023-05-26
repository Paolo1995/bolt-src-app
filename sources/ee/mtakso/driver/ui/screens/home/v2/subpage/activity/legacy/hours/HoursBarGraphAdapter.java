package ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.hours;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.driver.HoursSubPeriodData;
import ee.mtakso.driver.ui.base.statistics.BarGraphAdapter;
import ee.mtakso.driver.ui.utils.Dates;
import ee.mtakso.driver.ui.utils.Seconds;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import java.util.List;

/* loaded from: classes3.dex */
public class HoursBarGraphAdapter implements BarGraphAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f29671a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f29672b;

    /* renamed from: c  reason: collision with root package name */
    private final List<HoursSubPeriodData> f29673c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f29674d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f29675e;

    private HoursBarGraphAdapter(TextView textView, int[] iArr, List<HoursSubPeriodData> list, boolean z7, Context context) {
        this.f29671a = textView;
        this.f29672b = iArr;
        this.f29673c = list;
        this.f29674d = z7;
        this.f29675e = context;
    }

    public static HoursBarGraphAdapter g(Context context, List<HoursSubPeriodData> list, boolean z7) {
        return new HoursBarGraphAdapter((TextView) View.inflate(context, R.layout.bargraph_tooltip_basic, null), new int[]{ContextUtilsKt.b(context, R.attr.linkAlternative)}, list, z7, context);
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BarGraphAdapter
    public View a() {
        return this.f29671a;
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BarGraphAdapter
    public int[] b() {
        return this.f29672b;
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BarGraphAdapter
    public String c(int i8) {
        if (this.f29674d) {
            return Dates.a(this.f29673c.get(i8).b());
        }
        return Dates.c(this.f29673c.get(i8).b());
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BarGraphAdapter
    public int d() {
        return this.f29673c.size();
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BarGraphAdapter
    public void e(int i8) {
        this.f29671a.setText(Seconds.a(this.f29675e, this.f29673c.get(i8).a()));
    }

    @Override // ee.mtakso.driver.ui.base.statistics.BarGraphAdapter
    public float[] f(int i8) {
        return new float[]{this.f29673c.get(i8).a()};
    }
}
