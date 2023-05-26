package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public abstract class oi {

    /* loaded from: classes5.dex */
    public static final class a extends oi {

        /* renamed from: a  reason: collision with root package name */
        private final int f44473a;

        /* renamed from: b  reason: collision with root package name */
        private final int f44474b;

        public a(int i8, int i9) {
            super(null);
            this.f44473a = i8;
            this.f44474b = i9;
        }

        public final int a() {
            return this.f44474b;
        }

        public final int b() {
            return this.f44473a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f44473a == aVar.f44473a && this.f44474b == aVar.f44474b;
            }
            return false;
        }

        public int hashCode() {
            return (this.f44473a * 31) + this.f44474b;
        }

        public String toString() {
            int i8 = this.f44473a;
            int i9 = this.f44474b;
            return "Fixed(width=" + i8 + ", height=" + i9 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends oi {

        /* renamed from: a  reason: collision with root package name */
        public static final b f44475a = new b();

        private b() {
            super(null);
        }
    }

    private oi() {
    }

    public /* synthetic */ oi(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
