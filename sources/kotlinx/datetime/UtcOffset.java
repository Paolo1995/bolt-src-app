package kotlinx.datetime;

import j$.time.DateTimeException;
import j$.time.ZoneOffset;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.UtcOffsetSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: UtcOffsetJvm.kt */
@Serializable(with = UtcOffsetSerializer.class)
/* loaded from: classes5.dex */
public final class UtcOffset {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private static final UtcOffset f52042b;

    /* renamed from: a  reason: collision with root package name */
    private final ZoneOffset f52043a;

    /* compiled from: UtcOffsetJvm.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UtcOffset a(String offsetString) {
            Intrinsics.f(offsetString, "offsetString");
            try {
                return new UtcOffset(ZoneOffset.of(offsetString));
            } catch (DateTimeException e8) {
                throw new DateTimeFormatException(e8);
            }
        }

        public final KSerializer<UtcOffset> serializer() {
            return UtcOffsetSerializer.f52052a;
        }
    }

    static {
        ZoneOffset UTC = ZoneOffset.UTC;
        Intrinsics.e(UTC, "UTC");
        f52042b = new UtcOffset(UTC);
    }

    public UtcOffset(ZoneOffset zoneOffset) {
        Intrinsics.f(zoneOffset, "zoneOffset");
        this.f52043a = zoneOffset;
    }

    public final ZoneOffset a() {
        return this.f52043a;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof UtcOffset) && Intrinsics.a(this.f52043a, ((UtcOffset) obj).f52043a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f52043a.hashCode();
    }

    public String toString() {
        String zoneOffset = this.f52043a.toString();
        Intrinsics.e(zoneOffset, "zoneOffset.toString()");
        return zoneOffset;
    }
}
