package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.Color;
import eu.bolt.driver.earnings.network.EarningsBalanceStateType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBalanceStateTypeMapper.kt */
/* loaded from: classes3.dex */
public final class EarningsBalanceStateTypeMapper {

    /* compiled from: EarningsBalanceStateTypeMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29050a;

        static {
            int[] iArr = new int[EarningsBalanceStateType.values().length];
            try {
                iArr[EarningsBalanceStateType.NEGATIVE_OVER_THE_LIMIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f29050a = iArr;
        }
    }

    public final Color a(EarningsBalanceStateType type) {
        Intrinsics.f(type, "type");
        if (WhenMappings.f29050a[type.ordinal()] == 1) {
            return new Color.Attr(R.attr.contentCritical);
        }
        return new Color.Attr(R.attr.contentPrimary);
    }
}
