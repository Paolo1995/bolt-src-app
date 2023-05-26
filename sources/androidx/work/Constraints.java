package androidx.work;

import android.os.Build;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class Constraints {

    /* renamed from: i  reason: collision with root package name */
    public static final Constraints f8237i = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private NetworkType f8238a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8239b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8240c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8241d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8242e;

    /* renamed from: f  reason: collision with root package name */
    private long f8243f;

    /* renamed from: g  reason: collision with root package name */
    private long f8244g;

    /* renamed from: h  reason: collision with root package name */
    private ContentUriTriggers f8245h;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        boolean f8246a = false;

        /* renamed from: b  reason: collision with root package name */
        boolean f8247b = false;

        /* renamed from: c  reason: collision with root package name */
        NetworkType f8248c = NetworkType.NOT_REQUIRED;

        /* renamed from: d  reason: collision with root package name */
        boolean f8249d = false;

        /* renamed from: e  reason: collision with root package name */
        boolean f8250e = false;

        /* renamed from: f  reason: collision with root package name */
        long f8251f = -1;

        /* renamed from: g  reason: collision with root package name */
        long f8252g = -1;

        /* renamed from: h  reason: collision with root package name */
        ContentUriTriggers f8253h = new ContentUriTriggers();

        @NonNull
        public Constraints a() {
            return new Constraints(this);
        }
    }

    public Constraints() {
        this.f8238a = NetworkType.NOT_REQUIRED;
        this.f8243f = -1L;
        this.f8244g = -1L;
        this.f8245h = new ContentUriTriggers();
    }

    @NonNull
    public ContentUriTriggers a() {
        return this.f8245h;
    }

    @NonNull
    public NetworkType b() {
        return this.f8238a;
    }

    public long c() {
        return this.f8243f;
    }

    public long d() {
        return this.f8244g;
    }

    public boolean e() {
        if (this.f8245h.c() > 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Constraints.class != obj.getClass()) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.f8239b != constraints.f8239b || this.f8240c != constraints.f8240c || this.f8241d != constraints.f8241d || this.f8242e != constraints.f8242e || this.f8243f != constraints.f8243f || this.f8244g != constraints.f8244g || this.f8238a != constraints.f8238a) {
            return false;
        }
        return this.f8245h.equals(constraints.f8245h);
    }

    public boolean f() {
        return this.f8241d;
    }

    public boolean g() {
        return this.f8239b;
    }

    public boolean h() {
        return this.f8240c;
    }

    public int hashCode() {
        long j8 = this.f8243f;
        long j9 = this.f8244g;
        return (((((((((((((this.f8238a.hashCode() * 31) + (this.f8239b ? 1 : 0)) * 31) + (this.f8240c ? 1 : 0)) * 31) + (this.f8241d ? 1 : 0)) * 31) + (this.f8242e ? 1 : 0)) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31) + ((int) (j9 ^ (j9 >>> 32)))) * 31) + this.f8245h.hashCode();
    }

    public boolean i() {
        return this.f8242e;
    }

    public void j(ContentUriTriggers contentUriTriggers) {
        this.f8245h = contentUriTriggers;
    }

    public void k(@NonNull NetworkType networkType) {
        this.f8238a = networkType;
    }

    public void l(boolean z7) {
        this.f8241d = z7;
    }

    public void m(boolean z7) {
        this.f8239b = z7;
    }

    public void n(boolean z7) {
        this.f8240c = z7;
    }

    public void o(boolean z7) {
        this.f8242e = z7;
    }

    public void p(long j8) {
        this.f8243f = j8;
    }

    public void q(long j8) {
        this.f8244g = j8;
    }

    Constraints(Builder builder) {
        this.f8238a = NetworkType.NOT_REQUIRED;
        this.f8243f = -1L;
        this.f8244g = -1L;
        this.f8245h = new ContentUriTriggers();
        this.f8239b = builder.f8246a;
        int i8 = Build.VERSION.SDK_INT;
        this.f8240c = i8 >= 23 && builder.f8247b;
        this.f8238a = builder.f8248c;
        this.f8241d = builder.f8249d;
        this.f8242e = builder.f8250e;
        if (i8 >= 24) {
            this.f8245h = builder.f8253h;
            this.f8243f = builder.f8251f;
            this.f8244g = builder.f8252g;
        }
    }

    public Constraints(@NonNull Constraints constraints) {
        this.f8238a = NetworkType.NOT_REQUIRED;
        this.f8243f = -1L;
        this.f8244g = -1L;
        this.f8245h = new ContentUriTriggers();
        this.f8239b = constraints.f8239b;
        this.f8240c = constraints.f8240c;
        this.f8238a = constraints.f8238a;
        this.f8241d = constraints.f8241d;
        this.f8242e = constraints.f8242e;
        this.f8245h = constraints.f8245h;
    }
}
