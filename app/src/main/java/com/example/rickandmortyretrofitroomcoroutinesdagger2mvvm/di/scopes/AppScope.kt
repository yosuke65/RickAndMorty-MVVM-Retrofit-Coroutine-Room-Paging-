package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.scopes

import javax.inject.Scope

/**
 * Replacement scope for @Singleton to improve readability
 */
@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope {
}