package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public class RequestManagerFragment extends Fragment {

    /* renamed from: f  reason: collision with root package name */
    private final ActivityFragmentLifecycle f10591f;

    /* renamed from: g  reason: collision with root package name */
    private final RequestManagerTreeNode f10592g;

    /* renamed from: h  reason: collision with root package name */
    private final Set<RequestManagerFragment> f10593h;

    /* renamed from: i  reason: collision with root package name */
    private RequestManager f10594i;

    /* renamed from: j  reason: collision with root package name */
    private RequestManagerFragment f10595j;

    /* renamed from: k  reason: collision with root package name */
    private Fragment f10596k;

    /* loaded from: classes.dex */
    private class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        FragmentRequestManagerTreeNode() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        @NonNull
        public Set<RequestManager> a() {
            Set<RequestManagerFragment> b8 = RequestManagerFragment.this.b();
            HashSet hashSet = new HashSet(b8.size());
            for (RequestManagerFragment requestManagerFragment : b8) {
                if (requestManagerFragment.e() != null) {
                    hashSet.add(requestManagerFragment.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    private void a(RequestManagerFragment requestManagerFragment) {
        this.f10593h.add(requestManagerFragment);
    }

    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            return this.f10596k;
        }
        return parentFragment;
    }

    @TargetApi(17)
    private boolean g(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 != null) {
                if (parentFragment2.equals(parentFragment)) {
                    return true;
                }
                fragment = fragment.getParentFragment();
            } else {
                return false;
            }
        }
    }

    private void h(@NonNull Activity activity) {
        l();
        RequestManagerFragment q8 = Glide.c(activity).k().q(activity);
        this.f10595j = q8;
        if (!equals(q8)) {
            this.f10595j.a(this);
        }
    }

    private void i(RequestManagerFragment requestManagerFragment) {
        this.f10593h.remove(requestManagerFragment);
    }

    private void l() {
        RequestManagerFragment requestManagerFragment = this.f10595j;
        if (requestManagerFragment != null) {
            requestManagerFragment.i(this);
            this.f10595j = null;
        }
    }

    @NonNull
    @TargetApi(17)
    Set<RequestManagerFragment> b() {
        if (equals(this.f10595j)) {
            return Collections.unmodifiableSet(this.f10593h);
        }
        if (this.f10595j != null) {
            HashSet hashSet = new HashSet();
            for (RequestManagerFragment requestManagerFragment : this.f10595j.b()) {
                if (g(requestManagerFragment.getParentFragment())) {
                    hashSet.add(requestManagerFragment);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public ActivityFragmentLifecycle c() {
        return this.f10591f;
    }

    public RequestManager e() {
        return this.f10594i;
    }

    @NonNull
    public RequestManagerTreeNode f() {
        return this.f10592g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Fragment fragment) {
        this.f10596k = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            h(fragment.getActivity());
        }
    }

    public void k(RequestManager requestManager) {
        this.f10594i = requestManager;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException e8) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e8);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f10591f.c();
        l();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        l();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f10591f.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f10591f.e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    RequestManagerFragment(@NonNull ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.f10592g = new FragmentRequestManagerTreeNode();
        this.f10593h = new HashSet();
        this.f10591f = activityFragmentLifecycle;
    }
}
