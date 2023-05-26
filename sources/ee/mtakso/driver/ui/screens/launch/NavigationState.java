package ee.mtakso.driver.ui.screens.launch;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationState.kt */
/* loaded from: classes3.dex */
public interface NavigationState {

    /* compiled from: NavigationState.kt */
    /* loaded from: classes3.dex */
    public static final class Landing implements NavigationState {

        /* renamed from: a  reason: collision with root package name */
        private final Throwable f30436a;

        public Landing() {
            this(null, 1, null);
        }

        public Landing(Throwable th) {
            this.f30436a = th;
        }

        public final Throwable a() {
            return this.f30436a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Landing) && Intrinsics.a(this.f30436a, ((Landing) obj).f30436a);
        }

        public int hashCode() {
            Throwable th = this.f30436a;
            if (th == null) {
                return 0;
            }
            return th.hashCode();
        }

        public String toString() {
            Throwable th = this.f30436a;
            return "Landing(error=" + th + ")";
        }

        public /* synthetic */ Landing(Throwable th, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? null : th);
        }
    }

    /* compiled from: NavigationState.kt */
    /* loaded from: classes3.dex */
    public static final class SignUp implements NavigationState {

        /* renamed from: a  reason: collision with root package name */
        public static final SignUp f30437a = new SignUp();

        private SignUp() {
        }
    }

    /* compiled from: NavigationState.kt */
    /* loaded from: classes3.dex */
    public static final class Splash implements NavigationState {

        /* renamed from: a  reason: collision with root package name */
        public static final Splash f30438a = new Splash();

        private Splash() {
        }
    }
}
