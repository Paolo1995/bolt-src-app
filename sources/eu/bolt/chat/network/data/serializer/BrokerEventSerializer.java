package eu.bolt.chat.network.data.serializer;

import eu.bolt.chat.network.data.BrokerEvent;
import eu.bolt.chat.network.data.IncomingChatDomainEvent;
import eu.bolt.chat.network.data.UnknownDomainEvent;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.JsonContentPolymorphicSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;

/* compiled from: BrokerEventSerializer.kt */
/* loaded from: classes5.dex */
public final class BrokerEventSerializer extends JsonContentPolymorphicSerializer<BrokerEvent> {

    /* renamed from: c  reason: collision with root package name */
    public static final BrokerEventSerializer f39337c = new BrokerEventSerializer();

    private BrokerEventSerializer() {
        super(Reflection.b(BrokerEvent.class));
    }

    @Override // kotlinx.serialization.json.JsonContentPolymorphicSerializer
    protected DeserializationStrategy<? extends BrokerEvent> f(JsonElement element) {
        Object g8;
        Intrinsics.f(element, "element");
        g8 = MapsKt__MapsKt.g(JsonElementKt.i(element), "domain");
        if (Intrinsics.a(JsonElementKt.j((JsonElement) g8).b(), "chat")) {
            return IncomingChatDomainEvent.Companion.serializer();
        }
        return UnknownDomainEvent.Companion.serializer();
    }
}
