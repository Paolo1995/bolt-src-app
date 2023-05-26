package eu.bolt.chat.chatcore.network.repo;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.QuickReplyEntity;
import eu.bolt.chat.chatcore.entity.TerminationInfo;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatEvent.kt */
/* loaded from: classes5.dex */
public abstract class ChatEvent {

    /* compiled from: ChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class MessagesSeenConfirmation extends ChatEvent {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f38356a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessagesSeenConfirmation(List<String> messagesSeenIds) {
            super(null);
            Intrinsics.f(messagesSeenIds, "messagesSeenIds");
            this.f38356a = messagesSeenIds;
        }

        public final List<String> a() {
            return this.f38356a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MessagesSeenConfirmation) && Intrinsics.a(this.f38356a, ((MessagesSeenConfirmation) obj).f38356a);
        }

        public int hashCode() {
            return this.f38356a.hashCode();
        }

        public String toString() {
            return "MessagesSeenConfirmation(messagesSeenIds=" + this.f38356a + ')';
        }
    }

    /* compiled from: ChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class NewMessage extends ChatEvent {

        /* renamed from: a  reason: collision with root package name */
        private final ChatMessageEntity f38357a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewMessage(ChatMessageEntity entity) {
            super(null);
            Intrinsics.f(entity, "entity");
            this.f38357a = entity;
        }

        public final ChatMessageEntity a() {
            return this.f38357a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NewMessage) && Intrinsics.a(this.f38357a, ((NewMessage) obj).f38357a);
        }

        public int hashCode() {
            return this.f38357a.hashCode();
        }

        public String toString() {
            return "NewMessage(entity=" + this.f38357a + ')';
        }
    }

    /* compiled from: ChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class QuickReplies extends ChatEvent {

        /* renamed from: a  reason: collision with root package name */
        private final List<QuickReplyEntity> f38358a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QuickReplies(List<QuickReplyEntity> suggestions) {
            super(null);
            Intrinsics.f(suggestions, "suggestions");
            this.f38358a = suggestions;
        }

        public final List<QuickReplyEntity> a() {
            return this.f38358a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof QuickReplies) && Intrinsics.a(this.f38358a, ((QuickReplies) obj).f38358a);
        }

        public int hashCode() {
            return this.f38358a.hashCode();
        }

        public String toString() {
            return "QuickReplies(suggestions=" + this.f38358a + ')';
        }
    }

    /* compiled from: ChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class ServiceMessage extends ChatEvent {

        /* renamed from: a  reason: collision with root package name */
        private final ChatMessageEntity f38359a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ServiceMessage(ChatMessageEntity entity) {
            super(null);
            Intrinsics.f(entity, "entity");
            this.f38359a = entity;
        }

        public final ChatMessageEntity a() {
            return this.f38359a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ServiceMessage) && Intrinsics.a(this.f38359a, ((ServiceMessage) obj).f38359a);
        }

        public int hashCode() {
            return this.f38359a.hashCode();
        }

        public String toString() {
            return "ServiceMessage(entity=" + this.f38359a + ')';
        }
    }

    /* compiled from: ChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class StartChat extends ChatEvent {

        /* renamed from: a  reason: collision with root package name */
        private final ChatEntity f38360a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartChat(ChatEntity chatEntity) {
            super(null);
            Intrinsics.f(chatEntity, "chatEntity");
            this.f38360a = chatEntity;
        }

        public final ChatEntity a() {
            return this.f38360a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StartChat) && Intrinsics.a(this.f38360a, ((StartChat) obj).f38360a);
        }

        public int hashCode() {
            return this.f38360a.hashCode();
        }

        public String toString() {
            return "StartChat(chatEntity=" + this.f38360a + ')';
        }
    }

    /* compiled from: ChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class TerminalMessage extends ChatEvent {

        /* renamed from: a  reason: collision with root package name */
        private final TerminationInfo f38361a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TerminalMessage(TerminationInfo terminationInfo) {
            super(null);
            Intrinsics.f(terminationInfo, "terminationInfo");
            this.f38361a = terminationInfo;
        }

        public final TerminationInfo a() {
            return this.f38361a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TerminalMessage) && Intrinsics.a(this.f38361a, ((TerminalMessage) obj).f38361a);
        }

        public int hashCode() {
            return this.f38361a.hashCode();
        }

        public String toString() {
            return "TerminalMessage(terminationInfo=" + this.f38361a + ')';
        }
    }

    private ChatEvent() {
    }

    public /* synthetic */ ChatEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
