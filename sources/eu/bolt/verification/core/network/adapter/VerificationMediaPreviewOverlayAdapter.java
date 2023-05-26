package eu.bolt.verification.core.network.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import eu.bolt.verification.sdk.internal.ro;
import java.lang.reflect.Type;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class VerificationMediaPreviewOverlayAdapter implements JsonDeserializer<ro.f.b> {

    /* renamed from: a  reason: collision with root package name */
    private static final a f41916a = new a(null);

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
    public ro.f.b deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) {
        Type type2;
        Intrinsics.f(context, "context");
        JsonObject asJsonObject = jsonElement != null ? jsonElement.getAsJsonObject() : null;
        if (asJsonObject == null) {
            return null;
        }
        String asString = asJsonObject.get("shape_type").getAsString();
        if (Intrinsics.a(asString, "rectangle")) {
            type2 = ro.f.b.C0089b.class;
        } else if (!Intrinsics.a(asString, "oval")) {
            return null;
        } else {
            type2 = ro.f.b.a.class;
        }
        return (ro.f.b) context.deserialize(asJsonObject, type2);
    }
}
