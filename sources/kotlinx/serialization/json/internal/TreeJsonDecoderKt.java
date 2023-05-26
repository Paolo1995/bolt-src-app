package kotlinx.serialization.json.internal;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: TreeJsonDecoder.kt */
/* loaded from: classes5.dex */
public final class TreeJsonDecoderKt {
    public static final <T> T a(Json json, JsonElement element, DeserializationStrategy<T> deserializer) {
        boolean a8;
        Decoder jsonPrimitiveDecoder;
        Intrinsics.f(json, "<this>");
        Intrinsics.f(element, "element");
        Intrinsics.f(deserializer, "deserializer");
        if (element instanceof JsonObject) {
            jsonPrimitiveDecoder = new JsonTreeDecoder(json, (JsonObject) element, null, null, 12, null);
        } else if (element instanceof JsonArray) {
            jsonPrimitiveDecoder = new JsonTreeListDecoder(json, (JsonArray) element);
        } else {
            if (element instanceof JsonLiteral) {
                a8 = true;
            } else {
                a8 = Intrinsics.a(element, JsonNull.INSTANCE);
            }
            if (a8) {
                jsonPrimitiveDecoder = new JsonPrimitiveDecoder(json, (JsonPrimitive) element);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return (T) jsonPrimitiveDecoder.G(deserializer);
    }

    public static final <T> T b(Json json, String discriminator, JsonObject element, DeserializationStrategy<T> deserializer) {
        Intrinsics.f(json, "<this>");
        Intrinsics.f(discriminator, "discriminator");
        Intrinsics.f(element, "element");
        Intrinsics.f(deserializer, "deserializer");
        return (T) new JsonTreeDecoder(json, element, discriminator, deserializer.a()).G(deserializer);
    }
}
