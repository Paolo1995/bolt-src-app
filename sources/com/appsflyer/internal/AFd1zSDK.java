package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class AFd1zSDK<Body> implements ResponseNetwork<Body> {
    final int AFInAppEventParameterName;
    final boolean AFInAppEventType;
    @NonNull
    private final Body AFKeystoreWrapper;
    @NonNull
    public final AFc1hSDK valueOf;
    @NonNull
    final Map<String, List<String>> values;

    public AFd1zSDK(@NonNull Body body, int i8, boolean z7, Map<String, List<String>> map, @NonNull AFc1hSDK aFc1hSDK) {
        this.AFKeystoreWrapper = body;
        this.AFInAppEventParameterName = i8;
        this.AFInAppEventType = z7;
        this.values = new HashMap(map);
        this.valueOf = aFc1hSDK;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFd1zSDK aFd1zSDK = (AFd1zSDK) obj;
        if (this.AFInAppEventParameterName != aFd1zSDK.AFInAppEventParameterName || this.AFInAppEventType != aFd1zSDK.AFInAppEventType || !this.AFKeystoreWrapper.equals(aFd1zSDK.AFKeystoreWrapper) || !this.values.equals(aFd1zSDK.values)) {
            return false;
        }
        return this.valueOf.equals(aFd1zSDK.valueOf);
    }

    @Override // com.appsflyer.internal.components.network.http.ResponseNetwork
    @NonNull
    public Body getBody() {
        return this.AFKeystoreWrapper;
    }

    @Override // com.appsflyer.internal.components.network.http.ResponseNetwork
    public List<String> getHeaderField(@NonNull String str) {
        for (String str2 : this.values.keySet()) {
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                return this.values.get(str2);
            }
        }
        return null;
    }

    @Override // com.appsflyer.internal.components.network.http.ResponseNetwork
    public int getStatusCode() {
        return this.AFInAppEventParameterName;
    }

    public int hashCode() {
        return (((((((this.AFKeystoreWrapper.hashCode() * 31) + this.AFInAppEventParameterName) * 31) + (this.AFInAppEventType ? 1 : 0)) * 31) + this.values.hashCode()) * 31) + this.valueOf.hashCode();
    }

    @Override // com.appsflyer.internal.components.network.http.ResponseNetwork
    public boolean isSuccessful() {
        return this.AFInAppEventType;
    }

    public final String values(@NonNull String str) {
        List<String> headerField = getHeaderField(str);
        if (headerField != null && !headerField.isEmpty()) {
            Iterator<String> it = headerField.iterator();
            StringBuilder sb = new StringBuilder(it.next());
            while (it.hasNext()) {
                sb.append(", ");
                sb.append(it.next());
            }
            return sb.toString();
        }
        return null;
    }
}
