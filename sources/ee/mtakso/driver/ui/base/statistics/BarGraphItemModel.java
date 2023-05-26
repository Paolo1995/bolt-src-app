package ee.mtakso.driver.ui.base.statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BarGraphItemModel.kt */
/* loaded from: classes3.dex */
public final class BarGraphItemModel {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f26310d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f26311a;

    /* renamed from: b  reason: collision with root package name */
    private final float[] f26312b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f26313c;

    /* compiled from: BarGraphItemModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BarGraphItemModel a(String name, float[] values, int[] colors, float f8) {
            float x02;
            List r02;
            float[] p8;
            List X;
            int[] r7;
            Intrinsics.f(name, "name");
            Intrinsics.f(values, "values");
            Intrinsics.f(colors, "colors");
            ArrayList arrayList = new ArrayList(values.length);
            for (float f9 : values) {
                arrayList.add(Float.valueOf(f9 / f8));
            }
            x02 = CollectionsKt___CollectionsKt.x0(arrayList);
            r02 = CollectionsKt___CollectionsKt.r0(arrayList);
            p8 = ArraysKt___ArraysJvmKt.p(new float[]{1 - x02}, r02);
            X = ArraysKt___ArraysKt.X(colors);
            r7 = ArraysKt___ArraysJvmKt.r(new int[]{0}, X);
            return new BarGraphItemModel(name, p8, r7);
        }
    }

    public BarGraphItemModel(String name, float[] weights, int[] colors) {
        Intrinsics.f(name, "name");
        Intrinsics.f(weights, "weights");
        Intrinsics.f(colors, "colors");
        this.f26311a = name;
        this.f26312b = weights;
        this.f26313c = colors;
    }

    public static final BarGraphItemModel a(String str, float[] fArr, int[] iArr, float f8) {
        return f26310d.a(str, fArr, iArr, f8);
    }

    public final int[] b() {
        return this.f26313c;
    }

    public final String c() {
        return this.f26311a;
    }

    public final float[] d() {
        return this.f26312b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BarGraphItemModel) {
            BarGraphItemModel barGraphItemModel = (BarGraphItemModel) obj;
            return Intrinsics.a(this.f26311a, barGraphItemModel.f26311a) && Intrinsics.a(this.f26312b, barGraphItemModel.f26312b) && Intrinsics.a(this.f26313c, barGraphItemModel.f26313c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f26311a.hashCode() * 31) + Arrays.hashCode(this.f26312b)) * 31) + Arrays.hashCode(this.f26313c);
    }

    public String toString() {
        String str = this.f26311a;
        String arrays = Arrays.toString(this.f26312b);
        String arrays2 = Arrays.toString(this.f26313c);
        return "BarGraphItemModel(name=" + str + ", weights=" + arrays + ", colors=" + arrays2 + ")";
    }
}
