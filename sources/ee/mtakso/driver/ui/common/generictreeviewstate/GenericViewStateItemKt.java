package ee.mtakso.driver.ui.common.generictreeviewstate;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.generic.ValueMark;
import ee.mtakso.driver.network.client.generic.ValueStyle;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericItemDelegate;
import ee.mtakso.driver.uikit.utils.Color;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GenericViewStateItem.kt */
/* loaded from: classes3.dex */
public final class GenericViewStateItemKt {

    /* compiled from: GenericViewStateItem.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26355a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f26356b;

        static {
            int[] iArr = new int[ValueMark.values().length];
            try {
                iArr[ValueMark.IMPORTANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ValueMark.HIGHLIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ValueMark.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f26355a = iArr;
            int[] iArr2 = new int[ValueStyle.values().length];
            try {
                iArr2[ValueStyle.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ValueStyle.BOLD.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            f26356b = iArr2;
        }
    }

    public static final Color.Attr a(ValueMark valueMark) {
        Intrinsics.f(valueMark, "<this>");
        int i8 = WhenMappings.f26355a[valueMark.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return new Color.Attr(R.attr.contentPrimary);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new Color.Attr(R.attr.contentPrimary);
        }
        return new Color.Attr(R.attr.accentRed);
    }

    public static final int b(ValueMark valueMark) {
        Intrinsics.f(valueMark, "<this>");
        int i8 = WhenMappings.f26355a[valueMark.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return R.color.neutral400;
                }
                throw new NoWhenBranchMatchedException();
            }
            return R.color.white;
        }
        return R.color.red500;
    }

    public static final GenericItemDelegate.TextStyle c(ValueStyle valueStyle) {
        Intrinsics.f(valueStyle, "<this>");
        int i8 = WhenMappings.f26356b[valueStyle.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return GenericItemDelegate.TextStyle.BOLD;
            }
            throw new NoWhenBranchMatchedException();
        }
        return GenericItemDelegate.TextStyle.NORMAL;
    }
}
