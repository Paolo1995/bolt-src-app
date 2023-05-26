package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
public interface y6 {

    /* loaded from: classes5.dex */
    public static final class a {
        public static void a(y6 y6Var, z6 z6Var) {
        }

        public static void b(y6 y6Var, Serializable payload) {
            Intrinsics.f(payload, "payload");
        }

        public static Flow<k6> c(y6 y6Var, z6 z6Var) {
            return null;
        }

        public static Flow<k6> d(y6 y6Var, z6 z6Var) {
            return null;
        }

        public static void e(y6 y6Var, z6 z6Var) {
        }

        public static void f(y6 y6Var, z6 z6Var) {
        }
    }

    void A(z6 z6Var);

    void m(z6 z6Var);

    void o(Serializable serializable);

    Flow<k6> p(z6 z6Var);

    void q(z6 z6Var);

    Flow<k6> r(z6 z6Var);

    void t(z6 z6Var);

    void u(z6 z6Var);
}
