package com.clevertap.android.sdk.customviews;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.clevertap.android.sdk.R$drawable;
import com.clevertap.android.sdk.inbox.CTInboxActivity;
import com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;

/* loaded from: classes.dex */
public class MediaPlayerRecyclerView extends RecyclerView {
    SimpleExoPlayer Q0;
    private Context R0;
    private CTInboxBaseMessageViewHolder S0;
    private PlayerView T0;

    public MediaPlayerRecyclerView(Context context) {
        super(context);
        H1(context);
    }

    private CTInboxBaseMessageViewHolder G1() {
        CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder;
        int i8;
        int k22 = ((LinearLayoutManager) getLayoutManager()).k2();
        int n22 = ((LinearLayoutManager) getLayoutManager()).n2();
        CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder2 = null;
        int i9 = 0;
        for (int i10 = k22; i10 <= n22; i10++) {
            View childAt = getChildAt(i10 - k22);
            if (childAt != null && (cTInboxBaseMessageViewHolder = (CTInboxBaseMessageViewHolder) childAt.getTag()) != null && cTInboxBaseMessageViewHolder.X()) {
                Rect rect = new Rect();
                if (cTInboxBaseMessageViewHolder.f7332a.getGlobalVisibleRect(rect)) {
                    i8 = rect.height();
                } else {
                    i8 = 0;
                }
                if (i8 > i9) {
                    cTInboxBaseMessageViewHolder2 = cTInboxBaseMessageViewHolder;
                    i9 = i8;
                }
            }
        }
        return cTInboxBaseMessageViewHolder2;
    }

    private void H1(Context context) {
        this.R0 = context.getApplicationContext();
        PlayerView playerView = new PlayerView(this.R0);
        this.T0 = playerView;
        playerView.setBackgroundColor(0);
        if (CTInboxActivity.f11495l == 2) {
            this.T0.setResizeMode(3);
        } else {
            this.T0.setResizeMode(0);
        }
        this.T0.setUseArtwork(true);
        this.T0.setDefaultArtwork(ResourcesCompat.f(context.getResources(), R$drawable.ct_audio, null));
        SimpleExoPlayer build = new SimpleExoPlayer.Builder(context).setTrackSelector(new DefaultTrackSelector(this.R0, new AdaptiveTrackSelection.Factory())).build();
        this.Q0 = build;
        build.setVolume(0.0f);
        this.T0.setUseController(true);
        this.T0.setControllerAutoShow(false);
        this.T0.setPlayer(this.Q0);
        l(new RecyclerView.OnScrollListener() { // from class: com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void a(@NonNull RecyclerView recyclerView, int i8) {
                super.a(recyclerView, i8);
                if (i8 == 0) {
                    MediaPlayerRecyclerView.this.K1();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void b(@NonNull RecyclerView recyclerView, int i8, int i9) {
                super.b(recyclerView, i8, i9);
            }
        });
        j(new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void b(@NonNull View view) {
                if (MediaPlayerRecyclerView.this.S0 != null && MediaPlayerRecyclerView.this.S0.f7332a.equals(view)) {
                    MediaPlayerRecyclerView.this.N1();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void d(@NonNull View view) {
            }
        });
        this.Q0.addListener(new Player.Listener() { // from class: com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView.3
        });
    }

    private void M1() {
        ViewGroup viewGroup;
        int indexOfChild;
        PlayerView playerView = this.T0;
        if (playerView != null && (viewGroup = (ViewGroup) playerView.getParent()) != null && (indexOfChild = viewGroup.indexOfChild(this.T0)) >= 0) {
            viewGroup.removeViewAt(indexOfChild);
            SimpleExoPlayer simpleExoPlayer = this.Q0;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.stop();
            }
            CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder = this.S0;
            if (cTInboxBaseMessageViewHolder != null) {
                cTInboxBaseMessageViewHolder.Y();
                this.S0 = null;
            }
        }
    }

    public void I1() {
        SimpleExoPlayer simpleExoPlayer = this.Q0;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(false);
        }
    }

    public void J1() {
        if (this.T0 == null) {
            H1(this.R0);
            K1();
        }
    }

    public void K1() {
        int i8;
        boolean z7;
        if (this.T0 == null) {
            return;
        }
        CTInboxBaseMessageViewHolder G1 = G1();
        if (G1 == null) {
            N1();
            M1();
            return;
        }
        CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder = this.S0;
        if (cTInboxBaseMessageViewHolder != null && cTInboxBaseMessageViewHolder.f7332a.equals(G1.f7332a)) {
            Rect rect = new Rect();
            if (this.S0.f7332a.getGlobalVisibleRect(rect)) {
                i8 = rect.height();
            } else {
                i8 = 0;
            }
            SimpleExoPlayer simpleExoPlayer = this.Q0;
            if (simpleExoPlayer != null) {
                if (i8 >= 400) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    if (this.S0.a0()) {
                        this.Q0.setPlayWhenReady(true);
                        return;
                    }
                    return;
                }
                simpleExoPlayer.setPlayWhenReady(false);
                return;
            }
            return;
        }
        M1();
        if (G1.P(this.T0)) {
            this.S0 = G1;
        }
    }

    public void L1() {
        SimpleExoPlayer simpleExoPlayer = this.Q0;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
            this.Q0.release();
            this.Q0 = null;
        }
        this.S0 = null;
        this.T0 = null;
    }

    public void N1() {
        SimpleExoPlayer simpleExoPlayer = this.Q0;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
        }
        this.S0 = null;
    }
}
