package eu.bolt.android.engine.html.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Token.kt */
/* loaded from: classes5.dex */
public abstract class Token {

    /* renamed from: a  reason: collision with root package name */
    private final int f36923a;

    /* compiled from: Token.kt */
    /* loaded from: classes5.dex */
    public static final class Days extends Token {

        /* renamed from: b  reason: collision with root package name */
        private final String f36924b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Days(String value) {
            super(4, null);
            Intrinsics.f(value, "value");
            this.f36924b = value;
        }

        public final String b() {
            return this.f36924b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Days) && Intrinsics.a(this.f36924b, ((Days) obj).f36924b);
        }

        public int hashCode() {
            return this.f36924b.hashCode();
        }

        public String toString() {
            String str = this.f36924b;
            return "Days(value=" + str + ")";
        }
    }

    /* compiled from: Token.kt */
    /* loaded from: classes5.dex */
    public static final class Hours extends Token {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f36925b;

        /* renamed from: c  reason: collision with root package name */
        private final String f36926c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Hours(boolean z7, String value) {
            super(3, null);
            Intrinsics.f(value, "value");
            this.f36925b = z7;
            this.f36926c = value;
        }

        public final String b() {
            return this.f36926c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Hours) {
                Hours hours = (Hours) obj;
                return this.f36925b == hours.f36925b && Intrinsics.a(this.f36926c, hours.f36926c);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z7 = this.f36925b;
            ?? r02 = z7;
            if (z7) {
                r02 = 1;
            }
            return (r02 * 31) + this.f36926c.hashCode();
        }

        public String toString() {
            boolean z7 = this.f36925b;
            String str = this.f36926c;
            return "Hours(long=" + z7 + ", value=" + str + ")";
        }
    }

    /* compiled from: Token.kt */
    /* loaded from: classes5.dex */
    public static final class HoursMarker extends Token {

        /* renamed from: b  reason: collision with root package name */
        private final String f36927b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HoursMarker(String value) {
            super(0, null);
            Intrinsics.f(value, "value");
            this.f36927b = value;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HoursMarker) && Intrinsics.a(this.f36927b, ((HoursMarker) obj).f36927b);
        }

        public int hashCode() {
            return this.f36927b.hashCode();
        }

        public String toString() {
            String str = this.f36927b;
            return "HoursMarker(value=" + str + ")";
        }
    }

    /* compiled from: Token.kt */
    /* loaded from: classes5.dex */
    public static final class Minutes extends Token {

        /* renamed from: b  reason: collision with root package name */
        private final String f36928b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Minutes(String value) {
            super(2, null);
            Intrinsics.f(value, "value");
            this.f36928b = value;
        }

        public final String b() {
            return this.f36928b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Minutes) && Intrinsics.a(this.f36928b, ((Minutes) obj).f36928b);
        }

        public int hashCode() {
            return this.f36928b.hashCode();
        }

        public String toString() {
            String str = this.f36928b;
            return "Minutes(value=" + str + ")";
        }
    }

    /* compiled from: Token.kt */
    /* loaded from: classes5.dex */
    public static final class Seconds extends Token {

        /* renamed from: b  reason: collision with root package name */
        private final String f36929b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Seconds(String value) {
            super(1, null);
            Intrinsics.f(value, "value");
            this.f36929b = value;
        }

        public final String b() {
            return this.f36929b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Seconds) && Intrinsics.a(this.f36929b, ((Seconds) obj).f36929b);
        }

        public int hashCode() {
            return this.f36929b.hashCode();
        }

        public String toString() {
            String str = this.f36929b;
            return "Seconds(value=" + str + ")";
        }
    }

    /* compiled from: Token.kt */
    /* loaded from: classes5.dex */
    public static final class Text extends Token {

        /* renamed from: b  reason: collision with root package name */
        private final String f36930b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(String value) {
            super(0, null);
            Intrinsics.f(value, "value");
            this.f36930b = value;
        }

        public final String b() {
            return this.f36930b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Text) && Intrinsics.a(this.f36930b, ((Text) obj).f36930b);
        }

        public int hashCode() {
            return this.f36930b.hashCode();
        }

        public String toString() {
            String str = this.f36930b;
            return "Text(value=" + str + ")";
        }
    }

    private Token(int i8) {
        this.f36923a = i8;
    }

    public /* synthetic */ Token(int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i8);
    }

    public final int a() {
        return this.f36923a;
    }
}
