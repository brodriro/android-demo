package me.rzknairb.demoapp.views;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.uber.autodispose.lifecycle.CorrespondingEventsFunction;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import com.uber.autodispose.lifecycle.LifecycleScopeProvider;

import dagger.android.support.DaggerFragment;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public abstract class BaseFragment extends DaggerFragment implements LifecycleScopeProvider<BaseFragment.FragmentEvent> {
    public enum FragmentEvent {
        ATTACH,
        CREATE,
        CREATE_VIEW,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTROY_VIEW,
        DESTROY,
        DETACH
    }

    private static final CorrespondingEventsFunction<FragmentEvent> CORRESPONDING_EVENTS =
            event -> {
                switch (event) {
                    case ATTACH:
                        return FragmentEvent.DETACH;
                    case CREATE:
                        return FragmentEvent.DESTROY;
                    case CREATE_VIEW:
                        return FragmentEvent.DESTROY_VIEW;
                    case START:
                        return FragmentEvent.STOP;
                    case RESUME:
                        return FragmentEvent.PAUSE;
                    case PAUSE:
                        return FragmentEvent.STOP;
                    case STOP:
                        return FragmentEvent.DESTROY_VIEW;
                    case DESTROY_VIEW:
                        return FragmentEvent.DESTROY;
                    case DESTROY:
                        return FragmentEvent.DETACH;
                    default:
                        throw new LifecycleEndedException("Cannot bind to Fragment lifecycle after detach.");
                }
            };

    private final BehaviorSubject<FragmentEvent> lifecycleEvents = BehaviorSubject.create();

    @Override
    public Observable<FragmentEvent> lifecycle() {
        return lifecycleEvents.hide();
    }

    @Override
    public CorrespondingEventsFunction<FragmentEvent> correspondingEvents() {
        return CORRESPONDING_EVENTS;
    }

    @Nullable
    @Override
    public FragmentEvent peekLifecycle() {
        return lifecycleEvents.getValue();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        lifecycleEvents.onNext(FragmentEvent.ATTACH);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lifecycleEvents.onNext(FragmentEvent.CREATE);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lifecycleEvents.onNext(FragmentEvent.CREATE_VIEW);
    }

    @Override
    public void onStart() {
        super.onStart();
        lifecycleEvents.onNext(FragmentEvent.START);
    }

    @Override
    public void onResume() {
        super.onResume();
        lifecycleEvents.onNext(FragmentEvent.RESUME);
    }

    @Override
    public void onPause() {
        lifecycleEvents.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    @Override
    public void onStop() {
        lifecycleEvents.onNext(FragmentEvent.STOP);
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        lifecycleEvents.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        lifecycleEvents.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        lifecycleEvents.onNext(FragmentEvent.DETACH);
        super.onDetach();
    }
}
