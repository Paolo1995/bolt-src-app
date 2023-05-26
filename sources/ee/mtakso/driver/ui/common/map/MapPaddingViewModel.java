package ee.mtakso.driver.ui.common.map;

import android.graphics.Rect;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.common.map.MapPaddingViewModel;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapPaddingViewModel.kt */
/* loaded from: classes3.dex */
public final class MapPaddingViewModel extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final MediatorLiveData<Rect> f26380a;

    /* renamed from: b  reason: collision with root package name */
    private final MutableLiveData<Rect> f26381b;

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<Rect> f26382c;

    @Inject
    public MapPaddingViewModel() {
        MediatorLiveData<Rect> mediatorLiveData = new MediatorLiveData<>();
        this.f26380a = mediatorLiveData;
        MutableLiveData<Rect> mutableLiveData = new MutableLiveData<>(new Rect());
        this.f26381b = mutableLiveData;
        MutableLiveData<Rect> mutableLiveData2 = new MutableLiveData<>(new Rect());
        this.f26382c = mutableLiveData2;
        mediatorLiveData.o(new Rect());
        final Function1<Rect, Unit> function1 = new Function1<Rect, Unit>() { // from class: ee.mtakso.driver.ui.common.map.MapPaddingViewModel.1
            {
                super(1);
            }

            public final void b(Rect rect) {
                MapPaddingViewModel.this.h();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
                b(rect);
                return Unit.f50853a;
            }
        };
        mediatorLiveData.p(mutableLiveData, new Observer() { // from class: m2.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MapPaddingViewModel.c(Function1.this, obj);
            }
        });
        final Function1<Rect, Unit> function12 = new Function1<Rect, Unit>() { // from class: ee.mtakso.driver.ui.common.map.MapPaddingViewModel.2
            {
                super(1);
            }

            public final void b(Rect rect) {
                MapPaddingViewModel.this.h();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
                b(rect);
                return Unit.f50853a;
            }
        };
        mediatorLiveData.p(mutableLiveData2, new Observer() { // from class: m2.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MapPaddingViewModel.d(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        ((Rect) LiveDataExtKt.b(this.f26380a)).left = ((Rect) LiveDataExtKt.b(this.f26381b)).left + ((Rect) LiveDataExtKt.b(this.f26382c)).left;
        ((Rect) LiveDataExtKt.b(this.f26380a)).top = ((Rect) LiveDataExtKt.b(this.f26381b)).top + ((Rect) LiveDataExtKt.b(this.f26382c)).top;
        ((Rect) LiveDataExtKt.b(this.f26380a)).right = ((Rect) LiveDataExtKt.b(this.f26381b)).right + ((Rect) LiveDataExtKt.b(this.f26382c)).right;
        ((Rect) LiveDataExtKt.b(this.f26380a)).bottom = ((Rect) LiveDataExtKt.b(this.f26381b)).bottom + ((Rect) LiveDataExtKt.b(this.f26382c)).bottom;
        LiveDataExtKt.a(this.f26380a);
    }

    public final void f(int i8) {
        ((Rect) LiveDataExtKt.b(this.f26381b)).bottom = i8;
        LiveDataExtKt.a(this.f26381b);
    }

    public final void g(int i8) {
        ((Rect) LiveDataExtKt.b(this.f26381b)).top = i8;
        LiveDataExtKt.a(this.f26381b);
    }

    public final MutableLiveData<Rect> i() {
        return this.f26382c;
    }

    public final MediatorLiveData<Rect> j() {
        return this.f26380a;
    }
}
