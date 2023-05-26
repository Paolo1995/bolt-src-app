package eu.bolt.verification.core.network.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import eu.bolt.verification.sdk.internal.pm;
import java.lang.reflect.Type;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class VerificationButtonActionConditionAdapter implements JsonDeserializer<pm> {

    /* renamed from: a  reason: collision with root package name */
    private static final a f41912a = new a(null);

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
    public pm deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) {
        Type type2;
        Intrinsics.f(context, "context");
        JsonObject asJsonObject = jsonElement != null ? jsonElement.getAsJsonObject() : null;
        if (asJsonObject == null) {
            return null;
        }
        String asString = asJsonObject.get("type").getAsString();
        JsonObject asJsonObject2 = asJsonObject.get("payload").getAsJsonObject();
        if (asString != null) {
            int hashCode = asString.hashCode();
            if (hashCode != -1576037481) {
                if (hashCode != 551290041) {
                    if (hashCode != 700371138 || !asString.equals("field_regex")) {
                        return null;
                    }
                    type2 = pm.b.class;
                } else if (!asString.equals("has_required_answer")) {
                    return null;
                } else {
                    type2 = pm.c.class;
                }
            } else if (!asString.equals("checkbox_selected")) {
                return null;
            } else {
                type2 = pm.a.class;
            }
            return (pm) context.deserialize(asJsonObject2, type2);
        }
        return null;
    }
}
