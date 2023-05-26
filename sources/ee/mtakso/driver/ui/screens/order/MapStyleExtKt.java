package ee.mtakso.driver.ui.screens.order;

import android.content.Context;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.R;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapStyleExt.kt */
/* loaded from: classes3.dex */
public final class MapStyleExtKt {

    /* compiled from: MapStyleExt.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30971a;

        static {
            int[] iArr = new int[MapStyle.values().length];
            try {
                iArr[MapStyle.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MapStyle.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f30971a = iArr;
        }
    }

    public static final int a(MapStyle mapStyle, Context context) {
        int i8;
        Intrinsics.f(mapStyle, "<this>");
        Intrinsics.f(context, "context");
        int i9 = WhenMappings.f30971a[mapStyle.ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                i8 = R.color.neutral500;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            i8 = R.color.neutral600;
        }
        return ContextCompat.getColor(context, i8);
    }

    public static final int b(MapStyle mapStyle, Context context) {
        Intrinsics.f(mapStyle, "<this>");
        Intrinsics.f(context, "context");
        int i8 = WhenMappings.f30971a[mapStyle.ordinal()];
        if (i8 != 1 && i8 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return ContextCompat.getColor(context, R.color.white);
    }

    public static final <T> T c(MapStyle mapStyle, T t7, T t8) {
        Intrinsics.f(mapStyle, "<this>");
        int i8 = WhenMappings.f30971a[mapStyle.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                if (t8 != null) {
                    return t8;
                }
                return t7;
            }
            throw new NoWhenBranchMatchedException();
        }
        return t7;
    }
}
