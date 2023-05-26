package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class SurfaceCombination {

    /* renamed from: a  reason: collision with root package name */
    private final List<SurfaceConfig> f3695a = new ArrayList();

    private static void b(List<int[]> list, int i8, int[] iArr, int i9) {
        boolean z7;
        if (i9 >= iArr.length) {
            list.add((int[]) iArr.clone());
            return;
        }
        for (int i10 = 0; i10 < i8; i10++) {
            int i11 = 0;
            while (true) {
                if (i11 < i9) {
                    if (i10 == iArr[i11]) {
                        z7 = true;
                        break;
                    }
                    i11++;
                } else {
                    z7 = false;
                    break;
                }
            }
            if (!z7) {
                iArr[i9] = i10;
                b(list, i8, iArr, i9 + 1);
            }
        }
    }

    private List<int[]> c(int i8) {
        ArrayList arrayList = new ArrayList();
        b(arrayList, i8, new int[i8], 0);
        return arrayList;
    }

    public boolean a(@NonNull SurfaceConfig surfaceConfig) {
        return this.f3695a.add(surfaceConfig);
    }

    public boolean d(@NonNull List<SurfaceConfig> list) {
        if (list.isEmpty()) {
            return true;
        }
        if (list.size() > this.f3695a.size()) {
            return false;
        }
        for (int[] iArr : c(this.f3695a.size())) {
            boolean z7 = true;
            for (int i8 = 0; i8 < this.f3695a.size() && (iArr[i8] >= list.size() || ((z7 = z7 & this.f3695a.get(i8).e(list.get(iArr[i8]))))); i8++) {
            }
            if (z7) {
                return true;
            }
        }
        return false;
    }
}
