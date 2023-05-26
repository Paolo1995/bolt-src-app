package kotlinx.datetime;

import j$.time.chrono.ChronoLocalDateTime;
import j$.time.format.DateTimeParseException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.LocalDateTimeIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: LocalDateTime.kt */
@Serializable(with = LocalDateTimeIso8601Serializer.class)
/* loaded from: classes5.dex */
public final class LocalDateTime implements Comparable<LocalDateTime> {
    public static final Companion Companion = new Companion(null);

    /* renamed from: g  reason: collision with root package name */
    private static final LocalDateTime f52037g;

    /* renamed from: h  reason: collision with root package name */
    private static final LocalDateTime f52038h;

    /* renamed from: f  reason: collision with root package name */
    private final j$.time.LocalDateTime f52039f;

    /* compiled from: LocalDateTime.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalDateTime a(String isoString) {
            Intrinsics.f(isoString, "isoString");
            try {
                return new LocalDateTime(j$.time.LocalDateTime.parse(isoString));
            } catch (DateTimeParseException e8) {
                throw new DateTimeFormatException(e8);
            }
        }

        public final KSerializer<LocalDateTime> serializer() {
            return LocalDateTimeIso8601Serializer.f52048a;
        }
    }

    static {
        j$.time.LocalDateTime MIN = j$.time.LocalDateTime.MIN;
        Intrinsics.e(MIN, "MIN");
        f52037g = new LocalDateTime(MIN);
        j$.time.LocalDateTime MAX = j$.time.LocalDateTime.MAX;
        Intrinsics.e(MAX, "MAX");
        f52038h = new LocalDateTime(MAX);
    }

    public LocalDateTime(j$.time.LocalDateTime value) {
        Intrinsics.f(value, "value");
        this.f52039f = value;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(LocalDateTime other) {
        Intrinsics.f(other, "other");
        return this.f52039f.compareTo((ChronoLocalDateTime<?>) other.f52039f);
    }

    public final j$.time.LocalDateTime c() {
        return this.f52039f;
    }

    public boolean equals(Object obj) {
        if (this != obj && (!(obj instanceof LocalDateTime) || !Intrinsics.a(this.f52039f, ((LocalDateTime) obj).f52039f))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f52039f.hashCode();
    }

    public String toString() {
        String localDateTime = this.f52039f.toString();
        Intrinsics.e(localDateTime, "value.toString()");
        return localDateTime;
    }
}
