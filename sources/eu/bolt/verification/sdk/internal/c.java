package eu.bolt.verification.sdk.internal;

import android.os.Build;
import android.window.SplashScreen;
import android.window.SplashScreenView;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SplashScreenView splashScreenView) {
        Intrinsics.f(splashScreenView, "splashScreenView");
        splashScreenView.remove();
    }

    public static final void c(AppCompatActivity appCompatActivity) {
        Intrinsics.f(appCompatActivity, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            appCompatActivity.getSplashScreen().setOnExitAnimationListener(new SplashScreen.OnExitAnimationListener() { // from class: eu.bolt.verification.sdk.internal.bl
                public final void onSplashScreenExit(SplashScreenView splashScreenView) {
                    c.b(splashScreenView);
                }
            });
        }
    }
}
