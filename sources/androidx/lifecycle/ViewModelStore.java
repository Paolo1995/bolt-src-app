package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class ViewModelStore {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, ViewModel> f6804a = new HashMap<>();

    public final void a() {
        for (ViewModel viewModel : this.f6804a.values()) {
            viewModel.clear();
        }
        this.f6804a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ViewModel b(String str) {
        return this.f6804a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> c() {
        return new HashSet(this.f6804a.keySet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(String str, ViewModel viewModel) {
        ViewModel put = this.f6804a.put(str, viewModel);
        if (put != null) {
            put.onCleared();
        }
    }
}
