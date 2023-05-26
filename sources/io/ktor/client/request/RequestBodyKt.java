package io.ktor.client.request;

import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;

/* compiled from: RequestBody.kt */
/* loaded from: classes5.dex */
public final class RequestBodyKt {

    /* renamed from: a  reason: collision with root package name */
    private static final AttributeKey<TypeInfo> f46648a = new AttributeKey<>("BodyTypeAttributeKey");

    public static final AttributeKey<TypeInfo> a() {
        return f46648a;
    }
}
