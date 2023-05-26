package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class aa implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final Boolean f41988f;

    /* loaded from: classes5.dex */
    public static final class a extends aa {

        /* renamed from: g  reason: collision with root package name */
        private final int f41989g;

        /* renamed from: h  reason: collision with root package name */
        private final Boolean f41990h;

        @Override // eu.bolt.verification.sdk.internal.aa
        public Boolean a() {
            return this.f41990h;
        }

        public final Drawable b(Context context) {
            Intrinsics.f(context, "context");
            return new ColorDrawable(f2.b(context, this.f41989g));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f41989g == aVar.f41989g && Intrinsics.a(a(), aVar.a());
            }
            return false;
        }

        public int hashCode() {
            return (this.f41989g * 31) + (a() == null ? 0 : a().hashCode());
        }

        public String toString() {
            int i8 = this.f41989g;
            Boolean a8 = a();
            return "ColorDrawable(colorResId=" + i8 + ", roundDrawable=" + a8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends aa {

        /* renamed from: g  reason: collision with root package name */
        private final int f41991g;

        /* renamed from: h  reason: collision with root package name */
        private final Integer f41992h;

        /* renamed from: i  reason: collision with root package name */
        private final Boolean f41993i;

        public b(int i8, Integer num, Boolean bool) {
            super(null, 1, null);
            this.f41991g = i8;
            this.f41992h = num;
            this.f41993i = bool;
        }

        public /* synthetic */ b(int i8, Integer num, Boolean bool, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(i8, (i9 & 2) != 0 ? null : num, (i9 & 4) != 0 ? null : bool);
        }

        @Override // eu.bolt.verification.sdk.internal.aa
        public Boolean a() {
            return this.f41993i;
        }

        public final Drawable b(Context context) {
            Intrinsics.f(context, "context");
            Drawable o8 = f2.o(context, this.f41991g);
            Integer num = this.f41992h;
            return num != null ? a6.a(o8, f2.b(context, num.intValue())) : o8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f41991g == bVar.f41991g && Intrinsics.a(this.f41992h, bVar.f41992h) && Intrinsics.a(a(), bVar.a());
            }
            return false;
        }

        public int hashCode() {
            int i8 = this.f41991g * 31;
            Integer num = this.f41992h;
            return ((i8 + (num == null ? 0 : num.hashCode())) * 31) + (a() != null ? a().hashCode() : 0);
        }

        public String toString() {
            int i8 = this.f41991g;
            Integer num = this.f41992h;
            Boolean a8 = a();
            return "Drawable(drawableResId=" + i8 + ", tintResId=" + num + ", roundDrawable=" + a8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends aa {

        /* renamed from: g  reason: collision with root package name */
        private final String f41994g;

        /* renamed from: h  reason: collision with root package name */
        private final f f41995h;

        /* renamed from: i  reason: collision with root package name */
        private final Boolean f41996i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f41997j;

        /* renamed from: k  reason: collision with root package name */
        private final boolean f41998k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String url, f fVar, Boolean bool, boolean z7, boolean z8) {
            super(null, 1, null);
            Intrinsics.f(url, "url");
            this.f41994g = url;
            this.f41995h = fVar;
            this.f41996i = bool;
            this.f41997j = z7;
            this.f41998k = z8;
        }

        public /* synthetic */ c(String str, f fVar, Boolean bool, boolean z7, boolean z8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? null : fVar, (i8 & 4) != 0 ? null : bool, (i8 & 8) != 0 ? false : z7, (i8 & 16) != 0 ? false : z8);
        }

        @Override // eu.bolt.verification.sdk.internal.aa
        public Boolean a() {
            return this.f41996i;
        }

        public final boolean b() {
            return this.f41998k;
        }

        public final boolean c() {
            return this.f41997j;
        }

        public final String d() {
            return this.f41994g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return Intrinsics.a(this.f41994g, cVar.f41994g) && Intrinsics.a(this.f41995h, cVar.f41995h) && Intrinsics.a(a(), cVar.a()) && this.f41997j == cVar.f41997j && this.f41998k == cVar.f41998k;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.f41994g.hashCode() * 31;
            f fVar = this.f41995h;
            int hashCode2 = (((hashCode + (fVar == null ? 0 : fVar.hashCode())) * 31) + (a() != null ? a().hashCode() : 0)) * 31;
            boolean z7 = this.f41997j;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode2 + i8) * 31;
            boolean z8 = this.f41998k;
            return i9 + (z8 ? 1 : z8 ? 1 : 0);
        }

        public String toString() {
            String str = this.f41994g;
            f fVar = this.f41995h;
            Boolean a8 = a();
            boolean z7 = this.f41997j;
            boolean z8 = this.f41998k;
            return "Lottie(url=" + str + ", size=" + fVar + ", roundDrawable=" + a8 + ", repeat=" + z7 + ", playAnimation=" + z8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends aa {

        /* renamed from: g  reason: collision with root package name */
        private final a f41999g;

        /* renamed from: h  reason: collision with root package name */
        private final f f42000h;

        /* renamed from: i  reason: collision with root package name */
        private final Boolean f42001i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f42002j;

        /* renamed from: k  reason: collision with root package name */
        private final boolean f42003k;

        /* loaded from: classes5.dex */
        public interface a extends Serializable {

            /* renamed from: eu.bolt.verification.sdk.internal.aa$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0028a implements a {

                /* renamed from: f  reason: collision with root package name */
                private final String f42004f;

                public final String a() {
                    return this.f42004f;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof C0028a) && Intrinsics.a(this.f42004f, ((C0028a) obj).f42004f);
                }

                public int hashCode() {
                    return this.f42004f.hashCode();
                }

                public String toString() {
                    String str = this.f42004f;
                    return "Asset(assetName=" + str + ")";
                }
            }

            /* loaded from: classes5.dex */
            public static final class b implements a {

                /* renamed from: f  reason: collision with root package name */
                private final int f42005f;

                public final int a() {
                    return this.f42005f;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof b) && this.f42005f == ((b) obj).f42005f;
                }

                public int hashCode() {
                    return this.f42005f;
                }

                public String toString() {
                    int i8 = this.f42005f;
                    return "Raw(rawRes=" + i8 + ")";
                }
            }
        }

        @Override // eu.bolt.verification.sdk.internal.aa
        public Boolean a() {
            return this.f42001i;
        }

        public final boolean b() {
            return this.f42003k;
        }

        public final boolean c() {
            return this.f42002j;
        }

        public final a d() {
            return this.f41999g;
        }

        public final f e() {
            return this.f42000h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d) {
                d dVar = (d) obj;
                return Intrinsics.a(this.f41999g, dVar.f41999g) && Intrinsics.a(this.f42000h, dVar.f42000h) && Intrinsics.a(a(), dVar.a()) && this.f42002j == dVar.f42002j && this.f42003k == dVar.f42003k;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.f41999g.hashCode() * 31;
            f fVar = this.f42000h;
            int hashCode2 = (((hashCode + (fVar == null ? 0 : fVar.hashCode())) * 31) + (a() != null ? a().hashCode() : 0)) * 31;
            boolean z7 = this.f42002j;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode2 + i8) * 31;
            boolean z8 = this.f42003k;
            return i9 + (z8 ? 1 : z8 ? 1 : 0);
        }

        public String toString() {
            a aVar = this.f41999g;
            f fVar = this.f42000h;
            Boolean a8 = a();
            boolean z7 = this.f42002j;
            boolean z8 = this.f42003k;
            return "LottieLocal(resource=" + aVar + ", size=" + fVar + ", roundDrawable=" + a8 + ", repeat=" + z7 + ", playAnimation=" + z8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends aa {

        /* renamed from: g  reason: collision with root package name */
        private final int f42006g;

        /* renamed from: h  reason: collision with root package name */
        private final f f42007h;

        /* renamed from: i  reason: collision with root package name */
        private final Boolean f42008i;

        public e(int i8, f fVar, Boolean bool) {
            super(null, 1, null);
            this.f42006g = i8;
            this.f42007h = fVar;
            this.f42008i = bool;
        }

        public /* synthetic */ e(int i8, f fVar, Boolean bool, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(i8, (i9 & 2) != 0 ? null : fVar, (i9 & 4) != 0 ? null : bool);
        }

        @Override // eu.bolt.verification.sdk.internal.aa
        public Boolean a() {
            return this.f42008i;
        }

        public final int b() {
            return this.f42006g;
        }

        public final f c() {
            return this.f42007h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof e) {
                e eVar = (e) obj;
                return this.f42006g == eVar.f42006g && Intrinsics.a(this.f42007h, eVar.f42007h) && Intrinsics.a(a(), eVar.a());
            }
            return false;
        }

        public int hashCode() {
            int i8 = this.f42006g * 31;
            f fVar = this.f42007h;
            return ((i8 + (fVar == null ? 0 : fVar.hashCode())) * 31) + (a() != null ? a().hashCode() : 0);
        }

        public String toString() {
            int i8 = this.f42006g;
            f fVar = this.f42007h;
            Boolean a8 = a();
            return "Resources(drawableRes=" + i8 + ", size=" + fVar + ", roundDrawable=" + a8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class f implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private final float f42009f;

        /* renamed from: g  reason: collision with root package name */
        private final float f42010g;

        public f(float f8, float f9) {
            this.f42009f = f8;
            this.f42010g = f9;
        }

        public final float a() {
            return this.f42009f;
        }

        public final float b() {
            return this.f42010g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof f) {
                f fVar = (f) obj;
                return Float.compare(this.f42009f, fVar.f42009f) == 0 && Float.compare(this.f42010g, fVar.f42010g) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f42009f) * 31) + Float.floatToIntBits(this.f42010g);
        }

        public String toString() {
            float f8 = this.f42009f;
            float f9 = this.f42010g;
            return "Size(heightDp=" + f8 + ", widthDp=" + f9 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class g extends aa {

        /* renamed from: g  reason: collision with root package name */
        private final String f42011g;

        /* renamed from: h  reason: collision with root package name */
        private final Integer f42012h;

        /* renamed from: i  reason: collision with root package name */
        private final f f42013i;

        /* renamed from: j  reason: collision with root package name */
        private final Integer f42014j;

        /* renamed from: k  reason: collision with root package name */
        private final Integer f42015k;

        /* renamed from: l  reason: collision with root package name */
        private final Integer f42016l;

        /* renamed from: m  reason: collision with root package name */
        private final Boolean f42017m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String url, Integer num, f fVar, Integer num2, Integer num3, Integer num4, Boolean bool) {
            super(null, 1, null);
            Intrinsics.f(url, "url");
            this.f42011g = url;
            this.f42012h = num;
            this.f42013i = fVar;
            this.f42014j = num2;
            this.f42015k = num3;
            this.f42016l = num4;
            this.f42017m = bool;
        }

        public /* synthetic */ g(String str, Integer num, f fVar, Integer num2, Integer num3, Integer num4, Boolean bool, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? null : num, (i8 & 4) != 0 ? null : fVar, (i8 & 8) != 0 ? null : num2, (i8 & 16) != 0 ? null : num3, (i8 & 32) != 0 ? null : num4, (i8 & 64) == 0 ? bool : null);
        }

        @Override // eu.bolt.verification.sdk.internal.aa
        public Boolean a() {
            return this.f42017m;
        }

        public final Integer b() {
            return this.f42015k;
        }

        public final Integer c() {
            return this.f42014j;
        }

        public final Integer d() {
            return this.f42016l;
        }

        public final f e() {
            return this.f42013i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof g) {
                g gVar = (g) obj;
                return Intrinsics.a(this.f42011g, gVar.f42011g) && Intrinsics.a(this.f42012h, gVar.f42012h) && Intrinsics.a(this.f42013i, gVar.f42013i) && Intrinsics.a(this.f42014j, gVar.f42014j) && Intrinsics.a(this.f42015k, gVar.f42015k) && Intrinsics.a(this.f42016l, gVar.f42016l) && Intrinsics.a(a(), gVar.a());
            }
            return false;
        }

        public final Integer f() {
            return this.f42012h;
        }

        public final String g() {
            return this.f42011g;
        }

        public int hashCode() {
            int hashCode = this.f42011g.hashCode() * 31;
            Integer num = this.f42012h;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            f fVar = this.f42013i;
            int hashCode3 = (hashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 31;
            Integer num2 = this.f42014j;
            int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.f42015k;
            int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.f42016l;
            return ((hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31) + (a() != null ? a().hashCode() : 0);
        }

        public String toString() {
            String str = this.f42011g;
            Integer num = this.f42012h;
            f fVar = this.f42013i;
            Integer num2 = this.f42014j;
            Integer num3 = this.f42015k;
            Integer num4 = this.f42016l;
            Boolean a8 = a();
            return "WebImage(url=" + str + ", tint=" + num + ", size=" + fVar + ", placeholderRes=" + num2 + ", errorRes=" + num3 + ", placeholderTint=" + num4 + ", roundDrawable=" + a8 + ")";
        }
    }

    private aa(Boolean bool) {
        this.f41988f = bool;
    }

    public /* synthetic */ aa(Boolean bool, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : bool, null);
    }

    public /* synthetic */ aa(Boolean bool, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool);
    }

    public Boolean a() {
        return this.f41988f;
    }
}
