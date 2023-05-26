package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AccessibilityNodeProviderCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Object f6069a;

    /* loaded from: classes.dex */
    static class AccessibilityNodeProviderApi16 extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        final AccessibilityNodeProviderCompat f6070a;

        AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.f6070a = accessibilityNodeProviderCompat;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i8) {
            AccessibilityNodeInfoCompat b8 = this.f6070a.b(i8);
            if (b8 == null) {
                return null;
            }
            return b8.z0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i8) {
            List<AccessibilityNodeInfoCompat> c8 = this.f6070a.c(str, i8);
            if (c8 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = c8.size();
            for (int i9 = 0; i9 < size; i9++) {
                arrayList.add(c8.get(i9).z0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i8, int i9, Bundle bundle) {
            return this.f6070a.f(i8, i9, bundle);
        }
    }

    /* loaded from: classes.dex */
    static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProviderApi16 {
        AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i8) {
            AccessibilityNodeInfoCompat d8 = this.f6070a.d(i8);
            if (d8 == null) {
                return null;
            }
            return d8.z0();
        }
    }

    /* loaded from: classes.dex */
    static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i8, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f6070a.a(i8, AccessibilityNodeInfoCompat.A0(accessibilityNodeInfo), str, bundle);
        }
    }

    public AccessibilityNodeProviderCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6069a = new AccessibilityNodeProviderApi26(this);
        } else {
            this.f6069a = new AccessibilityNodeProviderApi19(this);
        }
    }

    public void a(int i8, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @NonNull String str, Bundle bundle) {
    }

    public AccessibilityNodeInfoCompat b(int i8) {
        return null;
    }

    public List<AccessibilityNodeInfoCompat> c(@NonNull String str, int i8) {
        return null;
    }

    public AccessibilityNodeInfoCompat d(int i8) {
        return null;
    }

    public Object e() {
        return this.f6069a;
    }

    public boolean f(int i8, int i9, Bundle bundle) {
        return false;
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.f6069a = obj;
    }
}
