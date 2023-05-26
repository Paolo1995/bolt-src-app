package eu.bolt.chat.network.data;

import eu.bolt.chat.network.data.serializer.TextMessageSerializer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: IncomingChatEvent.kt */
@Serializable(with = TextMessageSerializer.class)
/* loaded from: classes5.dex */
public abstract class MessageEventBase extends EventBase {
    public static final Companion Companion = new Companion(null);

    /* compiled from: IncomingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<MessageEventBase> serializer() {
            return TextMessageSerializer.f39340c;
        }
    }

    private MessageEventBase() {
        super(null);
    }

    public /* synthetic */ MessageEventBase(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
