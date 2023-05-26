package io.ktor.http;

import io.ktor.http.Headers;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Headers.kt */
/* loaded from: classes5.dex */
public final class EmptyHeaders implements Headers {

    /* renamed from: c  reason: collision with root package name */
    public static final EmptyHeaders f46765c = new EmptyHeaders();

    private EmptyHeaders() {
    }

    @Override // io.ktor.util.StringValues
    public Set<Map.Entry<String, List<String>>> a() {
        return SetsKt.b();
    }

    @Override // io.ktor.util.StringValues
    public boolean b() {
        return true;
    }

    @Override // io.ktor.util.StringValues
    public List<String> c(String name) {
        Intrinsics.f(name, "name");
        return null;
    }

    @Override // io.ktor.util.StringValues
    public void d(Function2<? super String, ? super List<String>, Unit> function2) {
        Headers.DefaultImpls.a(this, function2);
    }

    @Override // io.ktor.util.StringValues
    public String get(String str) {
        return Headers.DefaultImpls.b(this, str);
    }

    @Override // io.ktor.util.StringValues
    public Set<String> names() {
        return SetsKt.b();
    }

    public String toString() {
        return "Headers " + a();
    }
}
