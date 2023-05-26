package eu.bolt.driver.voip.service.call;

import ee.mtakso.voip_client.VoipCall;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallState.kt */
/* loaded from: classes5.dex */
public enum CallState {
    CREATED,
    ESTABLISHING,
    ESTABLISHED,
    ENDED;
    

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f41635f = new Companion(null);

    /* compiled from: CallState.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* compiled from: CallState.kt */
        /* loaded from: classes5.dex */
        public /* synthetic */ class WhenMappings {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f41641a;

            static {
                int[] iArr = new int[VoipCall.State.values().length];
                try {
                    iArr[VoipCall.State.CREATED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[VoipCall.State.ESTABLISHING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[VoipCall.State.ESTABLISHED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[VoipCall.State.ENDED.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f41641a = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CallState a(VoipCall.State state) {
            Intrinsics.f(state, "state");
            int i8 = WhenMappings.f41641a[state.ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 == 4) {
                            return CallState.ENDED;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return CallState.ESTABLISHED;
                }
                return CallState.ESTABLISHING;
            }
            return CallState.CREATED;
        }
    }
}
