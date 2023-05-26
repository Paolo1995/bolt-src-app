package ee.mtakso.driver.service.modules.status;

import ee.mtakso.driver.network.client.driver.DriverMightBeBlocked;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoOnlineStepResult.kt */
/* loaded from: classes3.dex */
public abstract class GoOnlineStepResult {

    /* compiled from: GoOnlineStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class Error extends GoOnlineStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final Throwable f25280a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable throwable) {
            super(null);
            Intrinsics.f(throwable, "throwable");
            this.f25280a = throwable;
        }

        public final Throwable a() {
            return this.f25280a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.a(this.f25280a, ((Error) obj).f25280a);
        }

        public int hashCode() {
            return this.f25280a.hashCode();
        }

        public String toString() {
            Throwable th = this.f25280a;
            return "Error(throwable=" + th + ")";
        }
    }

    /* compiled from: GoOnlineStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class LocationCheck extends GoOnlineStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final GeoLocationManagerState f25281a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocationCheck(GeoLocationManagerState state) {
            super(null);
            Intrinsics.f(state, "state");
            this.f25281a = state;
        }

        public final GeoLocationManagerState a() {
            return this.f25281a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LocationCheck) && this.f25281a == ((LocationCheck) obj).f25281a;
        }

        public int hashCode() {
            return this.f25281a.hashCode();
        }

        public String toString() {
            GeoLocationManagerState geoLocationManagerState = this.f25281a;
            return "LocationCheck(state=" + geoLocationManagerState + ")";
        }
    }

    /* compiled from: GoOnlineStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class StartWorking extends GoOnlineStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final DriverMightBeBlocked f25282a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartWorking(DriverMightBeBlocked driverMightBeBlocked) {
            super(null);
            Intrinsics.f(driverMightBeBlocked, "driverMightBeBlocked");
            this.f25282a = driverMightBeBlocked;
        }

        public final DriverMightBeBlocked a() {
            return this.f25282a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StartWorking) && Intrinsics.a(this.f25282a, ((StartWorking) obj).f25282a);
        }

        public int hashCode() {
            return this.f25282a.hashCode();
        }

        public String toString() {
            DriverMightBeBlocked driverMightBeBlocked = this.f25282a;
            return "StartWorking(driverMightBeBlocked=" + driverMightBeBlocked + ")";
        }
    }

    private GoOnlineStepResult() {
    }

    public /* synthetic */ GoOnlineStepResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
