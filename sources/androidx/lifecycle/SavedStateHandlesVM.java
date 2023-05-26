package androidx.lifecycle;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: SavedStateHandleSupport.kt */
/* loaded from: classes.dex */
public final class SavedStateHandlesVM extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, SavedStateHandle> f6767a = new LinkedHashMap();

    public final Map<String, SavedStateHandle> a() {
        return this.f6767a;
    }
}
