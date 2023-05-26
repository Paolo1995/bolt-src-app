package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.eh;
import eu.bolt.verification.sdk.internal.qn;
import eu.bolt.verification.sdk.internal.ye;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class eh {

    /* renamed from: a  reason: collision with root package name */
    private final xn f42768a;

    /* renamed from: b  reason: collision with root package name */
    private final ye f42769b;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final qn.b f42770a;

        public a(qn.b flow) {
            Intrinsics.f(flow, "flow");
            this.f42770a = flow;
        }

        public final qn.b a() {
            return this.f42770a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f42770a, ((a) obj).f42770a);
        }

        public int hashCode() {
            return this.f42770a.hashCode();
        }

        public String toString() {
            qn.b bVar = this.f42770a;
            return "Args(flow=" + bVar + ")";
        }
    }

    @Inject
    public eh(xn verificationFlowRepository, ye predefineDefaultValuesForStepInteractor) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        Intrinsics.f(predefineDefaultValuesForStepInteractor, "predefineDefaultValuesForStepInteractor");
        this.f42768a = verificationFlowRepository;
        this.f42769b = predefineDefaultValuesForStepInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(a args, eh this$0) {
        Intrinsics.f(args, "$args");
        Intrinsics.f(this$0, "this$0");
        if ((!args.a().f().isEmpty()) || qk.b(args.a().b())) {
            this$0.f42768a.i(args.a());
            this$0.f42768a.n(args.a().b());
            this$0.f42768a.f(args.a().e());
        }
    }

    public Completable b(final a args) {
        Intrinsics.f(args, "args");
        Completable d8 = Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.ks
            @Override // io.reactivex.functions.Action
            public final void run() {
                eh.c(eh.a.this, this);
            }
        }).d(this.f42769b.c(new ye.a(args.a().f())));
        Intrinsics.e(d8, "fromAction {\n           …r.Args(args.flow.steps)))");
        return d8;
    }
}
