package eu.bolt.verification.sdk.internal;

import eu.bolt.client.design.toolbar.DesignToolbarView;
import java.io.Serializable;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class o2 implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final b f44371f;

    /* renamed from: g  reason: collision with root package name */
    private final a f44372g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f44373h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f44374i;

    /* loaded from: classes5.dex */
    public static abstract class a implements Serializable {

        /* renamed from: eu.bolt.verification.sdk.internal.o2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0078a extends a {

            /* renamed from: f  reason: collision with root package name */
            public static final C0078a f44375f = new C0078a();

            private C0078a() {
                super(null);
            }
        }

        /* loaded from: classes5.dex */
        public static final class b extends a {

            /* renamed from: f  reason: collision with root package name */
            private final Set<h2> f44376f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(Set<? extends h2> allowedCountries) {
                super(null);
                Intrinsics.f(allowedCountries, "allowedCountries");
                this.f44376f = allowedCountries;
            }

            public final Set<h2> a() {
                return this.f44376f;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && Intrinsics.a(this.f44376f, ((b) obj).f44376f);
            }

            public int hashCode() {
                return this.f44376f.hashCode();
            }

            public String toString() {
                Set<h2> set = this.f44376f;
                return "Allowed(allowedCountries=" + set + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class c extends a {

            /* renamed from: f  reason: collision with root package name */
            private final Set<h2> f44377f;

            public final Set<h2> a() {
                return this.f44377f;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof c) && Intrinsics.a(this.f44377f, ((c) obj).f44377f);
            }

            public int hashCode() {
                return this.f44377f.hashCode();
            }

            public String toString() {
                Set<h2> set = this.f44377f;
                return "Excluded(excludedCountries=" + set + ")";
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private final DesignToolbarView.c f44378f;

        /* loaded from: classes5.dex */
        public static final class a extends b {

            /* renamed from: g  reason: collision with root package name */
            public static final a f44379g = new a();

            private a() {
                super(DesignToolbarView.c.a.f40250h, null);
            }
        }

        /* renamed from: eu.bolt.verification.sdk.internal.o2$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0079b extends b {

            /* renamed from: g  reason: collision with root package name */
            public static final C0079b f44380g = new C0079b();

            private C0079b() {
                super(DesignToolbarView.c.b.f40251h, null);
            }
        }

        private b(DesignToolbarView.c cVar) {
            this.f44378f = cVar;
        }

        public /* synthetic */ b(DesignToolbarView.c cVar, DefaultConstructorMarker defaultConstructorMarker) {
            this(cVar);
        }

        public final DesignToolbarView.c a() {
            return this.f44378f;
        }
    }

    public o2() {
        this(null, null, false, false, 15, null);
    }

    public o2(b backButton, a availableCountries, boolean z7, boolean z8) {
        Intrinsics.f(backButton, "backButton");
        Intrinsics.f(availableCountries, "availableCountries");
        this.f44371f = backButton;
        this.f44372g = availableCountries;
        this.f44373h = z7;
        this.f44374i = z8;
    }

    public /* synthetic */ o2(b bVar, a aVar, boolean z7, boolean z8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? b.a.f44379g : bVar, (i8 & 2) != 0 ? a.C0078a.f44375f : aVar, (i8 & 4) != 0 ? true : z7, (i8 & 8) != 0 ? false : z8);
    }

    public final a a() {
        return this.f44372g;
    }

    public final b b() {
        return this.f44371f;
    }

    public final boolean c() {
        return this.f44374i;
    }

    public final boolean d() {
        return this.f44373h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o2) {
            o2 o2Var = (o2) obj;
            return Intrinsics.a(this.f44371f, o2Var.f44371f) && Intrinsics.a(this.f44372g, o2Var.f44372g) && this.f44373h == o2Var.f44373h && this.f44374i == o2Var.f44374i;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f44371f.hashCode() * 31) + this.f44372g.hashCode()) * 31;
        boolean z7 = this.f44373h;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        boolean z8 = this.f44374i;
        return i9 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public String toString() {
        b bVar = this.f44371f;
        a aVar = this.f44372g;
        boolean z7 = this.f44373h;
        boolean z8 = this.f44374i;
        return "CountryPickerRibArgs(backButton=" + bVar + ", availableCountries=" + aVar + ", showCountryCodes=" + z7 + ", forceFinishOnBackPress=" + z8 + ")";
    }
}
