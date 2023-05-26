package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class kp implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final td f43902f;

    /* renamed from: g  reason: collision with root package name */
    private final List<a> f43903g;

    /* renamed from: h  reason: collision with root package name */
    private final b f43904h;

    /* loaded from: classes5.dex */
    public static final class a implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private final String f43905f;

        /* renamed from: g  reason: collision with root package name */
        private final Long f43906g;

        public a(String url, Long l8) {
            Intrinsics.f(url, "url");
            this.f43905f = url;
            this.f43906g = l8;
        }

        public final Long a() {
            return this.f43906g;
        }

        public final String b() {
            return this.f43905f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f43905f, aVar.f43905f) && Intrinsics.a(this.f43906g, aVar.f43906g);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f43905f.hashCode() * 31;
            Long l8 = this.f43906g;
            return hashCode + (l8 == null ? 0 : l8.hashCode());
        }

        public String toString() {
            String str = this.f43905f;
            Long l8 = this.f43906g;
            return "CloseWebviewUrl(url=" + str + ", delayMs=" + l8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private final String f43907f;

        /* renamed from: g  reason: collision with root package name */
        private final Boolean f43908g;

        public b(String str, Boolean bool) {
            this.f43907f = str;
            this.f43908g = bool;
        }

        public final Boolean a() {
            return this.f43908g;
        }

        public final String b() {
            return this.f43907f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return Intrinsics.a(this.f43907f, bVar.f43907f) && Intrinsics.a(this.f43908g, bVar.f43908g);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f43907f;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Boolean bool = this.f43908g;
            return hashCode + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            String str = this.f43907f;
            Boolean bool = this.f43908g;
            return "OnUserCloseWebview(reportSdkEventRequest=" + str + ", closeSdk=" + bool + ")";
        }
    }

    public kp(td openWebViewModel, List<a> list, b bVar) {
        Intrinsics.f(openWebViewModel, "openWebViewModel");
        this.f43902f = openWebViewModel;
        this.f43903g = list;
        this.f43904h = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ kp a(kp kpVar, td tdVar, List list, b bVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            tdVar = kpVar.f43902f;
        }
        if ((i8 & 2) != 0) {
            list = kpVar.f43903g;
        }
        if ((i8 & 4) != 0) {
            bVar = kpVar.f43904h;
        }
        return kpVar.b(tdVar, list, bVar);
    }

    public final kp b(td openWebViewModel, List<a> list, b bVar) {
        Intrinsics.f(openWebViewModel, "openWebViewModel");
        return new kp(openWebViewModel, list, bVar);
    }

    public final List<a> c() {
        return this.f43903g;
    }

    public final b d() {
        return this.f43904h;
    }

    public final td e() {
        return this.f43902f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof kp) {
            kp kpVar = (kp) obj;
            return Intrinsics.a(this.f43902f, kpVar.f43902f) && Intrinsics.a(this.f43903g, kpVar.f43903g) && Intrinsics.a(this.f43904h, kpVar.f43904h);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f43902f.hashCode() * 31;
        List<a> list = this.f43903g;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        b bVar = this.f43904h;
        return hashCode2 + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        td tdVar = this.f43902f;
        List<a> list = this.f43903g;
        b bVar = this.f43904h;
        return "VerificationOpenWebViewModel(openWebViewModel=" + tdVar + ", closeWebViewUrls=" + list + ", onUserCloseWebview=" + bVar + ")";
    }
}
