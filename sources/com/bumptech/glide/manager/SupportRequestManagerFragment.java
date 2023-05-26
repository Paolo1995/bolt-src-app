package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class SupportRequestManagerFragment extends Fragment {

    /* renamed from: f  reason: collision with root package name */
    private final ActivityFragmentLifecycle f10611f;

    /* renamed from: g  reason: collision with root package name */
    private final RequestManagerTreeNode f10612g;

    /* renamed from: h  reason: collision with root package name */
    private final Set<SupportRequestManagerFragment> f10613h;

    /* renamed from: i  reason: collision with root package name */
    private SupportRequestManagerFragment f10614i;

    /* renamed from: j  reason: collision with root package name */
    private RequestManager f10615j;

    /* renamed from: k  reason: collision with root package name */
    private Fragment f10616k;

    /* loaded from: classes.dex */
    private class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        SupportFragmentRequestManagerTreeNode() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        @NonNull
        public Set<RequestManager> a() {
            Set<SupportRequestManagerFragment> E = SupportRequestManagerFragment.this.E();
            HashSet hashSet = new HashSet(E.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : E) {
                if (supportRequestManagerFragment.H() != null) {
                    hashSet.add(supportRequestManagerFragment.H());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    private void D(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f10613h.add(supportRequestManagerFragment);
    }

    private Fragment G() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            return this.f10616k;
        }
        return parentFragment;
    }

    private static FragmentManager J(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean K(@NonNull Fragment fragment) {
        Fragment G = G();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment != null) {
                if (parentFragment.equals(G)) {
                    return true;
                }
                fragment = fragment.getParentFragment();
            } else {
                return false;
            }
        }
    }

    private void L(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        P();
        SupportRequestManagerFragment s7 = Glide.c(context).k().s(fragmentManager);
        this.f10614i = s7;
        if (!equals(s7)) {
            this.f10614i.D(this);
        }
    }

    private void M(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f10613h.remove(supportRequestManagerFragment);
    }

    private void P() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f10614i;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.M(this);
            this.f10614i = null;
        }
    }

    @NonNull
    Set<SupportRequestManagerFragment> E() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f10614i;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.f10613h);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.f10614i.E()) {
            if (K(supportRequestManagerFragment2.G())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public ActivityFragmentLifecycle F() {
        return this.f10611f;
    }

    public RequestManager H() {
        return this.f10615j;
    }

    @NonNull
    public RequestManagerTreeNode I() {
        return this.f10612g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(Fragment fragment) {
        FragmentManager J;
        this.f10616k = fragment;
        if (fragment == null || fragment.getContext() == null || (J = J(fragment)) == null) {
            return;
        }
        L(fragment.getContext(), J);
    }

    public void O(RequestManager requestManager) {
        this.f10615j = requestManager;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager J = J(this);
        if (J == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
                return;
            }
            return;
        }
        try {
            L(getContext(), J);
        } catch (IllegalStateException e8) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e8);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f10611f.c();
        P();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10616k = null;
        P();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f10611f.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f10611f.e();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + G() + "}";
    }

    @SuppressLint({"ValidFragment"})
    public SupportRequestManagerFragment(@NonNull ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.f10612g = new SupportFragmentRequestManagerTreeNode();
        this.f10613h = new HashSet();
        this.f10611f = activityFragmentLifecycle;
    }
}
