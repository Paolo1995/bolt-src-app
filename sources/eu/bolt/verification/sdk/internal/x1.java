package eu.bolt.verification.sdk.internal;

import io.reactivex.Completable;
import io.reactivex.functions.Action;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class x1 {

    /* renamed from: a  reason: collision with root package name */
    private final xn f45601a;

    @Inject
    public x1(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f45601a = verificationFlowRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(x1 this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f45601a.y();
    }

    public Completable b() {
        Completable u7 = Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.vx
            @Override // io.reactivex.functions.Action
            public final void run() {
                x1.c(x1.this);
            }
        });
        Intrinsics.e(u7, "fromAction {\n           …uireCloseForm()\n        }");
        return u7;
    }
}
