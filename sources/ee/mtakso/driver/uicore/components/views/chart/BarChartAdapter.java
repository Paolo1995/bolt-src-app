package ee.mtakso.driver.uicore.components.views.chart;

import android.graphics.RectF;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: BarChartAdapter.kt */
/* loaded from: classes5.dex */
public abstract class BarChartAdapter {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f35504b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private static final RectF f35505c = new RectF(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);

    /* renamed from: a  reason: collision with root package name */
    private Function0<Unit> f35506a;

    /* compiled from: BarChartAdapter.kt */
    /* loaded from: classes5.dex */
    public static final class BarLabel {

        /* renamed from: a  reason: collision with root package name */
        private final String f35513a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f35514b;

        public BarLabel(String text, boolean z7) {
            Intrinsics.f(text, "text");
            this.f35513a = text;
            this.f35514b = z7;
        }

        public final String a() {
            return this.f35513a;
        }

        public final boolean b() {
            return this.f35514b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BarLabel) {
                BarLabel barLabel = (BarLabel) obj;
                return Intrinsics.a(this.f35513a, barLabel.f35513a) && this.f35514b == barLabel.f35514b;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.f35513a.hashCode() * 31;
            boolean z7 = this.f35514b;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode + i8;
        }

        public String toString() {
            String str = this.f35513a;
            boolean z7 = this.f35514b;
            return "BarLabel(text=" + str + ", isHighlighted=" + z7 + ")";
        }
    }

    /* compiled from: BarChartAdapter.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(BarLabel barLabel) {
            boolean z7;
            boolean y7;
            if (barLabel == null) {
                return true;
            }
            if (barLabel.a().length() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                return true;
            }
            y7 = StringsKt__StringsJVMKt.y(barLabel.a());
            if (y7) {
                return true;
            }
            return false;
        }
    }

    public abstract BarInfo a(int i8);

    public abstract int b();

    public final void c() {
        Function0<Unit> function0 = this.f35506a;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final RectF d(RectF rectF) {
        Intrinsics.f(rectF, "<this>");
        if (Intrinsics.a(rectF, f35505c)) {
            return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        return rectF;
    }

    public final void e(Function0<Unit> function0) {
        this.f35506a = function0;
    }

    /* compiled from: BarChartAdapter.kt */
    /* loaded from: classes5.dex */
    public static final class BarInfo {

        /* renamed from: a  reason: collision with root package name */
        private final float f35507a;

        /* renamed from: b  reason: collision with root package name */
        private final float f35508b;

        /* renamed from: c  reason: collision with root package name */
        private final float f35509c;

        /* renamed from: d  reason: collision with root package name */
        private final List<BarSector> f35510d;

        /* renamed from: e  reason: collision with root package name */
        private final BarLabel f35511e;

        /* renamed from: f  reason: collision with root package name */
        private final Object f35512f;

        public BarInfo(float f8, float f9, float f10, List<BarSector> sectors, BarLabel barLabel, Object obj) {
            Intrinsics.f(sectors, "sectors");
            this.f35507a = f8;
            this.f35508b = f9;
            this.f35509c = f10;
            this.f35510d = sectors;
            this.f35511e = barLabel;
            this.f35512f = obj;
        }

        public final float a() {
            return this.f35507a;
        }

        public final float b() {
            return this.f35509c;
        }

        public final BarLabel c() {
            return this.f35511e;
        }

        public final float d() {
            return this.f35508b;
        }

        public final List<BarSector> e() {
            return this.f35510d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BarInfo) {
                BarInfo barInfo = (BarInfo) obj;
                return Float.compare(this.f35507a, barInfo.f35507a) == 0 && Float.compare(this.f35508b, barInfo.f35508b) == 0 && Float.compare(this.f35509c, barInfo.f35509c) == 0 && Intrinsics.a(this.f35510d, barInfo.f35510d) && Intrinsics.a(this.f35511e, barInfo.f35511e) && Intrinsics.a(this.f35512f, barInfo.f35512f);
            }
            return false;
        }

        public int hashCode() {
            int floatToIntBits = ((((((Float.floatToIntBits(this.f35507a) * 31) + Float.floatToIntBits(this.f35508b)) * 31) + Float.floatToIntBits(this.f35509c)) * 31) + this.f35510d.hashCode()) * 31;
            BarLabel barLabel = this.f35511e;
            int hashCode = (floatToIntBits + (barLabel == null ? 0 : barLabel.hashCode())) * 31;
            Object obj = this.f35512f;
            return hashCode + (obj != null ? obj.hashCode() : 0);
        }

        public String toString() {
            float f8 = this.f35507a;
            float f9 = this.f35508b;
            float f10 = this.f35509c;
            List<BarSector> list = this.f35510d;
            BarLabel barLabel = this.f35511e;
            Object obj = this.f35512f;
            return "BarInfo(basement=" + f8 + ", peak=" + f9 + ", index=" + f10 + ", sectors=" + list + ", label=" + barLabel + ", extraData=" + obj + ")";
        }

        public /* synthetic */ BarInfo(float f8, float f9, float f10, List list, BarLabel barLabel, Object obj, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(f8, f9, f10, list, (i8 & 16) != 0 ? null : barLabel, (i8 & 32) != 0 ? null : obj);
        }
    }
}
