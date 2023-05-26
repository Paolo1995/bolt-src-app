package io.ktor.websocket;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: CloseReason.kt */
/* loaded from: classes5.dex */
public final class CloseReason {

    /* renamed from: a  reason: collision with root package name */
    private final short f47519a;

    /* renamed from: b  reason: collision with root package name */
    private final String f47520b;

    /* compiled from: CloseReason.kt */
    /* loaded from: classes5.dex */
    public enum Codes {
        NORMAL(1000),
        GOING_AWAY(1001),
        PROTOCOL_ERROR(1002),
        CANNOT_ACCEPT(1003),
        CLOSED_ABNORMALLY(1006),
        NOT_CONSISTENT(1007),
        VIOLATED_POLICY(1008),
        TOO_BIG(1009),
        NO_EXTENSION(1010),
        INTERNAL_ERROR(1011),
        SERVICE_RESTART(1012),
        TRY_AGAIN_LATER(1013);
        

        /* renamed from: g  reason: collision with root package name */
        public static final Companion f47521g = new Companion(null);

        /* renamed from: h  reason: collision with root package name */
        private static final Map<Short, Codes> f47522h;

        /* renamed from: i  reason: collision with root package name */
        public static final Codes f47523i;

        /* renamed from: f  reason: collision with root package name */
        private final short f47537f;

        /* compiled from: CloseReason.kt */
        /* loaded from: classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Codes a(short s7) {
                return (Codes) Codes.f47522h.get(Short.valueOf(s7));
            }
        }

        static {
            int b8;
            int d8;
            Codes[] values = values();
            b8 = MapsKt__MapsJVMKt.b(values.length);
            d8 = RangesKt___RangesKt.d(b8, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(d8);
            for (Codes codes : values) {
                linkedHashMap.put(Short.valueOf(codes.f47537f), codes);
            }
            f47522h = linkedHashMap;
            f47523i = INTERNAL_ERROR;
        }

        Codes(short s7) {
            this.f47537f = s7;
        }

        public final short e() {
            return this.f47537f;
        }
    }

    public CloseReason(short s7, String message) {
        Intrinsics.f(message, "message");
        this.f47519a = s7;
        this.f47520b = message;
    }

    public final short a() {
        return this.f47519a;
    }

    public final Codes b() {
        return Codes.f47521g.a(this.f47519a);
    }

    public final String c() {
        return this.f47520b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CloseReason) {
            CloseReason closeReason = (CloseReason) obj;
            return this.f47519a == closeReason.f47519a && Intrinsics.a(this.f47520b, closeReason.f47520b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f47519a * 31) + this.f47520b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CloseReason(reason=");
        Object b8 = b();
        if (b8 == null) {
            b8 = Short.valueOf(this.f47519a);
        }
        sb.append(b8);
        sb.append(", message=");
        sb.append(this.f47520b);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseReason(Codes code, String message) {
        this(code.e(), message);
        Intrinsics.f(code, "code");
        Intrinsics.f(message, "message");
    }
}
