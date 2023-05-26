package ee.mtakso.driver.ui.common;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.generic.HighlightType;
import ee.mtakso.driver.uikit.utils.Color;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HighlightTypeExt.kt */
/* loaded from: classes3.dex */
public final class HighlightTypeExtKt {

    /* compiled from: HighlightTypeExt.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26336a;

        static {
            int[] iArr = new int[HighlightType.values().length];
            try {
                iArr[HighlightType.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HighlightType.OK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HighlightType.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HighlightType.WARNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HighlightType.ALERT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f26336a = iArr;
        }
    }

    public static final Color a(HighlightType highlightType) {
        Intrinsics.f(highlightType, "<this>");
        return new Color.Attr(b(highlightType));
    }

    public static final int b(HighlightType highlightType) {
        Intrinsics.f(highlightType, "<this>");
        int i8 = WhenMappings.f26336a[highlightType.ordinal()];
        if (i8 == 1 || i8 == 2) {
            return R.attr.infoBlockBackgroundTintInfo;
        }
        if (i8 != 3) {
            if (i8 != 4) {
                if (i8 != 5) {
                    return R.attr.infoBlockBackgroundTintInfo;
                }
                return R.attr.infoBlockBackgroundTintAlert;
            }
            return R.attr.infoBlockBackgroundTintWarning;
        }
        return R.attr.infoBlockBackgroundTintSuccess;
    }

    public static final Color c(HighlightType highlightType) {
        Intrinsics.f(highlightType, "<this>");
        return new Color.Attr(d(highlightType));
    }

    public static final int d(HighlightType highlightType) {
        Intrinsics.f(highlightType, "<this>");
        int i8 = WhenMappings.f26336a[highlightType.ordinal()];
        return R.attr.contentPrimary;
    }

    public static final int e(HighlightType highlightType) {
        Intrinsics.f(highlightType, "<this>");
        int i8 = WhenMappings.f26336a[highlightType.ordinal()];
        if (i8 != 1 && i8 != 2 && i8 != 3) {
            if (i8 == 4 || i8 == 5) {
                return R.drawable.ic_alert_72dp;
            }
            return 0;
        }
        return R.drawable.ic_info_circle_fill;
    }

    public static final Color f(HighlightType highlightType) {
        Intrinsics.f(highlightType, "<this>");
        return new Color.Attr(g(highlightType));
    }

    public static final int g(HighlightType highlightType) {
        Intrinsics.f(highlightType, "<this>");
        int i8 = WhenMappings.f26336a[highlightType.ordinal()];
        if (i8 == 1 || i8 == 2) {
            return R.attr.infoBlockIconTintInfo;
        }
        if (i8 != 3) {
            if (i8 != 4) {
                if (i8 != 5) {
                    return R.attr.infoBlockIconTintInfo;
                }
                return R.attr.infoBlockIconTintAlert;
            }
            return R.attr.infoBlockIconTintWarning;
        }
        return R.attr.infoBlockIconTintSuccess;
    }

    public static final Color h(HighlightType highlightType) {
        Intrinsics.f(highlightType, "<this>");
        return new Color.Attr(i(highlightType));
    }

    public static final int i(HighlightType highlightType) {
        Intrinsics.f(highlightType, "<this>");
        int i8 = WhenMappings.f26336a[highlightType.ordinal()];
        if (i8 == 1 || i8 == 2) {
            return R.attr.infoBlockTextInfo;
        }
        if (i8 != 3) {
            if (i8 != 4) {
                if (i8 != 5) {
                    return R.attr.infoBlockTextInfo;
                }
                return R.attr.infoBlockTextAlert;
            }
            return R.attr.infoBlockTextWarning;
        }
        return R.attr.infoBlockTextSuccess;
    }

    public static final Color j(HighlightType highlightType) {
        Intrinsics.f(highlightType, "<this>");
        return new Color.Attr(k(highlightType));
    }

    public static final int k(HighlightType highlightType) {
        Intrinsics.f(highlightType, "<this>");
        int i8 = WhenMappings.f26336a[highlightType.ordinal()];
        if (i8 == 1 || i8 == 2 || i8 == 3) {
            return R.attr.linkAlternative;
        }
        if (i8 != 4) {
            if (i8 != 5) {
                return R.attr.linkAlternative;
            }
            return R.attr.contentCritical;
        }
        return R.attr.accentYellow;
    }

    public static final Color l(HighlightType highlightType) {
        Intrinsics.f(highlightType, "<this>");
        return new Color.Attr(m(highlightType));
    }

    public static final int m(HighlightType highlightType) {
        Intrinsics.f(highlightType, "<this>");
        int i8 = WhenMappings.f26336a[highlightType.ordinal()];
        if (i8 == 1 || i8 == 2 || i8 == 3) {
            return R.attr.contentSecondary;
        }
        if (i8 != 4) {
            if (i8 != 5) {
                return R.attr.contentSecondary;
            }
            return R.attr.contentCritical;
        }
        return R.attr.accentYellow;
    }

    public static final Color n(HighlightType highlightType) {
        Intrinsics.f(highlightType, "<this>");
        return new Color.Attr(o(highlightType));
    }

    public static final int o(HighlightType highlightType) {
        Intrinsics.f(highlightType, "<this>");
        int i8 = WhenMappings.f26336a[highlightType.ordinal()];
        if (i8 != 1 && i8 != 2 && i8 != 3 && (i8 == 4 || i8 == 5)) {
            return R.attr.contentPrimary;
        }
        return R.attr.contentSecondary;
    }
}
