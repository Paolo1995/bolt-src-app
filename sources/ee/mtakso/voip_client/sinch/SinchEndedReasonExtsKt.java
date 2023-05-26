package ee.mtakso.voip_client.sinch;

import com.sinch.android.rtc.calling.CallEndCause;
import ee.mtakso.voip_client.VoipCall;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SinchEndedReasonExts.kt */
/* loaded from: classes5.dex */
public final class SinchEndedReasonExtsKt {

    /* compiled from: SinchEndedReasonExts.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36583a;

        static {
            int[] iArr = new int[CallEndCause.values().length];
            try {
                iArr[CallEndCause.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CallEndCause.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CallEndCause.HUNG_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CallEndCause.OTHER_DEVICE_ANSWERED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CallEndCause.DENIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CallEndCause.TIMEOUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CallEndCause.NO_ANSWER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[CallEndCause.CANCELED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f36583a = iArr;
        }
    }

    private static final VoipCall.EndReason a(CallEndCause callEndCause) {
        int i8 = WhenMappings.f36583a[callEndCause.ordinal()];
        if (i8 != 5) {
            if (i8 != 6 && i8 != 7 && i8 != 8) {
                return VoipCall.EndReason.ERROR;
            }
            return VoipCall.EndReason.NO_ANSWER_FROM_INCOMING_CONNECTION;
        }
        return VoipCall.EndReason.HANG_UP;
    }

    private static final VoipCall.EndReason b(CallEndCause callEndCause) {
        int i8 = WhenMappings.f36583a[callEndCause.ordinal()];
        if (i8 != 5) {
            if (i8 != 6 && i8 != 7 && i8 != 8) {
                return VoipCall.EndReason.ERROR;
            }
            return VoipCall.EndReason.NO_ANSWER_FROM_OUTGOING_CONNECTION;
        }
        return VoipCall.EndReason.DECLINED_FROM_OUTGOING_CONNECTION;
    }

    public static final VoipCall.EndReason c(CallEndCause callEndCause, boolean z7) {
        Intrinsics.f(callEndCause, "<this>");
        int i8 = WhenMappings.f36583a[callEndCause.ordinal()];
        if (i8 != 1 && i8 != 2) {
            if (i8 != 3) {
                if (i8 != 4) {
                    if (z7) {
                        return a(callEndCause);
                    }
                    return b(callEndCause);
                }
                return VoipCall.EndReason.OTHER_DEVICE_ANSWERED;
            }
            return VoipCall.EndReason.HANG_UP;
        }
        return VoipCall.EndReason.ERROR;
    }
}
