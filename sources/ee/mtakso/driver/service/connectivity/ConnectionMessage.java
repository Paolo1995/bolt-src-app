package ee.mtakso.driver.service.connectivity;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectionMessage.kt */
/* loaded from: classes3.dex */
public abstract class ConnectionMessage {

    /* compiled from: ConnectionMessage.kt */
    /* loaded from: classes3.dex */
    public static final class Reconnected extends ConnectionMessage {

        /* renamed from: a  reason: collision with root package name */
        public static final Reconnected f24081a = new Reconnected();

        private Reconnected() {
            super(null);
        }
    }

    /* compiled from: ConnectionMessage.kt */
    /* loaded from: classes3.dex */
    public static final class Status extends ConnectionMessage {

        /* renamed from: a  reason: collision with root package name */
        private final NetworkConnectionStatus f24082a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Status(NetworkConnectionStatus status) {
            super(null);
            Intrinsics.f(status, "status");
            this.f24082a = status;
        }

        public final NetworkConnectionStatus a() {
            return this.f24082a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Status) && this.f24082a == ((Status) obj).f24082a;
        }

        public int hashCode() {
            return this.f24082a.hashCode();
        }

        public String toString() {
            NetworkConnectionStatus networkConnectionStatus = this.f24082a;
            return "Status(status=" + networkConnectionStatus + ")";
        }
    }

    private ConnectionMessage() {
    }

    public /* synthetic */ ConnectionMessage(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
