package com.appsflyer.internal.platform_extension;

import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class PluginInfo {
    private final String AFInAppEventType;
    private final Plugin valueOf;
    private final Map<String, String> values;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PluginInfo(Plugin plugin, String str) {
        this(plugin, str, null, 4, null);
        Intrinsics.f(plugin, "");
        Intrinsics.f(str, "");
    }

    public PluginInfo(Plugin plugin, String str, Map<String, String> map) {
        Intrinsics.f(plugin, "");
        Intrinsics.f(str, "");
        Intrinsics.f(map, "");
        this.valueOf = plugin;
        this.AFInAppEventType = str;
        this.values = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PluginInfo copy$default(PluginInfo pluginInfo, Plugin plugin, String str, Map map, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            plugin = pluginInfo.valueOf;
        }
        if ((i8 & 2) != 0) {
            str = pluginInfo.AFInAppEventType;
        }
        if ((i8 & 4) != 0) {
            map = pluginInfo.values;
        }
        return pluginInfo.copy(plugin, str, map);
    }

    public final Plugin component1() {
        return this.valueOf;
    }

    public final String component2() {
        return this.AFInAppEventType;
    }

    public final Map<String, String> component3() {
        return this.values;
    }

    public final PluginInfo copy(Plugin plugin, String str, Map<String, String> map) {
        Intrinsics.f(plugin, "");
        Intrinsics.f(str, "");
        Intrinsics.f(map, "");
        return new PluginInfo(plugin, str, map);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PluginInfo) {
            PluginInfo pluginInfo = (PluginInfo) obj;
            return this.valueOf == pluginInfo.valueOf && Intrinsics.a(this.AFInAppEventType, pluginInfo.AFInAppEventType) && Intrinsics.a(this.values, pluginInfo.values);
        }
        return false;
    }

    public final Map<String, String> getAdditionalParams() {
        return this.values;
    }

    public final Plugin getPlugin() {
        return this.valueOf;
    }

    public final String getVersion() {
        return this.AFInAppEventType;
    }

    public final int hashCode() {
        return (((this.valueOf.hashCode() * 31) + this.AFInAppEventType.hashCode()) * 31) + this.values.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PluginInfo(plugin=");
        sb.append(this.valueOf);
        sb.append(", version=");
        sb.append(this.AFInAppEventType);
        sb.append(", additionalParams=");
        sb.append(this.values);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ PluginInfo(Plugin plugin, String str, Map map, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(plugin, str, (i8 & 4) != 0 ? MapsKt__MapsKt.f() : map);
    }
}
