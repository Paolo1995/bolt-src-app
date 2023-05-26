package com.tbruyelle.rxpermissions2;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class RxPermissions {

    /* renamed from: b  reason: collision with root package name */
    static final String f19731b = "RxPermissions";

    /* renamed from: c  reason: collision with root package name */
    static final Object f19732c = new Object();

    /* renamed from: a  reason: collision with root package name */
    Lazy<RxPermissionsFragment> f19733a;

    @FunctionalInterface
    /* loaded from: classes3.dex */
    public interface Lazy<V> {
        V get();
    }

    public RxPermissions(@NonNull FragmentActivity fragmentActivity) {
        this.f19733a = g(fragmentActivity.getSupportFragmentManager());
    }

    private RxPermissionsFragment f(@NonNull FragmentManager fragmentManager) {
        return (RxPermissionsFragment) fragmentManager.findFragmentByTag(f19731b);
    }

    @NonNull
    private Lazy<RxPermissionsFragment> g(@NonNull final FragmentManager fragmentManager) {
        return new Lazy<RxPermissionsFragment>() { // from class: com.tbruyelle.rxpermissions2.RxPermissions.1

            /* renamed from: a  reason: collision with root package name */
            private RxPermissionsFragment f19734a;

            @Override // com.tbruyelle.rxpermissions2.RxPermissions.Lazy
            /* renamed from: a */
            public synchronized RxPermissionsFragment get() {
                if (this.f19734a == null) {
                    this.f19734a = RxPermissions.this.h(fragmentManager);
                }
                return this.f19734a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RxPermissionsFragment h(@NonNull FragmentManager fragmentManager) {
        boolean z7;
        RxPermissionsFragment f8 = f(fragmentManager);
        if (f8 == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            RxPermissionsFragment rxPermissionsFragment = new RxPermissionsFragment();
            fragmentManager.beginTransaction().add(rxPermissionsFragment, f19731b).commitNow();
            return rxPermissionsFragment;
        }
        return f8;
    }

    private Observable<?> l(Observable<?> observable, Observable<?> observable2) {
        if (observable == null) {
            return Observable.just(f19732c);
        }
        return Observable.merge(observable, observable2);
    }

    private Observable<?> m(String... strArr) {
        for (String str : strArr) {
            if (!this.f19733a.get().D(str)) {
                return Observable.empty();
            }
        }
        return Observable.just(f19732c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<Permission> n(Observable<?> observable, final String... strArr) {
        if (strArr != null && strArr.length != 0) {
            return l(observable, m(strArr)).flatMap(new Function<Object, Observable<Permission>>() { // from class: com.tbruyelle.rxpermissions2.RxPermissions.5
                @Override // io.reactivex.functions.Function
                /* renamed from: a */
                public Observable<Permission> apply(Object obj) {
                    return RxPermissions.this.q(strArr);
                }
            });
        }
        throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    public Observable<Permission> q(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArr) {
            this.f19733a.get().H("Requesting permission " + str);
            if (i(str)) {
                arrayList.add(Observable.just(new Permission(str, true, false)));
            } else if (k(str)) {
                arrayList.add(Observable.just(new Permission(str, false, false)));
            } else {
                PublishSubject<Permission> E = this.f19733a.get().E(str);
                if (E == null) {
                    arrayList2.add(str);
                    E = PublishSubject.e();
                    this.f19733a.get().K(str, E);
                }
                arrayList.add(E);
            }
        }
        if (!arrayList2.isEmpty()) {
            r((String[]) arrayList2.toArray(new String[arrayList2.size()]));
        }
        return Observable.concat(Observable.fromIterable(arrayList));
    }

    public <T> ObservableTransformer<T, Boolean> d(final String... strArr) {
        return new ObservableTransformer<T, Boolean>() { // from class: com.tbruyelle.rxpermissions2.RxPermissions.2
            @Override // io.reactivex.ObservableTransformer
            public ObservableSource<Boolean> a(Observable<T> observable) {
                return RxPermissions.this.n(observable, strArr).buffer(strArr.length).flatMap(new Function<List<Permission>, ObservableSource<Boolean>>() { // from class: com.tbruyelle.rxpermissions2.RxPermissions.2.1
                    @Override // io.reactivex.functions.Function
                    /* renamed from: a */
                    public ObservableSource<Boolean> apply(List<Permission> list) {
                        if (list.isEmpty()) {
                            return Observable.empty();
                        }
                        for (Permission permission : list) {
                            if (!permission.f19729b) {
                                return Observable.just(Boolean.FALSE);
                            }
                        }
                        return Observable.just(Boolean.TRUE);
                    }
                });
            }
        };
    }

    public <T> ObservableTransformer<T, Permission> e(final String... strArr) {
        return new ObservableTransformer<T, Permission>() { // from class: com.tbruyelle.rxpermissions2.RxPermissions.3
            @Override // io.reactivex.ObservableTransformer
            public ObservableSource<Permission> a(Observable<T> observable) {
                return RxPermissions.this.n(observable, strArr);
            }
        };
    }

    public boolean i(String str) {
        if (j() && !this.f19733a.get().F(str)) {
            return false;
        }
        return true;
    }

    boolean j() {
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }

    public boolean k(String str) {
        if (j() && this.f19733a.get().G(str)) {
            return true;
        }
        return false;
    }

    public Observable<Boolean> o(String... strArr) {
        return Observable.just(f19732c).compose(d(strArr));
    }

    public Observable<Permission> p(String... strArr) {
        return Observable.just(f19732c).compose(e(strArr));
    }

    @TargetApi(23)
    void r(String[] strArr) {
        this.f19733a.get().H("requestPermissionsFromFragment " + TextUtils.join(", ", strArr));
        this.f19733a.get().J(strArr);
    }
}
