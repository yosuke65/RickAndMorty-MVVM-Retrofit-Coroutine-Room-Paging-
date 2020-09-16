package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.annotations

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)