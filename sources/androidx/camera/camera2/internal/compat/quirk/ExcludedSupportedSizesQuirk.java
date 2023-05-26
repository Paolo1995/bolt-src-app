package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirk;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.sinch.android.rtc.internal.InternalErrorCodes;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class ExcludedSupportedSizesQuirk implements Quirk {
    @NonNull
    private List<Size> b(@NonNull String str, int i8) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0") && (i8 == 34 || i8 == 35)) {
            arrayList.add(new Size(PeerConnectionUtils.HD_VIDEO_HEIGHT, PeerConnectionUtils.HD_VIDEO_HEIGHT));
            arrayList.add(new Size(400, 400));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> c(@NonNull String str, int i8) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0") && i8 == 256) {
            arrayList.add(new Size(4160, 3120));
            arrayList.add(new Size(InternalErrorCodes.ApiCallFailed, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> d(@NonNull String str, int i8) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0") && i8 == 256) {
            arrayList.add(new Size(4160, 3120));
            arrayList.add(new Size(InternalErrorCodes.ApiCallFailed, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> e(@NonNull String str, int i8) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0")) {
            if (i8 != 34) {
                if (i8 == 35) {
                    arrayList.add(new Size(2048, 1536));
                    arrayList.add(new Size(2048, 1152));
                    arrayList.add(new Size(1920, 1080));
                }
            } else {
                arrayList.add(new Size(4128, 3096));
                arrayList.add(new Size(4128, 2322));
                arrayList.add(new Size(3088, 3088));
                arrayList.add(new Size(3264, 2448));
                arrayList.add(new Size(3264, 1836));
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(1920, 1080));
            }
        } else if (str.equals("1") && (i8 == 34 || i8 == 35)) {
            arrayList.add(new Size(2576, 1932));
            arrayList.add(new Size(2560, 1440));
            arrayList.add(new Size(1920, 1920));
            arrayList.add(new Size(2048, 1536));
            arrayList.add(new Size(2048, 1152));
            arrayList.add(new Size(1920, 1080));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> f(@NonNull String str, int i8) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0")) {
            if (i8 != 34) {
                if (i8 == 35) {
                    arrayList.add(new Size(4128, 2322));
                    arrayList.add(new Size(3088, 3088));
                    arrayList.add(new Size(3264, 2448));
                    arrayList.add(new Size(3264, 1836));
                    arrayList.add(new Size(2048, 1536));
                    arrayList.add(new Size(2048, 1152));
                    arrayList.add(new Size(1920, 1080));
                }
            } else {
                arrayList.add(new Size(4128, 3096));
                arrayList.add(new Size(4128, 2322));
                arrayList.add(new Size(3088, 3088));
                arrayList.add(new Size(3264, 2448));
                arrayList.add(new Size(3264, 1836));
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(1920, 1080));
            }
        } else if (str.equals("1") && (i8 == 34 || i8 == 35)) {
            arrayList.add(new Size(3264, 2448));
            arrayList.add(new Size(3264, 1836));
            arrayList.add(new Size(2448, 2448));
            arrayList.add(new Size(1920, 1920));
            arrayList.add(new Size(2048, 1536));
            arrayList.add(new Size(2048, 1152));
            arrayList.add(new Size(1920, 1080));
        }
        return arrayList;
    }

    private static boolean g() {
        if ("HUAWEI".equalsIgnoreCase(Build.BRAND) && "HWANE".equalsIgnoreCase(Build.DEVICE)) {
            return true;
        }
        return false;
    }

    private static boolean h() {
        if ("OnePlus".equalsIgnoreCase(Build.BRAND) && "OnePlus6".equalsIgnoreCase(Build.DEVICE)) {
            return true;
        }
        return false;
    }

    private static boolean i() {
        if ("OnePlus".equalsIgnoreCase(Build.BRAND) && "OnePlus6T".equalsIgnoreCase(Build.DEVICE)) {
            return true;
        }
        return false;
    }

    private static boolean j() {
        String str = Build.BRAND;
        Locale locale = Locale.US;
        if ("SAMSUNG".equalsIgnoreCase(str.toUpperCase(locale)) && "J7XELTE".equalsIgnoreCase(Build.DEVICE.toUpperCase(locale)) && Build.VERSION.SDK_INT >= 27) {
            return true;
        }
        return false;
    }

    private static boolean k() {
        String str = Build.BRAND;
        Locale locale = Locale.US;
        if ("SAMSUNG".equalsIgnoreCase(str.toUpperCase(locale)) && "ON7XELTE".equalsIgnoreCase(Build.DEVICE.toUpperCase(locale)) && Build.VERSION.SDK_INT >= 27) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean l() {
        if (!h() && !i() && !g() && !k() && !j()) {
            return false;
        }
        return true;
    }

    @NonNull
    public List<Size> a(@NonNull String str, int i8) {
        if (h()) {
            return c(str, i8);
        }
        if (i()) {
            return d(str, i8);
        }
        if (g()) {
            return b(str, i8);
        }
        if (k()) {
            return f(str, i8);
        }
        if (j()) {
            return e(str, i8);
        }
        Logger.k("ExcludedSupportedSizesQuirk", "Cannot retrieve list of supported sizes to exclude on this device.");
        return Collections.emptyList();
    }
}
