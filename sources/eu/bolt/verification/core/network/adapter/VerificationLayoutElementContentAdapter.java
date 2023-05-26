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
public final class VerificationLayoutElementContentAdapter implements JsonDeserializer<ro> {

    /* renamed from: a  reason: collision with root package name */
    private static final a f41915a = new a(null);

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
    public ro deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) {
        String asString;
        Type type2;
        Intrinsics.f(context, "context");
        JsonObject asJsonObject = jsonElement != null ? jsonElement.getAsJsonObject() : null;
        if (asJsonObject == null || (asString = asJsonObject.get("type").getAsString()) == null) {
            return null;
        }
        switch (asString.hashCode()) {
            case -2109822408:
                if (asString.equals("text_input")) {
                    type2 = ro.h.class;
                    break;
                } else {
                    return null;
                }
            case -1713645971:
                if (asString.equals("media_preview")) {
                    type2 = ro.f.class;
                    break;
                } else {
                    return null;
                }
            case -1377687758:
                if (asString.equals("button")) {
                    type2 = ro.a.class;
                    break;
                } else {
                    return null;
                }
            case -1192343404:
                if (asString.equals("check_box_group")) {
                    type2 = ro.b.class;
                    break;
                } else {
                    return null;
                }
            case 100313435:
                if (asString.equals("image")) {
                    type2 = ro.e.class;
                    break;
                } else {
                    return null;
                }
            case 1250407999:
                if (asString.equals("date_picker")) {
                    type2 = ro.d.class;
                    break;
                } else {
                    return null;
                }
            case 1949288814:
                if (asString.equals("paragraph")) {
                    type2 = ro.g.class;
                    break;
                } else {
                    return null;
                }
            case 1974335080:
                if (asString.equals("country_selector")) {
                    type2 = ro.c.class;
                    break;
                } else {
                    return null;
                }
            default:
                return null;
        }
        return (ro) context.deserialize(asJsonObject, type2);
    }
}
