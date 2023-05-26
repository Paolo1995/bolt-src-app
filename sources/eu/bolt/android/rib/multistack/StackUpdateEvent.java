package eu.bolt.android.rib.multistack;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: StackUpdateEvent.kt */
/* loaded from: classes5.dex */
public abstract class StackUpdateEvent implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final String f37230f;

    /* renamed from: g  reason: collision with root package name */
    private final String f37231g;

    /* compiled from: StackUpdateEvent.kt */
    /* loaded from: classes5.dex */
    public static final class CancelStateRestoration extends StackUpdateEvent {

        /* renamed from: h  reason: collision with root package name */
        private final String f37232h;

        /* renamed from: i  reason: collision with root package name */
        private final String f37233i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CancelStateRestoration(String stackKey, String internalTagPath) {
            super(stackKey, internalTagPath, null);
            Intrinsics.f(stackKey, "stackKey");
            Intrinsics.f(internalTagPath, "internalTagPath");
            this.f37232h = stackKey;
            this.f37233i = internalTagPath;
        }

        public final String d() {
            return this.f37232h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CancelStateRestoration) {
                CancelStateRestoration cancelStateRestoration = (CancelStateRestoration) obj;
                return Intrinsics.a(this.f37232h, cancelStateRestoration.f37232h) && Intrinsics.a(this.f37233i, cancelStateRestoration.f37233i);
            }
            return false;
        }

        public int hashCode() {
            return (this.f37232h.hashCode() * 31) + this.f37233i.hashCode();
        }

        public String toString() {
            String str = this.f37232h;
            String str2 = this.f37233i;
            return "CancelStateRestoration(stackKey=" + str + ", internalTagPath=" + str2 + ")";
        }
    }

    /* compiled from: StackUpdateEvent.kt */
    /* loaded from: classes5.dex */
    public static final class NestedChildAdded extends StackUpdateEvent {

        /* renamed from: h  reason: collision with root package name */
        private final String f37234h;

        /* renamed from: i  reason: collision with root package name */
        private final String f37235i;

        /* renamed from: j  reason: collision with root package name */
        private final String f37236j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NestedChildAdded(String stateName, String stackKey, String internalTagPath) {
            super(stackKey, internalTagPath, null);
            Intrinsics.f(stateName, "stateName");
            Intrinsics.f(stackKey, "stackKey");
            Intrinsics.f(internalTagPath, "internalTagPath");
            this.f37234h = stateName;
            this.f37235i = stackKey;
            this.f37236j = internalTagPath;
        }

        public final String d() {
            return this.f37235i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NestedChildAdded) {
                NestedChildAdded nestedChildAdded = (NestedChildAdded) obj;
                return Intrinsics.a(this.f37234h, nestedChildAdded.f37234h) && Intrinsics.a(this.f37235i, nestedChildAdded.f37235i) && Intrinsics.a(this.f37236j, nestedChildAdded.f37236j);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f37234h.hashCode() * 31) + this.f37235i.hashCode()) * 31) + this.f37236j.hashCode();
        }

        public String toString() {
            String str = this.f37234h;
            String str2 = this.f37235i;
            String str3 = this.f37236j;
            return "NestedChildAdded(stateName=" + str + ", stackKey=" + str2 + ", internalTagPath=" + str3 + ")";
        }
    }

    /* compiled from: StackUpdateEvent.kt */
    /* loaded from: classes5.dex */
    public static final class PushedToStack extends StackUpdateEvent {

        /* renamed from: h  reason: collision with root package name */
        private final String f37237h;

        /* renamed from: i  reason: collision with root package name */
        private final String f37238i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PushedToStack(String stackKey, String internalTagPath) {
            super(stackKey, internalTagPath, null);
            Intrinsics.f(stackKey, "stackKey");
            Intrinsics.f(internalTagPath, "internalTagPath");
            this.f37237h = stackKey;
            this.f37238i = internalTagPath;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PushedToStack) {
                PushedToStack pushedToStack = (PushedToStack) obj;
                return Intrinsics.a(this.f37237h, pushedToStack.f37237h) && Intrinsics.a(this.f37238i, pushedToStack.f37238i);
            }
            return false;
        }

        public int hashCode() {
            return (this.f37237h.hashCode() * 31) + this.f37238i.hashCode();
        }

        public String toString() {
            String str = this.f37237h;
            String str2 = this.f37238i;
            return "PushedToStack(stackKey=" + str + ", internalTagPath=" + str2 + ")";
        }
    }

    private StackUpdateEvent(String str, String str2) {
        this.f37230f = str;
        this.f37231g = str2;
    }

    public /* synthetic */ StackUpdateEvent(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public final String a() {
        return this.f37230f;
    }

    public final String b() {
        String V0;
        V0 = StringsKt__StringsKt.V0(this.f37231g, "/", null, 2, null);
        return V0;
    }

    public final String c() {
        return this.f37231g;
    }
}
