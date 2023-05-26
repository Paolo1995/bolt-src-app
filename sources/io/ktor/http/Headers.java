package io.ktor.http;

import io.ktor.util.StringValues;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Headers.kt */
/* loaded from: classes5.dex */
public interface Headers extends StringValues {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f46777a = Companion.f46778a;

    /* compiled from: Headers.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f46778a = new Companion();

        /* renamed from: b  reason: collision with root package name */
        private static final Headers f46779b = EmptyHeaders.f46765c;

        private Companion() {
        }

        public final Headers a() {
            return f46779b;
        }
    }

    /* compiled from: Headers.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static void a(Headers headers, Function2<? super String, ? super List<String>, Unit> body) {
            Intrinsics.f(body, "body");
            StringValues.DefaultImpls.a(headers, body);
        }

        public static String b(Headers headers, String name) {
            Intrinsics.f(name, "name");
            return StringValues.DefaultImpls.b(headers, name);
        }
    }
}
