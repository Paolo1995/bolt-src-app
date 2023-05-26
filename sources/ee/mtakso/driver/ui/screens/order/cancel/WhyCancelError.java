package ee.mtakso.driver.ui.screens.order.cancel;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WhyCancelError.kt */
/* loaded from: classes3.dex */
public abstract class WhyCancelError {

    /* compiled from: WhyCancelError.kt */
    /* loaded from: classes3.dex */
    public static final class CantCancel extends WhyCancelError {

        /* renamed from: a  reason: collision with root package name */
        private final long f31275a;

        public CantCancel(long j8) {
            super(null);
            this.f31275a = j8;
        }

        public final long a() {
            return this.f31275a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CantCancel) && this.f31275a == ((CantCancel) obj).f31275a;
        }

        public int hashCode() {
            return i0.a.a(this.f31275a);
        }

        public String toString() {
            long j8 = this.f31275a;
            return "CantCancel(timeToWait=" + j8 + ")";
        }
    }

    /* compiled from: WhyCancelError.kt */
    /* loaded from: classes3.dex */
    public static final class EmptyNotAllowed extends WhyCancelError {

        /* renamed from: a  reason: collision with root package name */
        public static final EmptyNotAllowed f31276a = new EmptyNotAllowed();

        private EmptyNotAllowed() {
            super(null);
        }
    }

    /* compiled from: WhyCancelError.kt */
    /* loaded from: classes3.dex */
    public static final class None extends WhyCancelError {

        /* renamed from: a  reason: collision with root package name */
        public static final None f31277a = new None();

        private None() {
            super(null);
        }
    }

    private WhyCancelError() {
    }

    public /* synthetic */ WhyCancelError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
