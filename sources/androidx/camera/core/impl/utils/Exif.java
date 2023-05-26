package androidx.camera.core.impl.utils;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class Exif {

    /* renamed from: c  reason: collision with root package name */
    private static final String f3762c = "Exif";

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f3763d = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.1
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd", Locale.US);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f3764e = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.2
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss", Locale.US);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f3765f = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.3
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private static final List<String> f3766g = n();

    /* renamed from: h  reason: collision with root package name */
    private static final List<String> f3767h = Arrays.asList("ImageWidth", "ImageLength", "PixelXDimension", "PixelYDimension", "Compression", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation");

    /* renamed from: a  reason: collision with root package name */
    private final ExifInterface f3768a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3769b = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Speed {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class Converter {

            /* renamed from: a  reason: collision with root package name */
            final double f3770a;

            Converter(double d8) {
                this.f3770a = d8;
            }

            double a() {
                return this.f3770a / 2.23694d;
            }
        }

        private Speed() {
        }

        static Converter a(double d8) {
            return new Converter(d8 * 0.621371d);
        }

        static Converter b(double d8) {
            return new Converter(d8 * 1.15078d);
        }

        static Converter c(double d8) {
            return new Converter(d8);
        }
    }

    private Exif(ExifInterface exifInterface) {
        this.f3768a = exifInterface;
    }

    private void a() {
        long currentTimeMillis = System.currentTimeMillis();
        String f8 = f(currentTimeMillis);
        this.f3768a.b0("DateTime", f8);
        try {
            this.f3768a.b0("SubSecTime", Long.toString(currentTimeMillis - d(f8).getTime()));
        } catch (ParseException unused) {
        }
    }

    private static Date c(String str) throws ParseException {
        return f3763d.get().parse(str);
    }

    private static Date d(String str) throws ParseException {
        return f3765f.get().parse(str);
    }

    private static Date e(String str) throws ParseException {
        return f3764e.get().parse(str);
    }

    private static String f(long j8) {
        return f3765f.get().format(new Date(j8));
    }

    @NonNull
    public static Exif h(@NonNull File file) throws IOException {
        return i(file.toString());
    }

    @NonNull
    public static Exif i(@NonNull String str) throws IOException {
        return new Exif(new ExifInterface(str));
    }

    @NonNull
    public static Exif j(@NonNull ImageProxy imageProxy) throws IOException {
        ByteBuffer b8 = imageProxy.n0()[0].b();
        b8.rewind();
        byte[] bArr = new byte[b8.capacity()];
        b8.get(bArr);
        return k(new ByteArrayInputStream(bArr));
    }

    @NonNull
    public static Exif k(@NonNull InputStream inputStream) throws IOException {
        return new Exif(new ExifInterface(inputStream));
    }

    @NonNull
    public static List<String> n() {
        return Arrays.asList("ImageWidth", "ImageLength", "BitsPerSample", "Compression", "PhotometricInterpretation", "Orientation", "SamplesPerPixel", "PlanarConfiguration", "YCbCrSubSampling", "YCbCrPositioning", "XResolution", "YResolution", "ResolutionUnit", "StripOffsets", "RowsPerStrip", "StripByteCounts", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "TransferFunction", "WhitePoint", "PrimaryChromaticities", "YCbCrCoefficients", "ReferenceBlackWhite", "DateTime", "ImageDescription", "Make", "Model", "Software", "Artist", "Copyright", "ExifVersion", "FlashpixVersion", "ColorSpace", "Gamma", "PixelXDimension", "PixelYDimension", "ComponentsConfiguration", "CompressedBitsPerPixel", "MakerNote", "UserComment", "RelatedSoundFile", "DateTimeOriginal", "DateTimeDigitized", "OffsetTime", "OffsetTimeOriginal", "OffsetTimeDigitized", "SubSecTime", "SubSecTimeOriginal", "SubSecTimeDigitized", "ExposureTime", "FNumber", "ExposureProgram", "SpectralSensitivity", "PhotographicSensitivity", "OECF", "SensitivityType", "StandardOutputSensitivity", "RecommendedExposureIndex", "ISOSpeed", "ISOSpeedLatitudeyyy", "ISOSpeedLatitudezzz", "ShutterSpeedValue", "ApertureValue", "BrightnessValue", "ExposureBiasValue", "MaxApertureValue", "SubjectDistance", "MeteringMode", "LightSource", "Flash", "SubjectArea", "FocalLength", "FlashEnergy", "SpatialFrequencyResponse", "FocalPlaneXResolution", "FocalPlaneYResolution", "FocalPlaneResolutionUnit", "SubjectLocation", "ExposureIndex", "SensingMethod", "FileSource", "SceneType", "CFAPattern", "CustomRendered", "ExposureMode", "WhiteBalance", "DigitalZoomRatio", "FocalLengthIn35mmFilm", "SceneCaptureType", "GainControl", "Contrast", "Saturation", "Sharpness", "DeviceSettingDescription", "SubjectDistanceRange", "ImageUniqueID", "CameraOwnerName", "BodySerialNumber", "LensSpecification", "LensMake", "LensModel", "LensSerialNumber", "GPSVersionID", "GPSLatitudeRef", "GPSLatitude", "GPSLongitudeRef", "GPSLongitude", "GPSAltitudeRef", "GPSAltitude", "GPSTimeStamp", "GPSSatellites", "GPSStatus", "GPSMeasureMode", "GPSDOP", "GPSSpeedRef", "GPSSpeed", "GPSTrackRef", "GPSTrack", "GPSImgDirectionRef", "GPSImgDirection", "GPSMapDatum", "GPSDestLatitudeRef", "GPSDestLatitude", "GPSDestLongitudeRef", "GPSDestLongitude", "GPSDestBearingRef", "GPSDestBearing", "GPSDestDistanceRef", "GPSDestDistance", "GPSProcessingMethod", "GPSAreaInformation", "GPSDateStamp", "GPSDifferential", "GPSHPositioningError", "InteroperabilityIndex", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation", "DNGVersion", "DefaultCropSize", "ThumbnailImage", "PreviewImageStart", "PreviewImageLength", "AspectFrame", "SensorBottomBorder", "SensorLeftBorder", "SensorRightBorder", "SensorTopBorder", "ISO", "JpgFromRaw", "Xmp", "NewSubfileType", "SubfileType");
    }

    private long x(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return d(str).getTime();
        } catch (ParseException unused) {
            return -1L;
        }
    }

    private long y(String str, String str2) {
        if (str == null && str2 == null) {
            return -1L;
        }
        if (str2 == null) {
            try {
                return c(str).getTime();
            } catch (ParseException unused) {
                return -1L;
            }
        } else if (str == null) {
            try {
                return e(str2).getTime();
            } catch (ParseException unused2) {
                return -1L;
            }
        } else {
            return x(str + " " + str2);
        }
    }

    public void A() throws IOException {
        if (!this.f3769b) {
            a();
        }
        this.f3768a.W();
    }

    public void b(@NonNull Location location) {
        this.f3768a.c0(location);
    }

    public void g(@NonNull Exif exif) {
        ArrayList<String> arrayList = new ArrayList(f3766g);
        arrayList.removeAll(f3767h);
        for (String str : arrayList) {
            String g8 = this.f3768a.g(str);
            if (g8 != null) {
                exif.f3768a.b0(str, g8);
            }
        }
    }

    public void l() {
        int i8;
        switch (r()) {
            case 2:
                i8 = 1;
                break;
            case 3:
                i8 = 4;
                break;
            case 4:
                i8 = 3;
                break;
            case 5:
                i8 = 6;
                break;
            case 6:
                i8 = 5;
                break;
            case 7:
                i8 = 8;
                break;
            case 8:
                i8 = 7;
                break;
            default:
                i8 = 2;
                break;
        }
        this.f3768a.b0("Orientation", String.valueOf(i8));
    }

    public void m() {
        int i8;
        switch (r()) {
            case 2:
                i8 = 3;
                break;
            case 3:
                i8 = 2;
                break;
            case 4:
                i8 = 1;
                break;
            case 5:
                i8 = 8;
                break;
            case 6:
                i8 = 7;
                break;
            case 7:
                i8 = 6;
                break;
            case 8:
                i8 = 5;
                break;
            default:
                i8 = 4;
                break;
        }
        this.f3768a.b0("Orientation", String.valueOf(i8));
    }

    public String o() {
        return this.f3768a.g("ImageDescription");
    }

    public int p() {
        return this.f3768a.i("ImageLength", 0);
    }

    public Location q() {
        double a8;
        String g8 = this.f3768a.g("GPSProcessingMethod");
        double[] m8 = this.f3768a.m();
        double f8 = this.f3768a.f(0.0d);
        double h8 = this.f3768a.h("GPSSpeed", 0.0d);
        String g9 = this.f3768a.g("GPSSpeedRef");
        if (g9 == null) {
            g9 = "K";
        }
        long y7 = y(this.f3768a.g("GPSDateStamp"), this.f3768a.g("GPSTimeStamp"));
        if (m8 == null) {
            return null;
        }
        if (g8 == null) {
            g8 = f3762c;
        }
        Location location = new Location(g8);
        location.setLatitude(m8[0]);
        location.setLongitude(m8[1]);
        if (f8 != 0.0d) {
            location.setAltitude(f8);
        }
        if (h8 != 0.0d) {
            char c8 = 65535;
            int hashCode = g9.hashCode();
            if (hashCode != 75) {
                if (hashCode != 77) {
                    if (hashCode == 78 && g9.equals("N")) {
                        c8 = 1;
                    }
                } else if (g9.equals("M")) {
                    c8 = 0;
                }
            } else if (g9.equals("K")) {
                c8 = 2;
            }
            if (c8 != 0) {
                if (c8 != 1) {
                    a8 = Speed.a(h8).a();
                } else {
                    a8 = Speed.b(h8).a();
                }
            } else {
                a8 = Speed.c(h8).a();
            }
            location.setSpeed((float) a8);
        }
        if (y7 != -1) {
            location.setTime(y7);
        }
        return location;
    }

    public int r() {
        return this.f3768a.i("Orientation", 0);
    }

    public int s() {
        switch (r()) {
            case 3:
            case 4:
                return 180;
            case 5:
                return 270;
            case 6:
            case 7:
                return 90;
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public long t() {
        long x7 = x(this.f3768a.g("DateTimeOriginal"));
        if (x7 == -1) {
            return -1L;
        }
        String g8 = this.f3768a.g("SubSecTimeOriginal");
        if (g8 != null) {
            try {
                long parseLong = Long.parseLong(g8);
                while (parseLong > 1000) {
                    parseLong /= 10;
                }
                return x7 + parseLong;
            } catch (NumberFormatException unused) {
                return x7;
            }
        }
        return x7;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", Integer.valueOf(u()), Integer.valueOf(p()), Integer.valueOf(s()), Boolean.valueOf(w()), Boolean.valueOf(v()), q(), Long.valueOf(t()), o());
    }

    public int u() {
        return this.f3768a.i("ImageWidth", 0);
    }

    public boolean v() {
        if (r() != 2) {
            return false;
        }
        return true;
    }

    public boolean w() {
        int r7 = r();
        if (r7 == 4 || r7 == 5 || r7 == 7) {
            return true;
        }
        return false;
    }

    public void z(int i8) {
        if (i8 % 90 != 0) {
            Logger.k(f3762c, String.format(Locale.US, "Can only rotate in right angles (eg. 0, 90, 180, 270). %d is unsupported.", Integer.valueOf(i8)));
            this.f3768a.b0("Orientation", String.valueOf(0));
            return;
        }
        int i9 = i8 % 360;
        int r7 = r();
        while (i9 < 0) {
            i9 += 90;
            switch (r7) {
                case 2:
                    r7 = 5;
                    break;
                case 3:
                case 8:
                    r7 = 6;
                    break;
                case 4:
                    r7 = 7;
                    break;
                case 5:
                    r7 = 4;
                    break;
                case 6:
                    r7 = 1;
                    break;
                case 7:
                    r7 = 2;
                    break;
                default:
                    r7 = 8;
                    break;
            }
        }
        while (i9 > 0) {
            i9 -= 90;
            switch (r7) {
                case 2:
                    r7 = 7;
                    break;
                case 3:
                    r7 = 8;
                    break;
                case 4:
                    r7 = 5;
                    break;
                case 5:
                    r7 = 2;
                    break;
                case 6:
                    r7 = 3;
                    break;
                case 7:
                    r7 = 4;
                    break;
                case 8:
                    r7 = 1;
                    break;
                default:
                    r7 = 6;
                    break;
            }
        }
        this.f3768a.b0("Orientation", String.valueOf(r7));
    }
}
