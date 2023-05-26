package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.jl;
import eu.bolt.verification.sdk.internal.ro;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class iq {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43611a = new a(null);

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final jl.a a(String str) {
        if (Intrinsics.a(str, "numbers")) {
            return jl.a.NUMBERS;
        }
        Intrinsics.a(str, "text");
        return jl.a.TEXT;
    }

    public final jl b(ro.h from) {
        Intrinsics.f(from, "from");
        return new jl(from.a(), from.b().a(), a(from.b().b()));
    }
}
