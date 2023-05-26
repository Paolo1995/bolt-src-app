package kotlinx.serialization.json;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.serialization.json.internal.StringOpsKt;

/* compiled from: JsonElement.kt */
/* loaded from: classes5.dex */
public final class JsonElementKt {
    public static final JsonPrimitive a(String str) {
        if (str == null) {
            return JsonNull.INSTANCE;
        }
        return new JsonLiteral(str, true);
    }

    private static final Void b(JsonElement jsonElement, String str) {
        throw new IllegalArgumentException("Element " + Reflection.b(jsonElement.getClass()) + " is not a " + str);
    }

    public static final Boolean c(JsonPrimitive jsonPrimitive) {
        Intrinsics.f(jsonPrimitive, "<this>");
        return StringOpsKt.d(jsonPrimitive.b());
    }

    public static final String d(JsonPrimitive jsonPrimitive) {
        Intrinsics.f(jsonPrimitive, "<this>");
        if (jsonPrimitive instanceof JsonNull) {
            return null;
        }
        return jsonPrimitive.b();
    }

    public static final double e(JsonPrimitive jsonPrimitive) {
        Intrinsics.f(jsonPrimitive, "<this>");
        return Double.parseDouble(jsonPrimitive.b());
    }

    public static final Double f(JsonPrimitive jsonPrimitive) {
        Double k8;
        Intrinsics.f(jsonPrimitive, "<this>");
        k8 = StringsKt__StringNumberConversionsJVMKt.k(jsonPrimitive.b());
        return k8;
    }

    public static final float g(JsonPrimitive jsonPrimitive) {
        Intrinsics.f(jsonPrimitive, "<this>");
        return Float.parseFloat(jsonPrimitive.b());
    }

    public static final int h(JsonPrimitive jsonPrimitive) {
        Intrinsics.f(jsonPrimitive, "<this>");
        return Integer.parseInt(jsonPrimitive.b());
    }

    public static final JsonObject i(JsonElement jsonElement) {
        JsonObject jsonObject;
        Intrinsics.f(jsonElement, "<this>");
        if (jsonElement instanceof JsonObject) {
            jsonObject = (JsonObject) jsonElement;
        } else {
            jsonObject = null;
        }
        if (jsonObject != null) {
            return jsonObject;
        }
        b(jsonElement, "JsonObject");
        throw new KotlinNothingValueException();
    }

    public static final JsonPrimitive j(JsonElement jsonElement) {
        JsonPrimitive jsonPrimitive;
        Intrinsics.f(jsonElement, "<this>");
        if (jsonElement instanceof JsonPrimitive) {
            jsonPrimitive = (JsonPrimitive) jsonElement;
        } else {
            jsonPrimitive = null;
        }
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        b(jsonElement, "JsonPrimitive");
        throw new KotlinNothingValueException();
    }

    public static final long k(JsonPrimitive jsonPrimitive) {
        Intrinsics.f(jsonPrimitive, "<this>");
        return Long.parseLong(jsonPrimitive.b());
    }

    public static final Long l(JsonPrimitive jsonPrimitive) {
        Long o8;
        Intrinsics.f(jsonPrimitive, "<this>");
        o8 = StringsKt__StringNumberConversionsKt.o(jsonPrimitive.b());
        return o8;
    }
}
