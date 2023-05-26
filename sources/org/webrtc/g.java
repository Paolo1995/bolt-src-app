package org.webrtc;

import javax.microedition.khronos.egl.EGLContext;
import org.webrtc.EglBase;
import org.webrtc.EglBase10;
import org.webrtc.EglBase14;

/* loaded from: classes4.dex */
public final /* synthetic */ class g {
    static {
        Object obj = EglBase.lock;
    }

    public static EglBase.ConfigBuilder a() {
        return new EglBase.ConfigBuilder();
    }

    public static EglBase b() {
        return d(null, EglBase.CONFIG_PLAIN);
    }

    public static EglBase c(EglBase.Context context) {
        return d(context, EglBase.CONFIG_PLAIN);
    }

    public static EglBase d(EglBase.Context context, int[] iArr) {
        if (context == null) {
            return EglBase14Impl.isEGL14Supported() ? j(iArr) : g(iArr);
        } else if (context instanceof EglBase14.Context) {
            return i((EglBase14.Context) context, iArr);
        } else {
            if (context instanceof EglBase10.Context) {
                return f((EglBase10.Context) context, iArr);
            }
            throw new IllegalArgumentException("Unrecognized Context");
        }
    }

    public static EglBase10 e(EGLContext eGLContext, int[] iArr) {
        return new EglBase10Impl(eGLContext, iArr);
    }

    public static EglBase10 f(EglBase10.Context context, int[] iArr) {
        return new EglBase10Impl(context == null ? null : context.getRawContext(), iArr);
    }

    public static EglBase10 g(int[] iArr) {
        return new EglBase10Impl(null, iArr);
    }

    public static EglBase14 h(android.opengl.EGLContext eGLContext, int[] iArr) {
        return new EglBase14Impl(eGLContext, iArr);
    }

    public static EglBase14 i(EglBase14.Context context, int[] iArr) {
        return new EglBase14Impl(context == null ? null : context.getRawContext(), iArr);
    }

    public static EglBase14 j(int[] iArr) {
        return new EglBase14Impl(null, iArr);
    }

    public static int k(int[] iArr) {
        for (int i8 = 0; i8 < iArr.length - 1; i8++) {
            if (iArr[i8] == 12352) {
                int i9 = iArr[i8 + 1];
                if (i9 != 4) {
                    return i9 != 64 ? 1 : 3;
                }
                return 2;
            }
        }
        return 1;
    }
}
