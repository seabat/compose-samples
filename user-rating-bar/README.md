# user-rating-bar

ユーザー評価を表示する

### animateColorAsState

現カラーから別のカラーにアニメーションで変更する

```kotlin
    val tint by animateColorAsState(
        targetValue =
            if (ratingValue <= ratingState.value) {
                selectedColor
            } else {
                unselectedColor
            },
        label = ""
    )
 (省略)
     Icon(
        painter = painter,
        (省略)
        tint = tint
    )   
```    