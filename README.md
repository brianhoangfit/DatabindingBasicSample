# Android Databinding Basic sample

This sample showcases the following features of [Data binding library](https://developer.android.com/topic/libraries/data-binding/index.html)

- Layout variables and expressions
- Seamless integration with ViewModels and LiveData

## Feature

![Alt text](/screenshots/screenshot.png?raw=true "ViewModelActivity")

## Layout variables and expresssions
With Data Binding you can write less boilerplate and repetitive code. It moves UI operations out of the activities and fragment to the XML layout.

For example, instead of setting text on a TextView in an activity:

<code>
TextView textView = findViewById(R.id.name_label);
textView.setText(user.name);
</code>

You assign attribute to a variable, in the XML layout:

<code>
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@{viewmodel.name}" />
</code>

## LiveData
LiveData is an observable from [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) that is licycle-aware.

<code>
class ProfileViewModel : ViewModel() {
    private val _likes =  MutableLiveData(0)
    val likes: LiveData<Int> = _likes // Expose an immutable LiveData

    fun onLike() {
        _likes.value = (_likes.value ?: 0) + 1
    }
}
</code>

It requires an extra step done on the binding:

<code>
binding.lifecycleOwner = this  // use viewLifecycleOwner when assigning a fragment
</code>

## Binding adapters
Binding adapters let your customize or create layout attributes.For example, you can create an app:progressTint attribute for progress bars where you change the color of the progress indicator depending on an external value.

<code>
 @BindingAdapter("app:progressTint")
    @JvmStatic fun tintPopularity(view: ProgressBar, popularity: Popularity) {

        val color = getAssociatedColor(popularity, view.context)
        view.progressTintList = ColorStateList.valueOf(color)
    }
</code>

The binding is created in the XML layout with:

<code>
  <ProgressBar
        app:progressTint="@{viewmodel.popularity}" />
</code>

Using binding adapters lets you move UI calls from the activity to static methods, improving encapsulation.

You can also use multiple attributes in a Binding Adapter, see activity_main.xml for a complete example.

<p>Use the <code>printf()</code> function.</p>
