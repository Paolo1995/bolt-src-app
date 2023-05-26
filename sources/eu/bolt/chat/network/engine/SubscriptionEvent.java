package eu.bolt.chat.network.engine;

import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.exception.SubscriptionException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionEvent.kt */
/* loaded from: classes5.dex */
public abstract class SubscriptionEvent {

    /* compiled from: SubscriptionEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Failure extends SubscriptionEvent {

        /* renamed from: a  reason: collision with root package name */
        private final String f39529a;

        /* renamed from: b  reason: collision with root package name */
        private final SubscriptionException f39530b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(String topic, SubscriptionException error) {
            super(null);
            Intrinsics.f(topic, "topic");
            Intrinsics.f(error, "error");
            this.f39529a = topic;
            this.f39530b = error;
        }

        @Override // eu.bolt.chat.network.engine.SubscriptionEvent
        public String a() {
            return this.f39529a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return Intrinsics.a(a(), failure.a()) && Intrinsics.a(this.f39530b, failure.f39530b);
            }
            return false;
        }

        public int hashCode() {
            return (a().hashCode() * 31) + this.f39530b.hashCode();
        }

        public String toString() {
            return "Failure(topic=" + a() + ", error=" + this.f39530b + ')';
        }
    }

    /* compiled from: SubscriptionEvent.kt */
    /* loaded from: classes5.dex */
    public static final class NewMessage extends SubscriptionEvent {

        /* renamed from: a  reason: collision with root package name */
        private final MqttMessage f39531a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewMessage(MqttMessage message) {
            super(null);
            Intrinsics.f(message, "message");
            this.f39531a = message;
        }

        @Override // eu.bolt.chat.network.engine.SubscriptionEvent
        public String a() {
            return this.f39531a.c();
        }

        public final MqttMessage b() {
            return this.f39531a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NewMessage) && Intrinsics.a(this.f39531a, ((NewMessage) obj).f39531a);
        }

        public int hashCode() {
            return this.f39531a.hashCode();
        }

        public String toString() {
            return "NewMessage(message=" + this.f39531a + ')';
        }
    }

    /* compiled from: SubscriptionEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Success extends SubscriptionEvent {

        /* renamed from: a  reason: collision with root package name */
        private final String f39532a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String topic) {
            super(null);
            Intrinsics.f(topic, "topic");
            this.f39532a = topic;
        }

        @Override // eu.bolt.chat.network.engine.SubscriptionEvent
        public String a() {
            return this.f39532a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.a(a(), ((Success) obj).a());
        }

        public int hashCode() {
            return a().hashCode();
        }

        public String toString() {
            return "Success(topic=" + a() + ')';
        }
    }

    private SubscriptionEvent() {
    }

    public /* synthetic */ SubscriptionEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String a();
}
