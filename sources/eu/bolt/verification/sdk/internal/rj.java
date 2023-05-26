package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.pa;
import eu.bolt.verification.sdk.internal.rj;
import eu.bolt.verification.sdk.internal.y5;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.io.File;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import timber.log.Timber;

/* loaded from: classes5.dex */
public final class rj {

    /* renamed from: c  reason: collision with root package name */
    private static final a f44840c = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final pa f44841a;

    /* renamed from: b  reason: collision with root package name */
    private final y5 f44842b;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends RuntimeException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function1<y5.c, Boolean> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f44843f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Boolean invoke(y5.c it) {
            Intrinsics.f(it, "it");
            return Boolean.valueOf((it instanceof y5.c.e) || (it instanceof y5.c.a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function1<y5.c, CompletableSource> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f44845g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str) {
            super(1);
            this.f44845g = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(y5.c it) {
            Intrinsics.f(it, "$it");
            Timber.Forest forest = Timber.f53064a;
            forest.a("Unsupported status " + it, new Object[0]);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c */
        public final CompletableSource invoke(final y5.c it) {
            Intrinsics.f(it, "it");
            return Intrinsics.a(it, y5.c.a.f45731a) ? Completable.t(new b()) : it instanceof y5.c.e ? rj.this.i(this.f44845g, ((y5.c.e) it).a()) : Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.yv
                @Override // io.reactivex.functions.Action
                public final void run() {
                    rj.d.d(y5.c.this);
                }
            });
        }
    }

    @Inject
    public rj(pa intentRouter, y5 downloadFileManager) {
        Intrinsics.f(intentRouter, "intentRouter");
        Intrinsics.f(downloadFileManager, "downloadFileManager");
        this.f44841a = intentRouter;
        this.f44842b = downloadFileManager;
    }

    private final void f(String str, File file) {
        this.f44841a.a(new pa.a(str, null, null, file, 6, null));
    }

    private final boolean g(File file) {
        if (file.exists()) {
            if (file.lastModified() >= System.currentTimeMillis() - 600000) {
                return true;
            }
            file.delete();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Completable i(final String str, final File file) {
        Completable u7 = Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.xv
            @Override // io.reactivex.functions.Action
            public final void run() {
                rj.k(rj.this, str, file);
            }
        });
        Intrinsics.e(u7, "fromAction {\n           …hareText, file)\n        }");
        return u7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(rj this$0, String str, File file) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(file, "$file");
        this$0.f(str, file);
    }

    public final Completable e(String storyId, String slideId, String url, String str, String str2) {
        Intrinsics.f(storyId, "storyId");
        Intrinsics.f(slideId, "slideId");
        Intrinsics.f(url, "url");
        String str3 = "story" + storyId + "_slide" + slideId + "_" + str2;
        y5 y5Var = this.f44842b;
        z5 z5Var = z5.PNG;
        File e8 = y5Var.e(url, str3, z5Var);
        if (g(e8)) {
            return i(str, e8);
        }
        Observable<y5.c> i8 = this.f44842b.i(new y5.a(null, null, url, z5Var, str2, 3, null));
        final c cVar = c.f44843f;
        Observable<y5.c> filter = i8.filter(new Predicate() { // from class: eu.bolt.verification.sdk.internal.vv
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean h8;
                h8 = rj.h(Function1.this, obj);
                return h8;
            }
        });
        final d dVar = new d(str);
        Completable D = filter.flatMapCompletable(new Function() { // from class: eu.bolt.verification.sdk.internal.wv
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource j8;
                j8 = rj.j(Function1.this, obj);
                return j8;
            }
        }).D(new ag(3, 1000));
        Intrinsics.e(D, "fun shareStory(\n        …ELAY_MS))\n        }\n    }");
        return D;
    }
}
