package com.appsflyer.internal;

import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public final class AFd1cSDK extends AFd1iSDK<Map<String, String>> {
    private String AFLogger$LogLevel;
    private final boolean AFVersionDeclaration;
    private String afErrorLogForExcManagerOnly;
    public AFa1vSDK afRDLog;
    private final AFc1kSDK afWarnLog;
    private String getLevel;
    private final UUID onInstallConversionFailureNative;

    /* loaded from: classes.dex */
    public interface AFa1vSDK {
        void valueOf(String str);

        void valueOf(Map<String, String> map);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFd1cSDK(@NonNull AFc1vSDK aFc1vSDK, @NonNull UUID uuid, @NonNull Uri uri) {
        super(AFd1rSDK.ONELINK, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, uuid.toString());
        boolean z7 = false;
        this.afWarnLog = aFc1vSDK.AFInAppEventType();
        this.onInstallConversionFailureNative = uuid;
        if (!AFb1mSDK.valueOf(uri.getHost()) && !AFb1mSDK.valueOf(uri.getPath())) {
            try {
                try {
                    Object invoke = ((Class) AFb1lSDK.AFInAppEventParameterName(TextUtils.getCapsMode("", 0, 0) + 37, (-1) - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 46477))).getMethod("valueOf", null).invoke(((Class) AFb1lSDK.AFInAppEventParameterName(TextUtils.indexOf("", "", 0, 0) + 37, (-1) - TextUtils.lastIndexOf("", '0', 0, 0), (char) (((Process.getThreadPriority(0) + 20) >> 6) + 46478))).getDeclaredConstructor(Uri.class).newInstance(uri), null);
                    try {
                        boolean booleanValue = ((Boolean) ((Class) AFb1lSDK.AFInAppEventParameterName((ViewConfiguration.getScrollBarSize() >> 8) + 52, TextUtils.indexOf((CharSequence) "", '0', 0) + 38, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("AFKeystoreWrapper", null).invoke(invoke, null)).booleanValue();
                        try {
                            z7 = ((Boolean) ((Class) AFb1lSDK.AFInAppEventParameterName(52 - (ViewConfiguration.getTapTimeout() >> 16), TextUtils.lastIndexOf("", '0', 0, 0) + 38, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("valueOf", null).invoke(invoke, null)).booleanValue();
                            String[] split = uri.getPath().split("/");
                            if (booleanValue && split.length == 3) {
                                this.AFLogger$LogLevel = split[1];
                                this.afErrorLogForExcManagerOnly = split[2];
                                this.getLevel = uri.toString();
                            }
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause != null) {
                                throw cause;
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 != null) {
                            throw cause2;
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 != null) {
                        throw cause3;
                    }
                    throw th3;
                }
            } catch (Throwable th4) {
                Throwable cause4 = th4.getCause();
                if (cause4 != null) {
                    throw cause4;
                }
                throw th4;
            }
        }
        this.AFVersionDeclaration = z7;
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final AFc1jSDK<Map<String, String>> AFInAppEventType(@NonNull String str) {
        return this.afWarnLog.values(this.AFLogger$LogLevel, this.afErrorLogForExcManagerOnly, this.onInstallConversionFailureNative, str);
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    public final boolean AFVersionDeclaration() {
        return this.AFVersionDeclaration;
    }

    public final boolean afErrorLogForExcManagerOnly() {
        if (!TextUtils.isEmpty(this.AFLogger$LogLevel) && !TextUtils.isEmpty(this.afErrorLogForExcManagerOnly) && !this.AFLogger$LogLevel.equals("app")) {
            return true;
        }
        return false;
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final boolean afRDLog() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final boolean getLevel() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1iSDK, com.appsflyer.internal.AFd1pSDK
    public final long valueOf() {
        return 3000L;
    }

    @Override // com.appsflyer.internal.AFd1iSDK, com.appsflyer.internal.AFd1pSDK
    public final void values() {
        ResponseNetwork responseNetwork;
        super.values();
        AFa1vSDK aFa1vSDK = this.afRDLog;
        if (aFa1vSDK != null) {
            if (this.valueOf == AFd1tSDK.SUCCESS && (responseNetwork = this.afErrorLog) != null) {
                aFa1vSDK.valueOf((Map) responseNetwork.getBody());
                return;
            }
            Throwable afInfoLog = afInfoLog();
            String str = "Can't get OneLink data";
            if (afInfoLog instanceof ParsingException) {
                if (((ParsingException) afInfoLog).getRawResponse().isSuccessful()) {
                    aFa1vSDK.valueOf("Can't parse one link data");
                    return;
                }
                String str2 = this.getLevel;
                if (str2 != null) {
                    str = str2;
                }
                aFa1vSDK.valueOf(str);
                return;
            }
            String str3 = this.getLevel;
            if (str3 != null) {
                str = str3;
            }
            aFa1vSDK.valueOf(str);
        }
    }
}
