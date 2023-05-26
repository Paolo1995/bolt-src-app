package io.netty.handler.ssl;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
final class OpenSslKeyMaterialManager {
    private static final Map<String, String> KEY_TYPES;
    private final OpenSslKeyMaterialProvider provider;

    static {
        HashMap hashMap = new HashMap();
        KEY_TYPES = hashMap;
        hashMap.put("RSA", "RSA");
        hashMap.put("DHE_RSA", "RSA");
        hashMap.put("ECDHE_RSA", "RSA");
        hashMap.put("ECDHE_ECDSA", "EC");
        hashMap.put("ECDH_RSA", "EC_RSA");
        hashMap.put("ECDH_ECDSA", "EC_EC");
        hashMap.put("DH_RSA", "DH_RSA");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSslKeyMaterialManager(OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
        this.provider = openSslKeyMaterialProvider;
    }
}
