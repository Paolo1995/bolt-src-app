package eu.bolt.chat.network.engine;

import eu.bolt.chat.network.exception.MqttException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectionEvent.kt */
/* loaded from: classes5.dex */
public abstract class ConnectionEvent {

    /* compiled from: ConnectionEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Connected extends ConnectionEvent {

        /* renamed from: a  reason: collision with root package name */
        public static final Connected f39407a = new Connected();

        private Connected() {
            super(null);
        }

        public String toString() {
            return "Connected";
        }
    }

    /* compiled from: ConnectionEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Disconnected extends ConnectionEvent {

        /* renamed from: a  reason: collision with root package name */
        public static final Disconnected f39408a = new Disconnected();

        private Disconnected() {
            super(null);
        }

        public String toString() {
            return "Disconnected";
        }
    }

    /* compiled from: ConnectionEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Failure extends ConnectionEvent {

        /* renamed from: a  reason: collision with root package name */
        private final MqttException f39409a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(MqttException error) {
            super(null);
            Intrinsics.f(error, "error");
            this.f39409a = error;
        }

        public final MqttException a() {
            return this.f39409a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && Intrinsics.a(this.f39409a, ((Failure) obj).f39409a);
        }

        public int hashCode() {
            return this.f39409a.hashCode();
        }

        public String toString() {
            return "Failure(error=" + this.f39409a + ')';
        }
    }

    /* compiled from: ConnectionEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Reconnecting extends ConnectionEvent {

        /* renamed from: a  reason: collision with root package name */
        public static final Reconnecting f39410a = new Reconnecting();

        private Reconnecting() {
            super(null);
        }

        public String toString() {
            return "Reconnecting";
        }
    }

    private ConnectionEvent() {
    }

    public /* synthetic */ ConnectionEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
