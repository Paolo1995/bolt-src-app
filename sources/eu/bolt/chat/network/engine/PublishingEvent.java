package eu.bolt.chat.network.engine;

import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.exception.PublishingException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PublishingEvent.kt */
/* loaded from: classes5.dex */
public abstract class PublishingEvent {

    /* compiled from: PublishingEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Failure extends PublishingEvent {

        /* renamed from: a  reason: collision with root package name */
        private final MqttMessage f39526a;

        /* renamed from: b  reason: collision with root package name */
        private final PublishingException f39527b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(MqttMessage message, PublishingException error) {
            super(null);
            Intrinsics.f(message, "message");
            Intrinsics.f(error, "error");
            this.f39526a = message;
            this.f39527b = error;
        }

        public final PublishingException a() {
            return this.f39527b;
        }

        public final MqttMessage b() {
            return this.f39526a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return Intrinsics.a(this.f39526a, failure.f39526a) && Intrinsics.a(this.f39527b, failure.f39527b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f39526a.hashCode() * 31) + this.f39527b.hashCode();
        }

        public String toString() {
            return "Failure(message=" + this.f39526a + ", error=" + this.f39527b + ')';
        }
    }

    /* compiled from: PublishingEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Success extends PublishingEvent {

        /* renamed from: a  reason: collision with root package name */
        private final MqttMessage f39528a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(MqttMessage message) {
            super(null);
            Intrinsics.f(message, "message");
            this.f39528a = message;
        }

        public final MqttMessage a() {
            return this.f39528a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.a(this.f39528a, ((Success) obj).f39528a);
        }

        public int hashCode() {
            return this.f39528a.hashCode();
        }

        public String toString() {
            return "Success(message=" + this.f39528a + ')';
        }
    }

    private PublishingEvent() {
    }

    public /* synthetic */ PublishingEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
