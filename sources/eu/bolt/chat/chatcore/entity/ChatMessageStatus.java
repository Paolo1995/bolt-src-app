package eu.bolt.chat.chatcore.entity;

import eu.bolt.chat.chatcore.ChatKit;
import eu.bolt.chat.tools.logger.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMessageStatus.kt */
/* loaded from: classes5.dex */
public abstract class ChatMessageStatus {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f38162a = new Companion(null);

    /* compiled from: ChatMessageStatus.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChatMessageStatus a(String serverName) {
            Intrinsics.f(serverName, "serverName");
            if (Intrinsics.a(serverName, "delivered_to_backend")) {
                return DeliveredToBackend.f38163b;
            }
            if (Intrinsics.a(serverName, "seen_by_recipient")) {
                return new SeenByRecipient(false, 1, null);
            }
            Logger g8 = ChatKit.f37877a.g();
            g8.c(new IllegalArgumentException("Unsupported message status: " + serverName));
            return DeliveredToBackend.f38163b;
        }
    }

    /* compiled from: ChatMessageStatus.kt */
    /* loaded from: classes5.dex */
    public static final class DeliveredToBackend extends ChatMessageStatus {

        /* renamed from: b  reason: collision with root package name */
        public static final DeliveredToBackend f38163b = new DeliveredToBackend();

        private DeliveredToBackend() {
            super(null);
        }
    }

    /* compiled from: ChatMessageStatus.kt */
    /* loaded from: classes5.dex */
    public static final class PreliminaryDeliveredToBackend extends ChatMessageStatus {

        /* renamed from: b  reason: collision with root package name */
        public static final PreliminaryDeliveredToBackend f38164b = new PreliminaryDeliveredToBackend();

        private PreliminaryDeliveredToBackend() {
            super(null);
        }
    }

    /* compiled from: ChatMessageStatus.kt */
    /* loaded from: classes5.dex */
    public static final class SeenByRecipient extends ChatMessageStatus {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f38165b;

        public SeenByRecipient() {
            this(false, 1, null);
        }

        public SeenByRecipient(boolean z7) {
            super(null);
            this.f38165b = z7;
        }

        public final boolean a() {
            return this.f38165b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SeenByRecipient) && this.f38165b == ((SeenByRecipient) obj).f38165b;
        }

        public int hashCode() {
            boolean z7 = this.f38165b;
            if (z7) {
                return 1;
            }
            return z7 ? 1 : 0;
        }

        public String toString() {
            return "SeenByRecipient(sent=" + this.f38165b + ')';
        }

        public /* synthetic */ SeenByRecipient(boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? true : z7);
        }
    }

    /* compiled from: ChatMessageStatus.kt */
    /* loaded from: classes5.dex */
    public static final class Sending extends ChatMessageStatus {

        /* renamed from: b  reason: collision with root package name */
        public static final Sending f38166b = new Sending();

        private Sending() {
            super(null);
        }
    }

    /* compiled from: ChatMessageStatus.kt */
    /* loaded from: classes5.dex */
    public static final class SendingError extends ChatMessageStatus {

        /* renamed from: b  reason: collision with root package name */
        public static final SendingError f38167b = new SendingError();

        private SendingError() {
            super(null);
        }
    }

    private ChatMessageStatus() {
    }

    public /* synthetic */ ChatMessageStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
