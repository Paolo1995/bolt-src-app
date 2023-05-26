package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.android.rib.lifecycle.ActivityCallbackEvent;
import eu.bolt.verification.sdk.internal.ac;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.rx2.RxConvertKt;

/* loaded from: classes5.dex */
public final class pd {

    /* renamed from: d  reason: collision with root package name */
    public static final a f44530d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Activity f44531a;

    /* renamed from: b  reason: collision with root package name */
    private final RxActivityEvents f44532b;

    /* renamed from: c  reason: collision with root package name */
    private ValueCallback<Uri[]> f44533c;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @DebugMetadata(c = "eu.bolt.android.webview.delegate.OpenFileChooserDelegate$observeActivity$1", f = "OpenFileChooserDelegate.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class b extends SuspendLambda implements Function2<ActivityCallbackEvent, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44534g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f44535h;

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(continuation);
            bVar.f44535h = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(ActivityCallbackEvent activityCallbackEvent, Continuation<? super Unit> continuation) {
            return ((b) create(activityCallbackEvent, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f44534g == 0) {
                ResultKt.b(obj);
                ActivityCallbackEvent it = (ActivityCallbackEvent) this.f44535h;
                pd pdVar = pd.this;
                Intrinsics.e(it, "it");
                pdVar.c(it);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Inject
    public pd(Activity activity, RxActivityEvents rxActivityEvents) {
        Intrinsics.f(activity, "activity");
        Intrinsics.f(rxActivityEvents, "rxActivityEvents");
        this.f44531a = activity;
        this.f44532b = rxActivityEvents;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(ActivityCallbackEvent activityCallbackEvent) {
        if (activityCallbackEvent instanceof ActivityCallbackEvent.ActivityResult) {
            ActivityCallbackEvent.ActivityResult activityResult = (ActivityCallbackEvent.ActivityResult) activityCallbackEvent;
            if (activityResult.f() == 5921) {
                ValueCallback<Uri[]> valueCallback = this.f44533c;
                if (valueCallback == null) {
                    f();
                    return;
                }
                Uri[] uriArr = null;
                this.f44533c = null;
                Intent e8 = activityResult.e();
                Uri data = e8 != null ? e8.getData() : null;
                ClipData clipData = e8 != null ? e8.getClipData() : null;
                if (activityResult.g() == -1) {
                    if (clipData != null) {
                        uriArr = e(clipData);
                    } else if (data != null) {
                        uriArr = new Uri[]{data};
                    }
                }
                valueCallback.onReceiveValue(uriArr);
            }
        }
    }

    private final Uri[] e(ClipData clipData) {
        IntRange o8;
        int v7;
        o8 = RangesKt___RangesKt.o(0, clipData.getItemCount());
        v7 = CollectionsKt__IterablesKt.v(o8, 10);
        ArrayList arrayList = new ArrayList(v7);
        Iterator<Integer> it = o8.iterator();
        while (it.hasNext()) {
            arrayList.add(clipData.getItemAt(((IntIterator) it).nextInt()).getUri());
        }
        return (Uri[]) arrayList.toArray(new Uri[0]);
    }

    private final void f() {
        ac.b.f42045b.e().c(new IllegalStateException("received file picker result, but receiver was null"));
    }

    public final void a() {
        this.f44533c = null;
    }

    public final void b(WebChromeClient.FileChooserParams params, ValueCallback<Uri[]> callback) {
        Intrinsics.f(params, "params");
        Intrinsics.f(callback, "callback");
        this.f44533c = callback;
        this.f44531a.startActivityForResult(params.createIntent(), 5921);
    }

    public final Flow<ActivityCallbackEvent> g() {
        return FlowKt.F(RxConvertKt.b(this.f44532b.t()), new b(null));
    }
}
