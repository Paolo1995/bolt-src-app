package com.appsflyer.internal;

import com.appsflyer.internal.platform_extension.Plugin;
import com.appsflyer.internal.platform_extension.PluginInfo;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class AFf1sSDK implements AFf1uSDK {
    private PluginInfo values = new PluginInfo(Plugin.NATIVE, "6.10.2", null, 4, null);

    @Override // com.appsflyer.internal.AFf1uSDK
    public final void values(PluginInfo pluginInfo) {
        Intrinsics.f(pluginInfo, "");
        this.values = pluginInfo;
    }

    @Override // com.appsflyer.internal.AFf1uSDK
    public final Map<String, Object> values() {
        Map<String, Object> k8;
        k8 = MapsKt__MapsKt.k(TuplesKt.a("platform", this.values.getPlugin().getPluginName()), TuplesKt.a("version", this.values.getVersion()));
        if (!this.values.getAdditionalParams().isEmpty()) {
            k8.put("extras", this.values.getAdditionalParams());
        }
        return k8;
    }
}
