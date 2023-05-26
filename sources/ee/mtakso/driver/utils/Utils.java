package ee.mtakso.driver.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.appcompat.app.AlertDialog;
import ee.mtakso.driver.R;
import eu.bolt.kalev.Kalev;

/* loaded from: classes5.dex */
public class Utils {
    public static void b(Activity activity, String str) {
        if (activity == null) {
            Kalev.d("callClient(): context was null");
        } else if (str != null && !str.isEmpty()) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
            intent.addFlags(268435456);
            if (f(activity, intent)) {
                activity.startActivity(intent);
                return;
            }
            AlertDialog.Builder h8 = new AlertDialog.Builder(activity).h(R.string.error);
            h8.i(activity.getString(R.string.no_call_functionality) + "\n" + activity.getString(R.string.phone) + " " + str).l(R.string.ok_lowercase, new DialogInterface.OnClickListener() { // from class: ee.mtakso.driver.utils.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i8) {
                    dialogInterface.dismiss();
                }
            }).a().show();
        } else {
            Kalev.d("callClient(): phone number was null or empty.");
        }
    }

    private static String c(String str) {
        if (str != null && str.length() != 0) {
            char charAt = str.charAt(0);
            if (Character.isUpperCase(charAt)) {
                return str;
            }
            return Character.toUpperCase(charAt) + str.substring(1);
        }
        return "";
    }

    public static String d() {
        return Build.VERSION.RELEASE;
    }

    public static String e() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2 != null && str2.startsWith(str)) {
            return c(str2);
        }
        return c(str) + " " + str2;
    }

    private static boolean f(Context context, Intent intent) {
        if (context.getPackageManager().queryIntentActivities(intent, 0).size() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean g(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public static boolean h(Context context) {
        return context.getResources().getBoolean(R.bool.is_tablet);
    }
}
