package eu.bolt.verification.core.network.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import eu.bolt.verification.sdk.internal.jo;
import java.lang.reflect.Type;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class VerificationFlowDetailsResponseAdapter implements JsonDeserializer<jo> {

    /* renamed from: a  reason: collision with root package name */
    private static final a f41914a = new a(null);

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public jo deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) {
        Type type2;
        Intrinsics.f(context, "context");
        JsonObject asJsonObject = jsonElement != null ? jsonElement.getAsJsonObject() : null;
        if (asJsonObject == null) {
            return null;
        }
        String asString = asJsonObject.get("type").getAsString();
        if (Intrinsics.a(asString, "show_steps")) {
            type2 = jo.b.class;
        } else if (!Intrinsics.a(asString, "close_sdk")) {
            return null;
        } else {
            type2 = jo.a.class;
        }
        return (jo) context.deserialize(asJsonObject, type2);
    }
}
