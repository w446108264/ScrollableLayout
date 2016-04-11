ScrollableLayout
======================

An Android library supports sticking the navigator on the top when ItemView scrolls.

fork and change on [https://github.com/cpoopc/ScrollableLayout](https://github.com/cpoopc/ScrollableLayout) 

scrolling is not smooth, especially on some models .than 
「 [w446108264/StickHeaderLayout](https://github.com/w446108264/StickHeaderLayout) 」

gif
 
![Art](https://github.com/w446108264/ScrollableLayout/raw/master/output/little.gif)

![Art](https://github.com/w446108264/ScrollableLayout/raw/master/output/show.gif)


![Art](https://github.com/w446108264/ScrollableLayout/raw/master/output/p2.jpg)  ![Art](https://github.com/w446108264/ScrollableLayout/raw/master/output/p4.jpg)   
 
![Art](https://github.com/w446108264/ScrollableLayout/raw/master/output/p5.jpg)  ![Art](https://github.com/w446108264/ScrollableLayout/raw/master/output/p6.jpg) 


# Features

* API > 11 
* Support RecyclerView, ScrollView, ListView, WebView. 
* Support pulltoRefresh and loadmore
* Support dynamic headview

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
   compile 'com.github.w446108264:ScrollableLayout:1.0.2'
}
```
--


# Usage
 
simple to your proejct
 
### Layout
 
the frist childview will be ticked on the top.

```xml
      <com.scrollablelayout.ScrollableLayout
        android:id="@+id/sl_root"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="200dp"
            android:background="#345"
            android:gravity="center"
            android:textColor="#fff"
            android:text="header" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:background="#235"
            android:gravity="center"
            android:textColor="#fff"
            android:text="navigationbar" />

        <ListView
            android:id="@+id/vp_scroll"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="#f1f1f1" />

    </com.scrollablelayout.ScrollableLayout>
```
 
### Simple

```java

        sl_root = (ScrollableLayout) findViewById(R.id.sl_root);
        listview = (ListView) findViewById(R.id.vp_scroll);
        int size = 100;
        String[] stringArray = new String[size];
        for (int i = 0; i < size; ++i) {
            stringArray[i] = ""+i;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringArray);
        listview.setAdapter(adapter);
        sl_root.getHelper().setCurrentScrollableContainer(listview);

```
 
 
# Contact & Help

Please fell free to contact me if there is any problem when using the library.

* email: shengjun8486@gmail.com 

 

