package androidx.camera.core.impl.utils;

import android.os.Build;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.core.util.Preconditions;
import j$.util.Spliterator;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
public class ExifData {

    /* renamed from: c  reason: collision with root package name */
    static final String[] f3779c = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* renamed from: d  reason: collision with root package name */
    private static final ExifTag[] f3780d;

    /* renamed from: e  reason: collision with root package name */
    private static final ExifTag[] f3781e;

    /* renamed from: f  reason: collision with root package name */
    private static final ExifTag[] f3782f;

    /* renamed from: g  reason: collision with root package name */
    static final ExifTag[] f3783g;

    /* renamed from: h  reason: collision with root package name */
    private static final ExifTag[] f3784h;

    /* renamed from: i  reason: collision with root package name */
    static final ExifTag[][] f3785i;

    /* renamed from: j  reason: collision with root package name */
    static final HashSet<String> f3786j;

    /* renamed from: a  reason: collision with root package name */
    private final List<Map<String, ExifAttribute>> f3787a;

    /* renamed from: b  reason: collision with root package name */
    private final ByteOrder f3788b;

    /* renamed from: androidx.camera.core.impl.utils.ExifData$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3789a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3790b;

        static {
            int[] iArr = new int[WhiteBalanceMode.values().length];
            f3790b = iArr;
            try {
                iArr[WhiteBalanceMode.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3790b[WhiteBalanceMode.MANUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[CameraCaptureMetaData$FlashState.values().length];
            f3789a = iArr2;
            try {
                iArr2[CameraCaptureMetaData$FlashState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3789a[CameraCaptureMetaData$FlashState.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3789a[CameraCaptureMetaData$FlashState.FIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: c  reason: collision with root package name */
        private static final Pattern f3791c = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");

        /* renamed from: d  reason: collision with root package name */
        private static final Pattern f3792d = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

        /* renamed from: e  reason: collision with root package name */
        private static final Pattern f3793e = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

        /* renamed from: f  reason: collision with root package name */
        static final List<HashMap<String, ExifTag>> f3794f = Collections.list(new Enumeration<HashMap<String, ExifTag>>() { // from class: androidx.camera.core.impl.utils.ExifData.Builder.1

            /* renamed from: a  reason: collision with root package name */
            int f3797a = 0;

            @Override // java.util.Enumeration
            /* renamed from: a */
            public HashMap<String, ExifTag> nextElement() {
                ExifTag[] exifTagArr;
                HashMap<String, ExifTag> hashMap = new HashMap<>();
                for (ExifTag exifTag : ExifData.f3785i[this.f3797a]) {
                    hashMap.put(exifTag.f3813b, exifTag);
                }
                this.f3797a++;
                return hashMap;
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                if (this.f3797a < ExifData.f3785i.length) {
                    return true;
                }
                return false;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        final List<Map<String, ExifAttribute>> f3795a = Collections.list(new Enumeration<Map<String, ExifAttribute>>() { // from class: androidx.camera.core.impl.utils.ExifData.Builder.2

            /* renamed from: a  reason: collision with root package name */
            int f3798a = 0;

            @Override // java.util.Enumeration
            /* renamed from: a */
            public Map<String, ExifAttribute> nextElement() {
                this.f3798a++;
                return new HashMap();
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                if (this.f3798a < ExifData.f3785i.length) {
                    return true;
                }
                return false;
            }
        });

        /* renamed from: b  reason: collision with root package name */
        private final ByteOrder f3796b;

        Builder(@NonNull ByteOrder byteOrder) {
            this.f3796b = byteOrder;
        }

        private static Pair<Integer, Integer> b(String str) {
            int intValue;
            int i8;
            if (str.contains(",")) {
                String[] split = str.split(",", -1);
                Pair<Integer, Integer> b8 = b(split[0]);
                if (((Integer) b8.first).intValue() == 2) {
                    return b8;
                }
                for (int i9 = 1; i9 < split.length; i9++) {
                    Pair<Integer, Integer> b9 = b(split[i9]);
                    if (!((Integer) b9.first).equals(b8.first) && !((Integer) b9.second).equals(b8.first)) {
                        intValue = -1;
                    } else {
                        intValue = ((Integer) b8.first).intValue();
                    }
                    if (((Integer) b8.second).intValue() != -1 && (((Integer) b9.first).equals(b8.second) || ((Integer) b9.second).equals(b8.second))) {
                        i8 = ((Integer) b8.second).intValue();
                    } else {
                        i8 = -1;
                    }
                    if (intValue == -1 && i8 == -1) {
                        return new Pair<>(2, -1);
                    }
                    if (intValue == -1) {
                        b8 = new Pair<>(Integer.valueOf(i8), -1);
                    } else if (i8 == -1) {
                        b8 = new Pair<>(Integer.valueOf(intValue), -1);
                    }
                }
                return b8;
            } else if (str.contains("/")) {
                String[] split2 = str.split("/", -1);
                if (split2.length == 2) {
                    try {
                        long parseDouble = (long) Double.parseDouble(split2[0]);
                        long parseDouble2 = (long) Double.parseDouble(split2[1]);
                        if (parseDouble >= 0 && parseDouble2 >= 0) {
                            if (parseDouble <= 2147483647L && parseDouble2 <= 2147483647L) {
                                return new Pair<>(10, 5);
                            }
                            return new Pair<>(5, -1);
                        }
                        return new Pair<>(10, -1);
                    } catch (NumberFormatException unused) {
                    }
                }
                return new Pair<>(2, -1);
            } else {
                try {
                    try {
                        long parseLong = Long.parseLong(str);
                        int i10 = (parseLong > 0L ? 1 : (parseLong == 0L ? 0 : -1));
                        if (i10 >= 0 && parseLong <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                            return new Pair<>(3, 4);
                        }
                        if (i10 < 0) {
                            return new Pair<>(9, -1);
                        }
                        return new Pair<>(4, -1);
                    } catch (NumberFormatException unused2) {
                        Double.parseDouble(str);
                        return new Pair<>(12, -1);
                    }
                } catch (NumberFormatException unused3) {
                    return new Pair<>(2, -1);
                }
            }
        }

        private void d(@NonNull String str, @NonNull String str2, @NonNull List<Map<String, ExifAttribute>> list) {
            for (Map<String, ExifAttribute> map : list) {
                if (map.containsKey(str)) {
                    return;
                }
            }
            e(str, str2, list);
        }

        /* JADX WARN: Code restructure failed: missing block: B:60:0x018a, code lost:
            if (r7 != r0) goto L98;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void e(@androidx.annotation.NonNull java.lang.String r18, java.lang.String r19, @androidx.annotation.NonNull java.util.List<java.util.Map<java.lang.String, androidx.camera.core.impl.utils.ExifAttribute>> r20) {
            /*
                Method dump skipped, instructions count: 772
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifData.Builder.e(java.lang.String, java.lang.String, java.util.List):void");
        }

        @NonNull
        public ExifData a() {
            ArrayList list = Collections.list(new Enumeration<Map<String, ExifAttribute>>() { // from class: androidx.camera.core.impl.utils.ExifData.Builder.3

                /* renamed from: a  reason: collision with root package name */
                final Enumeration<Map<String, ExifAttribute>> f3800a;

                {
                    this.f3800a = Collections.enumeration(Builder.this.f3795a);
                }

                @Override // java.util.Enumeration
                /* renamed from: a */
                public Map<String, ExifAttribute> nextElement() {
                    return new HashMap(this.f3800a.nextElement());
                }

                @Override // java.util.Enumeration
                public boolean hasMoreElements() {
                    return this.f3800a.hasMoreElements();
                }
            });
            if (!list.get(1).isEmpty()) {
                d("ExposureProgram", String.valueOf(0), list);
                d("ExifVersion", "0230", list);
                d("ComponentsConfiguration", "1,2,3,0", list);
                d("MeteringMode", String.valueOf(0), list);
                d("LightSource", String.valueOf(0), list);
                d("FlashpixVersion", "0100", list);
                d("FocalPlaneResolutionUnit", String.valueOf(2), list);
                d("FileSource", String.valueOf(3), list);
                d("SceneType", String.valueOf(1), list);
                d("CustomRendered", String.valueOf(0), list);
                d("SceneCaptureType", String.valueOf(0), list);
                d("Contrast", String.valueOf(0), list);
                d("Saturation", String.valueOf(0), list);
                d("Sharpness", String.valueOf(0), list);
            }
            if (!list.get(2).isEmpty()) {
                d("GPSVersionID", "2300", list);
                d("GPSSpeedRef", "K", list);
                d("GPSTrackRef", "T", list);
                d("GPSImgDirectionRef", "T", list);
                d("GPSDestBearingRef", "T", list);
                d("GPSDestDistanceRef", "K", list);
            }
            return new ExifData(this.f3796b, list);
        }

        @NonNull
        public Builder c(@NonNull String str, @NonNull String str2) {
            e(str, str2, this.f3795a);
            return this;
        }

        @NonNull
        public Builder f(long j8) {
            return c("ExposureTime", String.valueOf(j8 / TimeUnit.SECONDS.toNanos(1L)));
        }

        @NonNull
        public Builder g(@NonNull CameraCaptureMetaData$FlashState cameraCaptureMetaData$FlashState) {
            int i8;
            if (cameraCaptureMetaData$FlashState == CameraCaptureMetaData$FlashState.UNKNOWN) {
                return this;
            }
            int i9 = AnonymousClass1.f3789a[cameraCaptureMetaData$FlashState.ordinal()];
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 != 3) {
                        Logger.k("ExifData", "Unknown flash state: " + cameraCaptureMetaData$FlashState);
                        return this;
                    }
                    i8 = 1;
                } else {
                    i8 = 32;
                }
            } else {
                i8 = 0;
            }
            if ((i8 & 1) == 1) {
                c("LightSource", String.valueOf(4));
            }
            return c("Flash", String.valueOf(i8));
        }

        @NonNull
        public Builder h(float f8) {
            return c("FocalLength", new LongRational(f8 * 1000.0f, 1000L).toString());
        }

        @NonNull
        public Builder i(int i8) {
            return c("ImageLength", String.valueOf(i8));
        }

        @NonNull
        public Builder j(int i8) {
            return c("ImageWidth", String.valueOf(i8));
        }

        @NonNull
        public Builder k(int i8) {
            return c("SensitivityType", String.valueOf(3)).c("PhotographicSensitivity", String.valueOf(Math.min((int) Settings.DEFAULT_INITIAL_WINDOW_SIZE, i8)));
        }

        @NonNull
        public Builder l(float f8) {
            return c("FNumber", String.valueOf(f8));
        }

        @NonNull
        public Builder m(int i8) {
            int i9;
            if (i8 != 0) {
                if (i8 != 90) {
                    if (i8 != 180) {
                        if (i8 != 270) {
                            Logger.k("ExifData", "Unexpected orientation value: " + i8 + ". Must be one of 0, 90, 180, 270.");
                            i9 = 0;
                        } else {
                            i9 = 8;
                        }
                    } else {
                        i9 = 3;
                    }
                } else {
                    i9 = 6;
                }
            } else {
                i9 = 1;
            }
            return c("Orientation", String.valueOf(i9));
        }

        @NonNull
        public Builder n(@NonNull WhiteBalanceMode whiteBalanceMode) {
            String valueOf;
            int i8 = AnonymousClass1.f3790b[whiteBalanceMode.ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    valueOf = null;
                } else {
                    valueOf = String.valueOf(1);
                }
            } else {
                valueOf = String.valueOf(0);
            }
            return c("WhiteBalance", valueOf);
        }
    }

    /* loaded from: classes.dex */
    public enum WhiteBalanceMode {
        AUTO,
        MANUAL
    }

    static {
        ExifTag[] exifTagArr = {new ExifTag("ImageWidth", Spliterator.NONNULL, 3, 4), new ExifTag("ImageLength", 257, 3, 4), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("Orientation", 274, 3), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4)};
        f3780d = exifTagArr;
        ExifTag[] exifTagArr2 = {new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("PhotographicSensitivity", 34855, 3), new ExifTag("SensitivityType", 34864, 3), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", 36867, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag("ComponentsConfiguration", 37121, 7), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", 40961, 3), new ExifTag("PixelXDimension", 40962, 3, 4), new ExifTag("PixelYDimension", 40963, 3, 4), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", 41987, 3), new ExifTag("SceneCaptureType", 41990, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", 41993, 3), new ExifTag("Sharpness", 41994, 3)};
        f3781e = exifTagArr2;
        ExifTag[] exifTagArr3 = {new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5, 10), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5, 10), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestDistanceRef", 25, 2)};
        f3782f = exifTagArr3;
        f3783g = new ExifTag[]{new ExifTag("SubIFDPointer", 330, 4), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("InteroperabilityIFDPointer", 40965, 4)};
        ExifTag[] exifTagArr4 = {new ExifTag("InteroperabilityIndex", 1, 2)};
        f3784h = exifTagArr4;
        f3785i = new ExifTag[][]{exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4};
        f3786j = new HashSet<>(Arrays.asList("FNumber", "ExposureTime", "GPSTimeStamp"));
    }

    ExifData(ByteOrder byteOrder, List<Map<String, ExifAttribute>> list) {
        boolean z7;
        if (list.size() == f3785i.length) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.j(z7, "Malformed attributes list. Number of IFDs mismatch.");
        this.f3788b = byteOrder;
        this.f3787a = list;
    }

    @NonNull
    public static Builder a() {
        return new Builder(ByteOrder.BIG_ENDIAN).c("Orientation", String.valueOf(1)).c("XResolution", "72/1").c("YResolution", "72/1").c("ResolutionUnit", String.valueOf(2)).c("YCbCrPositioning", String.valueOf(1)).c("Make", Build.MANUFACTURER).c("Model", Build.MODEL);
    }

    @NonNull
    public static ExifData b(@NonNull ImageProxy imageProxy, int i8) {
        Builder a8 = a();
        imageProxy.O0().a(a8);
        a8.m(i8);
        return a8.j(imageProxy.getWidth()).i(imageProxy.getHeight()).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Map<String, ExifAttribute> c(int i8) {
        int length = f3785i.length;
        Preconditions.c(i8, 0, length, "Invalid IFD index: " + i8 + ". Index should be between [0, EXIF_TAGS.length] ");
        return this.f3787a.get(i8);
    }

    @NonNull
    public ByteOrder d() {
        return this.f3788b;
    }
}
