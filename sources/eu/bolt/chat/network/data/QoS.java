package eu.bolt.chat.network.data;

import kotlin.UByte;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: QoS.kt */
/* loaded from: classes5.dex */
public enum QoS {
    AT_MOST_ONCE(UByte.c((byte) 0)),
    AT_LEAST_ONCE(UByte.c((byte) 1)),
    EXACTLY_ONCE(UByte.c((byte) 2));
    

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f39262g = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final byte f39267f;

    /* compiled from: QoS.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    QoS(byte b8) {
        this.f39267f = b8;
    }
}
