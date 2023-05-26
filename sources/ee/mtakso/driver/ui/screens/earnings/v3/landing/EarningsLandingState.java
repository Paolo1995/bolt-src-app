package ee.mtakso.driver.ui.screens.earnings.v3.landing;

import eu.bolt.driver.earnings.network.EarningLandingScreen;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsLandingState.kt */
/* loaded from: classes3.dex */
public abstract class EarningsLandingState {

    /* compiled from: EarningsLandingState.kt */
    /* loaded from: classes3.dex */
    public static final class Error extends EarningsLandingState {

        /* renamed from: a  reason: collision with root package name */
        private final Throwable f29344a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable error) {
            super(null);
            Intrinsics.f(error, "error");
            this.f29344a = error;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.a(this.f29344a, ((Error) obj).f29344a);
        }

        public int hashCode() {
            return this.f29344a.hashCode();
        }

        public String toString() {
            Throwable th = this.f29344a;
            return "Error(error=" + th + ")";
        }
    }

    /* compiled from: EarningsLandingState.kt */
    /* loaded from: classes3.dex */
    public static final class Loading extends EarningsLandingState {

        /* renamed from: a  reason: collision with root package name */
        public static final Loading f29345a = new Loading();

        private Loading() {
            super(null);
        }
    }

    /* compiled from: EarningsLandingState.kt */
    /* loaded from: classes3.dex */
    public static final class Ready extends EarningsLandingState {

        /* renamed from: a  reason: collision with root package name */
        private final EarningLandingScreen f29346a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ready(EarningLandingScreen data) {
            super(null);
            Intrinsics.f(data, "data");
            this.f29346a = data;
        }

        public final EarningLandingScreen a() {
            return this.f29346a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ready) && Intrinsics.a(this.f29346a, ((Ready) obj).f29346a);
        }

        public int hashCode() {
            return this.f29346a.hashCode();
        }

        public String toString() {
            EarningLandingScreen earningLandingScreen = this.f29346a;
            return "Ready(data=" + earningLandingScreen + ")";
        }
    }

    /* compiled from: EarningsLandingState.kt */
    /* loaded from: classes3.dex */
    public static final class Retrying extends EarningsLandingState {

        /* renamed from: a  reason: collision with root package name */
        public static final Retrying f29347a = new Retrying();

        private Retrying() {
            super(null);
        }
    }

    private EarningsLandingState() {
    }

    public /* synthetic */ EarningsLandingState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
