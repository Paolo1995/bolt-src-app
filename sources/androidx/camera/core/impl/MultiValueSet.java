package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class MultiValueSet<C> {

    /* renamed from: a  reason: collision with root package name */
    private Set<C> f3669a = new HashSet();

    public void a(@NonNull List<C> list) {
        this.f3669a.addAll(list);
    }

    @Override // 
    @NonNull
    /* renamed from: b */
    public abstract MultiValueSet<C> clone();

    @NonNull
    public List<C> c() {
        return Collections.unmodifiableList(new ArrayList(this.f3669a));
    }
}
