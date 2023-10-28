package com.vindipop.kantongku

import com.vindipop.kantongku.models.Category
import com.vindipop.kantongku.models.Expense
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

val config = RealmConfiguration.create(schema = setOf(Expense::class, Category::class))
val db: Realm = Realm.open(config)