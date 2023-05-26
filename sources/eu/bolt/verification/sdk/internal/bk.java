package eu.bolt.verification.sdk.internal;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class bk {

    /* renamed from: a  reason: collision with root package name */
    private final c f42356a;

    /* renamed from: b  reason: collision with root package name */
    private final int f42357b;

    /* renamed from: c  reason: collision with root package name */
    private final int f42358c;

    /* renamed from: d  reason: collision with root package name */
    private final List<b> f42359d;

    /* loaded from: classes5.dex */
    public enum a {
        START,
        CENTER,
        END
    }

    /* loaded from: classes5.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        private final a f42364a;

        /* loaded from: classes5.dex */
        public static final class a extends b {

            /* renamed from: b  reason: collision with root package name */
            private final tj f42365b;

            /* renamed from: c  reason: collision with root package name */
            private final a f42366c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(tj image, a align) {
                super(align, null);
                Intrinsics.f(image, "image");
                Intrinsics.f(align, "align");
                this.f42365b = image;
                this.f42366c = align;
            }

            public a a() {
                return this.f42366c;
            }

            public final tj b() {
                return this.f42365b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.a(this.f42365b, aVar.f42365b) && a() == aVar.a();
                }
                return false;
            }

            public int hashCode() {
                return (this.f42365b.hashCode() * 31) + a().hashCode();
            }

            public String toString() {
                tj tjVar = this.f42365b;
                a a8 = a();
                return "Asset(image=" + tjVar + ", align=" + a8 + ")";
            }
        }

        /* renamed from: eu.bolt.verification.sdk.internal.bk$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0037b extends b {

            /* renamed from: b  reason: collision with root package name */
            private final String f42367b;

            /* renamed from: c  reason: collision with root package name */
            private final String f42368c;

            /* renamed from: d  reason: collision with root package name */
            private final a f42369d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0037b(String str, String text, a align) {
                super(align, null);
                Intrinsics.f(text, "text");
                Intrinsics.f(align, "align");
                this.f42367b = str;
                this.f42368c = text;
                this.f42369d = align;
            }

            public a a() {
                return this.f42369d;
            }

            public final String b() {
                return this.f42367b;
            }

            public final String c() {
                return this.f42368c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof C0037b) {
                    C0037b c0037b = (C0037b) obj;
                    return Intrinsics.a(this.f42367b, c0037b.f42367b) && Intrinsics.a(this.f42368c, c0037b.f42368c) && a() == c0037b.a();
                }
                return false;
            }

            public int hashCode() {
                String str = this.f42367b;
                return ((((str == null ? 0 : str.hashCode()) * 31) + this.f42368c.hashCode()) * 31) + a().hashCode();
            }

            public String toString() {
                String str = this.f42367b;
                String str2 = this.f42368c;
                a a8 = a();
                return "Text(iconUrl=" + str + ", text=" + str2 + ", align=" + a8 + ")";
            }
        }

        private b(a aVar) {
            this.f42364a = aVar;
        }

        public /* synthetic */ b(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
            this(aVar);
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final int f42370a;

        /* renamed from: b  reason: collision with root package name */
        private final int f42371b;

        /* renamed from: c  reason: collision with root package name */
        private final int f42372c;

        /* renamed from: d  reason: collision with root package name */
        private final int f42373d;

        public c(int i8, int i9, int i10, int i11) {
            this.f42370a = i8;
            this.f42371b = i9;
            this.f42372c = i10;
            this.f42373d = i11;
        }

        public final int a() {
            return this.f42372c;
        }

        public final int b() {
            return this.f42371b;
        }

        public final int c() {
            return this.f42373d;
        }

        public final int d() {
            return this.f42370a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.f42370a == cVar.f42370a && this.f42371b == cVar.f42371b && this.f42372c == cVar.f42372c && this.f42373d == cVar.f42373d;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f42370a * 31) + this.f42371b) * 31) + this.f42372c) * 31) + this.f42373d;
        }

        public String toString() {
            int i8 = this.f42370a;
            int i9 = this.f42371b;
            int i10 = this.f42372c;
            int i11 = this.f42373d;
            return "Padding(top=" + i8 + ", left=" + i9 + ", bottom=" + i10 + ", right=" + i11 + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public bk(c padding, int i8, int i9, List<? extends b> items) {
        Intrinsics.f(padding, "padding");
        Intrinsics.f(items, "items");
        this.f42356a = padding;
        this.f42357b = i8;
        this.f42358c = i9;
        this.f42359d = items;
    }

    public final int a() {
        return this.f42358c;
    }

    public final List<b> b() {
        return this.f42359d;
    }

    public final int c() {
        return this.f42357b;
    }

    public final c d() {
        return this.f42356a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bk) {
            bk bkVar = (bk) obj;
            return Intrinsics.a(this.f42356a, bkVar.f42356a) && this.f42357b == bkVar.f42357b && this.f42358c == bkVar.f42358c && Intrinsics.a(this.f42359d, bkVar.f42359d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f42356a.hashCode() * 31) + this.f42357b) * 31) + this.f42358c) * 31) + this.f42359d.hashCode();
    }

    public String toString() {
        c cVar = this.f42356a;
        int i8 = this.f42357b;
        int i9 = this.f42358c;
        List<b> list = this.f42359d;
        return "StorySlideContent(padding=" + cVar + ", itemsSpacing=" + i8 + ", backgroundColor=" + i9 + ", items=" + list + ")";
    }
}
