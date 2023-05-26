package kotlinx.datetime;

import j$.time.DateTimeException;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.TimeZoneSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: TimeZoneJvm.kt */
@Serializable(with = TimeZoneSerializer.class)
/* loaded from: classes5.dex */
public class TimeZone {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private static final FixedOffsetTimeZone f52040b;

    /* renamed from: a  reason: collision with root package name */
    private final ZoneId f52041a;

    /* compiled from: TimeZoneJvm.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TimeZone a() {
            ZoneId systemDefault = ZoneId.systemDefault();
            Intrinsics.e(systemDefault, "systemDefault()");
            return c(systemDefault);
        }

        public final TimeZone b(String zoneId) {
            Intrinsics.f(zoneId, "zoneId");
            try {
                ZoneId of = ZoneId.of(zoneId);
                Intrinsics.e(of, "of(zoneId)");
                return c(of);
            } catch (Exception e8) {
                if (e8 instanceof DateTimeException) {
                    throw new IllegalTimeZoneException(e8);
                }
                throw e8;
            }
        }

        public final TimeZone c(ZoneId zoneId) {
            Intrinsics.f(zoneId, "zoneId");
            if (zoneId instanceof ZoneOffset) {
                return new FixedOffsetTimeZone(new UtcOffset((ZoneOffset) zoneId));
            }
            if (TimeZoneKt__TimeZoneJvmKt.a(zoneId)) {
                ZoneId normalized = zoneId.normalized();
                Intrinsics.d(normalized, "null cannot be cast to non-null type java.time.ZoneOffset");
                return new FixedOffsetTimeZone(new UtcOffset((ZoneOffset) normalized), zoneId);
            }
            return new TimeZone(zoneId);
        }

        public final KSerializer<TimeZone> serializer() {
            return TimeZoneSerializer.f52050a;
        }
    }

    static {
        ZoneOffset UTC = ZoneOffset.UTC;
        Intrinsics.e(UTC, "UTC");
        f52040b = UtcOffsetKt.a(new UtcOffset(UTC));
    }

    public TimeZone(ZoneId zoneId) {
        Intrinsics.f(zoneId, "zoneId");
        this.f52041a = zoneId;
    }

    public final String a() {
        String id = this.f52041a.getId();
        Intrinsics.e(id, "zoneId.id");
        return id;
    }

    public final ZoneId b() {
        return this.f52041a;
    }

    public boolean equals(Object obj) {
        if (this != obj && (!(obj instanceof TimeZone) || !Intrinsics.a(this.f52041a, ((TimeZone) obj).f52041a))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f52041a.hashCode();
    }

    public String toString() {
        String zoneId = this.f52041a.toString();
        Intrinsics.e(zoneId, "zoneId.toString()");
        return zoneId;
    }
}
