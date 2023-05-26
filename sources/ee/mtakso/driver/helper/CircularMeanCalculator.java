package ee.mtakso.driver.helper;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import q1.a;

/* compiled from: CircularMeanCalculator.kt */
/* loaded from: classes3.dex */
public final class CircularMeanCalculator {

    /* renamed from: a  reason: collision with root package name */
    private CircularFifoQueue<Double> f20937a;

    /* compiled from: CircularMeanCalculator.kt */
    /* loaded from: classes3.dex */
    private static final class SinCosPair {

        /* renamed from: a  reason: collision with root package name */
        private double f20938a;

        /* renamed from: b  reason: collision with root package name */
        private double f20939b;

        public SinCosPair(double d8, double d9) {
            this.f20938a = d8;
            this.f20939b = d9;
        }

        public final double a() {
            return this.f20939b;
        }

        public final double b() {
            return this.f20938a;
        }

        public final void c(double d8) {
            this.f20939b = d8;
        }

        public final void d(double d8) {
            this.f20938a = d8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SinCosPair) {
                SinCosPair sinCosPair = (SinCosPair) obj;
                return Double.compare(this.f20938a, sinCosPair.f20938a) == 0 && Double.compare(this.f20939b, sinCosPair.f20939b) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (a.a(this.f20938a) * 31) + a.a(this.f20939b);
        }

        public String toString() {
            double d8 = this.f20938a;
            double d9 = this.f20939b;
            return "SinCosPair(sin=" + d8 + ", cos=" + d9 + ")";
        }
    }

    public CircularMeanCalculator(int i8) {
        this.f20937a = new CircularFifoQueue<>(i8);
    }

    public final void a(double d8) {
        this.f20937a.add(Double.valueOf(d8));
    }

    public final double b() {
        int v7;
        if (this.f20937a.size() == 0) {
            return 0.0d;
        }
        CircularFifoQueue<Double> circularFifoQueue = this.f20937a;
        v7 = CollectionsKt__IterablesKt.v(circularFifoQueue, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (Double it : circularFifoQueue) {
            Intrinsics.e(it, "it");
            arrayList.add(new SinCosPair(Math.sin(Math.toRadians(it.doubleValue())), Math.cos(Math.toRadians(it.doubleValue()))));
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            SinCosPair sinCosPair = it2.next();
            while (it2.hasNext()) {
                SinCosPair sinCosPair2 = (SinCosPair) it2.next();
                SinCosPair sinCosPair3 = (SinCosPair) sinCosPair;
                sinCosPair3.c(sinCosPair3.a() + sinCosPair2.a());
                sinCosPair3.d(sinCosPair3.b() + sinCosPair2.b());
                sinCosPair = sinCosPair3;
            }
            SinCosPair sinCosPair4 = (SinCosPair) sinCosPair;
            sinCosPair4.c(sinCosPair4.a() / this.f20937a.size());
            sinCosPair4.d(sinCosPair4.b() / this.f20937a.size());
            double degrees = Math.toDegrees(Math.atan2(sinCosPair4.b(), sinCosPair4.a()));
            if (degrees < 0.0d) {
                return degrees + 360;
            }
            return degrees;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }
}
