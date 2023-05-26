package io.ktor.util.date;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Date.kt */
/* loaded from: classes5.dex */
public enum Month {
    JANUARY("Jan"),
    FEBRUARY("Feb"),
    MARCH("Mar"),
    APRIL("Apr"),
    MAY("May"),
    JUNE("Jun"),
    JULY("Jul"),
    AUGUST("Aug"),
    SEPTEMBER("Sep"),
    OCTOBER("Oct"),
    NOVEMBER("Nov"),
    DECEMBER("Dec");
    

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f47084g = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final String f47098f;

    /* compiled from: Date.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Month a(int i8) {
            return Month.values()[i8];
        }

        public final Month b(String value) {
            Month month;
            Intrinsics.f(value, "value");
            Month[] values = Month.values();
            int length = values.length;
            int i8 = 0;
            while (true) {
                if (i8 < length) {
                    month = values[i8];
                    if (Intrinsics.a(month.c(), value)) {
                        break;
                    }
                    i8++;
                } else {
                    month = null;
                    break;
                }
            }
            if (month != null) {
                return month;
            }
            throw new IllegalStateException(("Invalid month: " + value).toString());
        }
    }

    Month(String str) {
        this.f47098f = str;
    }

    public final String c() {
        return this.f47098f;
    }
}
