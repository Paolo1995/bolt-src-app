package io.ktor.http;

import io.ktor.http.Parameters;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Parameters.kt */
/* loaded from: classes5.dex */
public final class EmptyParameters implements Parameters {

    /* renamed from: c  reason: collision with root package name */
    public static final EmptyParameters f46766c = new EmptyParameters();

    private EmptyParameters() {
    }

    @Override // io.ktor.util.StringValues
    public Set<Map.Entry<String, List<String>>> a() {
        Set<Map.Entry<String, List<String>>> b8;
        b8 = SetsKt__SetsKt.b();
        return b8;
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
        Parameters.DefaultImpls.a(this, function2);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Parameters) && ((Parameters) obj).isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // io.ktor.util.StringValues
    public boolean isEmpty() {
        return true;
    }

    @Override // io.ktor.util.StringValues
    public Set<String> names() {
        Set<String> b8;
        b8 = SetsKt__SetsKt.b();
        return b8;
    }

    public String toString() {
        return "Parameters " + a();
    }
}
