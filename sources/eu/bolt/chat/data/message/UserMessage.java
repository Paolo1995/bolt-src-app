package eu.bolt.chat.data.message;

/* compiled from: UserMessage.kt */
/* loaded from: classes5.dex */
public interface UserMessage extends ChatMessage {

    /* compiled from: UserMessage.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static boolean a(UserMessage userMessage) {
            return !userMessage.e();
        }
    }

    @Override // eu.bolt.chat.data.message.ChatMessage
    UserMessage a(MessageStatus messageStatus);

    boolean c();

    boolean e();
}
