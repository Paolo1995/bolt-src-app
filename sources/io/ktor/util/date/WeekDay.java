package io.ktor.util.date;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Date.kt */
/* loaded from: classes5.dex */
public enum WeekDay {
    MONDAY("Mon"),
    TUESDAY("Tue"),
    WEDNESDAY("Wed"),
    THURSDAY("Thu"),
    FRIDAY("Fri"),
    SATURDAY("Sat"),
    SUNDAY("Sun");
    

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f47099g = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final String f47108f;

    /* compiled from: Date.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WeekDay a(int i8) {
            return WeekDay.values()[i8];
        }
    }

    WeekDay(String str) {
        this.f47108f = str;
    }
}
