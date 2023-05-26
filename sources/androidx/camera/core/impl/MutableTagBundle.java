package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.annotation.NonNull;
import java.util.Map;

/* loaded from: classes.dex */
public class MutableTagBundle extends TagBundle {
    private MutableTagBundle(Map<String, Object> map) {
        super(map);
    }

    @NonNull
    public static MutableTagBundle f() {
        return new MutableTagBundle(new ArrayMap());
    }

    @NonNull
    public static MutableTagBundle g(@NonNull TagBundle tagBundle) {
        ArrayMap arrayMap = new ArrayMap();
        for (String str : tagBundle.d()) {
            arrayMap.put(str, tagBundle.c(str));
        }
        return new MutableTagBundle(arrayMap);
    }

    public void e(@NonNull TagBundle tagBundle) {
        Map<String, Object> map;
        Map<String, Object> map2 = this.f3709a;
        if (map2 != null && (map = tagBundle.f3709a) != null) {
            map2.putAll(map);
        }
    }

    public void h(@NonNull String str, @NonNull Object obj) {
        this.f3709a.put(str, obj);
    }
}
