package com.example.nelson.domain.interactor;

import com.example.nelson.domain.executor.PostExecutionThread;
import com.example.nelson.domain.executor.ThreadExecutor;

import rx.Subscriber;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a {@link rx.Subscriber}
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
public abstract class UseCase {
  private Subscription subscription = Subscriptions.empty();


  /**
   * Builds an {@link rx.Observable} which will be used when executing the current {@link UseCase}.
   */
  public abstract Observable buildUseCaseObservable();

  /**
   * Executes the current use case.
   *
   * @param useCaseSubscriber The guy who will be listen to the observable build
   * with {@link #buildUseCaseObservable()}.
   */
  @SuppressWarnings("unchecked")
  public Observable get() {
    this.subscription = this.buildUseCaseObservable()
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.getScheduler())
        .subscribe(useCaseSubscriber);
  }

  /**
   * Unsubscribes from current {@link rx.Subscription}.
   */
  public void unsubscribe() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
