package io.ktor.serialization.kotlinx;

import io.ktor.util.reflect.TypeInfo;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialFormat;

/* compiled from: KotlinxSerializationBase.kt */
/* loaded from: classes5.dex */
public class SerializationParameters {

    /* renamed from: a  reason: collision with root package name */
    private final SerialFormat f46990a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f46991b;

    /* renamed from: c  reason: collision with root package name */
    private final TypeInfo f46992c;

    /* renamed from: d  reason: collision with root package name */
    private final Charset f46993d;

    /* renamed from: e  reason: collision with root package name */
    public KSerializer<?> f46994e;

    public SerializationParameters(SerialFormat format, Object obj, TypeInfo typeInfo, Charset charset) {
        Intrinsics.f(format, "format");
        Intrinsics.f(typeInfo, "typeInfo");
        Intrinsics.f(charset, "charset");
        this.f46990a = format;
        this.f46991b = obj;
        this.f46992c = typeInfo;
        this.f46993d = charset;
    }

    public Charset a() {
        return this.f46993d;
    }

    public SerialFormat b() {
        return this.f46990a;
    }

    public final KSerializer<?> c() {
        KSerializer<?> kSerializer = this.f46994e;
        if (kSerializer != null) {
            return kSerializer;
        }
        Intrinsics.w("serializer");
        return null;
    }

    public TypeInfo d() {
        return this.f46992c;
    }

    public Object e() {
        return this.f46991b;
    }

    public final void f(KSerializer<?> kSerializer) {
        Intrinsics.f(kSerializer, "<set-?>");
        this.f46994e = kSerializer;
    }
}
