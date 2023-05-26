package ee.mtakso.driver.service.geo.state;

import ee.mtakso.driver.platform.geo.LocationSettingsResult;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeoLocationIssue.kt */
/* loaded from: classes3.dex */
public abstract class GeoLocationIssue {

    /* compiled from: GeoLocationIssue.kt */
    /* loaded from: classes3.dex */
    public static final class Error extends GeoLocationIssue {

        /* renamed from: a  reason: collision with root package name */
        private final Throwable f24425a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable error) {
            super(null);
            Intrinsics.f(error, "error");
            this.f24425a = error;
        }

        public final Throwable a() {
            return this.f24425a;
        }
    }

    /* compiled from: GeoLocationIssue.kt */
    /* loaded from: classes3.dex */
    public static final class InsufficientDevice extends GeoLocationIssue {

        /* renamed from: a  reason: collision with root package name */
        public static final InsufficientDevice f24426a = new InsufficientDevice();

        private InsufficientDevice() {
            super(null);
        }
    }

    /* compiled from: GeoLocationIssue.kt */
    /* loaded from: classes3.dex */
    public static final class PermissionDenied extends GeoLocationIssue {

        /* renamed from: a  reason: collision with root package name */
        public static final PermissionDenied f24427a = new PermissionDenied();

        private PermissionDenied() {
            super(null);
        }
    }

    /* compiled from: GeoLocationIssue.kt */
    /* loaded from: classes3.dex */
    public static final class ResolvableError extends GeoLocationIssue {

        /* renamed from: a  reason: collision with root package name */
        private final LocationSettingsResult.ResolvableError f24428a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResolvableError(LocationSettingsResult.ResolvableError error) {
            super(null);
            Intrinsics.f(error, "error");
            this.f24428a = error;
        }

        public final LocationSettingsResult.ResolvableError a() {
            return this.f24428a;
        }
    }

    /* compiled from: GeoLocationIssue.kt */
    /* loaded from: classes3.dex */
    public static final class UnresolvableError extends GeoLocationIssue {

        /* renamed from: a  reason: collision with root package name */
        public static final UnresolvableError f24429a = new UnresolvableError();

        private UnresolvableError() {
            super(null);
        }
    }

    private GeoLocationIssue() {
    }

    public /* synthetic */ GeoLocationIssue(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
