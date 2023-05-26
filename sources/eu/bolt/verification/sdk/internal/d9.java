package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.d9;
import eu.bolt.verification.sdk.internal.em;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class d9 {

    /* renamed from: a  reason: collision with root package name */
    private final xn f42626a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ud f42627a;

        public a(ud selectedOption) {
            Intrinsics.f(selectedOption, "selectedOption");
            this.f42627a = selectedOption;
        }

        public final ud a() {
            return this.f42627a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f42627a, ((a) obj).f42627a);
        }

        public int hashCode() {
            return this.f42627a.hashCode();
        }

        public String toString() {
            ud udVar = this.f42627a;
            return "Args(selectedOption=" + udVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<Map<String, ? extends em>, CompletableSource> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ a f42628f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ d9 f42629g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(a aVar, d9 d9Var) {
            super(1);
            this.f42628f = aVar;
            this.f42629g = d9Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Map userInput, a args, d9 this$0) {
            Intrinsics.f(userInput, "$userInput");
            Intrinsics.f(args, "$args");
            Intrinsics.f(this$0, "this$0");
            Object obj = userInput.get(args.a().a());
            em.a aVar = obj instanceof em.a ? (em.a) obj : null;
            xn.j(this$0.f42626a, args.a().a(), args.a().c() ? this$0.c(args.a(), aVar) : this$0.h(args.a(), aVar), null, 4, null);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c */
        public final CompletableSource invoke(final Map<String, ? extends em> userInput) {
            Intrinsics.f(userInput, "userInput");
            final a aVar = this.f42628f;
            final d9 d9Var = this.f42629g;
            return Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.xr
                @Override // io.reactivex.functions.Action
                public final void run() {
                    d9.b.d(userInput, aVar, d9Var);
                }
            });
        }
    }

    @Inject
    public d9(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f42626a = verificationFlowRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final em c(ud udVar, em.a aVar) {
        List e8;
        List<String> n02;
        List e9;
        List<String> b8 = aVar != null ? aVar.b() : null;
        if (b8 == null) {
            e9 = CollectionsKt__CollectionsJVMKt.e(udVar.b());
            return new em.a(e9);
        } else if (b8.contains(udVar.b()) && b8.size() == 1) {
            return null;
        } else {
            if (!b8.contains(udVar.b()) || b8.size() <= 1) {
                e8 = CollectionsKt__CollectionsJVMKt.e(udVar.b());
                n02 = CollectionsKt___CollectionsKt.n0(b8, e8);
                return aVar.a(n02);
            }
            List<String> arrayList = new ArrayList<>();
            for (Object obj : b8) {
                if (!Intrinsics.a((String) obj, udVar.b())) {
                    arrayList.add(obj);
                }
            }
            return aVar.a(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final em h(ud udVar, em.a aVar) {
        List<String> e8;
        List e9;
        List<String> b8 = aVar != null ? aVar.b() : null;
        if (b8 == null) {
            e9 = CollectionsKt__CollectionsJVMKt.e(udVar.b());
            return new em.a(e9);
        } else if (b8.contains(udVar.b())) {
            return aVar;
        } else {
            e8 = CollectionsKt__CollectionsJVMKt.e(udVar.b());
            return aVar.a(e8);
        }
    }

    public Completable e(a args) {
        Intrinsics.f(args, "args");
        Single firstOrError = xn.c(this.f42626a, null, 1, null).firstOrError();
        final b bVar = new b(args, this);
        Completable s7 = firstOrError.s(new Function() { // from class: eu.bolt.verification.sdk.internal.wr
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource f8;
                f8 = d9.f(Function1.this, obj);
                return f8;
            }
        });
        Intrinsics.e(s7, "override fun execute(arg…    }\n            }\n    }");
        return s7;
    }
}
