package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes.dex */
public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight {
    @NonNull
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @NonNull
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    @NonNull
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i8, @NonNull Activity activity, int i9) {
        return getErrorDialog(i8, activity, i9, null);
    }

    @NonNull
    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i8, @NonNull Context context, int i9) {
        return GooglePlayServicesUtilLight.getErrorPendingIntent(i8, context, i9);
    }

    @NonNull
    @VisibleForTesting
    @Deprecated
    public static String getErrorString(int i8) {
        return GooglePlayServicesUtilLight.getErrorString(i8);
    }

    @NonNull
    public static Context getRemoteContext(@NonNull Context context) {
        return GooglePlayServicesUtilLight.getRemoteContext(context);
    }

    @NonNull
    public static Resources getRemoteResource(@NonNull Context context) {
        return GooglePlayServicesUtilLight.getRemoteResource(context);
    }

    @HideFirstParty
    @Deprecated
    public static int isGooglePlayServicesAvailable(@NonNull Context context) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i8) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i8);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i8, @NonNull Activity activity, int i9) {
        return showErrorDialogFragment(i8, activity, i9, null);
    }

    @Deprecated
    public static void showErrorNotification(int i8, @NonNull Context context) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (!GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i8) && !GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i8)) {
            googleApiAvailability.showErrorNotification(context, i8);
        } else {
            googleApiAvailability.zaf(context);
        }
    }

    @Deprecated
    public static Dialog getErrorDialog(int i8, @NonNull Activity activity, int i9, DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i8)) {
            i8 = 18;
        }
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, i8, i9, onCancelListener);
    }

    @KeepForSdk
    @Deprecated
    public static int isGooglePlayServicesAvailable(@NonNull Context context, int i8) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i8);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i8, @NonNull Activity activity, int i9, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i8, activity, null, i9, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i8, @NonNull Activity activity, Fragment fragment, int i9, DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i8)) {
            i8 = 18;
        }
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (fragment == null) {
            return googleApiAvailability.showErrorDialogFragment(activity, i8, i9, onCancelListener);
        }
        Dialog zaa = googleApiAvailability.zaa(activity, i8, zag.zac(fragment, GoogleApiAvailability.getInstance().getErrorResolutionIntent(activity, i8, "d"), i9), onCancelListener);
        if (zaa == null) {
            return false;
        }
        googleApiAvailability.zad(activity, zaa, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }
}
