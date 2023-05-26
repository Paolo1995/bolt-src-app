package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.annotation.NonNull;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class TagBundle {

    /* renamed from: b  reason: collision with root package name */
    private static final TagBundle f3708b = new TagBundle(new ArrayMap());

    /* renamed from: a  reason: collision with root package name */
    protected final Map<String, Object> f3709a;

    /* JADX INFO: Access modifiers changed from: protected */
    public TagBundle(@NonNull Map<String, Object> map) {
        this.f3709a = map;
    }

    @NonNull
    public static TagBundle a() {
        return f3708b;
    }

    @NonNull
    public static TagBundle b(@NonNull TagBundle tagBundle) {
        ArrayMap arrayMap = new ArrayMap();
        for (String str : tagBundle.d()) {
            arrayMap.put(str, tagBundle.c(str));
        }
        return new TagBundle(arrayMap);
    }

    public Object c(@NonNull String str) {
        return this.f3709a.get(str);
    }

    @NonNull
    public Set<String> d() {
        return this.f3709a.keySet();
    }

    @NonNull
    public final String toString() {
        return "android.hardware.camera2.CaptureRequest.setTag.CX";
    }
}
