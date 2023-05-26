package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.DisplayMetrics;
import android.util.Size;
import androidx.core.content.ContextCompat;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class g1 {

    /* renamed from: b  reason: collision with root package name */
    public static final a f43070b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f43071a;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43072a;

        static {
            int[] iArr = new int[q1.values().length];
            try {
                iArr[q1.BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[q1.FRONT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f43072a = iArr;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            int a8;
            Size size = (Size) t7;
            Size size2 = (Size) t8;
            a8 = ComparisonsKt__ComparisonsKt.a(Integer.valueOf(size.getHeight() * size.getWidth()), Integer.valueOf(size2.getHeight() * size2.getWidth()));
            return a8;
        }
    }

    @Inject
    public g1(Context context) {
        Intrinsics.f(context, "context");
        this.f43071a = context;
    }

    private final Size a(StreamConfigurationMap streamConfigurationMap) {
        Size[] pictureSizes;
        List f02;
        List v02;
        if (streamConfigurationMap != null && (pictureSizes = streamConfigurationMap.getOutputSizes(32)) != null) {
            Intrinsics.e(pictureSizes, "pictureSizes");
            f02 = ArraysKt___ArraysKt.f0(pictureSizes);
            v02 = CollectionsKt___CollectionsKt.v0(f02, new c());
            if (!v02.isEmpty()) {
                int width = ((Size) v02.get(v02.size() - 1)).getWidth();
                int height = ((Size) v02.get(v02.size() - 1)).getHeight();
                return new Size(Math.min(width, height), Math.max(width, height));
            }
        }
        return new Size(3072, 4096);
    }

    public final Size b(q1 cameraType) {
        String[] cameraIdList;
        Intrinsics.f(cameraType, "cameraType");
        Size size = new Size(3072, 4096);
        CameraManager cameraManager = (CameraManager) ContextCompat.getSystemService(this.f43071a, CameraManager.class);
        if (cameraManager != null && (cameraIdList = cameraManager.getCameraIdList()) != null) {
            for (String str : cameraIdList) {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                Intrinsics.e(cameraCharacteristics, "cameraManager.getCameraCharacteristics(it)");
                Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                if (num != null) {
                    int intValue = num.intValue();
                    int i8 = b.f43072a[cameraType.ordinal()];
                    int i9 = 1;
                    if (i8 != 1) {
                        if (i8 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        i9 = 0;
                    }
                    if (i9 == intValue) {
                        size = a((StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP));
                    }
                }
            }
        }
        return size;
    }

    public final ff c(q1 cameraType) {
        Intrinsics.f(cameraType, "cameraType");
        DisplayMetrics displayMetrics = this.f43071a.getResources().getDisplayMetrics();
        int i8 = displayMetrics.heightPixels;
        double d8 = displayMetrics.widthPixels;
        Size b8 = b(cameraType);
        double width = b8.getWidth() / b8.getHeight();
        if (d8 / i8 < width) {
            int a8 = f2.a(this.f43071a, 56.0f);
            return new ff(a8, (i8 - ((int) (d8 / width))) - a8, displayMetrics.widthPixels, 0);
        }
        return new ff(0, 0, displayMetrics.widthPixels, f2.a(this.f43071a, 56.0f));
    }
}
