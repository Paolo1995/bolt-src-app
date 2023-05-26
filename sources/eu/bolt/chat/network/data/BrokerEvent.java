package eu.bolt.chat.network.data;

import eu.bolt.chat.network.data.serializer.BrokerEventSerializer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: IncomingChatEvent.kt */
@Serializable(with = BrokerEventSerializer.class)
/* loaded from: classes5.dex */
public abstract class BrokerEvent {
    public static final Companion Companion = new Companion(null);

    /* compiled from: IncomingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<BrokerEvent> serializer() {
            return BrokerEventSerializer.f39337c;
        }
    }

    private BrokerEvent() {
    }

    public /* synthetic */ BrokerEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
