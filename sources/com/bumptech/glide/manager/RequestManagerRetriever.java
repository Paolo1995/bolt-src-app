package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideExperiments;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class RequestManagerRetriever implements Handler.Callback {

    /* renamed from: j  reason: collision with root package name */
    private static final RequestManagerFactory f10598j = new RequestManagerFactory() { // from class: com.bumptech.glide.manager.RequestManagerRetriever.1
        @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
        @NonNull
        public RequestManager a(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private volatile RequestManager f10599a;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f10602d;

    /* renamed from: e  reason: collision with root package name */
    private final RequestManagerFactory f10603e;

    /* renamed from: i  reason: collision with root package name */
    private final FrameWaiter f10607i;

    /* renamed from: b  reason: collision with root package name */
    final Map<FragmentManager, RequestManagerFragment> f10600b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f10601c = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final ArrayMap<View, Fragment> f10604f = new ArrayMap<>();

    /* renamed from: g  reason: collision with root package name */
    private final ArrayMap<View, android.app.Fragment> f10605g = new ArrayMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final Bundle f10606h = new Bundle();

    /* loaded from: classes.dex */
    public interface RequestManagerFactory {
        @NonNull
        RequestManager a(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context);
    }

    public RequestManagerRetriever(RequestManagerFactory requestManagerFactory, GlideExperiments glideExperiments) {
        this.f10603e = requestManagerFactory == null ? f10598j : requestManagerFactory;
        this.f10602d = new Handler(Looper.getMainLooper(), this);
        this.f10607i = b(glideExperiments);
    }

    @TargetApi(17)
    private static void a(@NonNull Activity activity) {
        if (!activity.isDestroyed()) {
            return;
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    private static FrameWaiter b(GlideExperiments glideExperiments) {
        if (HardwareConfigState.f10465h && HardwareConfigState.f10464g) {
            if (glideExperiments.a(GlideBuilder.WaitForFramesAfterTrimMemory.class)) {
                return new FirstFrameAndAfterTrimMemoryWaiter();
            }
            return new FirstFrameWaiter();
        }
        return new DoNothingFirstFrameWaiter();
    }

    private static Activity c(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(26)
    @Deprecated
    private void d(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        List<android.app.Fragment> fragments;
        if (Build.VERSION.SDK_INT >= 26) {
            fragments = fragmentManager.getFragments();
            for (android.app.Fragment fragment : fragments) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    d(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        e(fragmentManager, arrayMap);
    }

    @Deprecated
    private void e(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        int i8 = 0;
        while (true) {
            int i9 = i8 + 1;
            this.f10606h.putInt("key", i8);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f10606h, "key");
            } catch (Exception unused) {
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                d(fragment.getChildFragmentManager(), arrayMap);
            }
            i8 = i9;
        }
    }

    private static void f(Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                f(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Deprecated
    private android.app.Fragment g(@NonNull View view, @NonNull Activity activity) {
        this.f10605g.clear();
        d(activity.getFragmentManager(), this.f10605g);
        View findViewById = activity.findViewById(16908290);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f10605g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f10605g.clear();
        return fragment;
    }

    private Fragment h(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.f10604f.clear();
        f(fragmentActivity.getSupportFragmentManager().getFragments(), this.f10604f);
        View findViewById = fragmentActivity.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f10604f.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f10604f.clear();
        return fragment;
    }

    @NonNull
    @Deprecated
    private RequestManager i(@NonNull Context context, @NonNull FragmentManager fragmentManager, android.app.Fragment fragment, boolean z7) {
        RequestManagerFragment r7 = r(fragmentManager, fragment);
        RequestManager e8 = r7.e();
        if (e8 == null) {
            e8 = this.f10603e.a(Glide.c(context), r7.c(), r7.f(), context);
            if (z7) {
                e8.onStart();
            }
            r7.k(e8);
        }
        return e8;
    }

    @NonNull
    private RequestManager p(@NonNull Context context) {
        if (this.f10599a == null) {
            synchronized (this) {
                if (this.f10599a == null) {
                    this.f10599a = this.f10603e.a(Glide.c(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                }
            }
        }
        return this.f10599a;
    }

    @NonNull
    private RequestManagerFragment r(@NonNull FragmentManager fragmentManager, android.app.Fragment fragment) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment == null) {
            RequestManagerFragment requestManagerFragment2 = this.f10600b.get(fragmentManager);
            if (requestManagerFragment2 == null) {
                RequestManagerFragment requestManagerFragment3 = new RequestManagerFragment();
                requestManagerFragment3.j(fragment);
                this.f10600b.put(fragmentManager, requestManagerFragment3);
                fragmentManager.beginTransaction().add(requestManagerFragment3, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.f10602d.obtainMessage(1, fragmentManager).sendToTarget();
                return requestManagerFragment3;
            }
            return requestManagerFragment2;
        }
        return requestManagerFragment;
    }

    @NonNull
    private SupportRequestManagerFragment t(@NonNull androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null) {
            SupportRequestManagerFragment supportRequestManagerFragment2 = this.f10601c.get(fragmentManager);
            if (supportRequestManagerFragment2 == null) {
                SupportRequestManagerFragment supportRequestManagerFragment3 = new SupportRequestManagerFragment();
                supportRequestManagerFragment3.N(fragment);
                this.f10601c.put(fragmentManager, supportRequestManagerFragment3);
                fragmentManager.beginTransaction().add(supportRequestManagerFragment3, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.f10602d.obtainMessage(2, fragmentManager).sendToTarget();
                return supportRequestManagerFragment3;
            }
            return supportRequestManagerFragment2;
        }
        return supportRequestManagerFragment;
    }

    private static boolean u(Context context) {
        Activity c8 = c(context);
        if (c8 != null && c8.isFinishing()) {
            return false;
        }
        return true;
    }

    @NonNull
    private RequestManager v(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z7) {
        SupportRequestManagerFragment t7 = t(fragmentManager, fragment);
        RequestManager H = t7.H();
        if (H == null) {
            H = this.f10603e.a(Glide.c(context), t7.F(), t7.I(), context);
            if (z7) {
                H.onStart();
            }
            t7.O(H);
        }
        return H;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object remove;
        Object obj2;
        int i8 = message.what;
        Object obj3 = null;
        boolean z7 = true;
        if (i8 != 1) {
            if (i8 != 2) {
                z7 = false;
                obj2 = null;
                if (z7 && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
                }
                return z7;
            }
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.f10601c.remove(obj);
        } else {
            obj = (FragmentManager) message.obj;
            remove = this.f10600b.remove(obj);
        }
        Object obj4 = obj;
        obj3 = remove;
        obj2 = obj4;
        if (z7) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z7;
    }

    @NonNull
    public RequestManager j(@NonNull Activity activity) {
        if (Util.q()) {
            return l(activity.getApplicationContext());
        }
        if (activity instanceof FragmentActivity) {
            return o((FragmentActivity) activity);
        }
        a(activity);
        this.f10607i.a(activity);
        return i(activity, activity.getFragmentManager(), null, u(activity));
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    public RequestManager k(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!Util.q()) {
                if (fragment.getActivity() != null) {
                    this.f10607i.a(fragment.getActivity());
                }
                return i(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return l(fragment.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    @NonNull
    public RequestManager l(@NonNull Context context) {
        if (context != null) {
            if (Util.r() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return o((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return j((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return l(contextWrapper.getBaseContext());
                    }
                }
            }
            return p(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @NonNull
    public RequestManager m(@NonNull View view) {
        if (Util.q()) {
            return l(view.getContext().getApplicationContext());
        }
        Preconditions.d(view);
        Preconditions.e(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity c8 = c(view.getContext());
        if (c8 == null) {
            return l(view.getContext().getApplicationContext());
        }
        if (c8 instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) c8;
            Fragment h8 = h(view, fragmentActivity);
            if (h8 != null) {
                return n(h8);
            }
            return o(fragmentActivity);
        }
        android.app.Fragment g8 = g(view, c8);
        if (g8 == null) {
            return j(c8);
        }
        return k(g8);
    }

    @NonNull
    public RequestManager n(@NonNull Fragment fragment) {
        Preconditions.e(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.q()) {
            return l(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.f10607i.a(fragment.getActivity());
        }
        return v(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public RequestManager o(@NonNull FragmentActivity fragmentActivity) {
        if (Util.q()) {
            return l(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        this.f10607i.a(fragmentActivity);
        return v(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, u(fragmentActivity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @Deprecated
    public RequestManagerFragment q(Activity activity) {
        return r(activity.getFragmentManager(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public SupportRequestManagerFragment s(androidx.fragment.app.FragmentManager fragmentManager) {
        return t(fragmentManager, null);
    }
}
