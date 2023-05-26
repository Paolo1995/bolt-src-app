package eu.bolt.verification.sdk.internal;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import eu.bolt.logger.Logger;
import eu.bolt.verification.sdk.internal.ac;
import eu.bolt.verification.sdk.internal.af;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes5.dex */
public final class lf<T> implements af<T>, SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f44044a;

    /* renamed from: b  reason: collision with root package name */
    private final String f44045b;

    /* renamed from: c  reason: collision with root package name */
    private final T f44046c;

    /* renamed from: d  reason: collision with root package name */
    private final a<T> f44047d;

    /* renamed from: e  reason: collision with root package name */
    private final Observable<T> f44048e;

    /* renamed from: f  reason: collision with root package name */
    private final Logger f44049f = ac.a.f42020b.g();

    /* renamed from: g  reason: collision with root package name */
    private final Set<af.a<T>> f44050g = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface a<T> {
        void a(@NonNull String str, @NonNull T t7, @NonNull SharedPreferences.Editor editor);

        T b(@NonNull String str, @NonNull SharedPreferences sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public lf(SharedPreferences sharedPreferences, final String str, T t7, a<T> aVar, Observable<vd<String>> observable) {
        this.f44044a = sharedPreferences;
        this.f44045b = str;
        this.f44046c = t7;
        this.f44047d = aVar;
        this.f44048e = (Observable<T>) observable.filter(new Predicate() { // from class: eu.bolt.verification.sdk.internal.ou
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean d8;
                d8 = lf.d(str, (vd) obj);
                return d8;
            }
        }).startWith((Observable<vd<String>>) vd.c("<init>")).map(new Function() { // from class: eu.bolt.verification.sdk.internal.pu
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Object c8;
                c8 = lf.this.c((vd) obj);
                return c8;
            }
        });
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object c(vd vdVar) {
        return get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean d(String str, vd vdVar) {
        if (vdVar.f()) {
            return str.equals(vdVar.d());
        }
        return true;
    }

    @Override // eu.bolt.verification.sdk.internal.af
    @NonNull
    public synchronized T get() {
        if (!this.f44044a.contains(this.f44045b)) {
            return this.f44046c;
        }
        T b8 = this.f44047d.b(this.f44045b, this.f44044a);
        if (b8 == null) {
            return this.f44046c;
        }
        return b8;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (Objects.equals(str, this.f44045b)) {
            HashSet<af.a> hashSet = new HashSet();
            synchronized (this.f44050g) {
                hashSet.addAll(this.f44050g);
            }
            T t7 = get();
            for (af.a aVar : hashSet) {
                aVar.d(t7);
            }
        }
    }

    @Override // eu.bolt.verification.sdk.internal.af
    public void set(@NonNull T t7) {
        xe.b(t7, "value == null");
        SharedPreferences.Editor edit = this.f44044a.edit();
        this.f44047d.a(this.f44045b, t7, edit);
        edit.apply();
    }
}
