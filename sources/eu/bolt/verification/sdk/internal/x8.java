package eu.bolt.verification.sdk.internal;

import io.reactivex.Completable;
import io.reactivex.functions.Action;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class x8 {

    /* renamed from: a  reason: collision with root package name */
    private final xn f45637a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f45638a;

        public a(String stepId) {
            Intrinsics.f(stepId, "stepId");
            this.f45638a = stepId;
        }

        public final String a() {
            return this.f45638a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f45638a, ((a) obj).f45638a);
        }

        public int hashCode() {
            return this.f45638a.hashCode();
        }

        public String toString() {
            String str = this.f45638a;
            return "Args(stepId=" + str + ")";
        }
    }

    @Inject
    public x8(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f45637a = verificationFlowRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(x8 this$0, a args) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(args, "$args");
        this$0.f45637a.n(args.a());
    }

    public Completable b(final a args) {
        Intrinsics.f(args, "args");
        Completable u7 = Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.xx
            @Override // io.reactivex.functions.Action
            public final void run() {
                x8.c(x8.this, args);
            }
        });
        Intrinsics.e(u7, "fromAction {\n           …Id(args.stepId)\n        }");
        return u7;
    }
}
