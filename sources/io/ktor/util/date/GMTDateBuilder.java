package io.ktor.util.date;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GMTDateParser.kt */
/* loaded from: classes5.dex */
public final class GMTDateBuilder {

    /* renamed from: a  reason: collision with root package name */
    private Integer f47076a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f47077b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f47078c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f47079d;

    /* renamed from: e  reason: collision with root package name */
    public Month f47080e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f47081f;

    public final GMTDate a() {
        Integer num = this.f47076a;
        Intrinsics.c(num);
        int intValue = num.intValue();
        Integer num2 = this.f47077b;
        Intrinsics.c(num2);
        int intValue2 = num2.intValue();
        Integer num3 = this.f47078c;
        Intrinsics.c(num3);
        int intValue3 = num3.intValue();
        Integer num4 = this.f47079d;
        Intrinsics.c(num4);
        int intValue4 = num4.intValue();
        Month b8 = b();
        Integer num5 = this.f47081f;
        Intrinsics.c(num5);
        return DateJvmKt.a(intValue, intValue2, intValue3, intValue4, b8, num5.intValue());
    }

    public final Month b() {
        Month month = this.f47080e;
        if (month != null) {
            return month;
        }
        Intrinsics.w("month");
        return null;
    }

    public final void c(Integer num) {
        this.f47079d = num;
    }

    public final void d(Integer num) {
        this.f47078c = num;
    }

    public final void e(Integer num) {
        this.f47077b = num;
    }

    public final void f(Month month) {
        Intrinsics.f(month, "<set-?>");
        this.f47080e = month;
    }

    public final void g(Integer num) {
        this.f47076a = num;
    }

    public final void h(Integer num) {
        this.f47081f = num;
    }
}
