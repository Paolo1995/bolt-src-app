package androidx.activity.contextaware;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class ContextAwareHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Set<OnContextAvailableListener> f774a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    private volatile Context f775b;

    public void a(@NonNull OnContextAvailableListener onContextAvailableListener) {
        if (this.f775b != null) {
            onContextAvailableListener.a(this.f775b);
        }
        this.f774a.add(onContextAvailableListener);
    }

    public void b() {
        this.f775b = null;
    }

    public void c(@NonNull Context context) {
        this.f775b = context;
        for (OnContextAvailableListener onContextAvailableListener : this.f774a) {
            onContextAvailableListener.a(context);
        }
    }

    public Context d() {
        return this.f775b;
    }

    public void e(@NonNull OnContextAvailableListener onContextAvailableListener) {
        this.f774a.remove(onContextAvailableListener);
    }
}
