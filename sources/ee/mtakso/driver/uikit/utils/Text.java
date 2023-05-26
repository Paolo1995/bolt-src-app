package ee.mtakso.driver.uikit.utils;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Text.kt */
/* loaded from: classes5.dex */
public abstract class Text {

    /* compiled from: Text.kt */
    /* loaded from: classes5.dex */
    public static final class Value extends Text {

        /* renamed from: a  reason: collision with root package name */
        private final CharSequence f36065a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Value(CharSequence value) {
            super(null);
            Intrinsics.f(value, "value");
            this.f36065a = value;
        }

        public final CharSequence a() {
            return this.f36065a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Value) && Intrinsics.a(this.f36065a, ((Value) obj).f36065a);
        }

        public int hashCode() {
            return this.f36065a.hashCode();
        }

        public String toString() {
            CharSequence charSequence = this.f36065a;
            return "Value(value=" + ((Object) charSequence) + ")";
        }
    }

    private Text() {
    }

    public /* synthetic */ Text(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: Text.kt */
    /* loaded from: classes5.dex */
    public static final class Resource extends Text {

        /* renamed from: a  reason: collision with root package name */
        private final int f36063a;

        /* renamed from: b  reason: collision with root package name */
        private final List<Object> f36064b;

        public /* synthetic */ Resource(int i8, List list, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(i8, (i9 & 2) != 0 ? CollectionsKt__CollectionsKt.k() : list);
        }

        public final List<Object> a() {
            return this.f36064b;
        }

        public final int b() {
            return this.f36063a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Resource) {
                Resource resource = (Resource) obj;
                return this.f36063a == resource.f36063a && Intrinsics.a(this.f36064b, resource.f36064b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f36063a * 31) + this.f36064b.hashCode();
        }

        public String toString() {
            int i8 = this.f36063a;
            List<Object> list = this.f36064b;
            return "Resource(resource=" + i8 + ", args=" + list + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Resource(int i8, List<? extends Object> args) {
            super(null);
            Intrinsics.f(args, "args");
            this.f36063a = i8;
            this.f36064b = args;
        }
    }
}
