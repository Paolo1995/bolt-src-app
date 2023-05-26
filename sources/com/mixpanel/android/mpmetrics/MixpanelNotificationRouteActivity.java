package com.mixpanel.android.mpmetrics;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;
import com.mixpanel.android.mpmetrics.MixpanelNotificationData;
import com.mixpanel.android.util.MPLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MixpanelNotificationRouteActivity extends Activity {

    /* renamed from: f  reason: collision with root package name */
    protected final String f19307f = "MixpanelAPI.MixpanelNotificationRouteActivity";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mixpanel.android.mpmetrics.MixpanelNotificationRouteActivity$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19308a;

        static {
            int[] iArr = new int[MixpanelNotificationData.PushTapActionType.values().length];
            f19308a = iArr;
            try {
                iArr[MixpanelNotificationData.PushTapActionType.HOMESCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19308a[MixpanelNotificationData.PushTapActionType.URL_IN_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19308a[MixpanelNotificationData.PushTapActionType.DEEP_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected Intent a(Intent intent) {
        MixpanelNotificationData.PushTapActionType a8;
        CharSequence charSequence = intent.getExtras().getCharSequence("mp_tap_action_type");
        if (charSequence == null) {
            MPLog.a("MixpanelAPI.MixpanelNotificationRouteActivity", "Notification action click logged with no action type");
            a8 = MixpanelNotificationData.PushTapActionType.HOMESCREEN;
        } else {
            a8 = MixpanelNotificationData.PushTapActionType.a(charSequence.toString());
        }
        CharSequence charSequence2 = intent.getExtras().getCharSequence("mp_tap_action_uri");
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        int i8 = AnonymousClass1.f19308a[a8.ordinal()];
        if (i8 != 2) {
            if (i8 != 3) {
                return launchIntentForPackage;
            }
            return new Intent("android.intent.action.VIEW", Uri.parse(charSequence2.toString()));
        } else if (URLUtil.isValidUrl(charSequence2.toString())) {
            return new Intent("android.intent.action.VIEW", Uri.parse(charSequence2.toString())).addCategory("android.intent.category.BROWSABLE");
        } else {
            MPLog.a("MixpanelAPI.MixpanelNotificationRouteActivity", "Wanted to open url in browser but url is invalid: " + charSequence2.toString() + ". Starting default intent");
            return launchIntentForPackage;
        }
    }

    protected void b(Intent intent) {
        String str;
        String stringExtra = intent.getStringExtra("mp_tap_target");
        String stringExtra2 = intent.getStringExtra("mp_tap_action_type");
        String stringExtra3 = intent.getStringExtra("mp_tap_action_uri");
        Boolean valueOf = Boolean.valueOf(intent.getBooleanExtra("mp_is_sticky", false));
        String str2 = null;
        if (stringExtra != null && stringExtra.equals("button")) {
            str2 = intent.getStringExtra("mp_button_id");
            str = intent.getStringExtra("mp_button_label");
        } else {
            str = null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("$tap_target", stringExtra);
            jSONObject.putOpt("$tap_action_type", stringExtra2);
            jSONObject.putOpt("$tap_action_uri", stringExtra3);
            jSONObject.putOpt("$is_sticky", valueOf);
            jSONObject.putOpt("$button_id", str2);
            jSONObject.putOpt("$button_label", str);
        } catch (JSONException e8) {
            MPLog.d("MixpanelAPI.MixpanelNotificationRouteActivity", "Error adding tracking JSON properties.", e8);
        }
        MixpanelAPI.Z(getApplicationContext(), intent, "$push_notification_tap", jSONObject);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            b(intent);
            Intent a8 = a(intent);
            if (!extras.getBoolean("mp_is_sticky")) {
                MixpanelFCMMessagingService mixpanelFCMMessagingService = new MixpanelFCMMessagingService();
                Context applicationContext = getApplicationContext();
                getApplicationContext();
                mixpanelFCMMessagingService.b(extras, (NotificationManager) applicationContext.getSystemService("notification"));
            }
            finish();
            startActivity(a8);
            return;
        }
        MPLog.a("MixpanelAPI.MixpanelNotificationRouteActivity", "Notification route activity given null intent or null extras.");
    }
}
