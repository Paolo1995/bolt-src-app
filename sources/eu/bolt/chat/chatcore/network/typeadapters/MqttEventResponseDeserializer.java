package eu.bolt.chat.chatcore.network.typeadapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import eu.bolt.chat.chatcore.network.model.MqttEventResponse;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MqttEventResponseDeserializer.kt */
/* loaded from: classes5.dex */
public final class MqttEventResponseDeserializer implements JsonDeserializer<MqttEventResponse> {
    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public MqttEventResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext jsonContext) throws JsonParseException {
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(jsonContext, "jsonContext");
        if (Intrinsics.a(json.getAsJsonObject().get("domain").getAsString(), "chat")) {
            return (MqttEventResponse) jsonContext.deserialize(json, MqttEventResponse.Chat.class);
        }
        return null;
    }
}
