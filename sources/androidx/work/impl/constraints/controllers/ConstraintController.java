package androidx.work.impl.constraints.controllers;

import androidx.annotation.NonNull;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ConstraintController<T> implements ConstraintListener<T> {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f8524a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private T f8525b;

    /* renamed from: c  reason: collision with root package name */
    private ConstraintTracker<T> f8526c;

    /* renamed from: d  reason: collision with root package name */
    private OnConstraintUpdatedCallback f8527d;

    /* loaded from: classes.dex */
    public interface OnConstraintUpdatedCallback {
        void a(@NonNull List<String> list);

        void b(@NonNull List<String> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintController(ConstraintTracker<T> constraintTracker) {
        this.f8526c = constraintTracker;
    }

    private void h(OnConstraintUpdatedCallback onConstraintUpdatedCallback, T t7) {
        if (!this.f8524a.isEmpty() && onConstraintUpdatedCallback != null) {
            if (t7 != null && !c(t7)) {
                onConstraintUpdatedCallback.a(this.f8524a);
            } else {
                onConstraintUpdatedCallback.b(this.f8524a);
            }
        }
    }

    @Override // androidx.work.impl.constraints.ConstraintListener
    public void a(T t7) {
        this.f8525b = t7;
        h(this.f8527d, t7);
    }

    abstract boolean b(@NonNull WorkSpec workSpec);

    abstract boolean c(@NonNull T t7);

    public boolean d(@NonNull String str) {
        T t7 = this.f8525b;
        if (t7 != null && c(t7) && this.f8524a.contains(str)) {
            return true;
        }
        return false;
    }

    public void e(@NonNull Iterable<WorkSpec> iterable) {
        this.f8524a.clear();
        for (WorkSpec workSpec : iterable) {
            if (b(workSpec)) {
                this.f8524a.add(workSpec.f8618a);
            }
        }
        if (this.f8524a.isEmpty()) {
            this.f8526c.c(this);
        } else {
            this.f8526c.a(this);
        }
        h(this.f8527d, this.f8525b);
    }

    public void f() {
        if (!this.f8524a.isEmpty()) {
            this.f8524a.clear();
            this.f8526c.c(this);
        }
    }

    public void g(OnConstraintUpdatedCallback onConstraintUpdatedCallback) {
        if (this.f8527d != onConstraintUpdatedCallback) {
            this.f8527d = onConstraintUpdatedCallback;
            h(onConstraintUpdatedCallback, this.f8525b);
        }
    }
}
