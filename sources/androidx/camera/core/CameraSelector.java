package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.LensFacingCameraFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class CameraSelector {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public static final CameraSelector f3052b = new Builder().d(0).b();
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public static final CameraSelector f3053c = new Builder().d(1).b();

    /* renamed from: a  reason: collision with root package name */
    private LinkedHashSet<CameraFilter> f3054a;

    CameraSelector(LinkedHashSet<CameraFilter> linkedHashSet) {
        this.f3054a = linkedHashSet;
    }

    @NonNull
    public LinkedHashSet<CameraInternal> a(@NonNull LinkedHashSet<CameraInternal> linkedHashSet) {
        ArrayList arrayList = new ArrayList();
        Iterator<CameraInternal> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().g());
        }
        List<CameraInfo> b8 = b(arrayList);
        LinkedHashSet<CameraInternal> linkedHashSet2 = new LinkedHashSet<>();
        Iterator<CameraInternal> it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            CameraInternal next = it2.next();
            if (b8.contains(next.g())) {
                linkedHashSet2.add(next);
            }
        }
        return linkedHashSet2;
    }

    @NonNull
    public List<CameraInfo> b(@NonNull List<CameraInfo> list) {
        List<CameraInfo> arrayList = new ArrayList<>(list);
        Iterator<CameraFilter> it = this.f3054a.iterator();
        while (it.hasNext()) {
            arrayList = it.next().b(Collections.unmodifiableList(arrayList));
        }
        arrayList.retainAll(list);
        return arrayList;
    }

    @NonNull
    public LinkedHashSet<CameraFilter> c() {
        return this.f3054a;
    }

    public Integer d() {
        Iterator<CameraFilter> it = this.f3054a.iterator();
        Integer num = null;
        while (it.hasNext()) {
            CameraFilter next = it.next();
            if (next instanceof LensFacingCameraFilter) {
                Integer valueOf = Integer.valueOf(((LensFacingCameraFilter) next).c());
                if (num == null) {
                    num = valueOf;
                } else if (!num.equals(valueOf)) {
                    throw new IllegalStateException("Multiple conflicting lens facing requirements exist.");
                }
            }
        }
        return num;
    }

    @NonNull
    public CameraInternal e(@NonNull LinkedHashSet<CameraInternal> linkedHashSet) {
        Iterator<CameraInternal> it = a(linkedHashSet).iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new IllegalArgumentException("No available camera can be found");
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final LinkedHashSet<CameraFilter> f3055a;

        public Builder() {
            this.f3055a = new LinkedHashSet<>();
        }

        @NonNull
        public static Builder c(@NonNull CameraSelector cameraSelector) {
            return new Builder(cameraSelector.c());
        }

        @NonNull
        public Builder a(@NonNull CameraFilter cameraFilter) {
            this.f3055a.add(cameraFilter);
            return this;
        }

        @NonNull
        public CameraSelector b() {
            return new CameraSelector(this.f3055a);
        }

        @NonNull
        public Builder d(int i8) {
            this.f3055a.add(new LensFacingCameraFilter(i8));
            return this;
        }

        private Builder(@NonNull LinkedHashSet<CameraFilter> linkedHashSet) {
            this.f3055a = new LinkedHashSet<>(linkedHashSet);
        }
    }
}
