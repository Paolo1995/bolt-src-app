package eu.bolt.chat.data.message;

import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.EndChatInfo;
import eu.bolt.chat.data.QuickReplySuggestion;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageEvent.kt */
/* loaded from: classes5.dex */
public abstract class MessageEvent {

    /* compiled from: MessageEvent.kt */
    /* loaded from: classes5.dex */
    public static abstract class LifeCycle extends MessageEvent {

        /* compiled from: MessageEvent.kt */
        /* loaded from: classes5.dex */
        public static final class Finish extends LifeCycle {

            /* renamed from: a  reason: collision with root package name */
            private final EndChatInfo f38985a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Finish(EndChatInfo endChatInfo) {
                super(null);
                Intrinsics.f(endChatInfo, "endChatInfo");
                this.f38985a = endChatInfo;
            }

            public final EndChatInfo a() {
                return this.f38985a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Finish) && Intrinsics.a(this.f38985a, ((Finish) obj).f38985a);
            }

            public int hashCode() {
                return this.f38985a.hashCode();
            }

            public String toString() {
                return "Finish(endChatInfo=" + this.f38985a + ')';
            }
        }

        /* compiled from: MessageEvent.kt */
        /* loaded from: classes5.dex */
        public static final class MessageSeen extends LifeCycle {

            /* renamed from: a  reason: collision with root package name */
            private final List<String> f38986a;

            /* renamed from: b  reason: collision with root package name */
            private final String f38987b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MessageSeen(List<String> ids, String observerId) {
                super(null);
                Intrinsics.f(ids, "ids");
                Intrinsics.f(observerId, "observerId");
                this.f38986a = ids;
                this.f38987b = observerId;
            }

            public final List<String> a() {
                return this.f38986a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof MessageSeen) {
                    MessageSeen messageSeen = (MessageSeen) obj;
                    return Intrinsics.a(this.f38986a, messageSeen.f38986a) && Intrinsics.a(this.f38987b, messageSeen.f38987b);
                }
                return false;
            }

            public int hashCode() {
                return (this.f38986a.hashCode() * 31) + this.f38987b.hashCode();
            }

            public String toString() {
                return "MessageSeen(ids=" + this.f38986a + ", observerId=" + this.f38987b + ')';
            }
        }

        /* compiled from: MessageEvent.kt */
        /* loaded from: classes5.dex */
        public static final class Start extends LifeCycle {

            /* renamed from: a  reason: collision with root package name */
            private final Chat f38988a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Start(Chat chat) {
                super(null);
                Intrinsics.f(chat, "chat");
                this.f38988a = chat;
            }

            public final Chat a() {
                return this.f38988a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Start) && Intrinsics.a(this.f38988a, ((Start) obj).f38988a);
            }

            public int hashCode() {
                return this.f38988a.hashCode();
            }

            public String toString() {
                return "Start(chat=" + this.f38988a + ')';
            }
        }

        private LifeCycle() {
            super(null);
        }

        public /* synthetic */ LifeCycle(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MessageEvent.kt */
    /* loaded from: classes5.dex */
    public static abstract class Message extends MessageEvent {

        /* compiled from: MessageEvent.kt */
        /* loaded from: classes5.dex */
        public static final class Service extends Message {

            /* renamed from: a  reason: collision with root package name */
            private final ServiceTextMessage f38989a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Service(ServiceTextMessage serviceMessage) {
                super(null);
                Intrinsics.f(serviceMessage, "serviceMessage");
                this.f38989a = serviceMessage;
            }

            public final ServiceTextMessage a() {
                return this.f38989a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Service) && Intrinsics.a(this.f38989a, ((Service) obj).f38989a);
            }

            public int hashCode() {
                return this.f38989a.hashCode();
            }

            public String toString() {
                return "Service(serviceMessage=" + this.f38989a + ')';
            }
        }

        /* compiled from: MessageEvent.kt */
        /* loaded from: classes5.dex */
        public static final class TextMessage extends Message {

            /* renamed from: a  reason: collision with root package name */
            private final UserTextMessage f38990a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TextMessage(UserTextMessage textMessage) {
                super(null);
                Intrinsics.f(textMessage, "textMessage");
                this.f38990a = textMessage;
            }

            public final UserTextMessage a() {
                return this.f38990a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof TextMessage) && Intrinsics.a(this.f38990a, ((TextMessage) obj).f38990a);
            }

            public int hashCode() {
                return this.f38990a.hashCode();
            }

            public String toString() {
                return "TextMessage(textMessage=" + this.f38990a + ')';
            }
        }

        private Message() {
            super(null);
        }

        public /* synthetic */ Message(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MessageEvent.kt */
    /* loaded from: classes5.dex */
    public static final class QuickReply extends MessageEvent {

        /* renamed from: a  reason: collision with root package name */
        private final List<QuickReplySuggestion> f38991a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QuickReply(List<QuickReplySuggestion> suggestions) {
            super(null);
            Intrinsics.f(suggestions, "suggestions");
            this.f38991a = suggestions;
        }

        public final List<QuickReplySuggestion> a() {
            return this.f38991a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof QuickReply) && Intrinsics.a(this.f38991a, ((QuickReply) obj).f38991a);
        }

        public int hashCode() {
            return this.f38991a.hashCode();
        }

        public String toString() {
            return "QuickReply(suggestions=" + this.f38991a + ')';
        }
    }

    private MessageEvent() {
    }

    public /* synthetic */ MessageEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
