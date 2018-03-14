# quranVerses [![](https://jitpack.io/v/mosamabinomar/quranVerses.svg)](https://jitpack.io/#mosamabinomar/quranVerses)
Show random Quran verse in android app
<div>
  <img src="https://raw.githubusercontent.com/mosamabinomar/quranVerses/master/screens/english.png" width="300" height="500"/>
  <img src="https://raw.githubusercontent.com/mosamabinomar/quranVerses/master/screens/arabic.png" width="300" height="500"/> 
</div>

## How To Use
### STEP 1
Add it to your build.gradle with:
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
and:

```gradle
dependencies {
    compile 'com.github.mosamabinomar:quranVerses:1.0'
}
```
### STEP 2
Add this in your layout file to include the QuranVerseView. 
```    
<com.bullhead.quranquotes.views.QuranVerseView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:surahNameTextSize="12sp"
        app:surahNameTextColor="#888888"
        app:verseTextSize="30sp"
        android:layout_centerInParent="true"
        app:verseTextColor="@color/colorPrimaryDark"
        /> 
```
It will automatically set the verse. You don't need to do anything else, that's it.

## View Properties
| Attribute                | For What?                   |
| -------------------------|:---------------------------:| 
| `surahNameTextSize`      | Change Surah name text size |
| `surahNameTextColor`     | Change Surah name text color|
| `verseTextSize`          | Change Verse text size      |
| `verseTextColor`         | Change Verse text color     |

**Example** `app:surahNameTextSize="12sp"`

