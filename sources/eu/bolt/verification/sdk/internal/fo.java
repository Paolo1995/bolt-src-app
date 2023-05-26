package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.core.domain.model.VerificationFlowStatus;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class fo {

    /* renamed from: a  reason: collision with root package name */
    private static final a f43054a = new a(null);

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final VerificationFlowStatus a(String status) {
        Intrinsics.f(status, "status");
        int hashCode = status.hashCode();
        if (hashCode != -1994383672) {
            if (hashCode != -753541113) {
                if (hashCode != -511401953) {
                    if (hashCode == 3135262 && status.equals("fail")) {
                        return VerificationFlowStatus.FAIL;
                    }
                } else if (status.equals("verified_not_ok")) {
                    return VerificationFlowStatus.VERIFIED_NOT_OK;
                }
            } else if (status.equals("in_progress")) {
                return VerificationFlowStatus.IN_PROGRESS;
            }
        } else if (status.equals("verified")) {
            return VerificationFlowStatus.VERIFIED_SUCCESS;
        }
        return VerificationFlowStatus.UNKNOWN;
    }
}
