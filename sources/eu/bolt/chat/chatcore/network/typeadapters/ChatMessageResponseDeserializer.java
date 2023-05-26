package eu.bolt.chat.chatcore.network.typeadapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import eu.bolt.chat.chatcore.network.model.ChatEventResponse;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMessageResponseDeserializer.kt */
/* loaded from: classes5.dex */
public final class ChatMessageResponseDeserializer implements JsonDeserializer<ChatEventResponse> {
    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public ChatEventResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext jsonContext) throws JsonParseException {
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(jsonContext, "jsonContext");
        String str = (String) jsonContext.deserialize(json.getAsJsonObject().get("type"), String.class);
        if (str != null) {
            switch (str.hashCode()) {
                case -1587534008:
                    if (str.equals("quick_reply_suggestions")) {
                        return (ChatEventResponse) jsonContext.deserialize(json, ChatEventResponse.QuickReplies.class);
                    }
                    break;
                case -1274442605:
                    if (str.equals("finish")) {
                        return (ChatEventResponse) jsonContext.deserialize(json, ChatEventResponse.TerminalEvent.class);
                    }
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        return (ChatEventResponse) jsonContext.deserialize(json, ChatEventResponse.StartEvent.class);
                    }
                    break;
                case 184215677:
                    if (str.equals("service_message")) {
                        return (ChatEventResponse) jsonContext.deserialize(json, ChatEventResponse.ServiceMessageEvent.class);
                    }
                    break;
                case 249809475:
                    if (str.equals("seen_message")) {
                        return (ChatEventResponse) jsonContext.deserialize(json, ChatEventResponse.MessagesSeenConfirmation.class);
                    }
                    break;
                case 954925063:
                    if (str.equals("message")) {
                        return (ChatEventResponse) jsonContext.deserialize(json, ChatEventResponse.NewMessage.class);
                    }
                    break;
            }
        }
        return null;
    }
}
