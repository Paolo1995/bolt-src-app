package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.ClientType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class v1 {

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45423a;

        static {
            int[] iArr = new int[ClientType.values().length];
            try {
                iArr[ClientType.RIDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClientType.DRIVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ClientType.EATER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f45423a = iArr;
        }
    }

    public final kn a(ClientType clientType) {
        Intrinsics.f(clientType, "clientType");
        int i8 = a.f45423a[clientType.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return kn.EATER;
                }
                throw new NoWhenBranchMatchedException();
            }
            return kn.DRIVER;
        }
        return kn.RIDER;
    }
}
