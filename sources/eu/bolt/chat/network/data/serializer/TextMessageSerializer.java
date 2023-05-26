package eu.bolt.chat.network.data.serializer;

import eu.bolt.chat.network.data.MessageEventBase;
import eu.bolt.chat.network.data.ServiceMessageEvent;
import eu.bolt.chat.network.data.UnknownMessageEvent;
import eu.bolt.chat.network.data.UserMessageEvent;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.JsonContentPolymorphicSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;

/* compiled from: TextMessageSerializer.kt */
/* loaded from: classes5.dex */
public final class TextMessageSerializer extends JsonContentPolymorphicSerializer<MessageEventBase> {

    /* renamed from: c  reason: collision with root package name */
    public static final TextMessageSerializer f39340c = new TextMessageSerializer();

    private TextMessageSerializer() {
        super(Reflection.b(MessageEventBase.class));
    }

    @Override // kotlinx.serialization.json.JsonContentPolymorphicSerializer
    protected DeserializationStrategy<? extends MessageEventBase> f(JsonElement element) {
        Object g8;
        Intrinsics.f(element, "element");
        g8 = MapsKt__MapsKt.g(JsonElementKt.i(element), "type");
        String b8 = JsonElementKt.j((JsonElement) g8).b();
        if (Intrinsics.a(b8, "message")) {
            return UserMessageEvent.Companion.serializer();
        }
        if (Intrinsics.a(b8, "service_message")) {
            return ServiceMessageEvent.Companion.serializer();
        }
        return UnknownMessageEvent.Companion.serializer();
    }
}
