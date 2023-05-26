package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.inject.Provider;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ComponentDiscovery<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f15469a;

    /* renamed from: b  reason: collision with root package name */
    private final RegistrarNameRetriever<T> f15470b;

    /* loaded from: classes.dex */
    private static class MetadataRegistrarNameRetriever implements RegistrarNameRetriever<Context> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<? extends Service> f15471a;

        private Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f15471a), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", this.f15471a + " has no service info.");
                    return null;
                }
                return serviceInfo.metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        @Override // com.google.firebase.components.ComponentDiscovery.RegistrarNameRetriever
        /* renamed from: c */
        public List<String> a(Context context) {
            Bundle b8 = b(context);
            if (b8 == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : b8.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(b8.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }

        private MetadataRegistrarNameRetriever(Class<? extends Service> cls) {
            this.f15471a = cls;
        }
    }

    /* loaded from: classes.dex */
    interface RegistrarNameRetriever<T> {
        List<String> a(T t7);
    }

    ComponentDiscovery(T t7, RegistrarNameRetriever<T> registrarNameRetriever) {
        this.f15469a = t7;
        this.f15470b = registrarNameRetriever;
    }

    public static ComponentDiscovery<Context> c(Context context, Class<? extends Service> cls) {
        return new ComponentDiscovery<>(context, new MetadataRegistrarNameRetriever(cls));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ComponentRegistrar d(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            throw new InvalidRegistrarException(String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
        } catch (ClassNotFoundException unused) {
            Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str));
            return null;
        } catch (IllegalAccessException e8) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e8);
        } catch (InstantiationException e9) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e9);
        } catch (NoSuchMethodException e10) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e10);
        } catch (InvocationTargetException e11) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e11);
        }
    }

    public List<Provider<ComponentRegistrar>> b() {
        ArrayList arrayList = new ArrayList();
        for (final String str : this.f15470b.a(this.f15469a)) {
            arrayList.add(new Provider() { // from class: com.google.firebase.components.c
                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    ComponentRegistrar d8;
                    d8 = ComponentDiscovery.d(str);
                    return d8;
                }
            });
        }
        return arrayList;
    }
}
