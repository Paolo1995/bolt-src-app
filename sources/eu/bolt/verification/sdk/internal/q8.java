package eu.bolt.verification.sdk.internal;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class q8 {

    /* renamed from: a  reason: collision with root package name */
    private final xn f44635a;

    /* renamed from: b  reason: collision with root package name */
    private final ip f44636b;

    /* renamed from: c  reason: collision with root package name */
    private final rq f44637c;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<qn, Unit> {
        a() {
            super(1);
        }

        public final void b(qn qnVar) {
            q8.this.f44635a.l(false);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(qn qnVar) {
            b(qnVar);
            return Unit.f50853a;
        }
    }

    @Inject
    public q8(xn verificationFlowRepository, ip verificationNetworkRepository, rq userInputMapper) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        Intrinsics.f(verificationNetworkRepository, "verificationNetworkRepository");
        Intrinsics.f(userInputMapper, "userInputMapper");
        this.f44635a = verificationFlowRepository;
        this.f44636b = verificationNetworkRepository;
        this.f44637c = userInputMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public Single<qn> c(p8 args) {
        Intrinsics.f(args, "args");
        Single<qn> r7 = this.f44636b.r(args.a(), args.b() != null ? this.f44637c.b(args.b()) : null, args.c());
        final a aVar = new a();
        Single<qn> o8 = r7.o(new Consumer() { // from class: eu.bolt.verification.sdk.internal.mv
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                q8.d(Function1.this, obj);
            }
        });
        Intrinsics.e(o8, "override fun execute(arg…on(false)\n        }\n    }");
        return o8;
    }
}
