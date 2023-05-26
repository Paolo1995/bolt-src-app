package com.clevertap.android.sdk;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CTWebInterface {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<CleverTapAPI> f10856a;

    public CTWebInterface(CleverTapAPI cleverTapAPI) {
        this.f10856a = new WeakReference<>(cleverTapAPI);
    }

    @JavascriptInterface
    public void addMultiValueForKey(String str, String str2) {
        CleverTapAPI cleverTapAPI = this.f10856a.get();
        if (cleverTapAPI == null) {
            Logger.a("CleverTap Instance is null.");
        } else {
            cleverTapAPI.g(str, str2);
        }
    }

    @JavascriptInterface
    public void addMultiValuesForKey(String str, String str2) {
        CleverTapAPI cleverTapAPI = this.f10856a.get();
        if (cleverTapAPI == null) {
            Logger.a("CleverTap Instance is null.");
        } else if (str == null) {
            Logger.n("Key passed to CTWebInterface is null");
        } else if (str2 != null) {
            try {
                cleverTapAPI.h(str, Utils.f(new JSONArray(str2)));
            } catch (JSONException e8) {
                Logger.n("Unable to parse values from WebView " + e8.getLocalizedMessage());
            }
        } else {
            Logger.n("values passed to CTWebInterface is null");
        }
    }

    @JavascriptInterface
    public void pushChargedEvent(String str, String str2) {
        CleverTapAPI cleverTapAPI = this.f10856a.get();
        if (cleverTapAPI == null) {
            Logger.a("CleverTap Instance is null.");
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        if (str != null) {
            try {
                hashMap = Utils.g(new JSONObject(str));
            } catch (JSONException e8) {
                Logger.n("Unable to parse chargeDetails for Charged Event from WebView " + e8.getLocalizedMessage());
            }
            ArrayList<HashMap<String, Object>> arrayList = null;
            if (str2 != null) {
                try {
                    arrayList = Utils.e(new JSONArray(str2));
                } catch (JSONException e9) {
                    Logger.n("Unable to parse items for Charged Event from WebView " + e9.getLocalizedMessage());
                }
                cleverTapAPI.X(hashMap, arrayList);
                return;
            }
            return;
        }
        Logger.n("chargeDetails passed to CTWebInterface is null");
    }

    @JavascriptInterface
    public void pushEvent(String str) {
        CleverTapAPI cleverTapAPI = this.f10856a.get();
        if (cleverTapAPI == null) {
            Logger.a("CleverTap Instance is null.");
        } else {
            cleverTapAPI.Y(str);
        }
    }

    @JavascriptInterface
    public void pushProfile(String str) {
        CleverTapAPI cleverTapAPI = this.f10856a.get();
        if (cleverTapAPI == null) {
            Logger.a("CleverTap Instance is null.");
        } else if (str != null) {
            try {
                cleverTapAPI.c0(Utils.g(new JSONObject(str)));
            } catch (JSONException e8) {
                Logger.n("Unable to parse profile from WebView " + e8.getLocalizedMessage());
            }
        } else {
            Logger.n("profile passed to CTWebInterface is null");
        }
    }

    @JavascriptInterface
    public void removeMultiValueForKey(String str, String str2) {
        CleverTapAPI cleverTapAPI = this.f10856a.get();
        if (cleverTapAPI == null) {
            Logger.a("CleverTap Instance is null.");
        } else if (str == null) {
            Logger.n("Key passed to CTWebInterface is null");
        } else if (str2 == null) {
            Logger.n("Value passed to CTWebInterface is null");
        } else {
            cleverTapAPI.d0(str, str2);
        }
    }

    @JavascriptInterface
    public void removeMultiValuesForKey(String str, String str2) {
        CleverTapAPI cleverTapAPI = this.f10856a.get();
        if (cleverTapAPI == null) {
            Logger.a("CleverTap Instance is null.");
        } else if (str == null) {
            Logger.n("Key passed to CTWebInterface is null");
        } else if (str2 != null) {
            try {
                cleverTapAPI.e0(str, Utils.f(new JSONArray(str2)));
            } catch (JSONException e8) {
                Logger.n("Unable to parse values from WebView " + e8.getLocalizedMessage());
            }
        } else {
            Logger.n("values passed to CTWebInterface is null");
        }
    }

    @JavascriptInterface
    public void removeValueForKey(String str) {
        CleverTapAPI cleverTapAPI = this.f10856a.get();
        if (cleverTapAPI == null) {
            Logger.a("CleverTap Instance is null.");
        } else if (str == null) {
            Logger.n("Key passed to CTWebInterface is null");
        } else {
            cleverTapAPI.f0(str);
        }
    }

    @JavascriptInterface
    public void setMultiValueForKey(String str, String str2) {
        CleverTapAPI cleverTapAPI = this.f10856a.get();
        if (cleverTapAPI == null) {
            Logger.a("CleverTap Instance is null.");
        } else if (str == null) {
            Logger.n("Key passed to CTWebInterface is null");
        } else if (str2 != null) {
            try {
                cleverTapAPI.m0(str, Utils.f(new JSONArray(str2)));
            } catch (JSONException e8) {
                Logger.n("Unable to parse values from WebView " + e8.getLocalizedMessage());
            }
        } else {
            Logger.n("values passed to CTWebInterface is null");
        }
    }

    @JavascriptInterface
    public void pushEvent(String str, String str2) {
        CleverTapAPI cleverTapAPI = this.f10856a.get();
        if (cleverTapAPI == null) {
            Logger.a("CleverTap Instance is null.");
        } else if (str2 != null) {
            try {
                cleverTapAPI.Z(str, Utils.g(new JSONObject(str2)));
            } catch (JSONException e8) {
                Logger.n("Unable to parse eventActions from WebView " + e8.getLocalizedMessage());
            }
        } else {
            Logger.n("eventActions passed to CTWebInterface is null");
        }
    }
}
