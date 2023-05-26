package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.Color;
import eu.bolt.driver.earnings.network.DriverContentType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverContentTypeMapper.kt */
/* loaded from: classes3.dex */
public final class DriverContentTypeMapper {

    /* compiled from: DriverContentTypeMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29034a;

        static {
            int[] iArr = new int[DriverContentType.values().length];
            try {
                iArr[DriverContentType.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverContentType.SECONDARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverContentType.ACCENT_GREEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DriverContentType.CRITICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f29034a = iArr;
        }
    }

    public final Color a(DriverContentType contentType) {
        Intrinsics.f(contentType, "contentType");
        int i8 = WhenMappings.f29034a[contentType.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        return new Color.Attr(R.attr.contentSecondary);
                    }
                    return new Color.Attr(R.attr.contentCritical);
                }
                return new Color.Attr(R.attr.accentGreen);
            }
            return new Color.Attr(R.attr.contentSecondary);
        }
        return new Color.Attr(R.attr.contentPrimary);
    }
}
