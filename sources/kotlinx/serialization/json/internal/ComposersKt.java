package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* compiled from: Composers.kt */
/* loaded from: classes5.dex */
public final class ComposersKt {
    public static final Composer a(JsonWriter sb, Json json) {
        Intrinsics.f(sb, "sb");
        Intrinsics.f(json, "json");
        if (json.g().h()) {
            return new ComposerWithPrettyPrint(sb, json);
        }
        return new Composer(sb);
    }
}
