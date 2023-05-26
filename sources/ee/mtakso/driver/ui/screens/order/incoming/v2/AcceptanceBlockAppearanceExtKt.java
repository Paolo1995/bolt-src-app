package ee.mtakso.driver.ui.screens.order.incoming.v2;

import ee.mtakso.driver.network.client.order.AcceptanceBlockAppearance;
import ee.mtakso.driver.network.client.order.Order;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AcceptanceBlockAppearanceExt.kt */
/* loaded from: classes3.dex */
public final class AcceptanceBlockAppearanceExtKt {

    /* compiled from: AcceptanceBlockAppearanceExt.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31355a;

        static {
            int[] iArr = new int[AcceptanceBlockAppearance.values().length];
            try {
                iArr[AcceptanceBlockAppearance.ACTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AcceptanceBlockAppearance.PRIMARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AcceptanceBlockAppearance.NEUTRAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f31355a = iArr;
        }
    }

    public static final IncomingOrderStyle a(Order order) {
        Intrinsics.f(order, "<this>");
        AcceptanceBlockAppearance a8 = order.a();
        if (a8 == null) {
            a8 = AcceptanceBlockAppearance.PRIMARY;
        }
        return b(a8);
    }

    public static final IncomingOrderStyle b(AcceptanceBlockAppearance acceptanceBlockAppearance) {
        Intrinsics.f(acceptanceBlockAppearance, "<this>");
        int i8 = WhenMappings.f31355a[acceptanceBlockAppearance.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return IncomingOrderStyle.NEUTRAL;
                }
                throw new NoWhenBranchMatchedException();
            }
            return IncomingOrderStyle.PRIMARY;
        }
        return IncomingOrderStyle.ACTION;
    }
}
