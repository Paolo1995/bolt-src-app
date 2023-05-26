package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonEncoder;

/* compiled from: JsonStreams.kt */
/* loaded from: classes5.dex */
public final class JsonStreamsKt {
    public static final <T> void a(Json json, JsonWriter writer, SerializationStrategy<? super T> serializer, T t7) {
        Intrinsics.f(json, "<this>");
        Intrinsics.f(writer, "writer");
        Intrinsics.f(serializer, "serializer");
        new StreamingJsonEncoder(writer, json, WriteMode.OBJ, new JsonEncoder[WriteMode.values().length]).e(serializer, t7);
    }
}
