package eu.bolt.chat.network.data.parser;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: ChatJsonParser.kt */
/* loaded from: classes5.dex */
public final class ChatJsonParserKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Json f39332a = JsonKt.b(null, new Function1<JsonBuilder, Unit>() { // from class: eu.bolt.chat.network.data.parser.ChatJsonParserKt$ChatJsonParser$1
        public final void b(JsonBuilder Json) {
            Intrinsics.f(Json, "$this$Json");
            Json.g(true);
            Json.e(true);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            b(jsonBuilder);
            return Unit.f50853a;
        }
    }, 1, null);

    public static final Json a() {
        return f39332a;
    }
}
