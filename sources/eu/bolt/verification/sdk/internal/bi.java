package eu.bolt.verification.sdk.internal;

import android.util.LruCache;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Singleton
/* loaded from: classes5.dex */
public final class bi {

    /* renamed from: f  reason: collision with root package name */
    public static final b f42337f = new b(null);

    /* renamed from: a  reason: collision with root package name */
    private final xg f42338a;

    /* renamed from: b  reason: collision with root package name */
    private final dj f42339b;

    /* renamed from: c  reason: collision with root package name */
    private final kk f42340c;

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f42341d;

    /* renamed from: e  reason: collision with root package name */
    private final LruCache<String, ki> f42342e;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<rg, Unit> {
        a() {
            super(1);
        }

        public final void b(rg it) {
            Intrinsics.f(it, "it");
            bi.this.f42342e.evictAll();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(rg rgVar) {
            b(rgVar);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    private static abstract class c {

        /* loaded from: classes5.dex */
        public static final class a extends c {

            /* renamed from: a  reason: collision with root package name */
            public static final a f42344a = new a();

            private a() {
                super(null);
            }
        }

        /* loaded from: classes5.dex */
        public static final class b extends c {

            /* renamed from: a  reason: collision with root package name */
            private final ki f42345a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(ki story) {
                super(null);
                Intrinsics.f(story, "story");
                this.f42345a = story;
            }

            public final ki a() {
                return this.f42345a;
            }
        }

        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function0<rh> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ f0 f42346f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(f0 f0Var) {
            super(0);
            this.f42346f = f0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final rh invoke() {
            return (rh) this.f42346f.a(rh.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e extends Lambda implements Function1<ki, ObservableSource<? extends c>> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final ObservableSource<? extends c> invoke(ki story) {
            List n8;
            Intrinsics.f(story, "story");
            Observable just = Observable.just(new c.b(story));
            Intrinsics.e(just, "just(StoryContentEvent.StoryContent(story))");
            Observable e8 = bi.this.f42340c.j(story.b()).e(Observable.just(c.a.f42344a));
            Intrinsics.e(e8, "storySlidesCache.cacheSl….SlidesCachingCompleted))");
            n8 = CollectionsKt__CollectionsKt.n(just, e8);
            return Observable.merge(n8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class f extends Lambda implements Function1<c, ki> {

        /* renamed from: f  reason: collision with root package name */
        public static final f f42348f = new f();

        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final ki invoke(c cVar) {
            c.b bVar = cVar instanceof c.b ? (c.b) cVar : null;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public /* synthetic */ class g extends FunctionReferenceImpl implements Function1<jj, ki> {
        g(Object obj) {
            super(1, obj, dj.class, "map", "map(Lee/mtakso/client/core/data/network/models/stories/StoryResponse;)Leu/bolt/client/stories/data/entries/Story;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: j */
        public final ki invoke(jj p02) {
            Intrinsics.f(p02, "p0");
            return ((dj) this.f50989g).a(p02);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class h extends Lambda implements Function1<ki, Unit> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f42350g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str) {
            super(1);
            this.f42350g = str;
        }

        public final void b(ki kiVar) {
            bi.this.f42342e.put(this.f42350g, kiVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ki kiVar) {
            b(kiVar);
            return Unit.f50853a;
        }
    }

    @Inject
    public bi(f0 apiCreator, s8 getUserLanguageInteractor, xg rxSchedulers, dj storyMapper, kk storySlidesCache) {
        Lazy b8;
        Intrinsics.f(apiCreator, "apiCreator");
        Intrinsics.f(getUserLanguageInteractor, "getUserLanguageInteractor");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        Intrinsics.f(storyMapper, "storyMapper");
        Intrinsics.f(storySlidesCache, "storySlidesCache");
        this.f42338a = rxSchedulers;
        this.f42339b = storyMapper;
        this.f42340c = storySlidesCache;
        b8 = LazyKt__LazyJVMKt.b(new d(apiCreator));
        this.f42341d = b8;
        this.f42342e = new LruCache<>(10);
        ug.r(getUserLanguageInteractor.a(), new a(), null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ki e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ki) tmp0.invoke(obj);
    }

    private final rh f() {
        return (rh) this.f42341d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    public final Observable<ki> g(String storyId) {
        Single o8;
        Intrinsics.f(storyId, "storyId");
        if (this.f42342e.get(storyId) != null) {
            o8 = Single.w(this.f42342e.get(storyId));
        } else {
            Single<jj> K = f().c(storyId).K(this.f42338a.b());
            final g gVar = new g(this.f42339b);
            Single<R> x7 = K.x(new Function() { // from class: eu.bolt.verification.sdk.internal.yk
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ki e8;
                    e8 = bi.e(Function1.this, obj);
                    return e8;
                }
            });
            final h hVar = new h(storyId);
            o8 = x7.o(new Consumer() { // from class: eu.bolt.verification.sdk.internal.zk
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    bi.i(Function1.this, obj);
                }
            });
        }
        Intrinsics.e(o8, "fun observeStory(storyId…ryContent)?.story }\n    }");
        final e eVar = new e();
        Observable t7 = o8.t(new Function() { // from class: eu.bolt.verification.sdk.internal.al
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource j8;
                j8 = bi.j(Function1.this, obj);
                return j8;
            }
        });
        Intrinsics.e(t7, "fun observeStory(storyId…ryContent)?.story }\n    }");
        return ug.n(t7, f.f42348f);
    }
}
