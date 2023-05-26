package kotlinx.datetime;

import j$.time.Clock;
import j$.time.OffsetDateTime;
import j$.time.format.DateTimeParseException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.datetime.serializers.InstantIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: Instant.kt */
@Serializable(with = InstantIso8601Serializer.class)
/* loaded from: classes5.dex */
public final class Instant implements Comparable<Instant> {
    public static final Companion Companion = new Companion(null);

    /* renamed from: g  reason: collision with root package name */
    private static final Instant f52032g;

    /* renamed from: h  reason: collision with root package name */
    private static final Instant f52033h;

    /* renamed from: i  reason: collision with root package name */
    private static final Instant f52034i;

    /* renamed from: j  reason: collision with root package name */
    private static final Instant f52035j;

    /* renamed from: f  reason: collision with root package name */
    private final j$.time.Instant f52036f;

    /* compiled from: Instant.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String a(String str) {
            int a02;
            int i8;
            int a03;
            boolean z7;
            a02 = StringsKt__StringsKt.a0(str, 'T', 0, true, 2, null);
            if (a02 == -1) {
                return str;
            }
            int length = str.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i9 = length - 1;
                    char charAt = str.charAt(length);
                    if (charAt != '+' && charAt != '-') {
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                    if (z7) {
                        i8 = length;
                        break;
                    } else if (i9 < 0) {
                        break;
                    } else {
                        length = i9;
                    }
                }
            }
            i8 = -1;
            if (i8 < a02) {
                return str;
            }
            a03 = StringsKt__StringsKt.a0(str, ':', i8, false, 4, null);
            if (a03 == -1) {
                return str + ":00";
            }
            return str;
        }

        public final Instant b(long j8) {
            j$.time.Instant ofEpochMilli = j$.time.Instant.ofEpochMilli(j8);
            Intrinsics.e(ofEpochMilli, "ofEpochMilli(epochMilliseconds)");
            return new Instant(ofEpochMilli);
        }

        public final Instant c() {
            j$.time.Instant instant = Clock.systemUTC().instant();
            Intrinsics.e(instant, "systemUTC().instant()");
            return new Instant(instant);
        }

        public final Instant d(String isoString) {
            Intrinsics.f(isoString, "isoString");
            try {
                j$.time.Instant instant = OffsetDateTime.parse(a(isoString)).toInstant();
                Intrinsics.e(instant, "parse(fixOffsetRepresent…n(isoString)).toInstant()");
                return new Instant(instant);
            } catch (DateTimeParseException e8) {
                throw new DateTimeFormatException(e8);
            }
        }

        public final KSerializer<Instant> serializer() {
            return InstantIso8601Serializer.f52046a;
        }
    }

    static {
        j$.time.Instant ofEpochSecond = j$.time.Instant.ofEpochSecond(-3217862419201L, 999999999L);
        Intrinsics.e(ofEpochSecond, "ofEpochSecond(DISTANT_PAST_SECONDS, 999_999_999)");
        f52032g = new Instant(ofEpochSecond);
        j$.time.Instant ofEpochSecond2 = j$.time.Instant.ofEpochSecond(3093527980800L, 0L);
        Intrinsics.e(ofEpochSecond2, "ofEpochSecond(DISTANT_FUTURE_SECONDS, 0)");
        f52033h = new Instant(ofEpochSecond2);
        j$.time.Instant MIN = j$.time.Instant.MIN;
        Intrinsics.e(MIN, "MIN");
        f52034i = new Instant(MIN);
        j$.time.Instant MAX = j$.time.Instant.MAX;
        Intrinsics.e(MAX, "MAX");
        f52035j = new Instant(MAX);
    }

    public Instant(j$.time.Instant value) {
        Intrinsics.f(value, "value");
        this.f52036f = value;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Instant other) {
        Intrinsics.f(other, "other");
        return this.f52036f.compareTo(other.f52036f);
    }

    public final j$.time.Instant c() {
        return this.f52036f;
    }

    public final long e() {
        try {
            return this.f52036f.toEpochMilli();
        } catch (ArithmeticException unused) {
            if (this.f52036f.isAfter(j$.time.Instant.EPOCH)) {
                return Long.MAX_VALUE;
            }
            return Long.MIN_VALUE;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj && (!(obj instanceof Instant) || !Intrinsics.a(this.f52036f, ((Instant) obj).f52036f))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f52036f.hashCode();
    }

    public String toString() {
        String instant = this.f52036f.toString();
        Intrinsics.e(instant, "value.toString()");
        return instant;
    }
}
