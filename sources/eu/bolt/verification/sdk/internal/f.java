package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class f {

    /* loaded from: classes5.dex */
    public static final class a extends f {

        /* renamed from: a  reason: collision with root package name */
        private final String f42880a;

        public a(String str) {
            super(null);
            this.f42880a = str;
        }

        public final String a() {
            return this.f42880a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f42880a, ((a) obj).f42880a);
        }

        public int hashCode() {
            String str = this.f42880a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            String str = this.f42880a;
            return "ActionButton(label=" + str + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends f {

        /* renamed from: a  reason: collision with root package name */
        private final aa f42881a;

        public final aa a() {
            return this.f42881a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.a(this.f42881a, ((b) obj).f42881a);
        }

        public int hashCode() {
            return this.f42881a.hashCode();
        }

        public String toString() {
            aa aaVar = this.f42881a;
            return "ActionIcon(imageUiModel=" + aaVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends f {

        /* renamed from: a  reason: collision with root package name */
        public static final c f42882a = new c();

        private c() {
            super(null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends f {

        /* renamed from: a  reason: collision with root package name */
        public static final d f42883a = new d();

        private d() {
            super(null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends f {

        /* renamed from: a  reason: collision with root package name */
        public static final e f42884a = new e();

        private e() {
            super(null);
        }
    }

    private f() {
    }

    public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
