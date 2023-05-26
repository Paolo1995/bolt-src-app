package ee.mtakso.driver.ui.common.progress.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.common.progress.view.ProgressViewInflater;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgressViewInflater.kt */
/* loaded from: classes3.dex */
public final class ProgressViewInflater {

    /* renamed from: a  reason: collision with root package name */
    public static final ProgressViewInflater f26390a = new ProgressViewInflater();

    private ProgressViewInflater() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View view) {
    }

    private final View g(ViewGroup viewGroup) {
        View findViewById = viewGroup.findViewById(R.id.progressOverlay);
        if (findViewById == null) {
            View findViewById2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_loader_overlay, viewGroup, true).findViewById(R.id.progressOverlay);
            Intrinsics.e(findViewById2, "from(root.context)\n     …yId(R.id.progressOverlay)");
            return findViewById2;
        }
        return findViewById;
    }

    public final ProgressViewController c(ViewGroup root) {
        Intrinsics.f(root, "root");
        View g8 = g(root);
        g8.setOnClickListener(new View.OnClickListener() { // from class: n2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProgressViewInflater.e(view);
            }
        });
        return new ProgressViewController(g8);
    }

    public final ProgressViewController d(ViewGroup root, String message) {
        Intrinsics.f(root, "root");
        Intrinsics.f(message, "message");
        View g8 = g(root);
        g8.setOnClickListener(new View.OnClickListener() { // from class: n2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProgressViewInflater.f(view);
            }
        });
        ((TextView) g8.findViewById(R.id.labelLoader)).setText(message);
        return new ProgressViewController(g8);
    }
}
