package io.ktor.client.statement;

import io.ktor.util.reflect.TypeInfo;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpResponsePipeline.kt */
/* loaded from: classes5.dex */
public final class HttpResponseContainer {

    /* renamed from: a  reason: collision with root package name */
    private final TypeInfo f46662a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f46663b;

    public HttpResponseContainer(TypeInfo expectedType, Object response) {
        Intrinsics.f(expectedType, "expectedType");
        Intrinsics.f(response, "response");
        this.f46662a = expectedType;
        this.f46663b = response;
    }

    public final TypeInfo a() {
        return this.f46662a;
    }

    public final Object b() {
        return this.f46663b;
    }

    public final Object c() {
        return this.f46663b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HttpResponseContainer) {
            HttpResponseContainer httpResponseContainer = (HttpResponseContainer) obj;
            return Intrinsics.a(this.f46662a, httpResponseContainer.f46662a) && Intrinsics.a(this.f46663b, httpResponseContainer.f46663b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f46662a.hashCode() * 31) + this.f46663b.hashCode();
    }

    public String toString() {
        return "HttpResponseContainer(expectedType=" + this.f46662a + ", response=" + this.f46663b + ')';
    }
}
