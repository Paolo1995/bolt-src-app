package kotlinx.serialization.json;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Json.kt */
/* loaded from: classes5.dex */
public final class JsonKt {
    public static final Json a(Json from, Function1<? super JsonBuilder, Unit> builderAction) {
        Intrinsics.f(from, "from");
        Intrinsics.f(builderAction, "builderAction");
        JsonBuilder jsonBuilder = new JsonBuilder(from);
        builderAction.invoke(jsonBuilder);
        return new JsonImpl(jsonBuilder.a(), jsonBuilder.b());
    }

    public static /* synthetic */ Json b(Json json, Function1 function1, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            json = Json.f52300d;
        }
        return a(json, function1);
    }
}
