package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.workaround.ExcludedSupportedSizesContainer;
import androidx.camera.camera2.internal.compat.workaround.ExtraSupportedSurfaceCombinationsContainer;
import androidx.camera.camera2.internal.compat.workaround.ResolutionCorrector;
import androidx.camera.camera2.internal.compat.workaround.TargetAspectRatio;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.SurfaceSizeDefinition;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.core.util.Preconditions;
import j$.util.Spliterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class SupportedSurfaceCombination {

    /* renamed from: c  reason: collision with root package name */
    private final String f2664c;

    /* renamed from: d  reason: collision with root package name */
    private final CamcorderProfileHelper f2665d;

    /* renamed from: e  reason: collision with root package name */
    private final CameraCharacteristicsCompat f2666e;

    /* renamed from: f  reason: collision with root package name */
    private final ExcludedSupportedSizesContainer f2667f;

    /* renamed from: g  reason: collision with root package name */
    private final ExtraSupportedSurfaceCombinationsContainer f2668g;

    /* renamed from: h  reason: collision with root package name */
    private final int f2669h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f2670i;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2672k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2673l;

    /* renamed from: m  reason: collision with root package name */
    SurfaceSizeDefinition f2674m;
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    private final DisplayInfoManager f2676o;

    /* renamed from: a  reason: collision with root package name */
    private final List<SurfaceCombination> f2662a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, Size> f2663b = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    private final Map<Integer, List<Size>> f2671j = new HashMap();

    /* renamed from: n  reason: collision with root package name */
    private Map<Integer, Size[]> f2675n = new HashMap();

    /* renamed from: p  reason: collision with root package name */
    private final ResolutionCorrector f2677p = new ResolutionCorrector();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SupportedSurfaceCombination(@NonNull Context context, @NonNull String str, @NonNull CameraManagerCompat cameraManagerCompat, @NonNull CamcorderProfileHelper camcorderProfileHelper) throws CameraUnavailableException {
        int i8;
        this.f2672k = false;
        this.f2673l = false;
        String str2 = (String) Preconditions.g(str);
        this.f2664c = str2;
        this.f2665d = (CamcorderProfileHelper) Preconditions.g(camcorderProfileHelper);
        this.f2667f = new ExcludedSupportedSizesContainer(str);
        this.f2668g = new ExtraSupportedSurfaceCombinationsContainer();
        this.f2676o = DisplayInfoManager.b(context);
        try {
            CameraCharacteristicsCompat c8 = cameraManagerCompat.c(str2);
            this.f2666e = c8;
            Integer num = (Integer) c8.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            if (num != null) {
                i8 = num.intValue();
            } else {
                i8 = 2;
            }
            this.f2669h = i8;
            this.f2670i = x();
            int[] iArr = (int[]) c8.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr != null) {
                for (int i9 : iArr) {
                    if (i9 == 3) {
                        this.f2672k = true;
                    } else if (i9 == 6) {
                        this.f2673l = true;
                    }
                }
            }
            h();
            i();
            a();
        } catch (CameraAccessExceptionCompat e8) {
            throw CameraUnavailableExceptionHelper.a(e8);
        }
    }

    private void a() {
    }

    @NonNull
    private Size[] c(int i8) {
        Size[] outputSizes;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f2666e.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            if (Build.VERSION.SDK_INT < 23 && i8 == 34) {
                outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
            } else {
                outputSizes = streamConfigurationMap.getOutputSizes(i8);
            }
            if (outputSizes != null) {
                Size[] d8 = d(outputSizes, i8);
                Arrays.sort(d8, new CompareSizesByArea(true));
                return d8;
            }
            throw new IllegalArgumentException("Can not get supported output size for the format: " + i8);
        }
        throw new IllegalArgumentException("Can not retrieve SCALER_STREAM_CONFIGURATION_MAP");
    }

    @NonNull
    private Size[] d(@NonNull Size[] sizeArr, int i8) {
        List<Size> e8 = e(i8);
        ArrayList arrayList = new ArrayList(Arrays.asList(sizeArr));
        arrayList.removeAll(e8);
        return (Size[]) arrayList.toArray(new Size[0]);
    }

    @NonNull
    private List<Size> e(int i8) {
        List<Size> list = this.f2671j.get(Integer.valueOf(i8));
        if (list == null) {
            List<Size> a8 = this.f2667f.a(i8);
            this.f2671j.put(Integer.valueOf(i8), a8);
            return a8;
        }
        return list;
    }

    private Size f(int i8) {
        Size size = this.f2663b.get(Integer.valueOf(i8));
        if (size != null) {
            return size;
        }
        Size m8 = m(i8);
        this.f2663b.put(Integer.valueOf(i8), m8);
        return m8;
    }

    private Size g(Size size, int i8) {
        if (size != null && w(i8)) {
            return new Size(size.getHeight(), size.getWidth());
        }
        return size;
    }

    private void h() {
        this.f2662a.addAll(GuaranteedConfigurationsUtil.a(this.f2669h, this.f2672k, this.f2673l));
        this.f2662a.addAll(this.f2668g.a(this.f2664c, this.f2669h));
    }

    private void i() {
        this.f2674m = SurfaceSizeDefinition.a(new Size(640, 480), this.f2676o.d(), n());
    }

    @NonNull
    private Size[] j(int i8) {
        Size[] sizeArr = this.f2675n.get(Integer.valueOf(i8));
        if (sizeArr == null) {
            Size[] c8 = c(i8);
            this.f2675n.put(Integer.valueOf(i8), c8);
            return c8;
        }
        return sizeArr;
    }

    private List<List<Size>> k(List<List<Size>> list) {
        int i8 = 1;
        for (List<Size> list2 : list) {
            i8 *= list2.size();
        }
        if (i8 != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i9 = 0; i9 < i8; i9++) {
                arrayList.add(new ArrayList());
            }
            int size = i8 / list.get(0).size();
            int i10 = i8;
            for (int i11 = 0; i11 < list.size(); i11++) {
                List<Size> list3 = list.get(i11);
                for (int i12 = 0; i12 < i8; i12++) {
                    ((List) arrayList.get(i12)).add(list3.get((i12 % i10) / size));
                }
                if (i11 < list.size() - 1) {
                    i10 = size;
                    size /= list.get(i11 + 1).size();
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("Failed to find supported resolutions.");
    }

    private Size[] l(int i8, @NonNull ImageOutputConfig imageOutputConfig) {
        Size[] sizeArr = null;
        List<Pair<Integer, Size[]>> i9 = imageOutputConfig.i(null);
        if (i9 != null) {
            Iterator<Pair<Integer, Size[]>> it = i9.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pair<Integer, Size[]> next = it.next();
                if (((Integer) next.first).intValue() == i8) {
                    sizeArr = (Size[]) next.second;
                    break;
                }
            }
        }
        if (sizeArr != null) {
            Size[] d8 = d(sizeArr, i8);
            Arrays.sort(d8, new CompareSizesByArea(true));
            return d8;
        }
        return sizeArr;
    }

    @NonNull
    private Size n() {
        try {
            int parseInt = Integer.parseInt(this.f2664c);
            CamcorderProfile camcorderProfile = null;
            if (this.f2665d.b(parseInt, 1)) {
                camcorderProfile = this.f2665d.a(parseInt, 1);
            }
            if (camcorderProfile != null) {
                return new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
            }
            return o(parseInt);
        } catch (NumberFormatException unused) {
            return p();
        }
    }

    @NonNull
    private Size o(int i8) {
        CamcorderProfile camcorderProfile;
        Size size = SizeUtil.f3939c;
        if (this.f2665d.b(i8, 10)) {
            camcorderProfile = this.f2665d.a(i8, 10);
        } else if (this.f2665d.b(i8, 8)) {
            camcorderProfile = this.f2665d.a(i8, 8);
        } else if (this.f2665d.b(i8, 12)) {
            camcorderProfile = this.f2665d.a(i8, 12);
        } else if (this.f2665d.b(i8, 6)) {
            camcorderProfile = this.f2665d.a(i8, 6);
        } else if (this.f2665d.b(i8, 5)) {
            camcorderProfile = this.f2665d.a(i8, 5);
        } else if (this.f2665d.b(i8, 4)) {
            camcorderProfile = this.f2665d.a(i8, 4);
        } else {
            camcorderProfile = null;
        }
        if (camcorderProfile != null) {
            return new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        }
        return size;
    }

    @NonNull
    private Size p() {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f2666e.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(MediaRecorder.class);
            if (outputSizes == null) {
                return SizeUtil.f3939c;
            }
            Arrays.sort(outputSizes, new CompareSizesByArea(true));
            for (Size size : outputSizes) {
                int width = size.getWidth();
                Size size2 = SizeUtil.f3940d;
                if (width <= size2.getWidth() && size.getHeight() <= size2.getHeight()) {
                    return size;
                }
            }
            return SizeUtil.f3939c;
        }
        throw new IllegalArgumentException("Can not retrieve SCALER_STREAM_CONFIGURATION_MAP");
    }

    private Rational s(@NonNull ImageOutputConfig imageOutputConfig) {
        Rational rational;
        int a8 = new TargetAspectRatio().a(this.f2664c, this.f2666e);
        if (a8 != 0) {
            if (a8 != 1) {
                if (a8 != 2) {
                    if (a8 != 3) {
                        return null;
                    }
                    Size t7 = t(imageOutputConfig);
                    if (imageOutputConfig.u()) {
                        int w7 = imageOutputConfig.w();
                        if (w7 != 0) {
                            if (w7 != 1) {
                                Logger.c("SupportedSurfaceCombination", "Undefined target aspect ratio: " + w7);
                                return null;
                            } else if (this.f2670i) {
                                rational = AspectRatioUtil.f3756c;
                            } else {
                                rational = AspectRatioUtil.f3757d;
                            }
                        } else if (this.f2670i) {
                            rational = AspectRatioUtil.f3754a;
                        } else {
                            rational = AspectRatioUtil.f3755b;
                        }
                    } else if (t7 == null) {
                        return null;
                    } else {
                        return new Rational(t7.getWidth(), t7.getHeight());
                    }
                } else {
                    Size f8 = f(Spliterator.NONNULL);
                    return new Rational(f8.getWidth(), f8.getHeight());
                }
            } else if (this.f2670i) {
                rational = AspectRatioUtil.f3756c;
            } else {
                rational = AspectRatioUtil.f3757d;
            }
        } else if (this.f2670i) {
            rational = AspectRatioUtil.f3754a;
        } else {
            rational = AspectRatioUtil.f3755b;
        }
        return rational;
    }

    private Size t(@NonNull ImageOutputConfig imageOutputConfig) {
        return g(imageOutputConfig.A(null), imageOutputConfig.x(0));
    }

    private List<Integer> u(List<UseCaseConfig<?>> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Integer> arrayList2 = new ArrayList();
        for (UseCaseConfig<?> useCaseConfig : list) {
            int v7 = useCaseConfig.v(0);
            if (!arrayList2.contains(Integer.valueOf(v7))) {
                arrayList2.add(Integer.valueOf(v7));
            }
        }
        Collections.sort(arrayList2);
        Collections.reverse(arrayList2);
        for (Integer num : arrayList2) {
            int intValue = num.intValue();
            for (UseCaseConfig<?> useCaseConfig2 : list) {
                if (intValue == useCaseConfig2.v(0)) {
                    arrayList.add(Integer.valueOf(list.indexOf(useCaseConfig2)));
                }
            }
        }
        return arrayList;
    }

    private Map<Rational, List<Size>> v(List<Size> list) {
        HashMap hashMap = new HashMap();
        hashMap.put(AspectRatioUtil.f3754a, new ArrayList());
        hashMap.put(AspectRatioUtil.f3756c, new ArrayList());
        for (Size size : list) {
            Rational rational = null;
            for (Rational rational2 : hashMap.keySet()) {
                if (AspectRatioUtil.a(size, rational2)) {
                    List list2 = (List) hashMap.get(rational2);
                    if (!list2.contains(size)) {
                        list2.add(size);
                    }
                    rational = rational2;
                }
            }
            if (rational == null) {
                hashMap.put(new Rational(size.getWidth(), size.getHeight()), new ArrayList(Collections.singleton(size)));
            }
        }
        return hashMap;
    }

    private boolean w(int i8) {
        boolean z7;
        Integer num = (Integer) this.f2666e.a(CameraCharacteristics.SENSOR_ORIENTATION);
        Preconditions.h(num, "Camera HAL in bad state, unable to retrieve the SENSOR_ORIENTATION");
        int b8 = CameraOrientationUtil.b(i8);
        Integer num2 = (Integer) this.f2666e.a(CameraCharacteristics.LENS_FACING);
        Preconditions.h(num2, "Camera HAL in bad state, unable to retrieve the LENS_FACING");
        if (1 == num2.intValue()) {
            z7 = true;
        } else {
            z7 = false;
        }
        int a8 = CameraOrientationUtil.a(b8, num.intValue(), z7);
        if (a8 != 90 && a8 != 270) {
            return false;
        }
        return true;
    }

    private boolean x() {
        Size size = (Size) this.f2666e.a(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
        if (size == null || size.getWidth() >= size.getHeight()) {
            return true;
        }
        return false;
    }

    private void y() {
        this.f2676o.e();
        if (this.f2674m == null) {
            i();
            return;
        }
        this.f2674m = SurfaceSizeDefinition.a(this.f2674m.b(), this.f2676o.d(), this.f2674m.d());
    }

    private void z(List<Size> list, Size size) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int i8 = -1;
            for (int i9 = 0; i9 < list.size(); i9++) {
                Size size2 = list.get(i9);
                if (size2.getWidth() < size.getWidth() || size2.getHeight() < size.getHeight()) {
                    break;
                }
                if (i8 >= 0) {
                    arrayList.add(list.get(i8));
                }
                i8 = i9;
            }
            list.removeAll(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SurfaceConfig A(int i8, Size size) {
        return SurfaceConfig.f(i8, size, this.f2674m);
    }

    boolean b(List<SurfaceConfig> list) {
        Iterator<SurfaceCombination> it = this.f2662a.iterator();
        boolean z7 = false;
        while (it.hasNext() && !(z7 = it.next().d(list))) {
        }
        return z7;
    }

    Size m(int i8) {
        return (Size) Collections.max(Arrays.asList(j(i8)), new CompareSizesByArea());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Map<UseCaseConfig<?>, Size> q(@NonNull List<AttachedSurfaceInfo> list, @NonNull List<UseCaseConfig<?>> list2) {
        y();
        ArrayList arrayList = new ArrayList();
        for (AttachedSurfaceInfo attachedSurfaceInfo : list) {
            arrayList.add(attachedSurfaceInfo.d());
        }
        for (UseCaseConfig<?> useCaseConfig : list2) {
            arrayList.add(SurfaceConfig.f(useCaseConfig.getInputFormat(), new Size(640, 480), this.f2674m));
        }
        if (b(arrayList)) {
            List<Integer> u7 = u(list2);
            ArrayList arrayList2 = new ArrayList();
            for (Integer num : u7) {
                arrayList2.add(r(list2.get(num.intValue())));
            }
            HashMap hashMap = null;
            Iterator<List<Size>> it = k(arrayList2).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                List<Size> next = it.next();
                ArrayList arrayList3 = new ArrayList();
                for (AttachedSurfaceInfo attachedSurfaceInfo2 : list) {
                    arrayList3.add(attachedSurfaceInfo2.d());
                }
                for (int i8 = 0; i8 < next.size(); i8++) {
                    arrayList3.add(SurfaceConfig.f(list2.get(u7.get(i8).intValue()).getInputFormat(), next.get(i8), this.f2674m));
                }
                if (b(arrayList3)) {
                    hashMap = new HashMap();
                    for (UseCaseConfig<?> useCaseConfig2 : list2) {
                        hashMap.put(useCaseConfig2, next.get(u7.indexOf(Integer.valueOf(list2.indexOf(useCaseConfig2)))));
                    }
                }
            }
            if (hashMap != null) {
                return hashMap;
            }
            throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + this.f2664c + " and Hardware level: " + this.f2669h + ". May be the specified resolution is too large and not supported. Existing surfaces: " + list + " New configs: " + list2);
        }
        throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + this.f2664c + ".  May be attempting to bind too many use cases. Existing surfaces: " + list + " New configs: " + list2);
    }

    @NonNull
    List<Size> r(@NonNull UseCaseConfig<?> useCaseConfig) {
        int inputFormat = useCaseConfig.getInputFormat();
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) useCaseConfig;
        Size[] l8 = l(inputFormat, imageOutputConfig);
        if (l8 == null) {
            l8 = j(inputFormat);
        }
        ArrayList arrayList = new ArrayList();
        Size g8 = imageOutputConfig.g(null);
        Size m8 = m(inputFormat);
        if (g8 == null || SizeUtil.a(m8) < SizeUtil.a(g8)) {
            g8 = m8;
        }
        Arrays.sort(l8, new CompareSizesByArea(true));
        Size t7 = t(imageOutputConfig);
        Size size = SizeUtil.f3938b;
        int a8 = SizeUtil.a(size);
        if (SizeUtil.a(g8) < a8) {
            size = SizeUtil.f3937a;
        } else if (t7 != null && SizeUtil.a(t7) < a8) {
            size = t7;
        }
        for (Size size2 : l8) {
            if (SizeUtil.a(size2) <= SizeUtil.a(g8) && SizeUtil.a(size2) >= SizeUtil.a(size) && !arrayList.contains(size2)) {
                arrayList.add(size2);
            }
        }
        if (!arrayList.isEmpty()) {
            Rational s7 = s(imageOutputConfig);
            if (t7 == null) {
                t7 = imageOutputConfig.y(null);
            }
            List<Size> arrayList2 = new ArrayList<>();
            new HashMap();
            if (s7 == null) {
                arrayList2.addAll(arrayList);
                if (t7 != null) {
                    z(arrayList2, t7);
                }
            } else {
                Map<Rational, List<Size>> v7 = v(arrayList);
                if (t7 != null) {
                    for (Rational rational : v7.keySet()) {
                        z(v7.get(rational), t7);
                    }
                }
                ArrayList<Rational> arrayList3 = new ArrayList(v7.keySet());
                Collections.sort(arrayList3, new AspectRatioUtil.CompareAspectRatiosByDistanceToTargetRatio(s7));
                for (Rational rational2 : arrayList3) {
                    for (Size size3 : v7.get(rational2)) {
                        if (!arrayList2.contains(size3)) {
                            arrayList2.add(size3);
                        }
                    }
                }
            }
            return this.f2677p.a(SurfaceConfig.d(useCaseConfig.getInputFormat()), arrayList2);
        }
        throw new IllegalArgumentException("Can not get supported output size under supported maximum for the format: " + inputFormat);
    }
}
