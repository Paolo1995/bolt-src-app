package ee.mtakso.driver.di.modules;

import android.accounts.AccountManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.PowerManager;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import ee.mtakso.App;
import org.webrtc.MediaStreamTrack;

@Module
/* loaded from: classes3.dex */
public abstract class AndroidModule {
    public static <T> T c(Context context, String str) {
        return (T) context.getSystemService(str);
    }

    @Provides
    static AccountManager d(Context context) {
        return AccountManager.get(context);
    }

    @Provides
    static ApplicationInfo e(Context context) {
        return context.getApplicationInfo();
    }

    @Provides
    static AudioManager f(Context context) {
        return (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
    }

    @Provides
    static ClassLoader g(Context context) {
        return context.getClassLoader();
    }

    @Provides
    static SharedPreferences h(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    static InputMethodManager i(Context context) {
        return (InputMethodManager) context.getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static NotificationManager j(Context context) {
        return (NotificationManager) context.getSystemService("notification");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static PackageInfo k(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e8) {
            throw new RuntimeException(e8);
        }
    }

    @Provides
    static TelephonyManager l(Context context) {
        return (TelephonyManager) c(context, "phone");
    }

    @Provides
    static Vibrator m(Context context) {
        return (Vibrator) context.getSystemService("vibrator");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static WindowManager n(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static ConnectivityManager o(Context context) {
        return (ConnectivityManager) c(context, "connectivity");
    }

    @Provides
    static LayoutInflater p(Context context) {
        return (LayoutInflater) c(context, "layout_inflater");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static PackageManager q(Context context) {
        return context.getPackageManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static PowerManager r(Context context) {
        return (PowerManager) context.getSystemService("power");
    }

    @Binds
    abstract Application a(App app);

    @Binds
    abstract Context b(App app);
}
