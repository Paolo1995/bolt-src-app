package androidx.transition;

import android.view.View;
import android.view.WindowId;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
class WindowIdApi18 implements WindowIdImpl {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f7913a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowIdApi18(@NonNull View view) {
        this.f7913a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof WindowIdApi18) && ((WindowIdApi18) obj).f7913a.equals(this.f7913a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f7913a.hashCode();
    }
}
