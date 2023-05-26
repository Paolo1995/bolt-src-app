package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class NestedScrollingParentHelper {

    /* renamed from: a  reason: collision with root package name */
    private int f5953a;

    /* renamed from: b  reason: collision with root package name */
    private int f5954b;

    public NestedScrollingParentHelper(@NonNull ViewGroup viewGroup) {
    }

    public int a() {
        return this.f5953a | this.f5954b;
    }

    public void b(@NonNull View view, @NonNull View view2, int i8) {
        c(view, view2, i8, 0);
    }

    public void c(@NonNull View view, @NonNull View view2, int i8, int i9) {
        if (i9 == 1) {
            this.f5954b = i8;
        } else {
            this.f5953a = i8;
        }
    }

    public void d(@NonNull View view, int i8) {
        if (i8 == 1) {
            this.f5954b = 0;
        } else {
            this.f5953a = 0;
        }
    }
}
