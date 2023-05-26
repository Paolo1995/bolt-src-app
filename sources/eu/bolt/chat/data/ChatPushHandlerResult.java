package eu.bolt.chat.data;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatPushHandlerResult.kt */
/* loaded from: classes5.dex */
public interface ChatPushHandlerResult {

    /* compiled from: ChatPushHandlerResult.kt */
    /* loaded from: classes5.dex */
    public static final class Failure implements ChatPushHandlerResult {

        /* renamed from: a  reason: collision with root package name */
        public static final Failure f38935a = new Failure();

        private Failure() {
        }
    }

    /* compiled from: ChatPushHandlerResult.kt */
    /* loaded from: classes5.dex */
    public static final class NotPublished implements ChatPushHandlerResult {

        /* renamed from: a  reason: collision with root package name */
        private final ChatPushMessage f38936a;

        public NotPublished(ChatPushMessage message) {
            Intrinsics.f(message, "message");
            this.f38936a = message;
        }

        public final ChatPushMessage a() {
            return this.f38936a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NotPublished) && Intrinsics.a(this.f38936a, ((NotPublished) obj).f38936a);
        }

        public int hashCode() {
            return this.f38936a.hashCode();
        }

        public String toString() {
            return "NotPublished(message=" + this.f38936a + ')';
        }
    }

    /* compiled from: ChatPushHandlerResult.kt */
    /* loaded from: classes5.dex */
    public static final class Success implements ChatPushHandlerResult {

        /* renamed from: a  reason: collision with root package name */
        public static final Success f38937a = new Success();

        private Success() {
        }
    }
}
