package ee.mtakso.driver.uicore.components.views.swipe.states;

import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.text.TextUtilsCompat;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipeStrategy.kt */
/* loaded from: classes5.dex */
public interface SwipeStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f35713a = Companion.f35714a;

    /* compiled from: SwipeStrategy.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f35714a = new Companion();

        private Companion() {
        }

        public final SwipeStrategy a(Rect parentBounds) {
            Intrinsics.f(parentBounds, "parentBounds");
            if (b()) {
                return new RtlSwipeStrategy(parentBounds);
            }
            return new LtrSwipeStrategy(parentBounds);
        }

        public final boolean b() {
            if (TextUtilsCompat.a(Locale.getDefault()) == 0) {
                return true;
            }
            return false;
        }
    }

    void a(AppCompatImageView appCompatImageView);

    int b(float f8, View view);

    boolean c(View view);

    int d(int i8, View view);

    float e(View view);
}
