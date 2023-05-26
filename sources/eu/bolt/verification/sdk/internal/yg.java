package eu.bolt.verification.sdk.internal;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;

/* loaded from: classes5.dex */
public final class yg {

    /* renamed from: c  reason: collision with root package name */
    private static final Float f45749c = Float.valueOf(0.0f);

    /* renamed from: d  reason: collision with root package name */
    private static final Integer f45750d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static final Boolean f45751e = Boolean.FALSE;

    /* renamed from: f  reason: collision with root package name */
    private static final Long f45752f = 0L;

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f45753a;

    /* renamed from: b  reason: collision with root package name */
    private final Observable<vd<String>> f45754b;

    private yg(final SharedPreferences sharedPreferences) {
        this.f45753a = sharedPreferences;
        this.f45754b = Observable.create(new ObservableOnSubscribe() { // from class: eu.bolt.verification.sdk.internal.ey
            @Override // io.reactivex.ObservableOnSubscribe
            public final void a(ObservableEmitter observableEmitter) {
                yg.g(sharedPreferences, observableEmitter);
            }
        }).share();
    }

    @NonNull
    public static yg e(@NonNull SharedPreferences sharedPreferences) {
        xe.b(sharedPreferences, "preferences == null");
        return new yg(sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(final SharedPreferences sharedPreferences, final ObservableEmitter observableEmitter) {
        final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: eu.bolt.verification.sdk.internal.fy
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                yg.h(ObservableEmitter.this, sharedPreferences2, str);
            }
        };
        observableEmitter.b(new Cancellable() { // from class: eu.bolt.verification.sdk.internal.gy
            @Override // io.reactivex.functions.Cancellable
            public final void cancel() {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        });
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(ObservableEmitter observableEmitter, SharedPreferences sharedPreferences, String str) {
        observableEmitter.onNext(vd.b(str));
    }

    @NonNull
    public af<Boolean> d(@NonNull String str, @NonNull Boolean bool) {
        xe.b(str, "key == null");
        xe.b(bool, "defaultValue == null");
        return new lf(this.f45753a, str, bool, h0.f43187a, this.f45754b);
    }
}
