package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.SurfaceConfig;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class ExtraCroppingQuirk implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Range<Integer>> f2863a;

    /* renamed from: androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2864a;

        static {
            int[] iArr = new int[SurfaceConfig.ConfigType.values().length];
            f2864a = iArr;
            try {
                iArr[SurfaceConfig.ConfigType.PRIV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2864a[SurfaceConfig.ConfigType.YUV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2864a[SurfaceConfig.ConfigType.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f2863a = hashMap;
        hashMap.put("SM-T580", null);
        hashMap.put("SM-J710MN", new Range(21, 26));
        hashMap.put("SM-A320FL", null);
        hashMap.put("SM-G570M", null);
        hashMap.put("SM-G610F", null);
        hashMap.put("SM-G610M", new Range(21, 26));
    }

    private static boolean b() {
        boolean z7;
        if ("samsung".equalsIgnoreCase(Build.BRAND) && f2863a.containsKey(Build.MODEL.toUpperCase(Locale.US))) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            return false;
        }
        Range<Integer> range = f2863a.get(Build.MODEL.toUpperCase(Locale.US));
        if (range == null) {
            return true;
        }
        return range.contains((Range<Integer>) Integer.valueOf(Build.VERSION.SDK_INT));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        return b();
    }

    public Size a(@NonNull SurfaceConfig.ConfigType configType) {
        if (!b()) {
            return null;
        }
        int i8 = AnonymousClass1.f2864a[configType.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    return null;
                }
                return new Size(3264, 1836);
            }
            return new Size(1280, PeerConnectionUtils.HD_VIDEO_HEIGHT);
        }
        return new Size(1920, 1080);
    }
}
