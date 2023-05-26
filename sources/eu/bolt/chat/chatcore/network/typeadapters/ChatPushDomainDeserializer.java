package eu.bolt.chat.chatcore.network.typeadapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import eu.bolt.chat.chatcore.network.model.ChatPushDomain;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatPushDomainDeserializer.kt */
/* loaded from: classes5.dex */
public final class ChatPushDomainDeserializer implements JsonDeserializer<ChatPushDomain.Event> {
    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public ChatPushDomain.Event deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext jsonContext) throws JsonParseException {
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(jsonContext, "jsonContext");
        if (Intrinsics.a(json.getAsJsonObject().get("type").getAsString(), "message")) {
            return (ChatPushDomain.Event) jsonContext.deserialize(json, ChatPushDomain.Event.Message.class);
        }
        return null;
    }
}
