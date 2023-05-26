package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Fragment.kt */
/* loaded from: classes.dex */
public final class FragmentKt {
    public static final void clearFragmentResult(Fragment clearFragmentResult, String requestKey) {
        Intrinsics.f(clearFragmentResult, "$this$clearFragmentResult");
        Intrinsics.f(requestKey, "requestKey");
        clearFragmentResult.getParentFragmentManager().clearFragmentResult(requestKey);
    }

    public static final void clearFragmentResultListener(Fragment clearFragmentResultListener, String requestKey) {
        Intrinsics.f(clearFragmentResultListener, "$this$clearFragmentResultListener");
        Intrinsics.f(requestKey, "requestKey");
        clearFragmentResultListener.getParentFragmentManager().clearFragmentResultListener(requestKey);
    }

    public static final void setFragmentResult(Fragment setFragmentResult, String requestKey, Bundle result) {
        Intrinsics.f(setFragmentResult, "$this$setFragmentResult");
        Intrinsics.f(requestKey, "requestKey");
        Intrinsics.f(result, "result");
        setFragmentResult.getParentFragmentManager().setFragmentResult(requestKey, result);
    }

    public static final void setFragmentResultListener(Fragment setFragmentResultListener, String requestKey, final Function2<? super String, ? super Bundle, Unit> listener) {
        Intrinsics.f(setFragmentResultListener, "$this$setFragmentResultListener");
        Intrinsics.f(requestKey, "requestKey");
        Intrinsics.f(listener, "listener");
        setFragmentResultListener.getParentFragmentManager().setFragmentResultListener(requestKey, setFragmentResultListener, new FragmentResultListener() { // from class: androidx.fragment.app.FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0
            @Override // androidx.fragment.app.FragmentResultListener
            public final /* synthetic */ void onFragmentResult(@NonNull String p02, @NonNull Bundle p12) {
                Intrinsics.f(p02, "p0");
                Intrinsics.f(p12, "p1");
                Intrinsics.e(Function2.this.s(p02, p12), "invoke(...)");
            }
        });
    }
}
