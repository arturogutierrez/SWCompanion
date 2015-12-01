package com.arturogutierrez.swcompanion.data.storage.realm.helpers;

import android.content.Context;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;
import rx.Observable;
import rx.Subscriber;

public abstract class OnSubscribeRealmResults<T extends RealmObject>
    implements Observable.OnSubscribe<RealmResults<T>> {

  private final Context context;

  public OnSubscribeRealmResults(Context context) {
    this.context = context;
  }

  @Override
  public void call(Subscriber<? super RealmResults<T>> subscriber) {
    final Realm realm = Realm.getInstance(context);

    RealmResults<T> object;
    realm.beginTransaction();
    try {
      object = get(realm);
      realm.commitTransaction();
    } catch (RuntimeException e) {
      realm.cancelTransaction();
      subscriber.onError(new RealmException("Error during transaction.", e));
      return;
    } catch (Error e) {
      realm.cancelTransaction();
      subscriber.onError(e);
      return;
    }

    subscriber.onNext(object);
    subscriber.onCompleted();

    realm.close();
  }

  public abstract RealmResults<T> get(Realm realm);
}