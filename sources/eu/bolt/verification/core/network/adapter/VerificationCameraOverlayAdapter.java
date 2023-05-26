package eu.bolt.verification.core.network.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import eu.bolt.verification.sdk.internal.an;
import java.lang.reflect.Type;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class VerificationCameraOverlayAdapter implements JsonDeserializer<an.a> {

    /* renamed from: a  reason: collision with root package name */
    private static final a f41913a = new a(null);

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
    public an.a deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) {
        Type type2;
        Intrinsics.f(context, "context");
        JsonObject asJsonObject = jsonElement != null ? jsonElement.getAsJsonObject() : null;
        if (asJsonObject == null) {
            return null;
        }
        String asString = asJsonObject.get("shape_type").getAsString();
        if (Intrinsics.a(asString, "rectangle")) {
            type2 = an.a.b.class;
        } else if (!Intrinsics.a(asString, "oval")) {
            return null;
        } else {
            type2 = an.a.C0030a.class;
        }
        return (an.a) context.deserialize(asJsonObject, type2);
    }
}
