package ee.mtakso.driver.uicore.components.views.chart;

import android.graphics.RectF;
import android.text.TextPaint;
import ee.mtakso.driver.uicore.components.views.chart.BarChartAdapter;
import ee.mtakso.driver.uicore.components.views.chart.VerticalBarsProcessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: VerticalBarsProcessor.kt */
/* loaded from: classes5.dex */
public final class VerticalBarsProcessor {

    /* renamed from: l  reason: collision with root package name */
    private static final Companion f35547l = new Companion(null);
    @Deprecated

    /* renamed from: m  reason: collision with root package name */
    private static final RectF f35548m = new RectF(0.0f, 10.0f, 1.0f, 0.0f);

    /* renamed from: a  reason: collision with root package name */
    private final RectF f35549a;

    /* renamed from: b  reason: collision with root package name */
    private final BarChartAdapter f35550b;

    /* renamed from: c  reason: collision with root package name */
    private final TextPaint f35551c;

    /* renamed from: d  reason: collision with root package name */
    private final float f35552d;

    /* renamed from: e  reason: collision with root package name */
    private final float f35553e;

    /* renamed from: f  reason: collision with root package name */
    private final String f35554f;

    /* renamed from: g  reason: collision with root package name */
    private final Axis f35555g;

    /* renamed from: h  reason: collision with root package name */
    private final Axis f35556h;

    /* renamed from: i  reason: collision with root package name */
    private RectF f35557i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f35558j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f35559k;

    /* compiled from: VerticalBarsProcessor.kt */
    /* loaded from: classes5.dex */
    public enum Axis {
        REVERTED,
        NORMAL
    }

    /* compiled from: VerticalBarsProcessor.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: VerticalBarsProcessor.kt */
    /* loaded from: classes5.dex */
    public static final class ProcessingResult {

        /* renamed from: a  reason: collision with root package name */
        private final List<Bar> f35563a;

        /* renamed from: b  reason: collision with root package name */
        private final List<GridAxis> f35564b;

        /* renamed from: c  reason: collision with root package name */
        private final float f35565c;

        /* renamed from: d  reason: collision with root package name */
        private final float f35566d;

        public ProcessingResult(List<Bar> bars, List<GridAxis> grid, float f8, float f9) {
            Intrinsics.f(bars, "bars");
            Intrinsics.f(grid, "grid");
            this.f35563a = bars;
            this.f35564b = grid;
            this.f35565c = f8;
            this.f35566d = f9;
        }

        public final List<Bar> a() {
            return this.f35563a;
        }

        public final float b() {
            return this.f35566d;
        }

        public final List<GridAxis> c() {
            return this.f35564b;
        }

        public final float d() {
            return this.f35565c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ProcessingResult) {
                ProcessingResult processingResult = (ProcessingResult) obj;
                return Intrinsics.a(this.f35563a, processingResult.f35563a) && Intrinsics.a(this.f35564b, processingResult.f35564b) && Float.compare(this.f35565c, processingResult.f35565c) == 0 && Float.compare(this.f35566d, processingResult.f35566d) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f35563a.hashCode() * 31) + this.f35564b.hashCode()) * 31) + Float.floatToIntBits(this.f35565c)) * 31) + Float.floatToIntBits(this.f35566d);
        }

        public String toString() {
            List<Bar> list = this.f35563a;
            List<GridAxis> list2 = this.f35564b;
            float f8 = this.f35565c;
            float f9 = this.f35566d;
            return "ProcessingResult(bars=" + list + ", grid=" + list2 + ", leftInset=" + f8 + ", bottomInset=" + f9 + ")";
        }
    }

    /* compiled from: VerticalBarsProcessor.kt */
    /* loaded from: classes5.dex */
    public static final class RawGridValue {

        /* renamed from: a  reason: collision with root package name */
        private final float f35567a;

        /* renamed from: b  reason: collision with root package name */
        private final float f35568b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f35569c;

        public RawGridValue(float f8, float f9, boolean z7) {
            this.f35567a = f8;
            this.f35568b = f9;
            this.f35569c = z7;
        }

        public final float a() {
            return this.f35567a;
        }

        public final float b() {
            return this.f35568b;
        }

        public final boolean c() {
            return this.f35569c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RawGridValue) {
                RawGridValue rawGridValue = (RawGridValue) obj;
                return Float.compare(this.f35567a, rawGridValue.f35567a) == 0 && Float.compare(this.f35568b, rawGridValue.f35568b) == 0 && this.f35569c == rawGridValue.f35569c;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int floatToIntBits = ((Float.floatToIntBits(this.f35567a) * 31) + Float.floatToIntBits(this.f35568b)) * 31;
            boolean z7 = this.f35569c;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return floatToIntBits + i8;
        }

        public String toString() {
            float f8 = this.f35567a;
            float f9 = this.f35568b;
            boolean z7 = this.f35569c;
            return "RawGridValue(originY=" + f8 + ", positionY=" + f9 + ", isSpecial=" + z7 + ")";
        }
    }

    public VerticalBarsProcessor(RectF targetViewport, BarChartAdapter barChartAdapter, TextPaint gridTextPaint, float f8, float f9, String str, Axis xAxis, Axis yAxis) {
        Intrinsics.f(targetViewport, "targetViewport");
        Intrinsics.f(barChartAdapter, "barChartAdapter");
        Intrinsics.f(gridTextPaint, "gridTextPaint");
        Intrinsics.f(xAxis, "xAxis");
        Intrinsics.f(yAxis, "yAxis");
        this.f35549a = targetViewport;
        this.f35550b = barChartAdapter;
        this.f35551c = gridTextPaint;
        this.f35552d = f8;
        this.f35553e = f9;
        this.f35554f = str;
        this.f35555g = xAxis;
        this.f35556h = yAxis;
        int b8 = barChartAdapter.b();
        float f10 = Float.NEGATIVE_INFINITY;
        float f11 = Float.POSITIVE_INFINITY;
        float f12 = Float.NEGATIVE_INFINITY;
        float f13 = Float.NEGATIVE_INFINITY;
        float f14 = Float.POSITIVE_INFINITY;
        for (int i8 = 0; i8 < b8; i8++) {
            BarChartAdapter.BarInfo a8 = barChartAdapter.a(i8);
            if (t(a8) == BarType.POSITIVE) {
                float b9 = a8.b();
                float a9 = a8.a();
                float d8 = a8.d();
                f11 = Math.min(b9, f11);
                f13 = Math.max(b9 + 1, f13);
                f14 = Math.min(Math.min(a9, d8), f14);
                f12 = Math.max(Math.max(a9, d8), f12);
            }
        }
        this.f35557i = a(barChartAdapter.d(new RectF(f11, f12, f13, f14)));
        BarChartAdapter barChartAdapter2 = this.f35550b;
        int b10 = barChartAdapter2.b();
        float f15 = Float.NEGATIVE_INFINITY;
        float f16 = Float.POSITIVE_INFINITY;
        float f17 = Float.POSITIVE_INFINITY;
        for (int i9 = 0; i9 < b10; i9++) {
            BarChartAdapter.BarInfo a10 = barChartAdapter2.a(i9);
            if (t(a10) == BarType.NEGATIVE) {
                float b11 = a10.b();
                float a11 = a10.a();
                float d9 = a10.d();
                f16 = Math.min(b11, f16);
                f15 = Math.max(b11 + 1, f15);
                f17 = Math.min(Math.min(a11, d9), f17);
                f10 = Math.max(Math.max(a11, d9), f10);
            }
        }
        this.f35558j = a(barChartAdapter2.d(new RectF(f16, f10, f15, f17)));
        this.f35559k = c();
    }

    private final RectF a(RectF rectF) {
        int abs = (int) (Math.abs(rectF.height()) * 0.25f);
        float f8 = rectF.left;
        MathUtils mathUtils = MathUtils.f35546a;
        return new RectF(f8, mathUtils.a((int) rectF.top, abs), rectF.right, mathUtils.a((int) rectF.bottom, abs));
    }

    private final List<RawGridValue> b() {
        boolean z7;
        boolean z8;
        int floor = (int) Math.floor((this.f35557i.height() / this.f35559k.height()) * 4);
        int i8 = 4 - floor;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RawGridValue(0.0f, l(0.0f), true));
        if (i8 > 0) {
            float abs = Math.abs(this.f35558j.height()) / i8;
            float f8 = -abs;
            if (1 <= i8) {
                int i9 = 1;
                while (true) {
                    if (i9 != i8 && (i8 % 2 != 0 || i9 != i8 / 2)) {
                        z8 = false;
                    } else {
                        z8 = true;
                    }
                    arrayList.add(new RawGridValue(f8, l(f8), z8));
                    f8 -= abs;
                    if (i9 == i8) {
                        break;
                    }
                    i9++;
                }
            }
        }
        if (floor > 0) {
            float abs2 = Math.abs(this.f35557i.height()) / floor;
            if (1 <= floor) {
                float f9 = abs2;
                int i10 = 1;
                while (true) {
                    if (i10 != floor && (floor % 2 != 0 || i10 != floor / 2)) {
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                    arrayList.add(new RawGridValue(f9, l(f9), z7));
                    f9 += abs2;
                    if (i10 == floor) {
                        break;
                    }
                    i10++;
                }
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.z(arrayList, new Comparator() { // from class: ee.mtakso.driver.uicore.components.views.chart.VerticalBarsProcessor$calculateGridValues$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t7, T t8) {
                    int a8;
                    a8 = ComparisonsKt__ComparisonsKt.a(Float.valueOf(((VerticalBarsProcessor.RawGridValue) t7).b()), Float.valueOf(((VerticalBarsProcessor.RawGridValue) t8).b()));
                    return a8;
                }
            });
        }
        return arrayList;
    }

    private final RectF c() {
        if (e(this.f35557i) && e(this.f35558j)) {
            RectF rectF = f35548m;
            this.f35557i = rectF;
            return rectF;
        } else if (e(this.f35557i)) {
            return this.f35558j;
        } else {
            if (e(this.f35558j)) {
                return this.f35557i;
            }
            return new RectF(Math.min(this.f35557i.left, this.f35558j.left), Math.max(this.f35557i.top, this.f35558j.top), Math.max(this.f35557i.right, this.f35558j.right), Math.min(this.f35557i.bottom, this.f35558j.bottom));
        }
    }

    private final String d(RawGridValue rawGridValue, String str) {
        if (rawGridValue.c()) {
            if (str == null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
                String format = String.format("%.0f", Arrays.copyOf(new Object[]{Float.valueOf(rawGridValue.a())}, 1));
                Intrinsics.e(format, "format(format, *args)");
                return format;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f51021a;
            String format2 = String.format("%.0f %s", Arrays.copyOf(new Object[]{Float.valueOf(rawGridValue.a()), str}, 2));
            Intrinsics.e(format2, "format(format, *args)");
            return format2;
        }
        return null;
    }

    private final boolean e(RectF rectF) {
        if (r(rectF) == 0.0f) {
            return true;
        }
        return false;
    }

    private final float f(List<RawGridValue> list) {
        float f8 = 0.0f;
        for (RawGridValue rawGridValue : list) {
            if (rawGridValue.c()) {
                f8 = Math.max(f8, this.f35551c.measureText(d(rawGridValue, this.f35554f)));
            }
        }
        return (this.f35552d * 2) + f8;
    }

    private final float g(float f8) {
        return f8 - this.f35559k.left;
    }

    private final float h(float f8) {
        return f8 + Math.abs(this.f35558j.height());
    }

    private final List<Bar> j() {
        ArrayList arrayList = new ArrayList();
        float width = this.f35549a.width() / this.f35550b.b();
        int b8 = this.f35550b.b();
        int i8 = 0;
        while (i8 < b8) {
            BarChartAdapter.BarInfo a8 = this.f35550b.a(i8);
            float l8 = l(a8.a());
            float l9 = l(a8.d());
            BarType t7 = t(a8);
            float f8 = this.f35549a.left;
            i8++;
            arrayList.add(new Bar((i8 * width) + f8, (i8 * width) + f8, Math.max(l9, l8), Math.min(l9, l8), t7, BarKt.b(a8.c()), a8.e()));
        }
        return arrayList;
    }

    private final float k(float f8) {
        float o8 = o(g(f8));
        if (this.f35555g == Axis.REVERTED) {
            o8 = m(o8);
        }
        return o8 + this.f35549a.left;
    }

    private final float l(float f8) {
        float p8 = p(h(f8));
        if (this.f35556h == Axis.REVERTED) {
            p8 = n(p8);
        }
        return p8 + this.f35549a.top;
    }

    private final float m(float f8) {
        return this.f35549a.width() - f8;
    }

    private final float n(float f8) {
        return this.f35549a.height() - f8;
    }

    private final float o(float f8) {
        return Math.abs(this.f35549a.width() / this.f35559k.width()) * f8;
    }

    private final float p(float f8) {
        return Math.abs(this.f35549a.height() / this.f35559k.height()) * f8;
    }

    private final boolean q() {
        int b8 = this.f35550b.b();
        boolean z7 = false;
        for (int i8 = 0; i8 < b8; i8++) {
            z7 |= !BarChartAdapter.f35504b.a(this.f35550b.a(i8).c());
        }
        return z7;
    }

    private final float r(RectF rectF) {
        return Math.abs(rectF.height()) * Math.abs(rectF.width());
    }

    private final List<GridAxis> s(List<RawGridValue> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            arrayList.add(new GridAxis(list.get(i8).b(), k(this.f35559k.left), d(list.get(i8), this.f35554f)));
        }
        return arrayList;
    }

    private final BarType t(BarChartAdapter.BarInfo barInfo) {
        if (Math.min(barInfo.a(), barInfo.d()) < 0.0f) {
            return BarType.NEGATIVE;
        }
        return BarType.POSITIVE;
    }

    public final ProcessingResult i() {
        float a8;
        if (q()) {
            a8 = (this.f35553e * 2) + BarChartView.f35515y.a(this.f35551c);
        } else {
            a8 = BarChartView.f35515y.a(this.f35551c);
        }
        this.f35549a.bottom -= a8;
        List<RawGridValue> b8 = b();
        float f8 = f(b8);
        this.f35549a.left += f8;
        return new ProcessingResult(j(), s(b8), f8, a8);
    }

    public /* synthetic */ VerticalBarsProcessor(RectF rectF, BarChartAdapter barChartAdapter, TextPaint textPaint, float f8, float f9, String str, Axis axis, Axis axis2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(rectF, barChartAdapter, textPaint, f8, f9, str, (i8 & 64) != 0 ? Axis.NORMAL : axis, (i8 & 128) != 0 ? Axis.NORMAL : axis2);
    }
}
