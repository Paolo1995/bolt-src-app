package ee.mtakso.driver.ui.screens.update;

import ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult;
import ee.mtakso.driver.ui.helper.ErrorDialogDelegate;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleServicesUpdateDelegate.kt */
/* loaded from: classes5.dex */
public final class GoogleServicesUpdateDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final RoutingManager f33489a;

    /* renamed from: b  reason: collision with root package name */
    private final ErrorDialogDelegate f33490b;

    /* compiled from: GoogleServicesUpdateDelegate.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33491a;

        static {
            int[] iArr = new int[StoreIntegrityVerificationResult.ErrorType.values().length];
            try {
                iArr[StoreIntegrityVerificationResult.ErrorType.PLAY_STORE_UPDATE_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StoreIntegrityVerificationResult.ErrorType.PLAY_SERVICE_UPDATE_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f33491a = iArr;
        }
    }

    public GoogleServicesUpdateDelegate(RoutingManager routingManager, ErrorDialogDelegate errorDialogDelegate) {
        Intrinsics.f(routingManager, "routingManager");
        Intrinsics.f(errorDialogDelegate, "errorDialogDelegate");
        this.f33489a = routingManager;
        this.f33490b = errorDialogDelegate;
    }

    public final void a(Throwable error) {
        StoreIntegrityVerificationResult.Error error2;
        int i8;
        Intrinsics.f(error, "error");
        StoreIntegrityVerificationResult.ErrorType errorType = null;
        if (error instanceof StoreIntegrityVerificationResult.Error) {
            error2 = (StoreIntegrityVerificationResult.Error) error;
        } else {
            error2 = null;
        }
        if (error2 != null) {
            errorType = error2.b();
        }
        if (errorType == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f33491a[errorType.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                this.f33490b.a(error);
                return;
            } else {
                this.f33489a.b(MandatoryUpdateFragment.f33492p.b(MandatoryUpdateFragmentParams.PLAY_SERVICE_UPDATE_REQUIRED), true);
                return;
            }
        }
        this.f33489a.b(MandatoryUpdateFragment.f33492p.b(MandatoryUpdateFragmentParams.PLAY_STORE_UPDATE_REQUIRED), true);
    }
}
