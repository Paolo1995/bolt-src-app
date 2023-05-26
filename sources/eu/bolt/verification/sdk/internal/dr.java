package eu.bolt.verification.sdk.internal;

import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import eu.bolt.android.rib.BaseViewRibPresenter;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public interface dr extends BaseViewRibPresenter<b> {

    /* loaded from: classes5.dex */
    public static final class a {
        public static Observable<b> a(dr drVar) {
            return BaseViewRibPresenter.DefaultImpls.a(drVar);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b {

        /* loaded from: classes5.dex */
        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final a f42662a = new a();

            private a() {
                super(null);
            }
        }

        /* renamed from: eu.bolt.verification.sdk.internal.dr$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0046b extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final C0046b f42663a = new C0046b();

            private C0046b() {
                super(null);
            }
        }

        /* loaded from: classes5.dex */
        public static final class c extends b {

            /* renamed from: a  reason: collision with root package name */
            private final WebChromeClient.FileChooserParams f42664a;

            /* renamed from: b  reason: collision with root package name */
            private final ValueCallback<Uri[]> f42665b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(WebChromeClient.FileChooserParams chooserParams, ValueCallback<Uri[]> resultReceiver) {
                super(null);
                Intrinsics.f(chooserParams, "chooserParams");
                Intrinsics.f(resultReceiver, "resultReceiver");
                this.f42664a = chooserParams;
                this.f42665b = resultReceiver;
            }

            public final WebChromeClient.FileChooserParams a() {
                return this.f42664a;
            }

            public final ValueCallback<Uri[]> b() {
                return this.f42665b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof c) {
                    c cVar = (c) obj;
                    return Intrinsics.a(this.f42664a, cVar.f42664a) && Intrinsics.a(this.f42665b, cVar.f42665b);
                }
                return false;
            }

            public int hashCode() {
                return (this.f42664a.hashCode() * 31) + this.f42665b.hashCode();
            }

            public String toString() {
                WebChromeClient.FileChooserParams fileChooserParams = this.f42664a;
                ValueCallback<Uri[]> valueCallback = this.f42665b;
                return "OpenFilePickerClick(chooserParams=" + fileChooserParams + ", resultReceiver=" + valueCallback + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class d extends b {

            /* renamed from: a  reason: collision with root package name */
            private final String f42666a;

            /* renamed from: b  reason: collision with root package name */
            private final String f42667b;

            /* renamed from: c  reason: collision with root package name */
            private final String f42668c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(String url, String sourceId, String message) {
                super(null);
                Intrinsics.f(url, "url");
                Intrinsics.f(sourceId, "sourceId");
                Intrinsics.f(message, "message");
                this.f42666a = url;
                this.f42667b = sourceId;
                this.f42668c = message;
            }

            public final String a() {
                return this.f42668c;
            }

            public final String b() {
                return this.f42667b;
            }

            public final String c() {
                return this.f42666a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof d) {
                    d dVar = (d) obj;
                    return Intrinsics.a(this.f42666a, dVar.f42666a) && Intrinsics.a(this.f42667b, dVar.f42667b) && Intrinsics.a(this.f42668c, dVar.f42668c);
                }
                return false;
            }

            public int hashCode() {
                return (((this.f42666a.hashCode() * 31) + this.f42667b.hashCode()) * 31) + this.f42668c.hashCode();
            }

            public String toString() {
                String str = this.f42666a;
                String str2 = this.f42667b;
                String str3 = this.f42668c;
                return "PageJsError(url=" + str + ", sourceId=" + str2 + ", message=" + str3 + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class e extends b {

            /* renamed from: a  reason: collision with root package name */
            private final String f42669a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(String url) {
                super(null);
                Intrinsics.f(url, "url");
                this.f42669a = url;
            }

            public final String a() {
                return this.f42669a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof e) && Intrinsics.a(this.f42669a, ((e) obj).f42669a);
            }

            public int hashCode() {
                return this.f42669a.hashCode();
            }

            public String toString() {
                String str = this.f42669a;
                return "PageLoaded(url=" + str + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class f extends b {

            /* renamed from: a  reason: collision with root package name */
            private final String f42670a;

            /* renamed from: b  reason: collision with root package name */
            private final String f42671b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(String url, String reason) {
                super(null);
                Intrinsics.f(url, "url");
                Intrinsics.f(reason, "reason");
                this.f42670a = url;
                this.f42671b = reason;
            }

            public final String a() {
                return this.f42671b;
            }

            public final String b() {
                return this.f42670a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof f) {
                    f fVar = (f) obj;
                    return Intrinsics.a(this.f42670a, fVar.f42670a) && Intrinsics.a(this.f42671b, fVar.f42671b);
                }
                return false;
            }

            public int hashCode() {
                return (this.f42670a.hashCode() * 31) + this.f42671b.hashCode();
            }

            public String toString() {
                String str = this.f42670a;
                String str2 = this.f42671b;
                return "PageLoadingError(url=" + str + ", reason=" + str2 + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class g extends b {

            /* renamed from: a  reason: collision with root package name */
            private final String f42672a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public g(String deepLink) {
                super(null);
                Intrinsics.f(deepLink, "deepLink");
                this.f42672a = deepLink;
            }

            public final String a() {
                return this.f42672a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof g) && Intrinsics.a(this.f42672a, ((g) obj).f42672a);
            }

            public int hashCode() {
                return this.f42672a.hashCode();
            }

            public String toString() {
                String str = this.f42672a;
                return "UnsupportedDeeplinkFound(deepLink=" + str + ")";
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    boolean c();

    void d(int i8);

    void e();

    void q(ir irVar);

    void r(String str, String str2, Map<String, String> map);

    void s(String str, String str2);
}
