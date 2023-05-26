package io.ktor.http;

import io.ktor.util.StringValues;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Parameters.kt */
/* loaded from: classes5.dex */
public interface Parameters extends StringValues {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f46888b = Companion.f46889a;

    /* compiled from: Parameters.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f46889a = new Companion();

        /* renamed from: b  reason: collision with root package name */
        private static final Parameters f46890b = EmptyParameters.f46766c;

        private Companion() {
        }

        public final Parameters a() {
            return f46890b;
        }
    }

    /* compiled from: Parameters.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static void a(Parameters parameters, Function2<? super String, ? super List<String>, Unit> body) {
            Intrinsics.f(body, "body");
            StringValues.DefaultImpls.a(parameters, body);
        }
    }
}
