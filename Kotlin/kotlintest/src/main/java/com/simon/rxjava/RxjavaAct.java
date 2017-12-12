package com.simon.rxjava;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.simon.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/10/9 16:05
 */

public class RxjavaAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_rxjava);
    }

    /**
     * 点击显示RxJava
     *
     * @param view
     */
    public void showRxJava(View view) {
    }


    /**
     * 创建观察者
     */
    private void createObserver() {

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };


        Subscriber<String> subscriber = new Subscriber<String>() {

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };

        subscriber.unsubscribe();
        subscriber.isUnsubscribed();

    }


    /**
     * 创建被观察者
     */
    private void createObservable() {

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                subscriber.onNext("hello");
                subscriber.onNext("hello1");
                subscriber.onNext("hello2");
                subscriber.onCompleted();
//                subscriber.onError();

            }
        });


        Observable observable1 = Observable.just("hello", "hello1");
        String[] strs = {"hello", "hello1"};
        Observable observable2 = Observable.from(strs);


        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };

        observable.subscribe(observer);

    }


    /**
     * 自动创建出subscriber
     */
    private void autoCreateSubscriber() {

        Action1<String> onNextAction = new Action1<String>() {

            //onNext()

            @Override
            public void call(String s) {

            }
        };


        Action1<Throwable> onErrorAction = new Action1<Throwable>() {

            //onError()

            @Override
            public void call(Throwable throwable) {

            }
        };


        Action0 onCompleteAction = new Action0() {

            //onComplete()

            @Override
            public void call() {

            }
        };


        // 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
//        observable.subscribe(onNextAction);
        // 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
//        observable.subscribe(onNextAction, onErrorAction);
        // 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
//        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);

    }


    private void rxjavaTest() {


        int drawables[] = {R.drawable.bg, R.drawable.bg};
        final ImageView imageView = (ImageView) findViewById(R.id.iv_show);

        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {

                Drawable drawable = getResources().getDrawable(R.drawable.bg);
                subscriber.onNext(drawable);
                subscriber.onCompleted();

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Drawable>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Drawable drawable) {
                        imageView.setImageDrawable(drawable);
                    }
                });


        String[] names = {"jack", "hello", "tom"};
        final Button btn = (Button) findViewById(R.id.btnA);
        Observable.from(names)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        btn.setText(s);
                    }
                });


    }


    /**
     * Func1
     * <p>
     * rxJava里面的接口
     * <p>
     * 类似Action
     * <p>
     * 多了返回值
     * <p>
     * 它和 Action1 非常相似，也是 RxJava 的一个接口，用于包装含有一个参数的方法。
     * Func1 和Action 的区别在于， Func1 包装的是有返回值的方法。
     * 另外，和 ActionX 一样， FuncX 也有多个，用于不同参数个数的方法。
     */
    private void rxjavaTest1() {


        Observable.just("images/logo.png")
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String s) {
                        return null;
                    }
                })
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {

                    }
                });

    }


    /**
     * Map的用法
     * <p>
     * 事件对象的直接变换，具体功能上面已经介绍过。它是 RxJava 最常用的变换
     * <p>
     * A进去 B出来
     */
    private void rxjavaMap() {

        List<Student> studentList = new ArrayList<>();
        Observable.from(studentList).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Student>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Student student) {

                    }
                });


        Observable.from(studentList)
                .map(new Func1<Student, String>() {
                    @Override
                    public String call(Student student) {
                        return student.getName();
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        // TODO: 2017/10/10 显示name
                    }
                });

    }


    /**
     * 从上面的代码可以看出， flatMap() 和 map() 有一个相同点：它也是把传入的参数转化之后返回另一个对象。
     * 但需要注意，和map() 不同的是， flatMap() 中返回的是个 Observable 对象，
     * 并且这个 Observable 对象并不是被直接发送到了 Subscriber 的回调方法中。
     * flatMap() 的原理是这样的：1. 使用传入的事件对象创建一个 Observable 对象；
     * 2. 并不发送这个 Observable, 而是将它激活，于是它开始发送事件；
     * 3. 每一个创建出来的 Observable 发送的事件，都被汇入同一个 Observable ，
     * 而这个Observable 负责将这些事件统一交给 Subscriber 的回调方法。
     * 这三个步骤，把事件拆成了两级，通过一组新创建的Observable 将初始的对象『铺平』之后通过统一路径分发了下去。
     * 而这个『铺平』就是 flatMap() 所谓的 flat。
     */
    private void rxJavaFlatMap() {

        List<Student> studentList = new ArrayList<>();

        Observable
                .from(studentList)
                .flatMap(new Func1<Student, Observable<?>>() {
                    @Override
                    public Observable<?> call(Student student) {
                        return Observable.from(student.getCourse());
                    }
                })
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        String courseName = (String) o;
                        // TODO: 2017/10/10 显示每个学科的名字
                    }
                });

    }


    /**
     * 在前面讲 Subscriber 的时候，提到过 Subscriber 的 onStart() 可以用作流程开始前的初始化。
     * 然而 onStart() 由于在subscribe() 发生时就被调用了，因此不能指定线程，而是只能执行在 subscribe() 被调用时的线程。
     * 这就导致如果 onStart()中含有对线程有要求的代码（例如在界面上显示一个 ProgressBar，这必须在主线程执行），
     * 将会有线程非法的风险，因为有时你无法预测 subscribe() 将会在什么线程执行。
     * 而与 Subscriber.onStart() 相对应的，有一个方法 Observable.doOnSubscribe() 。
     * 它和 Subscriber.onStart() 同样是在subscribe() 调用后而且在事件发送前执行，但区别在于它可以指定线程。
     * 默认情况下， doOnSubscribe() 执行在 subscribe()发生的线程；而如果在 doOnSubscribe() 之后有 subscribeOn() 的话，
     * 它将执行在离它最近的 subscribeOn() 所指定的线程。
     *
     * 如下，在 doOnSubscribe()的后面跟一个 subscribeOn() ，就能指定准备工作的线程了。
     *
     */
    private void rxJavaDoOnSubscrible() {

        final ProgressBar progressBar = new ProgressBar(this);

        Observable
                .create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {

                    }
                })
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        progressBar.setVisibility(View.INVISIBLE);//需要执行在主线程
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())//执行在主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {

                    }
                });

    }

}































