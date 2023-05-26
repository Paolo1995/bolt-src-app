package com.tbruyelle.rxpermissions2;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class RxPermissionsFragment extends Fragment {

    /* renamed from: f  reason: collision with root package name */
    private Map<String, PublishSubject<Permission>> f19744f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private boolean f19745g;

    public boolean D(@NonNull String str) {
        return this.f19744f.containsKey(str);
    }

    public PublishSubject<Permission> E(@NonNull String str) {
        return this.f19744f.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(23)
    public boolean F(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity.checkSelfPermission(str) == 0) {
                return true;
            }
            return false;
        }
        throw new IllegalStateException("This fragment must be attached to an activity.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(23)
    public boolean G(String str) {
        boolean isPermissionRevokedByPolicy;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            isPermissionRevokedByPolicy = activity.getPackageManager().isPermissionRevokedByPolicy(str, getActivity().getPackageName());
            return isPermissionRevokedByPolicy;
        }
        throw new IllegalStateException("This fragment must be attached to an activity.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(String str) {
        if (this.f19745g) {
            Log.d(RxPermissions.f19731b, str);
        }
    }

    void I(String[] strArr, int[] iArr, boolean[] zArr) {
        boolean z7;
        int length = strArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            H("onRequestPermissionsResult  " + strArr[i8]);
            PublishSubject<Permission> publishSubject = this.f19744f.get(strArr[i8]);
            if (publishSubject == null) {
                Log.e(RxPermissions.f19731b, "RxPermissions.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
                return;
            }
            this.f19744f.remove(strArr[i8]);
            if (iArr[i8] == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            publishSubject.onNext(new Permission(strArr[i8], z7, zArr[i8]));
            publishSubject.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(23)
    public void J(@NonNull String[] strArr) {
        requestPermissions(strArr, 42);
    }

    public void K(@NonNull String str, @NonNull PublishSubject<Permission> publishSubject) {
        this.f19744f.put(str, publishSubject);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    @TargetApi(23)
    public void onRequestPermissionsResult(int i8, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i8, strArr, iArr);
        if (i8 != 42) {
            return;
        }
        boolean[] zArr = new boolean[strArr.length];
        for (int i9 = 0; i9 < strArr.length; i9++) {
            zArr[i9] = shouldShowRequestPermissionRationale(strArr[i9]);
        }
        I(strArr, iArr, zArr);
    }
}
