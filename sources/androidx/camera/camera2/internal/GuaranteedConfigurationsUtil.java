package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class GuaranteedConfigurationsUtil {
    private GuaranteedConfigurationsUtil() {
    }

    @NonNull
    public static List<SurfaceCombination> a(int i8, boolean z7, boolean z8) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(d());
        if (i8 == 0 || i8 == 1 || i8 == 3) {
            arrayList.addAll(f());
        }
        if (i8 == 1 || i8 == 3) {
            arrayList.addAll(c());
        }
        if (z7) {
            arrayList.addAll(g());
        }
        if (z8 && i8 == 0) {
            arrayList.addAll(b());
        }
        if (i8 == 3) {
            arrayList.addAll(e());
        }
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> b() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.a(SurfaceConfig.a(configType, configSize2));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination2.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.a(SurfaceConfig.a(configType2, configSize));
        surfaceCombination3.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(surfaceCombination3);
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> c() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.a(SurfaceConfig.a(configType, configSize2));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination2.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.a(SurfaceConfig.a(configType2, configSize));
        surfaceCombination3.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.a(SurfaceConfig.a(configType, configSize));
        surfaceCombination4.a(SurfaceConfig.a(configType, configSize));
        surfaceCombination4.a(SurfaceConfig.a(SurfaceConfig.ConfigType.JPEG, configSize2));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.VGA;
        surfaceCombination5.a(SurfaceConfig.a(configType2, configSize3));
        surfaceCombination5.a(SurfaceConfig.a(configType, configSize));
        surfaceCombination5.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.a(SurfaceConfig.a(configType2, configSize3));
        surfaceCombination6.a(SurfaceConfig.a(configType2, configSize));
        surfaceCombination6.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(surfaceCombination6);
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> d() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.JPEG;
        surfaceCombination2.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination3.a(SurfaceConfig.a(configType3, configSize));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination4.a(SurfaceConfig.a(configType, configSize2));
        surfaceCombination4.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.a(SurfaceConfig.a(configType3, configSize2));
        surfaceCombination5.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.a(SurfaceConfig.a(configType, configSize2));
        surfaceCombination6.a(SurfaceConfig.a(configType, configSize2));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.a(SurfaceConfig.a(configType, configSize2));
        surfaceCombination7.a(SurfaceConfig.a(configType3, configSize2));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.a(SurfaceConfig.a(configType, configSize2));
        surfaceCombination8.a(SurfaceConfig.a(configType3, configSize2));
        surfaceCombination8.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(surfaceCombination8);
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> e() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.VGA;
        surfaceCombination.a(SurfaceConfig.a(configType, configSize2));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.a(SurfaceConfig.a(configType2, configSize3));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.RAW;
        surfaceCombination.a(SurfaceConfig.a(configType3, configSize3));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.a(SurfaceConfig.a(configType, configSize));
        surfaceCombination2.a(SurfaceConfig.a(configType, configSize2));
        surfaceCombination2.a(SurfaceConfig.a(SurfaceConfig.ConfigType.JPEG, configSize3));
        surfaceCombination2.a(SurfaceConfig.a(configType3, configSize3));
        arrayList.add(surfaceCombination2);
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> f() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.RECORD;
        surfaceCombination.a(SurfaceConfig.a(configType, configSize2));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination2.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.a(SurfaceConfig.a(configType2, configSize));
        surfaceCombination3.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.a(SurfaceConfig.a(configType, configSize));
        surfaceCombination4.a(SurfaceConfig.a(configType, configSize2));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        surfaceCombination4.a(SurfaceConfig.a(configType3, configSize2));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.a(SurfaceConfig.a(configType, configSize));
        surfaceCombination5.a(SurfaceConfig.a(configType2, configSize2));
        surfaceCombination5.a(SurfaceConfig.a(configType3, configSize2));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.a(SurfaceConfig.a(configType2, configSize));
        surfaceCombination6.a(SurfaceConfig.a(configType2, configSize));
        surfaceCombination6.a(SurfaceConfig.a(configType3, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination6);
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> g() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.RAW;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination2.a(SurfaceConfig.a(configType2, configSize2));
        surfaceCombination2.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination3.a(SurfaceConfig.a(configType3, configSize2));
        surfaceCombination3.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.a(SurfaceConfig.a(configType2, configSize2));
        surfaceCombination4.a(SurfaceConfig.a(configType2, configSize2));
        surfaceCombination4.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.a(SurfaceConfig.a(configType2, configSize2));
        surfaceCombination5.a(SurfaceConfig.a(configType3, configSize2));
        surfaceCombination5.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.a(SurfaceConfig.a(configType3, configSize2));
        surfaceCombination6.a(SurfaceConfig.a(configType3, configSize2));
        surfaceCombination6.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.a(SurfaceConfig.a(configType2, configSize2));
        SurfaceConfig.ConfigType configType4 = SurfaceConfig.ConfigType.JPEG;
        surfaceCombination7.a(SurfaceConfig.a(configType4, configSize));
        surfaceCombination7.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.a(SurfaceConfig.a(configType3, configSize2));
        surfaceCombination8.a(SurfaceConfig.a(configType4, configSize));
        surfaceCombination8.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(surfaceCombination8);
        return arrayList;
    }
}
