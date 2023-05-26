package eu.bolt.verification.sdk.internal;

import android.graphics.Bitmap;
import com.airbnb.lottie.LottieComposition;
import eu.bolt.verification.sdk.internal.sj;
import eu.bolt.verification.sdk.internal.t9;
import eu.bolt.verification.sdk.internal.tj;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class kk {

    /* renamed from: d  reason: collision with root package name */
    public static final a f43877d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final xg f43878a;

    /* renamed from: b  reason: collision with root package name */
    private final t9 f43879b;

    /* renamed from: c  reason: collision with root package name */
    private final bc f43880c;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function1<Throwable, CompletableSource> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ sj f43882g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f43883h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(sj sjVar, int i8) {
            super(1);
            this.f43882g = sjVar;
            this.f43883h = i8;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final CompletableSource invoke(Throwable it) {
            Intrinsics.f(it, "it");
            return kk.this.n(this.f43882g, this.f43883h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function1<Bitmap, Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CompletableEmitter f43884f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CompletableEmitter completableEmitter) {
            super(1);
            this.f43884f = completableEmitter;
        }

        public final void b(Bitmap it) {
            Intrinsics.f(it, "it");
            if (this.f43884f.isDisposed()) {
                return;
            }
            this.f43884f.onComplete();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
            b(bitmap);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function1<Throwable, Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CompletableEmitter f43885f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(CompletableEmitter completableEmitter) {
            super(1);
            this.f43885f = completableEmitter;
        }

        public final void b(Throwable it) {
            Intrinsics.f(it, "it");
            if (this.f43885f.isDisposed()) {
                return;
            }
            this.f43885f.onError(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            b(th);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e extends Lambda implements Function1<LottieComposition, Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CompletableEmitter f43886f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(CompletableEmitter completableEmitter) {
            super(1);
            this.f43886f = completableEmitter;
        }

        public final void b(LottieComposition it) {
            Intrinsics.f(it, "it");
            if (this.f43886f.isDisposed()) {
                return;
            }
            this.f43886f.onComplete();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LottieComposition lottieComposition) {
            b(lottieComposition);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class f extends Lambda implements Function1<Throwable, Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CompletableEmitter f43887f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(CompletableEmitter completableEmitter) {
            super(1);
            this.f43887f = completableEmitter;
        }

        public final void b(Throwable it) {
            Intrinsics.f(it, "it");
            if (this.f43887f.isDisposed()) {
                return;
            }
            this.f43887f.onError(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            b(th);
            return Unit.f50853a;
        }
    }

    @Inject
    public kk(xg rxSchedulers, t9 imageLoader, bc lottieImageLoader) {
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        Intrinsics.f(imageLoader, "imageLoader");
        Intrinsics.f(lottieImageLoader, "lottieImageLoader");
        this.f43878a = rxSchedulers;
        this.f43879b = imageLoader;
        this.f43880c = lottieImageLoader;
    }

    static /* synthetic */ Completable e(kk kkVar, sj sjVar, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 5;
        }
        return kkVar.f(sjVar, i8);
    }

    private final Completable f(sj sjVar, int i8) {
        Completable g8;
        String str;
        sj.b bVar = sjVar instanceof sj.b ? (sj.b) sjVar : null;
        tj a8 = bVar != null ? bVar.a() : null;
        if (a8 == null || i8 <= 0) {
            g8 = Completable.g();
            str = "{\n            Completable.complete()\n        }";
        } else {
            Completable i9 = i(a8);
            final b bVar2 = new b(sjVar, i8);
            g8 = i9.C(new Function() { // from class: eu.bolt.verification.sdk.internal.du
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    CompletableSource k8;
                    k8 = kk.k(Function1.this, obj);
                    return k8;
                }
            });
            str = "private fun getCacheStra…omplete()\n        }\n    }";
        }
        Intrinsics.e(g8, str);
        return g8;
    }

    private final Completable g(final tj.a aVar) {
        Completable i8 = Completable.i(new CompletableOnSubscribe() { // from class: eu.bolt.verification.sdk.internal.eu
            @Override // io.reactivex.CompletableOnSubscribe
            public final void a(CompletableEmitter completableEmitter) {
                kk.l(kk.this, aVar, completableEmitter);
            }
        });
        Intrinsics.e(i8, "create { emitter ->\n    …}\n            )\n        }");
        return i8;
    }

    private final Completable h(final tj.b bVar) {
        Completable i8 = Completable.i(new CompletableOnSubscribe() { // from class: eu.bolt.verification.sdk.internal.fu
            @Override // io.reactivex.CompletableOnSubscribe
            public final void a(CompletableEmitter completableEmitter) {
                kk.m(kk.this, bVar, completableEmitter);
            }
        });
        Intrinsics.e(i8, "create { emitter ->\n    …}\n            )\n        }");
        return i8;
    }

    private final Completable i(tj tjVar) {
        if (tjVar instanceof tj.a) {
            return g((tj.a) tjVar);
        }
        if (tjVar instanceof tj.b) {
            return h((tj.b) tjVar);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(kk this$0, tj.a content, CompletableEmitter emitter) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(content, "$content");
        Intrinsics.f(emitter, "emitter");
        t9.a.a(this$0.f43879b, content.b(), new c(emitter), new d(emitter), false, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(kk this$0, tj.b content, CompletableEmitter emitter) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(content, "$content");
        Intrinsics.f(emitter, "emitter");
        this$0.f43880c.a(content.b(), new e(emitter), new f(emitter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Completable n(sj sjVar, int i8) {
        Completable d8 = Completable.J(1000L, TimeUnit.MILLISECONDS).d(f(sjVar, i8 - 1));
        Intrinsics.e(d8, "timer(TIME_FOR_RETRY_MIL…lide(slide, retries - 1))");
        return d8;
    }

    public final Completable j(List<? extends sj> slides) {
        int v7;
        Intrinsics.f(slides, "slides");
        v7 = CollectionsKt__IterablesKt.v(slides, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (sj sjVar : slides) {
            arrayList.add(e(this, sjVar, 0, 2, null));
        }
        Completable z7 = Completable.h(arrayList).z(this.f43878a.b());
        Intrinsics.e(z7, "concat(cacheQueue)\n     …bserveOn(rxSchedulers.io)");
        return z7;
    }
}
