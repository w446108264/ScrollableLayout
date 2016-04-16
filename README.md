ScrollableLayout
======================

> j.s 🇨🇳


easy to add a headview for any view and supports sticking the navigator on the top when ItemView scrolls.

fork and change on [https://github.com/cpoopc/ScrollableLayout](https://github.com/cpoopc/ScrollableLayout) 

scrolling is not smooth, especially on some models .

another choice 「 [w446108264/StickHeaderLayout](https://github.com/w446108264/StickHeaderLayout) 」
 
# Features

* API > 11 
* Support ViewPager, RecyclerView, ScrollView, ListView, WebView
* Support pulltoRefresh and loadmore
* Support dynamic headview
* Easy to add a headview for any view
 
![Art](https://github.com/w446108264/ScrollableLayout/raw/master/output/show.gif)


# Screen Recrod
  
<img src="https://github.com/w446108264/ScrollableLayout/raw/master/output/p2.jpg" width="24%" /> 
<img src="https://github.com/w446108264/ScrollableLayout/raw/master/output/p4.jpg" width="24%" /> 
<img src="https://github.com/w446108264/ScrollableLayout/raw/master/output/p5.jpg" width="24%" />
<img src="https://github.com/w446108264/ScrollableLayout/raw/master/output/p6.jpg" width="24%" /> 
  
# Samples

You can [download a sample APK](https://github.com/w446108264/ScrollableLayout/raw/master/output/simple.apk) 

 
# Gradle Dependency

Users of your library will need add the jitpack.io repository:

```xml  
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

and:

```xml
dependencies { 
   compile 'com.github.w446108264:ScrollableLayout:1.0.3'
}
```


# Sample Usage
 


```xml
      <com.scrollablelayout.ScrollableLayout
        android:id="@+id/sl_root"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <!--the frist childview will follow the scrollview scroll.-->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="200dp"
            android:background="#345"
            android:gravity="center"
            android:textColor="#fff"
            android:text="header" />

        <!--the second childview will be a navigator.
        it will be sticking on the top when ItemView scrolls, 
        it's not necessary to add if you don't want-->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:background="#235"
            android:gravity="center"
            android:textColor="#fff"
            android:text="navigationbar" />

        <!--ScrollView support ViewPager, RecyclerView, ScrollView, ListView, WebView-->
        <ListView
            android:id="@+id/vp_scroll"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="#f1f1f1" />

    </com.scrollablelayout.ScrollableLayout>
```
 
```java
    // please see the demo
    sl_root = (ScrollableLayout) findViewById(R.id.sl_root);
    listview = (ListView) findViewById(R.id.vp_scroll); 
    sl_root.getHelper().setCurrentScrollableContainer(listview);

```
 
 
# Contact & Help

Please fell free to contact me if there is any problem when using the library.

* email: shengjun8486@gmail.com 

 

