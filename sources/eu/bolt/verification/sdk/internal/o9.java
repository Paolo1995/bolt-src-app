package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class o9 extends ob {

    /* renamed from: f  reason: collision with root package name */
    private final String f44442f;

    /* renamed from: g  reason: collision with root package name */
    private final b f44443g;

    /* renamed from: h  reason: collision with root package name */
    private final a f44444h;

    /* loaded from: classes5.dex */
    public enum a {
        FILL_WIDTH,
        FILL_HEIGHT,
        CENTER
    }

    /* loaded from: classes5.dex */
    public static abstract class b implements Serializable {

        /* loaded from: classes5.dex */
        public static final class a extends b {

            /* renamed from: f  reason: collision with root package name */
            private final String f44449f;

            /* renamed from: g  reason: collision with root package name */
            private final ec f44450g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String fieldId, ec overlay) {
                super(null);
                Intrinsics.f(fieldId, "fieldId");
                Intrinsics.f(overlay, "overlay");
                this.f44449f = fieldId;
                this.f44450g = overlay;
            }

            public final String a() {
                return this.f44449f;
            }

            public final ec b() {
                return this.f44450g;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.a(this.f44449f, aVar.f44449f) && Intrinsics.a(this.f44450g, aVar.f44450g);
                }
                return false;
            }

            public int hashCode() {
                return (this.f44449f.hashCode() * 31) + this.f44450g.hashCode();
            }

            public String toString() {
                String str = this.f44449f;
                ec ecVar = this.f44450g;
                return "Preview(fieldId=" + str + ", overlay=" + ecVar + ")";
            }
        }

        /* renamed from: eu.bolt.verification.sdk.internal.o9$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0081b extends b {

            /* renamed from: f  reason: collision with root package name */
            private final String f44451f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0081b(String url) {
                super(null);
                Intrinsics.f(url, "url");
                this.f44451f = url;
            }

            public final String a() {
                return this.f44451f;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0081b) && Intrinsics.a(this.f44451f, ((C0081b) obj).f44451f);
            }

            public int hashCode() {
                return this.f44451f.hashCode();
            }

            public String toString() {
                String str = this.f44451f;
                return "Url(url=" + str + ")";
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public o9(String id, b source, a fillType) {
        Intrinsics.f(id, "id");
        Intrinsics.f(source, "source");
        Intrinsics.f(fillType, "fillType");
        this.f44442f = id;
        this.f44443g = source;
        this.f44444h = fillType;
    }

    @Override // eu.bolt.verification.sdk.internal.ob
    public String a() {
        return this.f44442f;
    }

    public final a b() {
        return this.f44444h;
    }

    public final b c() {
        return this.f44443g;
    }
}
