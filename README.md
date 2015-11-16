# ListViewEx
ListView with some extra features. 

Using like normal ListView

### Primary feature
Prevent onItemClick listener calls twice (or more times)

### Second feature
Fix some exceptions on old android  (before API 14)

###Repo
```
repositories {
	maven {
		url "https://jitpack.io"
	}
}
```

###Dependences
```
dependencies {
	compile 'com.github.Hivedi:ListViewEx:1.0.2'
}
```

### Sampe code
```java
ListViewEx list = (ListViewEx) findViewById(R.id.list);
list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"item1", "item2", "item 3"}));
list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		startActivity(new Intent(MainActivity.this, Main2Activity.class));
	}
});
```

#### Layout
```xml
<com.hivedi.widget.listviewex.ListViewEx
	android:id="@+id/list"
	android:layout_width="match_parent"
	android:layout_height="match_parent"/>
```
