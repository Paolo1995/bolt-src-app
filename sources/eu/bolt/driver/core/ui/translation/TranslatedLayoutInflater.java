package eu.bolt.driver.core.ui.translation;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.ViewTranslationTransformerManager;
import eu.bolt.driver.core.util.ReflectionUtilsKt;
import eu.bolt.kalev.Kalev;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: TranslatedLayoutInflater.kt */
/* loaded from: classes5.dex */
public final class TranslatedLayoutInflater extends LayoutInflater {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f41189d = new Companion(null);

    /* renamed from: e  reason: collision with root package name */
    private static final Set<String> f41190e;

    /* renamed from: a  reason: collision with root package name */
    private final TranslatedResources f41191a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f41192b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f41193c;

    /* compiled from: TranslatedLayoutInflater.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: TranslatedLayoutInflater.kt */
    /* loaded from: classes5.dex */
    private final class TranslatedWrapperFactory implements LayoutInflater.Factory {

        /* renamed from: f  reason: collision with root package name */
        private final LayoutInflater.Factory f41196f;

        public TranslatedWrapperFactory(LayoutInflater.Factory factory) {
            this.f41196f = factory;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            View view;
            Intrinsics.f(name, "name");
            Intrinsics.f(context, "context");
            Intrinsics.f(attrs, "attrs");
            LayoutInflater.Factory factory = this.f41196f;
            if (factory != null) {
                view = factory.onCreateView(name, context, attrs);
            } else {
                view = null;
            }
            if (view == null) {
                view = TranslatedLayoutInflater.this.d(name, context, attrs);
            }
            return TranslatedLayoutInflater.this.c(view, attrs);
        }
    }

    static {
        Set<String> f8;
        f8 = SetsKt__SetsKt.f("android.widget.", "android.webkit.");
        f41190e = f8;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TranslatedLayoutInflater(LayoutInflater original, Context newContext, TranslatedResources resourcesForViewTransformer) {
        super(original, newContext);
        Lazy b8;
        Intrinsics.f(original, "original");
        Intrinsics.f(newContext, "newContext");
        Intrinsics.f(resourcesForViewTransformer, "resourcesForViewTransformer");
        this.f41191a = resourcesForViewTransformer;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Field>() { // from class: eu.bolt.driver.core.ui.translation.TranslatedLayoutInflater$mConstructorArgs$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Field invoke() {
                return ReflectionUtilsKt.a(LayoutInflater.class, "mConstructorArgs");
            }
        });
        this.f41193c = b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View c(View view, AttributeSet attributeSet) {
        return ViewTranslationTransformerManager.f41263a.b(view, attributeSet, this.f41191a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View d(String str, Context context, AttributeSet attributeSet) {
        int a02;
        a02 = StringsKt__StringsKt.a0(str, '.', 0, false, 6, null);
        View view = null;
        if (a02 <= -1) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                return createView(context, str, null, attributeSet);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
        Field e8 = e();
        if (e8 == null) {
            return null;
        }
        Object c8 = ReflectionUtilsKt.c(e8, this);
        Intrinsics.d(c8, "null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        Object[] objArr = (Object[]) c8;
        Object obj = objArr[0];
        objArr[0] = context;
        ReflectionUtilsKt.e(e8, this, objArr);
        try {
            view = createView(str, null, attributeSet);
            objArr[0] = obj;
        } catch (ClassNotFoundException unused2) {
            objArr[0] = obj;
        } catch (Throwable th) {
            objArr[0] = obj;
            ReflectionUtilsKt.e(e8, this, objArr);
            throw th;
        }
        ReflectionUtilsKt.e(e8, this, objArr);
        return view;
    }

    private final Field e() {
        return (Field) this.f41193c.getValue();
    }

    private final void f() {
        if (this.f41192b) {
            return;
        }
        if (!(getContext() instanceof LayoutInflater.Factory2)) {
            this.f41192b = true;
            return;
        }
        Method b8 = ReflectionUtilsKt.b(LayoutInflater.class, "setPrivateFactory");
        if (b8 != null) {
            Context context = getContext();
            Intrinsics.d(context, "null cannot be cast to non-null type android.view.LayoutInflater.Factory2");
            ReflectionUtilsKt.d(this, b8, new PrivateWrapperFactory2(this, (LayoutInflater.Factory2) context));
        }
        this.f41192b = true;
    }

    @Override // android.view.LayoutInflater
    public LayoutInflater cloneInContext(Context newContext) {
        Intrinsics.f(newContext, "newContext");
        Resources resources = newContext.getResources();
        Intrinsics.e(resources, "newContext.resources");
        return new TranslatedLayoutInflater(this, newContext, new TranslatedResources(resources));
    }

    @Override // android.view.LayoutInflater
    public View inflate(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z7) {
        f();
        return super.inflate(xmlPullParser, viewGroup, z7);
    }

    @Override // android.view.LayoutInflater
    protected View onCreateView(String name, AttributeSet attrs) throws ClassNotFoundException {
        Intrinsics.f(name, "name");
        Intrinsics.f(attrs, "attrs");
        View view = null;
        for (String str : f41190e) {
            try {
                view = createView(name, str, attrs);
            } catch (ClassNotFoundException unused) {
                Kalev.b("Error while inflating the view " + name + " with prefix " + str);
            }
            if (view != null) {
                break;
            }
        }
        if (view == null) {
            view = super.onCreateView(name, attrs);
        }
        c(view, attrs);
        return view;
    }

    @Override // android.view.LayoutInflater
    public void setFactory(LayoutInflater.Factory factory) {
        if (factory instanceof TranslatedWrapperFactory) {
            super.setFactory(factory);
        } else {
            super.setFactory(new TranslatedWrapperFactory(factory));
        }
    }

    @Override // android.view.LayoutInflater
    public void setFactory2(LayoutInflater.Factory2 factory2) {
        if (factory2 instanceof TranslatedWrapperFactory2) {
            super.setFactory2(factory2);
        } else {
            super.setFactory2(new TranslatedWrapperFactory2(factory2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TranslatedLayoutInflater.kt */
    /* loaded from: classes5.dex */
    public final class PrivateWrapperFactory2 implements LayoutInflater.Factory2 {

        /* renamed from: f  reason: collision with root package name */
        private final LayoutInflater.Factory2 f41194f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ TranslatedLayoutInflater f41195g;

        public PrivateWrapperFactory2(TranslatedLayoutInflater translatedLayoutInflater, LayoutInflater.Factory2 factory2) {
            Intrinsics.f(factory2, "factory2");
            this.f41195g = translatedLayoutInflater;
            this.f41194f = factory2;
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String name, Context context, AttributeSet attrs) {
            Intrinsics.f(name, "name");
            Intrinsics.f(context, "context");
            Intrinsics.f(attrs, "attrs");
            View onCreateView = this.f41194f.onCreateView(view, name, context, attrs);
            if (onCreateView == null) {
                onCreateView = this.f41195g.d(name, context, attrs);
            }
            return this.f41195g.c(onCreateView, attrs);
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            Intrinsics.f(name, "name");
            Intrinsics.f(context, "context");
            Intrinsics.f(attrs, "attrs");
            View onCreateView = this.f41194f.onCreateView(name, context, attrs);
            if (onCreateView == null) {
                onCreateView = this.f41195g.d(name, context, attrs);
            }
            return this.f41195g.c(onCreateView, attrs);
        }
    }

    /* compiled from: TranslatedLayoutInflater.kt */
    @TargetApi(11)
    /* loaded from: classes5.dex */
    private final class TranslatedWrapperFactory2 implements LayoutInflater.Factory2 {

        /* renamed from: f  reason: collision with root package name */
        private final LayoutInflater.Factory2 f41198f;

        public TranslatedWrapperFactory2(LayoutInflater.Factory2 factory2) {
            this.f41198f = factory2;
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String name, Context context, AttributeSet attrs) {
            Intrinsics.f(name, "name");
            Intrinsics.f(context, "context");
            Intrinsics.f(attrs, "attrs");
            LayoutInflater.Factory2 factory2 = this.f41198f;
            View onCreateView = factory2 != null ? factory2.onCreateView(view, name, context, attrs) : null;
            if (onCreateView == null) {
                onCreateView = TranslatedLayoutInflater.this.d(name, context, attrs);
            }
            return TranslatedLayoutInflater.this.c(onCreateView, attrs);
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            Intrinsics.f(name, "name");
            Intrinsics.f(context, "context");
            Intrinsics.f(attrs, "attrs");
            LayoutInflater.Factory2 factory2 = this.f41198f;
            View onCreateView = factory2 != null ? factory2.onCreateView(name, context, attrs) : null;
            if (onCreateView == null) {
                onCreateView = TranslatedLayoutInflater.this.d(name, context, attrs);
            }
            return TranslatedLayoutInflater.this.c(onCreateView, attrs);
        }
    }
}
