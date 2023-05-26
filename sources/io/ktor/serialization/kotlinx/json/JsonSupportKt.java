package io.ktor.serialization.kotlinx.json;

import io.ktor.http.ContentType;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.kotlinx.KotlinxSerializationConverterKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: JsonSupport.kt */
/* loaded from: classes5.dex */
public final class JsonSupportKt {

    /* renamed from: a */
    private static final Json f46995a = JsonKt.b(null, new Function1<JsonBuilder, Unit>() { // from class: io.ktor.serialization.kotlinx.json.JsonSupportKt$DefaultJson$1
        public final void b(JsonBuilder Json) {
            Intrinsics.f(Json, "$this$Json");
            Json.f(true);
            Json.h(true);
            Json.c(true);
            Json.d(true);
            Json.i(false);
            Json.j(false);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            b(jsonBuilder);
            return Unit.f50853a;
        }
    }, 1, null);

    public static final void a(Configuration configuration, Json json, ContentType contentType) {
        Intrinsics.f(configuration, "<this>");
        Intrinsics.f(json, "json");
        Intrinsics.f(contentType, "contentType");
        KotlinxSerializationConverterKt.a(configuration, contentType, json);
    }

    public static /* synthetic */ void b(Configuration configuration, Json json, ContentType contentType, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            json = f46995a;
        }
        if ((i8 & 2) != 0) {
            contentType = ContentType.Application.f46731a.a();
        }
        a(configuration, json, contentType);
    }
}
