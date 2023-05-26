package eu.bolt.verification.sdk.internal;

import android.app.DownloadManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import eu.bolt.verification.R$string;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Action;
import java.io.File;
import java.util.Locale;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import timber.log.Timber;

@Singleton
/* loaded from: classes5.dex */
public final class y5 {

    /* renamed from: d  reason: collision with root package name */
    private static final b f45722d = new b(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f45723a;

    /* renamed from: b  reason: collision with root package name */
    private final xg f45724b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f45725c;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f45726a;

        /* renamed from: b  reason: collision with root package name */
        private final String f45727b;

        /* renamed from: c  reason: collision with root package name */
        private final String f45728c;

        /* renamed from: d  reason: collision with root package name */
        private final z5 f45729d;

        /* renamed from: e  reason: collision with root package name */
        private final String f45730e;

        public a(String str, String str2, String url, z5 mimeType, String str3) {
            Intrinsics.f(url, "url");
            Intrinsics.f(mimeType, "mimeType");
            this.f45726a = str;
            this.f45727b = str2;
            this.f45728c = url;
            this.f45729d = mimeType;
            this.f45730e = str3;
        }

        public /* synthetic */ a(String str, String str2, String str3, z5 z5Var, String str4, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2, str3, z5Var, (i8 & 16) != 0 ? null : str4);
        }

        public final String a() {
            return this.f45727b;
        }

        public final String b() {
            return this.f45730e;
        }

        public final z5 c() {
            return this.f45729d;
        }

        public final String d() {
            return this.f45726a;
        }

        public final String e() {
            return this.f45728c;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class c {

        /* loaded from: classes5.dex */
        public static final class a extends c {

            /* renamed from: a  reason: collision with root package name */
            public static final a f45731a = new a();

            private a() {
                super(null);
            }
        }

        /* loaded from: classes5.dex */
        public static final class b extends c {

            /* renamed from: a  reason: collision with root package name */
            public static final b f45732a = new b();

            private b() {
                super(null);
            }
        }

        /* renamed from: eu.bolt.verification.sdk.internal.y5$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0099c extends c {

            /* renamed from: a  reason: collision with root package name */
            public static final C0099c f45733a = new C0099c();

            private C0099c() {
                super(null);
            }
        }

        /* loaded from: classes5.dex */
        public static final class d extends c {

            /* renamed from: a  reason: collision with root package name */
            private final int f45734a;

            public d(int i8) {
                super(null);
                this.f45734a = i8;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof d) && this.f45734a == ((d) obj).f45734a;
            }

            public int hashCode() {
                return this.f45734a;
            }

            public String toString() {
                int i8 = this.f45734a;
                return "Running(progress=" + i8 + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class e extends c {

            /* renamed from: a  reason: collision with root package name */
            private final File f45735a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(File file) {
                super(null);
                Intrinsics.f(file, "file");
                this.f45735a = file;
            }

            public final File a() {
                return this.f45735a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof e) && Intrinsics.a(this.f45735a, ((e) obj).f45735a);
            }

            public int hashCode() {
                return this.f45735a.hashCode();
            }

            public String toString() {
                File file = this.f45735a;
                return "Success(file=" + file + ")";
            }
        }

        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final DownloadManager.Request c(a aVar) {
        File e8 = e(aVar.e(), aVar.b(), aVar.c());
        String d8 = aVar.d();
        if (d8 == null) {
            d8 = e8.getName();
        }
        String a8 = aVar.a();
        if (a8 == null) {
            a8 = this.f45723a.getString(R$string.downloading);
            Intrinsics.e(a8, "context.getString(R.string.downloading)");
        }
        DownloadManager.Request title = new DownloadManager.Request(Uri.parse(aVar.e())).setNotificationVisibility(0).setTitle(d8);
        Uri fromFile = Uri.fromFile(e8);
        Intrinsics.e(fromFile, "fromFile(this)");
        DownloadManager.Request allowedOverRoaming = title.setDestinationUri(fromFile).setMimeType(aVar.c().e()).setDescription(a8).setAllowedOverMetered(true).setAllowedOverRoaming(false);
        Intrinsics.e(allowedOverRoaming, "Request(Uri.parse(args.u…AllowedOverRoaming(false)");
        return allowedOverRoaming;
    }

    private final DownloadManager d() {
        return (DownloadManager) this.f45725c.getValue();
    }

    private final void f(long j8, ObservableEmitter<c> observableEmitter) {
        c cVar;
        boolean z7 = false;
        int i8 = 0;
        while (!z7 && !observableEmitter.isDisposed()) {
            Cursor query = d().query(new DownloadManager.Query().setFilterById(j8));
            Intrinsics.e(query, "downloadManager.query(Do…etFilterById(downloadId))");
            if (!query.moveToFirst()) {
                Timber.f53064a.b(new IllegalStateException("Cursor for download is invalid"));
                observableEmitter.onNext(c.a.f45731a);
                observableEmitter.onComplete();
                return;
            }
            int i9 = query.getInt(query.getColumnIndexOrThrow("status"));
            if (i9 == 1) {
                cVar = c.C0099c.f45733a;
            } else if (i9 == 2) {
                long j9 = query.getLong(query.getColumnIndexOrThrow("total_size"));
                if (j9 > 0) {
                    i8 = (int) ((query.getLong(query.getColumnIndexOrThrow("bytes_so_far")) * 100) / j9);
                }
                cVar = new c.d(i8);
            } else if (i9 != 4) {
                if (i9 == 8) {
                    observableEmitter.onNext(new c.d(100));
                    String path = Uri.parse(query.getString(query.getColumnIndexOrThrow("local_uri"))).getPath();
                    if (path == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    Intrinsics.e(path, "requireNotNull(Uri.parse…COLUMN_LOCAL_URI))).path)");
                    observableEmitter.onNext(new c.e(new File(path)));
                    observableEmitter.onComplete();
                    z7 = true;
                    i8 = 100;
                } else if (i9 == 16) {
                    observableEmitter.onNext(c.a.f45731a);
                    observableEmitter.onComplete();
                    z7 = true;
                }
                query.close();
                Thread.sleep(5L);
            } else {
                cVar = c.b.f45732a;
            }
            observableEmitter.onNext(cVar);
            query.close();
            Thread.sleep(5L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Ref$ObjectRef downloadId, y5 this$0) {
        Intrinsics.f(downloadId, "$downloadId");
        Intrinsics.f(this$0, "this$0");
        Long l8 = (Long) downloadId.f51016f;
        if (l8 != null) {
            this$0.d().remove(l8.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.Long, java.lang.Number] */
    public static final void h(Ref$ObjectRef downloadId, y5 this$0, DownloadManager.Request request, ObservableEmitter emitter) {
        Intrinsics.f(downloadId, "$downloadId");
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(request, "$request");
        Intrinsics.f(emitter, "emitter");
        try {
            ?? valueOf = Long.valueOf(this$0.d().enqueue(request));
            downloadId.f51016f = valueOf;
            if (valueOf == 0) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            this$0.f(valueOf.longValue(), emitter);
        } catch (Exception e8) {
            emitter.a(e8);
        }
    }

    public final File e(String url, String str, z5 mimeType) {
        boolean v7;
        String R0;
        Intrinsics.f(url, "url");
        Intrinsics.f(mimeType, "mimeType");
        if (str == null) {
            String pathSeparator = File.pathSeparator;
            Intrinsics.e(pathSeparator, "pathSeparator");
            R0 = StringsKt__StringsKt.R0(url, pathSeparator, null, 2, null);
            Locale locale = Locale.getDefault();
            Intrinsics.e(locale, "getDefault()");
            str = R0.toLowerCase(locale);
            Intrinsics.e(str, "this as java.lang.String).toLowerCase(locale)");
        }
        v7 = StringsKt__StringsJVMKt.v(str, mimeType.c(), false, 2, null);
        if (!v7) {
            str = str + mimeType.c();
        }
        return new File(this.f45723a.getExternalCacheDir(), str);
    }

    public final Observable<c> i(a args) {
        Observable<c> error;
        String str;
        Intrinsics.f(args, "args");
        try {
            final DownloadManager.Request c8 = c(args);
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            Observable create = Observable.create(new ObservableOnSubscribe() { // from class: eu.bolt.verification.sdk.internal.zx
                @Override // io.reactivex.ObservableOnSubscribe
                public final void a(ObservableEmitter observableEmitter) {
                    y5.h(Ref$ObjectRef.this, this, c8, observableEmitter);
                }
            });
            Intrinsics.e(create, "create { emitter ->\n    …)\n            }\n        }");
            error = create.distinctUntilChanged().doOnDispose(new Action() { // from class: eu.bolt.verification.sdk.internal.ay
                @Override // io.reactivex.functions.Action
                public final void run() {
                    y5.g(Ref$ObjectRef.this, this);
                }
            }).subscribeOn(this.f45724b.b());
            str = "observable.distinctUntil…scribeOn(rxSchedulers.io)";
        } catch (Exception e8) {
            error = Observable.error(e8);
            str = "error(e)";
        }
        Intrinsics.e(error, str);
        return error;
    }
}
