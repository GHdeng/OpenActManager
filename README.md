#Android界面跳转传递参数封装

###问题分析

- 或许大家看到标题Android界面跳转会觉得这个有什么好说的呢，无非就是使用startActivity(_this,_class) 和 Intent 的putExtra()来传递参数么！对，就是这么简单。
- but，大家有没想过当界面需要不断的跳转和带多个参数的时候使用Intent的putExtra()会显得很乱，更重要的是从 Intent 中取数据的时候需要格外小心——类型要对应，key 要写对，不然轻则取不到数据，重则 Crash。还有一点，就是当前 Activity/Fragment 必须要知道目标 Activity 的类名，这里耦合的很严重，有没有。当时就在想这是不是应该封装一下啊，或者有更好的解决方案。

----------

###方案（一）

 1. 在utils包里面创建一个统一管理界面跳转的单模式
 2. 在OpenActManager中创建intent实现跳转
 3. 传递数据使用序列化(Parcelable)对象来实现，创建一个实体类继承Parcelable接口，将传递的字段存放在该类中，方便获取和调用，再也不需要去找对应的key来获取参数。
 
``` java
// OpenActManager.class

private final String OPEN_ACTIVITY_KEY = "open_activity_key";

	/**
     * 获取上一个界面传递过来的参数
     *
     * @param activity this
     * @param <T>      泛型
     * @return
     */
    public <T> T getParcelableExtra(Activity activity) {
        Parcelable parcelable = activity.getIntent().getParcelableExtra(OPEN_ACTIVITY_KEY);
        activity = null;
        return (T) parcelable;
    }

	/**
     * 启动一个Activity
     * @param _this 
     * @param _class
     * @param flags
     * @param parcelable 传递的实体类
     */
    public void goActivity(Context _this, Class<? extends Activity> _class, int flags, Parcelable parcelable) {
        intent.setClass(_this, _class);
        setFlags(flags);
        putParcelable(parcelable);
        _this.startActivity(intent);
        _this = null;
    }
```

使用方式:
```java
//StartActTransfer.class
public int id;
public String name;
public ArrayList<String> data;
```
```java
//FirstActivity.class
StartActTransfer transfer = new StartActTransfer(10, 	"deng", new ArrayList<String>());
OpenActManager.get().goActivity(this, SecondActivity.class, transfer);
```
```java
//SecondActivity.class
StartActTransfer startActTransfer = OpenActManager.get().getParcelableExtra(this);
        if(startActTransfer!=null){
            int id = startActTransfer.id;
            String name = startActTransfer.name;
            ArrayList<String> data = startActTransfer.data;
            LogHelper.e("id:"+id+"   "+"name:"+name);
        }
```

完整例子代码 [github](https://github.com/GHdeng/OpenActManager)


----------

###方案（二）

 - 使用Android路由表框架
 - [http://www.sixwolf.net/blog/2016/03/23/Android路由框架设计/](http://www.sixwolf.net/blog/2016/03/23/Android%E8%B7%AF%E7%94%B1%E6%A1%86%E6%9E%B6%E8%AE%BE%E8%AE%A1/)


----------


我们都是站在巨人的肩膀上
参考：
http://www.jianshu.com/p/0590f530c617
http://www.sixwolf.net/blog/2016/03/23/Android%E8%B7%AF%E7%94%B1%E6%A1%86%E6%9E%B6%E8%AE%BE%E8%AE%A1/


# License
	Copyright (c) 2016 GHdeng
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
