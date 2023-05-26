package kotlinx.datetime;

import j$.time.ZoneId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.FixedOffsetTimeZoneSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: TimeZoneJvm.kt */
@Serializable(with = FixedOffsetTimeZoneSerializer.class)
/* loaded from: classes5.dex */
public final class FixedOffsetTimeZone extends TimeZone {
    public static final Companion Companion = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private final UtcOffset f52031c;

    /* compiled from: TimeZoneJvm.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<FixedOffsetTimeZone> serializer() {
            return FixedOffsetTimeZoneSerializer.f52044a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedOffsetTimeZone(UtcOffset offset, ZoneId zoneId) {
        super(zoneId);
        Intrinsics.f(offset, "offset");
        Intrinsics.f(zoneId, "zoneId");
        this.f52031c = offset;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FixedOffsetTimeZone(UtcOffset offset) {
        this(offset, offset.a());
        Intrinsics.f(offset, "offset");
    }
}
