package io.ktor.serialization.kotlinx;

import io.ktor.http.ContentType;
import io.ktor.util.reflect.TypeInfo;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialFormat;

/* compiled from: KotlinxSerializationBase.kt */
/* loaded from: classes5.dex */
public final class SerializationNegotiationParameters extends SerializationParameters {

    /* renamed from: f  reason: collision with root package name */
    private final SerialFormat f46985f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f46986g;

    /* renamed from: h  reason: collision with root package name */
    private final TypeInfo f46987h;

    /* renamed from: i  reason: collision with root package name */
    private final Charset f46988i;

    /* renamed from: j  reason: collision with root package name */
    private final ContentType f46989j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SerializationNegotiationParameters(SerialFormat format, Object obj, TypeInfo typeInfo, Charset charset, ContentType contentType) {
        super(format, obj, typeInfo, charset);
        Intrinsics.f(format, "format");
        Intrinsics.f(typeInfo, "typeInfo");
        Intrinsics.f(charset, "charset");
        Intrinsics.f(contentType, "contentType");
        this.f46985f = format;
        this.f46986g = obj;
        this.f46987h = typeInfo;
        this.f46988i = charset;
        this.f46989j = contentType;
    }

    @Override // io.ktor.serialization.kotlinx.SerializationParameters
    public Charset a() {
        return this.f46988i;
    }

    @Override // io.ktor.serialization.kotlinx.SerializationParameters
    public SerialFormat b() {
        return this.f46985f;
    }

    @Override // io.ktor.serialization.kotlinx.SerializationParameters
    public TypeInfo d() {
        return this.f46987h;
    }

    @Override // io.ktor.serialization.kotlinx.SerializationParameters
    public Object e() {
        return this.f46986g;
    }

    public final ContentType g() {
        return this.f46989j;
    }
}
